package model;

import java.io.Serializable;
import java.sql.Date;

public class Salary implements Serializable{


	private Date month;
	private double input;
	private double output;
	private double total;
	private String type;

	public Salary() {

	}

	public Salary(Date month, double input, double output, double total, String type) {
		this.month = month;
		this.input = input;
		this.output = output;
		this.total = total;
		this.type = type;
	}


	public Date getMonth() {
		return month;
	}

	public void setMonth(Date month) {
		this.month = month;
	}

	public double getInput() {
		return input;
	}

	public void setInput(double input) {
		this.input = input;
	}

	public double getOutput() {
		return output;
	}

	public void setOutput(double output) {
		this.output = output;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
