package global.productmgr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import global.dbmgr.*;
import global.generic.ValueObject;


public class ProductDAO extends DAO{

	//フィールドの定義
	private static ProductDAO productDAO;                   //ProductDAOオブジェクト
	private static final String TABLENAME = "PRODUCTS";     //対象テーブル名
	private static final String PRIMARYKEY = "PRODUCTID";   //テーブル中のプライマリキー

	//メソッドの定義
	//スーパークラスのコンストラクタにテーブル名とプライマリキー名を設定する。
	private ProductDAO() {
		super(TABLENAME, PRIMARYKEY);
		productDAO = getInstance();
	}

	//内部フィールドのproductDAOがnullだったら、ProductDAOをインスタンス化したうえで返す。もしnullでなければそのオブジェクトを返す。
	//戻り値：productDAOオブジェクト
	public static ProductDAO getInstance() {
		if (productDAO == null)
			productDAO = new ProductDAO();

		return productDAO;
	}

	//主キーをもとにデータベースから行を検索した後、それをもとにして製品オブジェクトを返す。
	//引数：PK 主キー
	//戻り値：値がセットされた状態の製品オブジェクト
	public ValueObject findByPrimaryKey( Object PK )
			throws ProductValueException{

		Product product = new Product();

		try {

			// 対照データが存在するかチェックする。
			// 存在しなければエラー
			this.isExistPK((String) PK);

			// プライマリーキーにより特定の1行を検索するSQL文を指定する。
			// 例）"SELECT ID, NAME, DESC FROM SAMPLE WHERE ID = ?"
			PreparedStatement pstmt = this.getPreparedStatement(SELECT_BY_PK);

			// プレイスフォルダーにセットしてSQLを実行する。
			pstmt.setString(1, (String) PK);
			ResultSet rs = this.getResultSet(pstmt);

			// 値を取得する。
			while (rs.next()) {
				product.setId(rs.getString("PRODUCTID"));
				product.setName(rs.getString("PRODUCTNAME"));
				product.setDesc(rs.getString("PRODUCTDESC"));
				//product.setCategory( product.getCategory().setName(rs.getString("PRODUCTCATEGORY")));
				product.setCategory( new Category(rs.getString("PRODUCTCATEGORY")));

				product.setPrice(rs.getDouble("PRODUCTPRICE"));
				product.setStatus(rs.getString("PRODUCTSTATUS"));
				product.setStock(rs.getInt("PRODUCTSTOCK"));
			}

		}catch(ProductValueException e){
			throw new ProductValueException();
			System.out.println(e.getMessage);
		}
		return product;
	}

	//主キーをもとにデータベースから行を検索した後、それをもとにして製品オブジェクトを返す。
	//引数：PK 主キー
	//戻り値：値がセットされた状態の製品オブジェクト
	public ValueObject findByPrimaryKey( String PK )
			throws ProductValueException{

		Product product = new Product();

		try {

			// 対照データが存在するかチェックする。
			// 存在しなければエラー
			this.isExistPK((String) PK);

			//SQL文の設定
			PreparedStatement pstmt = this.getPreparedStatement(SELECT_BY_PK);
			pstmt.setString(1, PK);

			//SQL文(SELECT)を実行する
			ResultSet rs = this.getResultSet(pstmt);

			//Productの生成
			while(rs.next()) {

				product.setId(rs.getString("PRODUCTID"));
				product.setName(rs.getString("PRODUCTNAME"));
				product.setDesc(rs.getString("PRODUCTDESC"));
				product.setCategory( product.getCategory().setName(rs.getString("PRODUCTCATEGORY")));
				product.setPrice(rs.getDouble("PRODUCTPRICE"));
				product.setStatus(rs.getString("PRODUCTSTATUS"));
				product.setStock(rs.getInt("PRODUCTSTOCK"));

			}

		}catch(ProductValueException e){
			throw new ProductValueException();
			System.out.println(e.getMessage);
		}
		return product;
	}

	//指定されたオブジェクトをデータベースに挿入する。
	//引数：valueObject 製品オブジェクト。製品番号が指定されていなくてはならない。
	//戻り値：登録完了後の製品オブジェクト
	public ValueObject insert( ValueObject valueObject )
			throws ProductValueException{

		Product product = (Product)valueObject;
		ValueObject object;

		try {
			// 対照データが存在しないことをチェックする。
			this.isDuplicatePK(product.getId());

			// 一行追加するSQL文を指定する。
			PreparedStatement pstmt = this.getPreparedStatement(INSERT_PRODUCT);

			// プレイスフォルダーにセットしてSQLを実行する。
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getDesc());
			pstmt.setString(4, product.getCategory().getName());
			pstmt.setDouble(5, product.getPrice());
			pstmt.setString(6, product.getStatus());
			pstmt.setInt(7, product.getStock());

			//SQL文(INSERT)の実行
			this.execute(pstmt);

			// 挿入されたデータを検索する。
			object = (ValueObject) this.findByPrimaryKey(product.getId());

		} catch (ProductValueException e) {
			throw new ProductValueException("valueObjectDAO#insert(): " + e);
		}
		return object;

	}

	//指定されたオブジェクトをデータベースで更新する。
	//引数：valueObject 製品オブジェクト。製品番号が指定されていなくてはならない。
	//戻り値：更新完了後の製品オブジェクト
	public ValueObject update( ValueObject valueObject )
			throws ProductValueException{

		Product product = (Product)valueObject;
		ValueObject object;

		try {

			// 対照データが存在するかチェックする。
			this.isExistPK(product.getId());

			// 対象データを更新するSQL文を指定する。
			PreparedStatement pstmt = this.getPreparedStatement(UPDATE_PRODUCT);

			// プレイスフォルダーにセットしてSQLを実行する。
			pstmt.setString(1, product.getId());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getDesc());
			pstmt.setString(4, product.getCategory().getName());
			pstmt.setDouble(5, product.getPrice());
			pstmt.setString(6, product.getStatus());
			pstmt.setInt(7, product.getStock());

			this.execute(pstmt);

			// 挿入されたデータを検索する。
			object = (ValueObject) this.findByPrimaryKey(product.getId());

		} catch (ProductValueException e) {
			throw new ProductValueException("DAO#update(): " + e);
		}
		return object;

	}

	//処理を行わない。（メソッドは空にしておく）
	//引数：valueObject 製品オブジェクト。製品番号が指定されていなくてはならない。
	//戻り値：削除対象となった製品オブジェクト。引数で渡したものと同じ。
	public ValueObject delete( ValueObject valueObject )
			throws ProductValueException{

	}









}
