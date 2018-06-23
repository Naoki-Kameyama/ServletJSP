/*
 * SQLのテンプレート
 *
 */

package template;

/** データベース操作に使用するSQL文を定数として定義したクラス。
 * @author Yuki Yamazaki
 * @version 2.0b
 */
public final class ConcreteSQL {
	public static final String SELECT_ALL = "SELECT COLS FROM TABLE ";
	public static final String SELECT__BY_PK = SELECT_ALL + "WHERE PK = ? ";
	public static final String INSERT_ =
		"INSERT INTO TABLE VALUES( ?, ?, ?, ?, ?, ?, ? )";
	public static final String UPDATE_ =
		"UPDATE TABLE SET COL = ? WHERE PK = ? ";
	public static final String DELETE_ = "DELETE FROM TABLE WHERE PK = ?";
}
