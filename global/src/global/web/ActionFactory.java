package global.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/** プロパティ･ファイルから値を検索し、そこに記述されているActionクラスをインスタンス化し呼び出し元に戻す。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */

public class ActionFactory {
	/** プロパティ･ファイルが配備されるディレクトリ（フォルダ）。 */
	private static final String PROJECTDIR = "/";
	/** プロパティ･ファイルの名前。 */
	private static final String PROP_FILE = PROJECTDIR + "action.properties";

	/** プロパティ･ファイル内から、tagで指定されたプロパティの値を読み込み、それをインスタンス化する。
	 * @return キーの値で記されているクラスをインスタンス化したオブジェクト。
	 * @param tag プロパティ・ファイル内のキー。
	 * @throws Exception メソッド内例外は全て呼び出し元に転送する。
	 */
	public static Object getObject(String tag) throws Exception {

		Class<?> c;
		Object o;
		String classString = "";

		try {
			classString = findValue(tag);
			c = Class.forName(classString);
			o = c.newInstance();

		} catch (Exception e) {

			String msg = "指定されたタグに対応するクラスの取得に失敗しました。\n";
			msg += "タグ: " + tag + "\n";
			msg += "クラス名: " + classString + "\n";

			throw new Exception(msg + "\n" + e);

		}

		return o;
	}

	/** tagで指定されたキーに対応する値をプロパティ･ファイル内から見つけ出す。
	 * @param tag action.properties内のキー。
	 * @return 対応する値。
	 */
	public static String findValue(String tag) {

		File propFile = null;
		InputStream fileInput;
		Properties actionProps;

		String value = null;

		try {
			propFile = new File(PROP_FILE);
			fileInput = new FileInputStream(propFile);
			actionProps = new Properties();
			actionProps.load(fileInput);

			value = actionProps.getProperty(tag);

		} catch (FileNotFoundException e) {

			System.out.println(e);
			System.out.println("プロパティファイル: " + PROP_FILE + " が見つかりません");

		} catch (IOException e) {

			System.out.println(e);
			System.out.println(propFile + " からデータを読み込めません。");
		}
		return value;
	}
}
