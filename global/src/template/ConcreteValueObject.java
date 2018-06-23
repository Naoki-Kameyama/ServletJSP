/*
 * ValueObjectのテンプレート
 *
 */

package template;

import global.generic.ValueObject;

/**
 * バリューオブジェクト。
 *
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class ConcreteValueObject extends ValueObject {

	private String field1;

	/** コンストラクタ */
	public ConcreteValueObject() {
	}

	/**
	 * フィールドに対するgetterメソッド。
	 *
	 * @return フィールドの値。
	 */
	public String getField1() {
		return field1;
	}

	/**
	 * フィールドに対するsetterメソッド。
	 *
	 * @param field1
	 *            フィールド1
	 */
	public void setField1(java.lang.String field1) {
		this.field1 = field1;
	}

}
