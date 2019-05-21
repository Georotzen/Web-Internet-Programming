package database.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteFolder")
public class DeleteFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteFolder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
			String username = "cs3220stu11";
			String password = "qYli8!Uz";
			c = DriverManager.getConnection(url, username, password);

			Statement stmt = c.createStatement();
			stmt.executeUpdate("DELETE FROM files WHERE id = " + request.getParameter("id"));
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
		response.sendRedirect("DatabaseAccess");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
