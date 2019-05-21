package bmi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns= "/BMICalculator", loadOnStartup = 1)
public class BMICalculator extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BMICalculator() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		double weightPounds = Integer.parseInt(request.getParameter( "weightPounds" ));	  
        
        int heightFoots = Integer.parseInt(request.getParameter( "heightFoots" ));
        int heightInches = Integer.parseInt(request.getParameter( "heightInches" ));    
        
        double weight = weightPounds / 2.205;
        double height = ((heightFoots * 12) + heightInches)/39.37;
        
        DecimalFormat decimalFormat = new DecimalFormat(".#");
        
        double BMI = (weight / Math.pow(height, 2));
        String BMIS = decimalFormat.format(BMI);
        
        String[] interpretationValues = {"Underwight", "Normal", "Overweight", "Obese"};
        String interpretation = "";
        
        if (BMI < 18.5) {
        	interpretation = interpretationValues[0];
        }
        if (18.5 <= BMI && BMI < 25.0) {
        	interpretation = interpretationValues[1];
        }
        if (25.0 <= BMI && BMI < 30.0) {
        	interpretation = interpretationValues[2];
        }
        if (30.0 <= BMI) {
        	interpretation = interpretationValues[3];
        }
        
        
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>Result BMI</title></head><body>");
	    out.println("<p> Your BMI is <strong>" + BMIS + "</strong>  You are of <strong>" + interpretation + "</strong></p>");
	    out.println("<p><a href=\"index.html\">Back to BMI Calculator</a></p>");
	    out.println("</body><html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
