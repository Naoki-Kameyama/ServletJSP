
package global.generic;

/**
 *  グローバル製菓社のデータ（エンティティ）定義に従い、不正なデータをチェックするためのメソッドが含まれる。
 *  製品カテゴリ、優待ランク、空白、生産計画ステータス、定価等のチェックを行う。
 *  @author Yuki Yamazaki, Masashi Okamura
 *  @version 2.1c
 */
public class Validate {
	/**
	 * 空白かどうかをチェックし、結果をbooleanで返す。
	 * @param s 対象文字列
	 * @return 空白ならばtrueを返す。
	 */
	public static boolean isEmpty(String s) {

		boolean status = false;

		try {
			if (s.equals("")) {
				status = true;
			}
		} catch (NullPointerException e) {
			status = true;
		}

		return status;
	}

	/**
	 * 顧客ランクが正しい値(A~E)になっているかをチェックし、結果をbooleanで返す。
	 * @param rank 顧客ランク。大文字小文字は問わない。
	 * @return 正しければtrueを返す。
	 */
	public static boolean isCustomerRank(String rank) {
		boolean status = true;
		String RANK = rank.toUpperCase();

		if (!(RANK.equals("A")
			|| RANK.equals("B")
			|| RANK.equals("C")
			|| RANK.equals("D")
			|| RANK.equals("E"))) {
			status = false;
		}

		return status;
	}

	/** 文字型として与えられた値が、数値として正しいかチェックし、結果をbooleanで返す。
	 *  @param price 調べたい文字列。
	 *  @return 正しければtrueを返す。また、DBスキーマに合わせて、定価が0.01円未満の場合はfalseとする。
	 */
	public static boolean isPrice(String price) {
		boolean status = true;

		try {
			Double d = new Double(price);

			if (d.doubleValue() < 0.01) {
				status=false;
			}
		} catch (NumberFormatException e) {
			status = false;
		}


		return status;
	}

	/**
	 * 製品ステータス(ON, DISCONTINUE)として正しいかテストする。
	 *@param productStatus 製品ステータス
	 *@return 正しければtrueを返す。
	 */
	public static boolean isProductStatus(String productStatus) {
		boolean status = true;

		if (!(productStatus.toUpperCase().equals("ON")
			|| productStatus.toUpperCase().equals("DISCONTINUE"))) {
			status = false;
		}

		return status;
	}

	/** 製品カテゴリとして適切かどうかを検証する.
	 * @param categoryName カテゴリ名。大文字小文字は問わない。
	 * @return 正しければtrueを返す。
	 */

	public static boolean isCategoryName(String categoryName) {
		String[] categories = { "cake", "choco", "pie", "cookie", "candy" };
		boolean status = false;

		for (int _i = 0; _i < categories.length; _i++) {
			if (categories[_i]
				.toUpperCase()
				.equals(categoryName.toUpperCase())) {
				status = true;
				break;
			}
		}

		return status;

	}

	/**
	 * 生産計画のステータスとして適切かどうか検証する.
	 *@param planStatus 生産計画ステータス
	 *@return 正しければtrueを返す。
	 */
	public static boolean isPlanStatus(String planStatus) {
		boolean status = true;
		String _PLANSTATUS = planStatus.toUpperCase();
		if (!(_PLANSTATUS.equals("COMPLETED")
			|| _PLANSTATUS.equals("PROCESSING")
			|| _PLANSTATUS.equals("PLAN")
			|| _PLANSTATUS.equals("CANCELED"))) {
			status = false;
		}

		return status;
	}

	/** 受注ステータス(ACCEPTED, CANCELED, SHIPPED)として適切かどうか検証する。
	 * @param orderStatus 受注ステータス。大文字小文字は問わない。
	 * @return 正しければtrueを返す。
	 */
	public static boolean isOrderStatus(String orderStatus) {
		boolean status = true;
		String _ORDERSTATUS = orderStatus.toUpperCase();
		if (!(_ORDERSTATUS.equals("ACCEPTED")
			|| _ORDERSTATUS.equals("CONFIRMING")
			|| _ORDERSTATUS.equals("PRODUCING")
			|| _ORDERSTATUS.equals("SHIPPED")
			|| _ORDERSTATUS.equals("CANCELED"))) {
			status = false;
		}

		return status;
	}

	/** 指定された整数が0より大きいかどうか検証する
	 * @param n 入力値
	 * @return 正であればtrueを返す。
	 */
	public static boolean isPositive(int n) {
		boolean status = false;
		if (n > 0) {
			status = true;
		}
		return status;
	}

	/** 指定された実数が0.0より大きいかどうかを検証する
	 * @param d 入力値
	 * @return 正であればtrueを返す。
	 */
	public static boolean isPositive(double d) {
		boolean status = false;
		double d_Zero = 0.0;

		if (d > d_Zero) {
			status = true;
		}
		return status;
	}

}
