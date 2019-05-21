package candidatesVI.servlet;

import java.util.ArrayList;
import java.util.List;

public class Candidate {
	
	Integer id;
	String name;
	String specialities;
	String presentation;
	double rating;
	List<Feedback> feedback;
	
	public Candidate(Integer id, String name, String specialities, String presentation) {
		this.id = id;
		this.name = name;
		this.specialities = specialities;
		this.presentation = presentation;
		this.rating = 0.0;
		feedback = new ArrayList<Feedback>();
	}
	
	public Candidate(Integer id, String name, String specialities, String presentation, double rating) {
		this.id = id;
		this.name = name;
		this.specialities = specialities;
		this.presentation = presentation;
		this.rating = rating;
		feedback = new ArrayList<Feedback>();
	}
	
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSpecialities() {
		return specialities;
	}

	public String getPresentation() {
		return presentation;
	}
	
	public double getRating() {
		return rating;
	}
	
	public List<Feedback> getFeedback() {
		return feedback;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSpecialities(String specialities) {
		this.specialities = specialities;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public void setFeedback(List<Feedback> feedback) {
		this.feedback = feedback;
	}

}