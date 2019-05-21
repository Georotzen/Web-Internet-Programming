package survey.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddQuestion")
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddQuestion() {
        super();
 
    }
    
    @SuppressWarnings("unchecked")
    private Survey getSurvey(Integer id) {
        List<Survey> surveys = (List<Survey>) getServletContext().getAttribute("surveys");

        for(Survey survey : surveys) {
        	if(survey.getId().equals(id)) {
        		return survey;
        	}
        }
        return null;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Survey survey = getSurvey(Integer.valueOf(request.getParameter("id")));
		
		int questionId = survey.getQuestions().size();
		
		request.setAttribute("questionId", questionId);
		request.setAttribute("survey", survey);
		request.getRequestDispatcher("/WEB-INF/AddQuestion.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		
		Survey survey = getSurvey(id);
		survey.addQuestion((new Question(request.getParameter("question"))));
		
		for (int i = 0; i < 10; i++) {
			String choice = request.getParameter("choice" + i);

			if (choice != null && choice.trim().length() > 0) {
				survey.getQuestions().get(Integer.valueOf(request.getParameter("questionId"))).addChoice(request.getParameter("choice" + i));
			}
		}

		response.sendRedirect("ViewSurvey?id=" + request.getParameter("id"));
	}
}
