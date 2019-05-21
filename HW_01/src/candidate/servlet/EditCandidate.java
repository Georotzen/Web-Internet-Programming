package candidate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditCandidate")
public class EditCandidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditCandidate() {
        super();
    }
    
    @SuppressWarnings("unchecked")
    private Candidate getCandidate(Integer id) {
        List<Candidate> candidates = (List<Candidate>) getServletContext().getAttribute("candidates");

        for(Candidate candidate : candidates) {
        	if(candidate.getId().equals(id)) {
        		return candidate;
        	}
        }
   
        return null;

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Candidate candidate = getCandidate(Integer.valueOf(request.getParameter("id")));
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<title>Edit Candidate</title>");
		out.println("<style>table { text-align: left; border: 1px solid black; border-collapse: collapse;"
				+ " margin-left: 10px; margin-right: 10px;}");
		out.println("th, td { text-align: left; border: 1px solid black; border-collapse: collapse;"
				+ " padding: 2px 2px 2px 2px; spacing: 2px 2px 2px 2px;}</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action='EditCandidate' method='post'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<td>" + candidate.getId());
		out.println("<input type='hidden' name='id' value='" + Integer.valueOf(request.getParameter("id")) +"'</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>Name</th>");
		out.println("<td><input type='text' name='name' size='60' value='" + candidate.getName() + "'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>Specialities</th>");
		out.println("<td><input type='text' name='specialities' size='60' value='" + candidate.getSpecialities() + "'/></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>Presentation</th>");
		out.println("<td><input type='text' name='presentation' size='60' value='" + candidate.getPresentation() + "'/></td>");
		out.println("</tr>");
		out.println("<tr><td colspan='2' rowspan='1'><input type='submit' value='Save' name='save' /></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Candidate candidate = getCandidate(Integer.valueOf(request.getParameter("id")));

        candidate.setName(request.getParameter("name"));
        candidate.setSpecialities(request.getParameter("specialities"));
        candidate.setPresentation(request.getParameter("presentation"));

        response.sendRedirect("CandidateReview");
	}

}
