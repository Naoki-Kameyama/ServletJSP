/*
 * DAOのテンプレート
 */

package template;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import global.dbmgr.DBValueException;
import global.generic.ValueException;
import global.generic.ValueObject;
import junittest.dbmgr.DAO;

/**
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class ConcreteDAO extends DAO {

	private static ConcreteDAO dao;

	// 対象のテーブル名とプライマリキーを指定する。
	private static final String TABLENAME = "__TABLENAME__";
	private static final String PRIMARYKEY = "__PRIMARYKEY__";

	/** コンストラクタ。newできないようにprivateとする。スーパークラスのコンストラクタにテーブル名とプライマリキー名を設定する */
	private ConcreteDAO() {
		super(TABLENAME, PRIMARYKEY);
	}

	/**
	 * 内部フィールドのproductDAOがNULLだったら、ProductDAOをインスタンス化したうえで返す。
	 *
	 * @return ProductDAOのインスタンス。
	 */
	public static ConcreteDAO getInstance() {
		if (dao == null)
			dao = new ConcreteDAO();

		return dao;
	}

	/**
	 * 主キーを元にデータベースから行を検索した後、それを元にしてエンティティ･オブジェクトを返す。
	 *
	 * @param _PK
	 *            主キー。
	 * @return 値がセットされた状態のエンティティ・オブジェクト。
	 * @throws ConcreteValueException
	 *             本メソッド内で生じた全例外はConcreteValueExceptionとして転送される。
	 */
	public ValueObject findByPrimaryKey(Object PK) throws ValueException {

		ValueObject valueObject = new ConcreteValueObject();

		try {

			// 対照データが存在するかチェックする。
			// 存在しなければエラー
			this.isExistPK((String) PK);

			// プライマリーキーにより特定の1行を検索するSQL文を指定する。
			// 例）"SELECT ID, NAME, DESC FROM SAMPLE WHERE ID = ?"
			PreparedStatement pstmt = this
					.getPreparedStatement("__SQL_SELECT_BY_PK__");

			// プレイスフォルダーにセットしてSQLを実行する。
			pstmt.setString(1, (String) PK);
			ResultSet rs = this.getResultSet(pstmt);

			// 値を取得する。
			while (rs.next()) {
				valueObject.setId(rs.getString(1));
				valueObject.setName(rs.getString(2));
				valueObject.setDesc(rs.getString(3));
			}

		} catch (DBValueException e) {
			throw new Exception(
					"valueObjectDAO#findByPrimaryKey(): " + e);
		} catch (SQLException e) {
			throw new Exception(
					"valueObjectDAO#findByPrimaryKey(): " + e);
		}
		return valueObject;
	}

	/**
	 * 指定されたオブジェクトをデータベースで更新する。
	 *
	 * @param valueObject
	 *            エンティティ・オブジェクト。
	 * @throws ConcreteValueException
	 *             本メソッド内で生じた全例外はConcreteValueExceptionとして転送される。
	 * @return 更新完了後のエンティティ・オブジェクト。
	 */
	public ValueObject insert(ValueObject valueObject) throws ValueException {

		try {
			// 対照データが存在しないことをチェックする。
			// 存在すればエラー
			this.isDuplicatePK(valueObject.getId());

			// 一行追加するSQL文を指定する。
			// 例）"INSERT INTO SAMPLE VALUES( ?, ?, ? )"
			PreparedStatement pstmt = this
					.getPreparedStatement("__SQL_INSERT__");

			// プレイスフォルダーにセットしてSQLを実行する。
			pstmt.setString(1, valueObject.getId());
			pstmt.setString(2, valueObject.getName());
			pstmt.setString(3, valueObject.getDesc());

			this.execute(pstmt);

			// 挿入されたデータを検索する。
			valueObject = (ValueObject) this.findByPrimaryKey(valueObject
					.getId());
		} catch (DBValueException e) {
			throw new Exception("valueObjectDAO#insert(): " + e);
		} catch (SQLException e) {
			throw new Exception("valueObjectDAO#insert(): " + e);
		}
		return valueObject;
	}

	/**
	 * 指定されたオブジェクトをデータベースで更新する。
	 *
	 * @param valueObject
	 *            エンティティ・オブジェクト。
	 * @throws ConcreteValueException
	 *             本メソッド内で生じた全例外はConcreteValueExceptionとして転送される。
	 * @return 更新完了後のエンティティ・オブジェクト。
	 */
	public ValueObject update(ValueObject valueObject) throws ValueException{

		try {
			// 対照データが存在するかチェックする。
			// 存在しなければエラー
			this.isExistPK(valueObject.getId());

			// 対象データを更新するSQL文を指定する。
			// 例）"UPDATE SAMPLE SET ID = ?, NAME = ?, DESC = ? WHERE ID = ?"
			PreparedStatement pstmt = this
					.getPreparedStatement("__SQL_UPDATE__");

			// プレイスフォルダーにセットしてSQLを実行する。
			pstmt.setString(1, valueObject.getId());
			pstmt.setString(2, valueObject.getName());
			pstmt.setString(3, valueObject.getDesc());

			pstmt.setString(4, valueObject.getId());

			this.execute(pstmt);

			// 挿入されたデータを検索する。
			valueObject = (ValueObject) this.findByPrimaryKey(valueObject
					.getId());

		} catch (DBValueException e) {
			throw new Exception("DAO#update(): " + e);
		} catch (SQLException e) {
			throw new Exception("DAO#update(): " + e);
		}
		return valueObject;
	}

	/**
	 * 指定されたオブジェクトをデータベースから削除する。
	 *
	 * @param valueObject
	 *            エンティティ・オブジェクト。
	 * @throws ConcreteValueException
	 *             本メソッド内で生じた全例外はConcreteValueExceptionとして転送される。
	 * @return 削除対象となったエンティティ・オブジェクト。引数で渡したものと同じ。
	 */
	public ValueObject delete(ValueObject valueObject) throws ValueException {

		try {
			// 対照データが存在するかチェックする。
			// 存在しなければエラー
			this.isExistPK(valueObject.getId());

			// 対象データを削除するSQL文を指定する。
			// 例）"DELETE FROM SAMPLE WHERE ID = ?"
			PreparedStatement pstmt = this
					.getPreparedStatement("__SQL_DELETE__");

			// プレイスフォルダーにセットしてSQLを実行する。
			pstmt.setString(1, valueObject.getId());
			this.execute(pstmt);

		} catch (DBValueException e) {
			throw new Exception("valueObjectDAO#delete(): " + e);
		} catch (SQLException e) {
			throw new Exception("valueObjectDAO#delete(): " + e);
		}
		return valueObject;
	}
}
