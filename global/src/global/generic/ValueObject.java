package global.generic;

/** エンティティの基底クラス。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
abstract public class ValueObject {

	/** エンティティの番号を保持する。 */
	protected String id;

	/** エンティティの名前を保持する。 */
	protected String name;

	/** エンティティに関する記述を保持する。 */
	protected String desc;

	/** コンストラクタ。 */
	public ValueObject() {
	}

	/** フィールドに対するgetterメソッド。
	 * @return 記述。
	 */
	public String getDesc() {
		return desc;
	}

	/** フィールドに対するsetterメソッド。
	 * @param desc 記述。
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/** フィールドに対するgetterメソッド
	 * @return 番号。
	 */
	public String getId() {
		return id;
	}

	/** フィールドに対するsetterメソッド。
	 * @param id 番号。
	 */
	public void setId(String id) {
		this.id = id;
	}

	/** フィールドに対するgetterメソッド。
	 * @return フィールドの値。
	 */
	public String getName() {
		return name;
	}

	/** フィールドに対するsetterメソッド。
	 * @param name 名前。
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** オブジェクトの文字列表現。
	 * @return 以下のようなフォーマットの文字列。id=xxx : name=xxx : desc=xxx
	 */
	public String toString() {
		return "id="
			+ this.id
			+ ":"
			+ "name="
			+ this.name
			+ ":"
			+ "desc="
			+ this.desc;
	}

}
