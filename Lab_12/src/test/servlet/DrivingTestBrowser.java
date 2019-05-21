package test.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DrivingTestBrowser")
public class DrivingTestBrowser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Question> questions = new ArrayList<Question>();
	int id = -1;
	
    public DrivingTestBrowser() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	id = -1;
		try {
			@SuppressWarnings("resource")
			Scanner in = new Scanner(new File(getServletContext().getRealPath("/WEB-INF/DrivingTest.txt")));
			
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
	    	in.nextLine();
	    	questions.add(new Question(in.nextLine(), in.nextLine(), in.nextLine(), in.nextLine(), Integer.parseInt(in.nextLine())));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(id == 9) {
			id= -1;
		}
		id++;
		getServletContext().setAttribute("questions", questions);
		getServletContext().setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/DrivingTest.jsp").forward(request, response);
	}


}
