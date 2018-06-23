//Naoki Kameyama

public class NoSuchPrimaryKeyException {

	public static void main(String args[]) throws NoSuchPrimaryKeyException {

		NoSuchPrimaryKeyException actual1 = new NoSuchPrimaryKeyException();
		NoSuchPrimaryKeyException actual2 = new NoSuchPrimaryKeyException("message");

			throw new NoSuchPrimaryKeyException("error");
	}

}