package survey.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewSurvey")
public class ViewSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewSurvey() {
        super();
    }
    
    @SuppressWarnings("unchecked")
    private Survey getSurvey(Integer id) {
        List<Survey> surveys = (List<Survey>) getServletContext().getAttribute("surveys");

        for(Survey survey : surveys) {
        	if(survey.getId() == id) {
        		return survey;
        	}
        }
        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Survey survey = getSurvey(Integer.valueOf(request.getParameter("id")));
		
		List<Question> questions = survey.getQuestions();
		
		int nOfQuestions = survey.getQuestions().size();
		request.setAttribute("nOfQuestions", nOfQuestions);
		request.setAttribute("survey", survey);
		request.setAttribute("questions", questions);
		
		request.getRequestDispatcher("/WEB-INF/ViewSurvey.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
