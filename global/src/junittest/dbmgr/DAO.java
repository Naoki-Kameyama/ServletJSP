package junittest.dbmgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Vector;

import global.dbmgr.DBManager;
import global.generic.ValueException;
import global.generic.ValueObject;





/**
 * IDAOインタフェースで定義されている、データベース操作に対する操作のいくつかを実装している基底抽象クラス。
 * @author Kohei Shimoyama, Dongyoung Jung
 * @version 1.0
 */

public abstract class DAO implements IDAO {

	private String primaryKey;
	private String tableName;

	protected DAO(String tableName, String primaryKey) {
		this.primaryKey = primaryKey;
		this.tableName = tableName;
	}

	public abstract ValueObject insert(ValueObject valueObject) throws DBValueException;

	public abstract ValueObject update(ValueObject valueObject) throws DBValueException;

	public abstract ValueObject delete(ValueObject valueObject) throws DBValueException;

	public int execute(PreparedStatement prep) throws ValueException {
		int result;
		try {
			result = prep.executeUpdate();
		} catch (Exception e) {
			throw new ValueException();
		}
		return result;
	}

	public abstract ValueObject findByPrimaryKey(Object PK) throws ValueException;

	public PreparedStatement getPreparedStatement(String sql) throws ValueException {
		DBManager dbm;
		Connection con;
		PreparedStatement pstmt;

		try {
			dbm = new DBManager();
			con = DBManager.getConnection();
			pstmt = con.prepareStatement(sql);
		} catch (Exception e) {
			throw new ValueException();
		}
		return pstmt;
	}

	public ResultSet getResultSet(PreparedStatement prep) throws ValueException {
		ResultSet rs;
		try {
			rs = prep.executeQuery();
		} catch (Exception e) {
			throw new ValueException();
		}
		return rs;
	}

	public void isDuplicatePK(String PK) throws DBValueException, DuplicatePrimaryKeyException {

		try {
			PreparedStatement pstmt = getPreparedStatement("SELECT COUNT(*) FROM " + tableName + " WHERE PK = " + PK);
			ResultSet rs = getResultSet(pstmt);
			if (rs.getInt(1) >= 1) {
				throw new DuplicatePrimaryKeyException();
			}
		} catch (DuplicatePrimaryKeyException e) {

		} catch (Exception e) {
			throw new DBValueException();
		}

	}

	public void isDuplicatePK(int PK) throws DBValueException, DuplicatePrimaryKeyException {
		try {
			PreparedStatement pstmt = getPreparedStatement("SELECT COUNT(*) FROM " + tableName + " WHERE PK = " + PK);
			ResultSet rs = getResultSet(pstmt);
			if (rs.getInt(1) >= 1) {
				throw new DuplicatePrimaryKeyException();
			}
		} catch (DuplicatePrimaryKeyException e) {

		} catch (Exception e) {
			throw new DBValueException();
		}
	}

	public void isExistPK(String PK) throws DBValueException, NoSuchPrimaryKeyException {
		try {
			PreparedStatement pstmt = getPreparedStatement("SELECT COUNT(*) FROM " + tableName + " WHERE PK = " + PK);
			ResultSet rs = getResultSet(pstmt);
			if (rs.getInt(1) == 1) {
				throw new DuplicatePrimaryKeyException();
			}
		} catch (NoSuchPrimaryKeyException e) {

		} catch (Exception e) {
			throw new DBValueException();
		}
	}

	public void isExistPK(int PK) throws DBValueException, NoSuchPrimaryKeyException {
		try {
			PreparedStatement pstmt = getPreparedStatement("SELECT COUNT(*) FROM " + tableName + " WHERE PK = " + PK);
			ResultSet rs = getResultSet(pstmt);
			if (rs.getInt(1) == 1) {
				throw new DuplicatePrimaryKeyException();
			}
		} catch (NoSuchPrimaryKeyException e) {

		} catch (Exception e) {
			throw new DBValueException();
		}
	}

	public Enumeration<String> getPKs() throws DBValueException {
		PreparedStatement pstmt;
		ResultSet rs;
		Enumeration<String> enu = null;
		Vector<String> vec;

		try {
			pstmt = getPreparedStatement("SELECT COLS FROM " + this.tableName);
			rs = getResultSet(pstmt);
			vec = new Vector<String>();

			while (rs.next()) {
			String s = rs.getString(1);
			vec.add(s);
			}
			enu = vec.elements();

		} catch (Exception e) {
			throw new DBValueException();
		}

		return enu;
	}

}
