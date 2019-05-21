package database.servlet;

public class File {
	Integer id;
	String name;
	boolean is_folder;
	Integer parent_id;
	Integer owner_id;
	
	public File(Integer id, String name, boolean is_folder, Integer parent_id, Integer owner_id) {
		this.id = id;
		this.name = name;
		this.is_folder = is_folder;
		this.parent_id = parent_id;
		this.owner_id = owner_id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isIs_folder() {
		return is_folder;
	}
	
	public Integer getParent_id() {
		return parent_id;
	}
	
	public Integer getOwner_id() {
		return owner_id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setIs_folder(boolean is_folder) {
		this.is_folder = is_folder;
	}
	
	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	
	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}

}
