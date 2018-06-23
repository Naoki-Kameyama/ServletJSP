
public class TestDBValueException {

	public static void main(String args[]) throws DBValueException {

		DBValueException test1 = new DBValueException();
		DBValueException test2 = new DBValueException("おはよう");

		throw new DBValueException();
	}

}
