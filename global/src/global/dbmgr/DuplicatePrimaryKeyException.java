//Naoki Kameyama

import global.dbmgr.DBValueException;

public class DuplicatePrimaryKeyException extends DBValueException{

	public DuplicatePrimaryKeyException() {
		super( "Duplicate PrimaryKey Exception" );
	}

	public DuplicatePrimaryKeyException(String message) {
		super(message);
	}

