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

@WebServlet("/CandidateFeedback")
public class CandidateFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CandidateFeedback() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Feedback> feedback = new ArrayList<Feedback>();
		List<Candidate> candidate = new ArrayList<Candidate>();
    	Connection c = null;
    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
    		
    		c = DriverManager.getConnection(url, username, password);
            Statement stmt = c.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM candidates "
					     					 + "WHERE id = " + request.getParameter("id"));
            
            while (rs.next()) {
					candidate.add(new Candidate(rs.getInt("id"), rs.getString("name"), rs.getString("specialities"), rs.getString("presentation"), rs.getDouble("rating")));
            }
            
            rs = stmt.executeQuery("SELECT * FROM feedback "
            							   + "WHERE parent_id = " + request.getParameter("id"));
            
            while (rs.next()) {
            	if (Double.toString(rs.getDouble("rating")).equals("NULL")) {
            		feedback.add(new Feedback("0.0", rs.getString("comment"), rs.getString("name"), rs.getString("feedback_date").substring(0, 10)));
            	}
            	else {
            		feedback.add(new Feedback(Integer.toString(rs.getInt("rating")), rs.getString("comment"), rs.getString("name"), rs.getString("feedback_date").substring(0, 10)));
            	}
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

    	candidate.get(0).setFeedback(feedback);
    	request.setAttribute("candidate", candidate.get(0));
        request.getRequestDispatcher("/WEB-INF/CandidateFeedback.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
			
			String sql = "INSERT INTO feedback (rating, comment, name, parent_id)" 
					   + "VALUES (?, ?, ?, " + request.getParameter("id") + ")";
			
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("rating"));
			pstmt.setString(2, request.getParameter("comment"));
			pstmt.setString(3, request.getParameter("name"));
			pstmt.executeUpdate();
			
			Statement stmt = c.createStatement();
			stmt.executeUpdate("UPDATE candidates c " 
							+ "SET c.rating = (SELECT * FROM ("
							+ "SELECT AVG(f.rating) "
							+ "FROM feedback f "
							+ "JOIN candidates c2 ON c2.id = f.parent_id "
							+ "AND c2.id = " + request.getParameter("id")
							+ " GROUP BY c2.id) AS temp) "
							+ "WHERE c.id = " + request.getParameter("id"));
			
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

		response.sendRedirect(response.encodeRedirectURL("CandidateFeedback?id=" + request.getParameter("id")));
	}

}