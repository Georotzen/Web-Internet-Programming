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


@WebServlet("/Folder")
public class Folder extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Folder() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<File> files = new ArrayList<File>();
		List<String> folder_name = new ArrayList<String>();
    	Connection c = null;
    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
    		
    		c = DriverManager.getConnection(url, username, password);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM files file " 
            							+ "INNER JOIN files folder ON file.parent_id = folder.id "
            							+ "WHERE folder.id =" +  request.getParameter("id"));

            while (rs.next()) {
                files.add(new File(rs.getInt("id"), rs.getString("name"), rs.getBoolean("is_folder"), 
                		           rs.getInt("parent_id"), rs.getInt("owner_id")));
            }
            
            Statement stmt_folder = c.createStatement();
            ResultSet rs_folder = stmt_folder.executeQuery("SELECT f.name FROM files f "
            							+ "WHERE f.id =" + request.getParameter("id"));
            while(rs_folder.next()) {
            	folder_name.add(rs_folder.getString("name"));
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
    	 request.setAttribute("folder_name",folder_name.get(0));
    	 request.setAttribute("folder_id", request.getParameter("id"));
    	 request.setAttribute("files", files);
         request.getRequestDispatcher("/WEB-INF/Folder.jsp").forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
