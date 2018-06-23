/*
 * Singletonのサンプル
 *
 */

package sample;

public class SingletonSample {
	//自分自身のクラスを1つ持つようにする。
	private static SingletonSample singleton;

	//コンストラクタをprivateにする。
	private SingletonSample() {
	}

	//インスタンスを得るためのメソッド。
	public static SingletonSample getInstance() {

		//もし、既にインスタンス化されていなければ、インスタンス化する。
		//インスタンス化されていれば、それを返す。
		if (singleton == null)
			singleton = new SingletonSample();

		return singleton;
	}
}
