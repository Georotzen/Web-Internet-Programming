package survey.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateSurvey")
public class CreateSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateSurvey() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.getRequestDispatcher("/WEB-INF/CreateSurvey.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Survey survey = new Survey(request.getParameter("name"));	
		List<Survey> surveys = (List<Survey>) getServletContext().getAttribute("surveys");
		surveys.add(survey);
		request.setAttribute("survey", survey);
		request.getRequestDispatcher("SurveyBuilder").forward(request, response);
	}

}
