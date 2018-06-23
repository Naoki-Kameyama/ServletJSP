package global.generic;

/** データ関連の一般的な例外。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class ValueException extends Exception {

	/**
	 *この例外に"Value Exception"をセットする。
	 */
	public ValueException() {
		super("Value Exception");
	}

	/**
	 *指定された文字列を元にメッセージを構築する。
	 *@param message メッセージ。
	 */
	public ValueException(String message) {
		super(message);
	}
}