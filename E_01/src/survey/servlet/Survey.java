package survey.servlet;

import java.util.ArrayList;
import java.util.List;

public class Survey {
	
	private static int idSeed = 0;
	Integer id;
	String name;
	List<Question> questions;
	
	public Survey(String name) {
		this.id = idSeed++;
		this.name = name;
		questions = new ArrayList<Question>();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question question) {
		questions.add(question);
	}
}
