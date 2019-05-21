package candidate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddCandidate")
public class AddCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Integer idSeed = 5;
       
   	public AddCandidate() {
        	super();
    	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Add Candidate</title>");
		out.println("<style>table { text-align: left; border: 1px solid black; border-collapse: collapse;"
				+ " margin-left: 10px; margin-right: 10px;}");
		out.println("th, td { text-align: left; border: 1px solid black; border-collapse: collapse;"
				+ " padding: 2px 2px 2px 2px; spacing: 2px 2px 2px 2px;}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='AddCandidate' method='post'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<td><input type='text' name='name' size='60'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>Specialities</th>");
		out.println("<td><input type='text' name='specialities' size='60'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>Presentation</th>");
		out.println("<td><input type='text' name='presentation' size='60'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' rowspan='1'><input type='submit' name='add' value='Add'/></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String specialities = request.getParameter("specialities");
		String presentation = request.getParameter("presentation");

		Candidate candidate = new Candidate(idSeed++, name, specialities, presentation);
		
		List<Candidate> candidates = (List<Candidate>) getServletContext().getAttribute("candidates");
		candidates.add(candidate);
		
		response.sendRedirect("CandidateReview");
	}
}
