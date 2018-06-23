package global.productmgr;
import global.dbmgr.DBValueException;
/**
 * 製品管理パッケージ内の操作時に発生する例外。
 *
 * @author Naoki Kameyama
 * @version 1.0
 */
public class ProductValueException extends DBValueException{

	//コンストラクタ
	//DBValueExceptionのコンストラクタに"Product Value Exception"という文字列をセットする。
	public ProductValueException() {
		super("Product Value Exception");
	}

	//コンストラクタ
	//DBValueExceptionのコンストラクタにmessageをセットする。
	public ProductValueException(String message) {
		super(message);
	}

}
