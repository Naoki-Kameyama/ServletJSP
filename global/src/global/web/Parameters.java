package global.web;

import java.util.Hashtable;

/** JSP間で値の受け渡しに使用するHashtableを拡張したクラス。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class Parameters extends Hashtable<Object, Object> {
	/** コンストラクタ。 */
	public Parameters() {
		super();
	}

	/** 指定されたキーにマップされている、ハッシュテーブルの値を返す。
	 * @param key ハッシュテーブルのキー
	 * @return 指定されたキーにマップされているハッシュテーブルの値。指定されたキーにマップされている値がない場合は空白文字列("")を返す。
	 */
	public Object getParam(Object key) {

		Object value = this.get(key);
		if (value == null)
			value = "";

    return value;
	}
}
