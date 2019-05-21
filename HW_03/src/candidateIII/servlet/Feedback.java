package candidateIII.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Feedback {

	Integer rating;
	String comment;
	String name;
	String date;
	
	public Feedback(String rating, String name, String comment) {
		this.rating = Integer.parseInt(rating);
		this.name = name;
		this.comment = comment;
		
		String pattern = "MM/dd/YYYY";
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		this.date = format.format(new Date());
	}
	
	public Feedback(String rating, String name, String comment, String date) {
		this.rating = Integer.parseInt(rating);
		this.name = name;
		this.comment = comment;
		this.date = date;
	}
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
