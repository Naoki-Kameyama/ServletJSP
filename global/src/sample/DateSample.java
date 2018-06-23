/*
 * 日付操作のサンプル
 */

package sample;

import java.util.Calendar;
import java.util.Date;

public class DateSample {

	/** Creates a new instance of DateSample */
	public DateSample() {
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {

		// Calendarオブジェクトの取得。現在の時刻が設定される。
		Calendar calendar = Calendar.getInstance();

		// 各フィールドから値を取得する。
		// 月は0からはじまる点に注意。
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DATE);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int min = calendar.get(Calendar.MINUTE);
		int sec = calendar.get(Calendar.SECOND);

		System.out.println("Now...");
		System.out.println(year + "/" + month + "/" + day + " " + hour + ":"
				+ min + ":" + sec);

		// 日時の完全なクリア
		calendar.clear();

		// 日時の厳密な解釈指定。
		// 一般的には存在しない日時をset()メソッドで設定すると例外
		// illegalArgumentException発生
		calendar.setLenient(false);

		// 時間の設定。1971年4月30日0時0分0秒に時間をセットする。
		// 月は0からはじまる点に注意。
		calendar.set(1971, 3, 30);

		// java.util.Dateへの変換
		Date date = calendar.getTime();
		System.out.println(date);

		// 100ヶ月足す。
		calendar.add(Calendar.MONTH, 100);

		date = calendar.getTime();
		System.out.println(date);
	}
}
