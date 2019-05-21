package guestbook.servlet;

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

@WebServlet("/AjaxEditNameEntry")
public class AjaxEditNameEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AjaxEditNameEntry() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    }

    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        Connection c = null;
        try {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";

            String sql = "update guestbook set name = ? where name = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement(sql);
            System.out.print(request.getParameter("name"));
            System.out.print(request.getParameter("oldName"));
            pstmt.setString( 1, request.getParameter( "name" ) );
            pstmt.setString( 2, request.getParameter( "oldName" ) );
            pstmt.executeUpdate();
        }
        catch( SQLException e ){
            throw new ServletException( e );
        }
        finally{
            try{
                if(c != null) c.close();
            }
            catch( SQLException e ){
                throw new ServletException( e );
            }
        }
    }
}
