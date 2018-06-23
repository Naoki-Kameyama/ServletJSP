package global.web;

/** アクション実行時に発生する基底例外。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class ActionException extends Exception {

	/** コンストラクタ。Exceptionのコンストラクタに"Action Exception"という文字列をセットする。 */
	public ActionException() {
		super("Action Exception");
	}

	/** コンストラクタ。Exceptionのコンストラクタに_messageをセットする。
	 * @param message エラーメッセージ。
	 */
	public ActionException(String message) {
		super(message);
	}

}