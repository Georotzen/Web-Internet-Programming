package expense.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Expenses")
public class Expenses extends HttpServlet {
	private static final long serialVersionUID = 1L;
     

    public Expenses() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Expense> expenses = new ArrayList<Expense>();
		double total = 0;
    	Connection c = null;
    	try {
    		String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu11";
    		String username = "cs3220stu11";
    		String password = "qYli8!Uz";
    		
    		
    		c = DriverManager.getConnection(url, username, password);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM expenses");
            
            while (rs.next()) {
            	expenses.add(new Expense(rs.getInt("id"), rs.getString("month"), rs.getDouble("amount"), rs.getString("tags")));
            }
            c.close();
    	} catch (SQLException e) {
    		throw new ServletException(e);
    	}
    	finally {
    		try {
    			if(c != null) c.close();
    		} catch(SQLException e)  {
    			throw new ServletException(e);
    		}
    	}
    	
    	for (int i = 0; i < expenses.size(); i++) {
    		total = total + expenses.get(i).getAmount();
    	}
    	
    	request.setAttribute("total", total);
    	request.setAttribute("expenses", expenses);
        request.getRequestDispatcher("/WEB-INF/Expenses.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
