/*
 *動的なクラスのインスタンス化のサンプル
 */
package sample;

public class InstanciateSample {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Exception {
		//対象のクラス。CLASSPATHが設定されていなければならない
		String name = "sample.ClassSample";

		//クラスのロード
		Class c = Class.forName(name);

		//クラスのインスタンス化とキャスト
		ClassSample o = (ClassSample) c.newInstance();

		//メソッドの呼び出し
		o.sampleMethod();
	}

}
