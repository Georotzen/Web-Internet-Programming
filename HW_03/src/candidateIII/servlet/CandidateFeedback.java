package candidateIII.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CandidateFeedback")
public class CandidateFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CandidateFeedback() {
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
        request.getRequestDispatcher("/WEB-INF/CandidateFeedback.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Candidate candidate = getCandidate(Integer.valueOf(request.getParameter("id")));
		
		Feedback feedback = new Feedback(request.getParameter("rating"), request.getParameter("name"), request.getParameter("comment"));
        candidate.addFeedback(feedback);

        response.sendRedirect("CandidateFeedback?id=" + request.getParameter("id"));
	}

}
