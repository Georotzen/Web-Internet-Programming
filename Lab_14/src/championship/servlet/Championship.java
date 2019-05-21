package championship.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Championship")
public class Championship extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int round;
	Map<String, String> matches;
	
    public Championship() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
		readTeams();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Championship.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		round++;
		if (round == 1) {
			matches.clear();
			matches.put(request.getParameter("match1"), request.getParameter("match2"));
			matches.put(request.getParameter("match3"), request.getParameter("match4"));
			request.getRequestDispatcher("/WEB-INF/Championship.jsp").forward(request, response);
		}
		if (round == 2) {
			matches.clear();
			matches.put(request.getParameter("match1"), request.getParameter("match2"));
			request.getRequestDispatcher("/WEB-INF/Championship.jsp").forward(request, response);
		}
		if (round == 3) {
			matches.clear();
			getServletContext().setAttribute("winner", request.getParameter("match1"));
			request.getRequestDispatcher("/WEB-INF/Championship.jsp").forward(request, response);
		}
		if (round > 3) {
			readTeams();
			request.getRequestDispatcher("/WEB-INF/Championship.jsp").forward(request, response);
		}
	}
	
	protected void readTeams() throws ServletException {
		matches = new HashMap<String, String>();
		round = 0;
		try {
	            Scanner in = new Scanner(new File(getServletContext().getRealPath("/WEB-INF/teams.txt")));
	            while(in.hasNextLine()) {
	            	matches.put(in.nextLine(), in.nextLine());
	            }
	            in.close();
	        }
	        catch(FileNotFoundException e) {
	            throw new ServletException(e);
	        }
		getServletContext().setAttribute("matches", matches);
	}

}
