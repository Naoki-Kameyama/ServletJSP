package global.productmgr;

/**
 * ProductDAO, ProductFinderがデータベース操作に使用するSQL文を定数として定義したクラス。
 * 定数の定義が目的でありメソッドは持たない。
 * @author Kohei Shimoyama
 * @version 1.0
 */

public class ProductsSQL {
	public static final String SELECT_BY_PK = "SELECT PRODUCTID, PRODUCTNAME, PRODUCTDESC, PRODUCTCATEGORY, PRODUCTPRICE, PRODUCTSTATUS, PRODUCTSTOCK FROM PRODUCTS WHERE PRODUCTID = ? ";

	public static final String INSERT_PRODUCT = "INSERT INTO PRODUCTS VALUES(?, ?, ?, ?, ?, ?, ?) ";

	public static final String UPDATE_PRODUCT = "UPDATE PRODUCTS SET PRODUCTID = ?, PRODUCTNAME = ?, PRODUCTDESC = ?, PRODUCTCATEGORY = ?, PRODUCTPRICE = ?, PRODUCTSTATUS = ?, PRODUCTSTOCK = ? WHERE PRODUCTID = ? ";

	public static final String DELETE_PRODUCT = "DELETE FROM PRODUCTS WHERE PRODUCTID = ? ";

	public static final String SELECT_ALL = "SELECT PRODUCTID, PRODUCTNAME, PRODUCTDESC, PRODUCTCATEGORY, PRODUCTPRICE, PRODUCTSTATUS, PRODUCTSTOCK FROM PRODUCTS ORDER BY PRODUCTID ";

	public static final String SELECT_ALL_PRE = "SELECT PRODUCTID, PRODUCTNAME, PRODUCTDESC, PRODUCTCATEGORY, PRODUCTPRICE, PRODUCTSTATUS, PRODUCTSTOCK FROM PRODUCTS ";

	public static final String SELECT_BY_CATEGORY = SELECT_ALL_PRE + " WHERE PRODUCTCATEGORY = ? ORDER BY PRODUCTID ";

	public static final String SELECT_BY_NAME = SELECT_ALL_PRE + " WHERE PRODUCTNAME LIKE ? ORDER BY PRODUCTID";

	public static final String SELECT_BY_STATUS = SELECT_ALL_PRE + " WHERE PRODUCTSTATUS = ? ORDER BY PRODUCTID";

	public static final String SELECT_BY_STOCK = SELECT_ALL_PRE + " WHERE PRODUCTSTOCK BETWEEN ? AND ? ORDER BY PRODUCTID ";

}