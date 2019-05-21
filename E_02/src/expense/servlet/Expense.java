package expense.servlet;

import java.util.Arrays;
import java.util.List;

public class Expense {
	Integer id;
	String month;
	double amount;
	List<String> tags;
	
	public Expense(Integer id, String month, double amount, String tags) {
		super();
		this.id = id;
		this.month = month;
		this.amount = amount;
		this.tags = Arrays.asList(tags.split("\\s*,\\s*"));
	}
	
	public String getMonth() {
		return month;
	}
	public double getAmount() {
		return amount;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
