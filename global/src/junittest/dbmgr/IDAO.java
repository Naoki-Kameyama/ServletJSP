package junittest.dbmgr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import global.generic.ValueException;
import global.generic.ValueObject;

/**
 * @author Kohei Shimoyama
 * @version 1.0
 * データベース操作に関する一般的なメソッドを定義するインタフェース。
 */

public interface IDAO {

	public ValueObject insert(ValueObject valueObject) throws ValueException;

	public ValueObject update(ValueObject valueObject) throws ValueException;

	public ValueObject delete(ValueObject valueObject) throws ValueException;

	public int execute(PreparedStatement prep) throws ValueException;

	public ValueObject findByPrimaryKey(Object PK) throws ValueException;

	public PreparedStatement getPreparedStatement(String sql) throws ValueException;

	public ResultSet getResultSet(PreparedStatement prep) throws ValueException;

	public void isDuplicatePK(String PK) throws ValueException, DuplicatePrimaryKeyException;

	public void isDuplicatePK(int PK) throws ValueException, DuplicatePrimaryKeyException;

	public void isExistPK(String PK) throws ValueException, NoSuchPrimaryKeyException;

	public void isExistPK(int PK) throws ValueException, NoSuchPrimaryKeyException;

	public Enumeration<String> getPKs() throws ValueException;

}
