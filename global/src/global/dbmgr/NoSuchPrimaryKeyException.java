//Naoki Kameyama

import global.dbmgr.DBValueException;

public class NoSuchPrimaryKeyException extends DBValueException{

	public NoSuchPrimaryKeyException() {
			super("No Such PrimaryKey Exception");
		}
		public NoSuchPrimaryKeyException(String message) {
			super(message);
		}
}

