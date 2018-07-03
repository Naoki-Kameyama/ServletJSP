package model;

public class Mori {
	private String userId;
	private String question;
	private String answer;

	public Mori() {

	}


	public Mori(String userId, String question, String answer){
		this.userId = userId;
		this.question = question;
		this.answer = answer;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}







}
