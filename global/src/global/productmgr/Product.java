package global.productmgr;

import global.generic.Validate;
import global.generic.ValueObject;

/** 製品を表すデータベース(PRODUCTSテーブル)と関連するバリューオブジェクト。
 *  1オブジェクトが1製品を表現する。
 *  データベースに関する処理は、ProductDAOに行わせる。製品カテゴリを表す
 *  フィールドにはCategoryオブジェクトを使用する。また、不正な製品データ
 *  を防ぐためにいくつかのValidateクラス内のメソッドが使用される。
 * @author Tomohiro Kanda
 * @version 1.0
 */

public class Product extends ValueObject {

	//フィールドの定義
	private Category category; //製品カテゴリ
	private double price; //定価
	private String status; //製品ステータス
	private int stock; //在庫数
	public static final int maxStock = 99999999; //最大在庫数(99999999）

	//メソッドの定義
	//フィールドcategoryをインスタンス化する。
	public Product() {
		category = new Category();
	}

	//フィールドcategoryに対するgetterメソッド。
	//戻り値：categoryの値
	public Category getCategory() {
		return category;
	}

	//フィールドpriceに対するgetterメソッド。
	//戻り値：priceの値
	public double getPrice() {
		return price;
	}

	//フィールドにstatus対するgetterメソッド
	//戻り値：statusの値
	public String getStatus() {
		return status;
	}

	//フィールドにstock対するgetterメソッド
	//戻り値：stockの値
	public int getStock() {
		return stock;
	}

	//フィールドにcategory対するsetterメソッド
	//引数：category カテゴリオブジェクト
	public void setCategory(Category category) {
		this.category = category;
	}

	//フィールドにprice対するsetterメソッド
	//引数：price 定価
	public void setPrice(double price) {
		this.price = price;
	}

	//フィールドにstock対するsetterメソッド
	//引数：stock 在庫数
	public void setStock(int stock) {
		this.stock = stock;
	}

	//フィールドにstatus対するsetterメソッド
	//引数：status 製品ステータス
	public void setStatus(String status)
			throws ProductValueException {

		if (Validate.isProductStatus(status)) {
			this.status = status;
		} else {
			throw new ProductValueException("product#setStatus(): ");
		}
	}
}
