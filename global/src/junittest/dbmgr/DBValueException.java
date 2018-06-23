package junittest.dbmgr;
import global.generic.ValueException;

public class DBValueException extends ValueException{

	//コンストラクタ
	public DBValueException() {
		super("Database Value Exception");
		System.out.println("Database Value Exception1111");
	}

	public DBValueException(String message) {
		super(message);
	}
}
