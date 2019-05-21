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

@WebServlet("/EditCandidate")
public class EditCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCandidate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Candidate> candidates = new ArrayList<Candidate>();
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
            	candidates.add(new Candidate(rs.getInt("id"), rs.getString("name"), rs.getString("specialities"), rs.getString("presentation"), rs.getDouble("rating")));
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
   	 	
		request.setAttribute("candidate", candidates.get(0));
        request.getRequestDispatcher("/WEB-INF/EditCandidate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
    		
    		String sql = "UPDATE candidates " 
    				   + "SET name = ?, "
    				   + "specialities = ?, "
    				   + "presentation = ? "
    				   + "WHERE id = ?";
			
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("specialities"));
			pstmt.setString(3, request.getParameter("presentation"));
			pstmt.setString(4, request.getParameter("id"));
			pstmt.executeUpdate();
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
		response.sendRedirect(response.encodeRedirectURL("CandidateReview"));
	}

}
