package survey.servlet;

import java.util.ArrayList;
import java.util.List;

public class Question {
	
	String description;
	List<String> choices;
	
	public Question(String description) {
		this.description = description;
		choices = new ArrayList<String>();
	}

	public String getDescription() {
		return description;
	}

	public List<String> getChoices() {
		return choices;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setChoices(List<String> choices) {
		this.choices = choices;
	}
	
	public void addChoice(String choice) {
		choices.add(choice);
	}
}
