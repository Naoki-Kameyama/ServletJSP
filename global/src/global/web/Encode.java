package global.web;

/** UTF-8でエンコードし直した値を返すようなメソッドを持ったクラス。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class Encode {
	/** 指定された文字列を、"UTF-8"でエンコーディングしなおして戻す。
	 * @param s ISO8859_1でエンコードされている文字列。
	 * @return UTF-8でエンコーディングしなおされた文字列。
	 */
	public static String toUnicode(String s) {
		String encoded = null;

		try {
			encoded = new String(s.getBytes("8859_1"), "UTF-8");
		} catch (Exception e) {
			System.out.println("Encode Error");
			System.out.println(e);
		}
		return encoded;
	}
}