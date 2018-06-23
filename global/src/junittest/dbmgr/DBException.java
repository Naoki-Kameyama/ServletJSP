package junittest.dbmgr;

public class DBException extends Exception{
		//コンストラクタ
		public DBException() {
			super("Database Connection Exception");
		}

		public DBException(String message) {
			super(message);
		}

}
