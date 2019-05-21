package inout.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = "/Login", loadOnStartup = 1)
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	boolean incorrect;
	static HttpSession session;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='Login' method='post'>");
		out.println("<table>");
		if(incorrect == true) {
			out.println("<tr>");
			out.println("<div style='color: red;'>Incorrect password or username</div>");
			out.println("</tr>");
			incorrect = false;
		}
		out.println("<tr>");
		out.println("<td>Username:</td>");
		out.println("<td><input type='text' name='username' value=''/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Password:</td>");
		out.println("<td><input type='password' name='password' value='' /></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td><input type='submit' value='Login' /></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("cysun") && password.equals("abcd")) {
			session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("Members");
		}
		else {
			incorrect = true;
			response.sendRedirect("Login");
		}
	}

}
