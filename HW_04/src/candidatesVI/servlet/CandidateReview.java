package candidatesVI.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/CandidateReview")
public class CandidateReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CandidateReview() {
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
            ResultSet rs = stmt.executeQuery("SELECT * FROM candidates");
     
            while (rs.next()) {
            		Statement stmt_updateRating = c.createStatement();
            		stmt_updateRating.executeUpdate("UPDATE candidates c " 
    									+ "SET c.rating = (SELECT * FROM ("
    									+ "SELECT AVG(f.rating) "
    									+ "FROM feedback f "
    									+ "JOIN candidates c2 ON c2.id = f.parent_id "
    									+ "AND c2.id = " + rs.getInt("id")
    									+ " GROUP BY c2.id) AS temp) "
    									+ "WHERE c.id = " + rs.getInt("id"));
            		
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
    	 request.setAttribute("candidates", candidates);
         request.getRequestDispatcher("/WEB-INF/CandidateReview.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

}