package candidatesVI.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddCandidate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
        request.getRequestDispatcher("/WEB-INF/AddCandidate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
			
			String sql = "INSERT INTO candidates (name, specialities, presentation) VALUES (?, ?, ?);";
			
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("name"));
			pstmt.setString(2, request.getParameter("specialities"));
			pstmt.setString(3, request.getParameter("presentation"));
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
		response.sendRedirect("CandidateReview");
	}

}