
package global.generic;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/** システム全体で使用される日付を表すオブジェクト。
 *  日付は年月日に加え時間単位で扱われ、それ未満の単位は全て0で扱われる。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class GlobalDate {

	/** 日付を保持する。 */
	private Date date;
	/** 日付を計算するために用いられる。dateと同一の日時を持つようにする */
	private Calendar cal;

	/** コンストラクタ。
	 * 現在の時刻をもとに、時間までのデータを内部データとして保持する。getGlobalDate()でその情報を取得できる。
	 */
	public GlobalDate() {
		this.date = new Date();
		this.date = Support.getDate(date, "hour");
		this.cal = Calendar.getInstance();
		this.cal.setTime(this.date);
	}

	/** コンストラクタ。
	 * 指定されたjava.util.Dateのデータを元に、分以降の値を0にする。
	 * @param date 日付データ。
	 */
	public GlobalDate(Date date) {
		this();
		try {
			this.date = Support.getDate(date, "hour");
			this.cal.setTime(this.date);
		} catch (NullPointerException e) {
			//Nothing toDo.
		}
	}

	/** コンストラクタ。
	 * 指定されたjava.sql.Timestampのデータをもとに、フィールドdate, calendarの分以降の値を0にして初期化する。
	 * @param date 日付データ。
	 */
	public GlobalDate(Timestamp date) {
		this();
		try {
			this.date = Support.getDate(new Date(date.getTime()), "hour");
			this.cal.setTime(this.date);
		} catch (NullPointerException e) {
			//Nothing toDo.
		}
	}

	/** コンストラクタ。
	 * 指定された数値をもとにフィールドdate, calendarのデータを設定する。年は今年を、分，秒は0にする。java.util.Dateは月が0から始まっているが、ここでは月は1から始まるものとする。
	 * @param month 月
	 * @param day 日
	 * @param hour 時
	 */
	public GlobalDate(int month, int day, int hour) {
		this();
		this.date =
			Support.getDate(cal.get(Calendar.YEAR), month, day, hour);
		this.cal.setTime(this.date);
	}

	/** オブジェクトが持っている日付を返す。
	 * @return 必要な部分が0に設定されている日付データ。
	 */
	public Date getGlobalDate() {
		return this.date;
	}


	/** オブジェクトが持っている月のデータを返す。月は1から始まるものを返すようにする。
	 * @return 月を表す整数値。
	 */
	public int getMonth() {
		return this.cal.get(Calendar.MONTH) + 1;
	}

	/** オブジェクトが持っている日のデータを返す。
	 * @return 日を表す整数値。
	 */
	public int getDay() {
		return this.cal.get(Calendar.DATE);
	}

	/** dayで指定された日数をフィールドdate, calendarに足す。
	 * @return 計算後の値をもつ、GlobalDateオブジェクト自身を返す。
	 * @param day 現在の日付に足したい日数。
	 */
	public GlobalDate addDay(int day) {
		this.cal.add(Calendar.DATE, day);
		this.date = this.cal.getTime();
		return this;

	}

	/** オブジェクトが持っている時間のデータを返す。
	 * @return 時間を表す整数値。
	 */
	public int getHour() {
		return this.cal.get(Calendar.HOUR_OF_DAY);
	}

	/** オブジェクトが持っている日付をjava.sql.Timestampに変換して返す。
	 * @return オブジェクトが持っている日付をTimestamp型に変換したもの。
	 */
	public Timestamp toSQLDate() {
		return new Timestamp(this.cal.getTime().getTime());

	}

	/** オブジェクトが持っている日付データの文字列表現。YYYY年MM月DD日 HH時のフォーマットで出力する。
	 * @return "YYYY年MM月DD日 HH時"
	 */
	public String toString() {
		String dateForm;
		dateForm =
			cal.get(Calendar.YEAR)
				+ "年 "
				+ getMonth()
				+ "月 "
				+ getDay()
				+ "日 "
				+ getHour()
				+ "時";
		return dateForm;
	}
}
