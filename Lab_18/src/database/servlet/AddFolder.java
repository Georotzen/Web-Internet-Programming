package database.servlet;

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

@WebServlet("/AddFolder")
public class AddFolder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddFolder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
        request.getRequestDispatcher("/WEB-INF/AddFolder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
			String username = "cs3220stu11";
			String password = "qYli8!Uz";
			c = DriverManager.getConnection(url, username, password);
			
			if (request.getParameter("parent_id").equalsIgnoreCase("NULL")) {
				String sql = "INSERT INTO files (name, is_folder, owner_id) VALUES (?, true, 1)";
				
				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, request.getParameter("name"));
				pstmt.executeUpdate();
			}
			else {
				String sql = "INSERT INTO files (name, is_folder, parent_id, owner_id) VALUES (?, true, ?, 1)";

				PreparedStatement pstmt = c.prepareStatement(sql);
				pstmt.setString(1, request.getParameter("name"));
				pstmt.setInt(2, Integer.parseInt((request.getParameter("parent_id"))));
				pstmt.executeUpdate();
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
		response.sendRedirect("DatabaseAccess");
	}
}
