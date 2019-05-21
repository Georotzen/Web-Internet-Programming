package candidateIII.servlet;

import java.io.IOException;
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
		
		candidates.get(0).addFeedback(new Feedback("5", "Sue", "I like his research. Seems to be a nice person.", "3/10/2019"));
		candidates.get(0).addFeedback(new Feedback("3", "Tom", "The presentation was not very well organized. He may be a good researcher but I don't think he'll be a good teacher.", "3/11/2019"));
		
		candidates.get(1).addFeedback(new Feedback("5", "Robert", "Amazing research. Totally deserves the job.", "3/20/2019"));
		candidates.get(1).addFeedback(new Feedback("4", "Mike", "Jack's reseach is incredible. However he wasn't able to deliver his presentation preciselly.", "3/21/2019"));
		
		getServletContext().setAttribute("candidates", candidates);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/CandidateReview.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
