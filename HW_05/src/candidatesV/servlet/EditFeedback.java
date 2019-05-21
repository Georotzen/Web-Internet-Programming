package candidatesV.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditFeedback")
public class EditFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String parent_idIn;
	String nameIn;
	String commentIn;
	String ratingIn;
       
    public EditFeedback() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		Connection c = null;

		try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
    		
    		parent_idIn = request.getParameter("parent_id");
    		nameIn = request.getParameter("name");
    		commentIn = request.getParameter("comment");
    		ratingIn = request.getParameter("rating");
    		
    		c = DriverManager.getConnection(url, username, password);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM feedback " 
            							   + "WHERE parent_id = '" + parent_idIn 
            							   + "' AND name = '" + nameIn 
            							   + "' AND comment = '" + commentIn
            							   + "' AND rating = '" + ratingIn + "'");
            while (rs.next()) {
            	feedbacks.add(new Feedback(Integer.toString(rs.getInt("rating")), rs.getString("comment"), rs.getString("name"), rs.getString("feedback_date").substring(0, 10)));
            }
            c.close();
    	} catch (SQLException e) {
    		throw new ServletException(e);
    	}
    	finally {
    		try {
    			if(c != null) c.close();
    		} catch(SQLException e)  {
    			throw new ServletException(e);
    		}
    	}
		
		request.setAttribute("feedbacks", feedbacks);
        request.getRequestDispatcher("/WEB-INF/EditFeedback.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
			
			String sql = "UPDATE feedback SET " 
					   + "rating = ?, " 
					   + "comment = ?, "
					   + "name = ? " 
					   + "WHERE parent_id = " + parent_idIn
					   + " AND name = '" + nameIn
					   + "' AND comment = '" + commentIn
					   + "' AND rating = '" + ratingIn + "'";
			
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("ratingUpdate"));
			pstmt.setString(2, request.getParameter("commentUpdate"));
			pstmt.setString(3, request.getParameter("nameUpdate"));
			pstmt.executeUpdate();
			
			Statement stmt = c.createStatement();
			stmt.executeUpdate("UPDATE candidates c " 
							+ "SET c.rating = (SELECT * FROM ("
							+ "SELECT AVG(f.rating) "
							+ "FROM feedback f "
							+ "JOIN candidates c2 ON c2.id = f.parent_id "
							+ "AND c2.id = " + parent_idIn
							+ " GROUP BY c2.id) AS temp) "
							+ "WHERE c.id = " + parent_idIn);
			
			c.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		finally {
			try {
				if(c != null) c.close();
			} catch(SQLException e)  {
				throw new ServletException(e);
			}
		}

		response.sendRedirect(response.encodeRedirectURL("CandidateFeedback?id=" + parent_idIn));
	}

}
