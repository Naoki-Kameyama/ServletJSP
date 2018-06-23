import global.generic.ValueException;

public class DBValueException extends ValueException{

	//コンストラクタ
	public DBValueException() {
		super("Database Value Exception");
	}

	public DBValueException(String message) {
		super(message);
	}
}
