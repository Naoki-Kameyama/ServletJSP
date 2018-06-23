/*
 * Finderのテンプレート
 *
 * @author Yuki Yamazaki, Masashi Okamura
 */

package template;

import global.dbmgr.IDAO;
import global.generic.ValueException;
import global.generic.ValueObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Vector;

/** 様々な条件でデータベース中のテーブルから検索しオブジェクトの集合として利用者に返す。
 * @author Yuki Yamazaki
 * @version 2.0b
 */
public class ConcreteFinder {

	/** Finderオブジェクト */
	private static ConcreteFinder finder;
	/** DAOオブジェクト */
	private IDAO dao;
	/** 検索結果数 */
	private int objectsCounts ;

	/** コンストラクタnewできないようにprivateとする。 */
	private ConcreteFinder() {
		//dao = concreteDAO.getInstance ();
	}

	/** 内部フィールドのFinderがNULLだったら、Finderをインスタンス化したうえで返す。
	 * @return Finderのインスタンス。
	 */
	public static ConcreteFinder getInstance() {
		if (finder == null) {
			finder = new ConcreteFinder();
		}

		return finder;
	}

	/** テーブル中の全件に関するオブジェクトのEnumerationを返す。
	 * 	<型指定>内で必要なデータ型を設定する。
	 * @throws ValueException 本メソッド内で生じた全例外はValueExceptionとして転送される。
	 * @return オブジェクトの集合に対するEnumeration。
	 */
	public Enumeration<型指定> getValueObjectsAll() throws ValueException {
		Enumeration<型指定> valueObjects = null;
		try {
			PreparedStatement pstmt = dao.getPreparedStatement("_SQL_");
			valueObjects = this.makeValueObjects(pstmt);
		} catch (Exception e) {
			throw new ValueException("Finder#getValueObjectsAll(): " + e);
		}
		return valueObjects;
	}

	/** 直前のオブジェクトの検索時の該当数を返す。
	 * @return フィールドの値（検索結果数）
	 */
	public int getObjectsCount() {
		return objectsCount;
	}


	/** PreparedStatementを実行し結果を取得し、オブジェクトの集合を作成しEnumerationで返す。
	 * <型指定>内で必要なデータ型を設定する。
	 * @param pstmt 実行したいPreparedStatement。
	 * @throws Exception 内部で起きた例外は全て呼び出し元に投げる。
	 * @return オブジェクトの集合に対するEnumeration。
	 */
	private Enumeration<型指定> makeValueObjects(PreparedStatement pstmt)
		throws Exception {
		Vector<型指定> v = new Vector<型指定>();
		ResultSet rs = dao.getResultSet(pstmt);

		while (rs.next()) {
			ValueObject valueObject = new ConcreteValueObject();

			valueObject.setId(rs.getString(1));
			valueObject.setName(rs.getString(2));
			valueObject.setDesc(rs.getString(3));

			v.addElement(valueObject);
		}

		objectsCount = v.size();
		return v.elements();
	}

}
