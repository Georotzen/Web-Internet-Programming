package candidate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CandidateReview", loadOnStartup = 2)
public class CandidateReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CandidateReview() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	List<Candidate> candidates = new ArrayList<Candidate>();
    	candidates.add(new Candidate(1, "John", "Machine Learning", "10am on 2/20 in ET A227"));
	candidates.add(new Candidate(2, "Jack", "Computer Vision", "10am on 2/25 in ET A332"));
	candidates.add(new Candidate(3, "Jane", "Machine Learning", "3pm on 2/27 in ET A126"));
	candidates.add(new Candidate(4, "May", "Computer Science Education", "3:30pm on 3/11 in FA A219"));
	getServletContext().setAttribute("candidates", candidates);
    }

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Candidate> candidates = (List<Candidate>) getServletContext().getAttribute("candidates");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Candidate Review</title>");
		out.println("<style>table { text-align: left; border: 1px solid black; border-collapse: collapse;"
				+ " margin-left: 10px; margin-right: 10px;}");
		out.println("th, td { text-align: left; border: 1px solid black; border-collapse: collapse;"
				+ " padding: 3px 3px 3px 3px; spacing: 3px 3px 3px 3px;}");
		out.println("a:visited, a:link, a:hover {color: blue; text-decoration: none;}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Name</th>");
		out.println("<th>Specialities</th>");
		out.println("<th>Presentation</th>");
		out.println("<th>Operation</th>");
		out.println("</tr>");
		
		for (Candidate candidate: candidates) {
			out.println("<tr>");
			out.println("<td style='text-align: center;'>" + candidate.getId() + "</td>");
			out.println("<td>" + candidate.getName() + "</td>");
			out.println("<td>" + candidate.getSpecialities() + "</td>");
			out.println("<td>" + candidate.getPresentation() + "</td>");
			out.println("<td style='text-align: center;'><a href='EditCandidate?id=" + candidate.getId() + "'>Edit</a></td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<p style='padding-left: 10px;'><a href='AddCandidate'>Add Candidate</a></p>");
		out.println("</body>");
		out.println("</html>");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
