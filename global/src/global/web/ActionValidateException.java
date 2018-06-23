package global.web;

/** アクション内で入力パラメータに誤りがあった際に発生する例外。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class ActionValidateException extends ActionException {

	/** コンストラクタ。ActionExceptionのコンストラクタに"Action Validate Exception"という文字列をセットする。 */
	public ActionValidateException() {
		super("Action Validate Exception");
	}

	/** コンストラクタ。ActionExceptionのコンストラクタにmessageをセットする。
	 * @param message エラーメッセージ。
	 */
	public ActionValidateException(String message) {
		super(message);
	}

}