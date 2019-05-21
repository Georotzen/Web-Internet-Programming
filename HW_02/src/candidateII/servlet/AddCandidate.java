package candidateII.servlet;

import java.io.IOException;
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
        request.getRequestDispatcher("/WEB-INF/AddCandidate.jsp").forward(request, response);
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
