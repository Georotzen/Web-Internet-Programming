package candidate.servlet;

public class Candidate {
	
	Integer id;
	String name;
	String specialities;
	String presentation;
	
	public Candidate(Integer id, String name, String specialities, String presentation) {
		this.id = id;
		this.name = name;
		this.specialities = specialities;
		this.presentation = presentation;
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

}
