public class JUTestDBException {

	public static void main(String args[]) throws DBException {

			DBException test1 = new DBException();
			DBException test2 = new DBException("おはよう");

			throw new DBException("hey");
	}

}
