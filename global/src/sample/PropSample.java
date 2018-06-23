package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropSample {
	public static void main(String[] args) throws Exception {

		// ファイルオブジェクトの取得
		File propertyFile = new File("c:/test.properties");

		// ファイルインプットストリームの取得
		InputStream in = new FileInputStream(propertyFile);

		// プロパティオブジェクトの取得
		Properties properties = new Properties();

		// ファイルインプットストリームからの読み込み
		properties.load(in);

		// greetingというキーを持つプロパティの値を取得
		String value = properties.getProperty("greeting");
		System.out.println(value);

		// Propertiesは文字をISO8859_1で扱うので、日本語は文字化ける可能性がある。
		// 適切なコードへ変換
		value = toUnicode(value);

		System.out.println(value);
	}

	// ISO8859_1を日本語へ変換するメソッド
	public static String toUnicode(String s) throws Exception {
		String encoded = null;
		encoded = new String(s.getBytes("8859_1"), "UTF-8");
		return encoded;
	}
}

