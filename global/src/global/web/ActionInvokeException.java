package global.web;

/** アクション内でロジックの異常があった際に発生する例外。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class ActionInvokeException extends ActionException {
	/** コンストラクタ。ActionExceptionのコンストラクタに"Action Invoke Exception"という文字列をセットする。 */
	public ActionInvokeException() {
		super("Action Invoke Exception");
	}

	/** コンストラクタ。ActionExceptionのコンストラクタにmessageをセットする。
	 * @param message エラーメッセージ。
	 */
	public ActionInvokeException(String message) {
		super(message);
	}
}