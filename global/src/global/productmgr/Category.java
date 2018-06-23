package global.productmgr;

import global.generic.Validate;

/** 製品のカテゴリを表すオブジェクト。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class Category {

	/** 製品カテゴリ名。 */
	private String name;

	/** コンストラクタ。 */

	public Category() {
	}

	/** コンストラクタ。指定された製品カテゴリ名を、内部フィールドに代入する。
	 * @param categoryName 製品カテゴリ名。
	 * @throws ProductValueException 不正な製品カテゴリ名が指定されたらProductValueExceptionを発生させる。
	 */
	public Category(String categoryName) throws ProductValueException {
		this.setName(categoryName);
	}
	/** フィールドに対するgetterメソッド。
	 * @return フィールドの値。
	 */
	public String getName() {
		return name;
	}

	/** フィールドに対するsetterメソッド。
	 * @param name 製品カテゴリ名。
	 * @throws ProductValueException 不正な製品カテゴリ名が指定されたらProductValueExceptionを発生させる。
	 */
	public void setName(String name) throws ProductValueException {
		if (Validate.isCategoryName(name)) {
			this.name = name;
		} else {
			throw new ProductValueException("category#setName(): ");
		}
	}

	/** オブジェクトの文字列表現。
	 * @return 製品カテゴリ名。
	 */
	public String toString() {
		return this.name;
	}

}
