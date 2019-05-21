package database.servlet;

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

@WebServlet("/DatabaseAccess")
public class DatabaseAccess extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DatabaseAccess() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	List<File> files = new ArrayList<File>();
    	Connection c = null;
    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
    		
    		c = DriverManager.getConnection(url, username, password);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM files f "
                    					   + "INNER JOIN users u ON f.owner_id = u.id "
                    					   + "WHERE parent_id IS NULL AND u.name = 'cysun' "
                    					   + "ORDER BY f.is_folder DESC");

            while (rs.next()) {
                files.add(new File(rs.getInt("id"), rs.getString("name"), rs.getBoolean("is_folder"), 
                		           rs.getInt("parent_id"), rs.getInt("owner_id")));
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
    	 request.setAttribute("files", files);
         request.getRequestDispatcher("/WEB-INF/DatabaseAccess.jsp").forward( request, response );
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request, response);
    }

}
