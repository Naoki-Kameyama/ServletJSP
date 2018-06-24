package model;

import java.io.Serializable;

public class Salary implements Serializable{


	private int month;
	private double input;
	private double output;
	private double total;

	public Salary() {

	}

	public Salary(int month, double input, double output, double total) {
		this.month = month;
		this.input = input;
		this.output = output;
		this.total = total;
	}


	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
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

}
