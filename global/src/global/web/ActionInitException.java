package global.web;

/** アクション初期化時に異常あった際に発生する例外。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class ActionInitException extends ActionException {

	/** コンストラクタ。ActionExceptionのコンストラクタに"Action Initial Exception"という文字列をセットする。 */
	public ActionInitException() {
		super("Action Initialize Exception");
	}

	/** コンストラクタ。ActionExceptionのコンストラクタにmessageをセットする。
	 * @param message エラーメッセージ。
	 */
	public ActionInitException(String message) {
		super(message);
	}

}