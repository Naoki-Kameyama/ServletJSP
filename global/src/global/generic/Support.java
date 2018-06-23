
package global.generic;

import java.util.Calendar;
import java.util.Date;

/** 共通で使用されるいくつかの機能をまとめる。
 *  日付の端数単位を全て0にするためのメソッドが含まれる。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class Support {

	/**
	 * 日付けの時刻を全て0にする。
	 * @param date java.util.Date型の日付
	 * @return 時刻が0になっている日付
	 */
	public static Date getDate(Date date) {
		return getDate(date, "non");
	}

	/**
	 * 日付けの精度を整える。指定された単位以降は0にする。
	 * 以下の精度が指定できる。
	 * hour 2015/10/10 13:00:00
	 * min 2015/10/10 13:13:00
	 * sec 2015/10/10 13:13:13
　　 * Calendarクラスを通して実際に存在する日付かどうかもチェックさせる。
	 *
	 *@param date 対象の日付
	 *@param prec "hour", "min", "sec"のうちのどれか1つを指定する。
	 *@return 指定された単位以降を0にした日付
	 */
	public static Date getDate(Date date, String prec) {
		Calendar cal = Calendar.getInstance();
		Calendar calorg = Calendar.getInstance();

		prec = prec.toUpperCase();

		calorg.setTime(date);

		cal.clear();
		cal.setLenient(false);

		cal.set(Calendar.YEAR, calorg.get(Calendar.YEAR));
		cal.set(Calendar.MONTH, calorg.get(Calendar.MONTH));
		cal.set(Calendar.DATE, calorg.get(Calendar.DATE));

		if (prec.equals("HOUR")) {

			cal.set(Calendar.HOUR_OF_DAY, calorg.get(Calendar.HOUR_OF_DAY));

		} else if (prec.equals("MIN")) {

			cal.set(Calendar.HOUR_OF_DAY, calorg.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE, calorg.get(Calendar.MINUTE));

		} else if (prec.equals("SEC")) {

			cal.set(Calendar.HOUR_OF_DAY, calorg.get(Calendar.HOUR_OF_DAY));
			cal.set(Calendar.MINUTE, calorg.get(Calendar.MINUTE));
			cal.set(Calendar.SECOND, calorg.get(Calendar.SECOND));
		}

		return cal.getTime();
	}

	/**
	 * 日付けの精度を整える。指定された単位以外は0にする。
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @param hour 時間
	 * @return 指定された単位外を0にした日付。
	 */
	public static Date getDate(int year, int month, int day, int hour) {
		return getDate(year, month, day, hour, 0, 0);
	}

	/**
	 * 日付けの精度を整える。
     * Calendarクラスを通して実際に存在する日付かどうかもチェックさせる。
	 * @param year 年
	 * @param month 月
	 * @param day 日
	 * @param hour 時間
	 * @param minute 分
	 * @param second 秒
	 * @return 日付。
	 */
	public static Date getDate(int year, int month, int day, int hour, int minute, int second) {
		Calendar cal = Calendar.getInstance();
		Date date = new Date();

		cal.clear();
		cal.setLenient(false);

		cal.set(year, month - 1, day, hour, minute, second);

		date = cal.getTime();

		return date;
	}
}
