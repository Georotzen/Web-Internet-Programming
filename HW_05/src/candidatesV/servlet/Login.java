package candidatesV.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		
		try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
    		
    		c = DriverManager.getConnection(url, username, password);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
            	
    			if (request.getParameter("username").equals(rs.getString("username")) && request.getParameter("password").equals(rs.getString("password"))) {
    				HttpSession session = request.getSession();
    				session.setAttribute("username", request.getParameter("username"));
    				session.setAttribute("password", request.getParameter("password"));
    				session.setAttribute("is_Admin", rs.getBoolean("is_Admin"));
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
		
		response.sendRedirect(response.encodeRedirectURL("CandidateReview"));
	}

}
