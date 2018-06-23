package uttest.sample;

class Greeting {

	String answer;

	public String hello(String lang) throws Exception {

		if (lang.equals("japanese"))
			answer = "konnichiwa";
		else if (lang.equals("english"))
			answer = "hello";
		else if (lang.equals("german"))
			answer = "hallo";
		else if (lang.equals("italian"))
			answer = "ciao";
		else if (lang.equals("spanish"))
			answer = "hola";
		else if (lang.equals("korean"))
			answer = "annyungasayo";
		else
			throw new Exception("エラー");

		return answer;
	}
}
