package inout.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Members")
public class Members extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean sessionInvalidated;

    public Members() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	sessionInvalidated = false;
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (sessionInvalidated == false) {
			out.println("<html>");
			out.println("<head><title>Welcome</title></head>");
			out.println("<body>");
			out.println("<h3>Welcome to the Members Area</h3>");
			out.println("<form action='Members' method='post'><input type='submit' value='Log out'/></form>");
			out.println("</body>");
			out.println("</html>");
			out.close();
		}
		if (sessionInvalidated == true) {
			out.println("<head><title>Welcome</title></head>");
			out.println("<body>");
			out.println("<h3>You are successfully logged out</h3>");
			out.println("<p><a href='Login'>Go back to main page</a></p>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			sessionInvalidated = false;
		}
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		sessionInvalidated = true;
		doGet(request, response);
	}

}
