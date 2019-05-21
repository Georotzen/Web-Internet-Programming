package survey.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/SurveyBuilder", loadOnStartup = 1)
public class SurveyBuilder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SurveyBuilder() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	List<Survey> surveys = new ArrayList<Survey>();
    	surveys.add(new Survey("CS 4961 Readiness Survey for Fall 2019"));
		surveys.add(new Survey("2016-2018 Curricular Feedback"));
		surveys.add(new Survey("2019 Curricular Feedback"));
		
		
		surveys.get(0).addQuestion(new Question("Have you completed all the following prerequisite CS courses with minimum C grade: CS3035, CS3112, CS3186, CS3220, CS3337, and CS3801?"));
		surveys.get(0).getQuestions().get(0).addChoice("Yes");
		surveys.get(0).getQuestions().get(0).addChoice("No, but I will complete all the six requirements by the end of Spring 2019.");
		surveys.get(0).getQuestions().get(0).addChoice("No, and I will not be able to complete them by the end of Spring 2019.");
		
		getServletContext().setAttribute("surveys", surveys);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/SurveyBuilder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
