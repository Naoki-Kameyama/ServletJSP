//Naoki Kameyama

public class TestDuplicatePrimaryKeyException {

	public static void main(String args[]) throws DuplicatePrimaryKeyException {

		DuplicatePrimaryKeyException actual1 = new DuplicatePrimaryKeyException();
		DuplicatePrimaryKeyException actual2 = new DuplicatePrimaryKeyException("message");

			throw new DuplicatePrimaryKeyException("error");
	}

}