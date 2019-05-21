package candidateII.servlet;

import java.io.IOException;
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
		
		request.setAttribute("candidate", candidate);
        request.getRequestDispatcher("/WEB-INF/EditCandidate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Candidate candidate = getCandidate(Integer.valueOf(request.getParameter("id")));

        candidate.setName(request.getParameter("name"));
        candidate.setSpecialities(request.getParameter("specialities"));
        candidate.setPresentation(request.getParameter("presentation"));

        response.sendRedirect("CandidateReview");
	}

}
