package global.dbmgr;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author Dongyoung Jung
 * @version 0.0.2
 *
 */
public class DBManager {
	private static java.sql.Connection con;
	private static final String PROJECTDIR = "/";
	private static final String DBPROP = PROJECTDIR + "db.properties";
	private static String driver;
	private static String passWord;
	private static String url;
	private static String userName;

	public DBManager() throws DBException {
		loadDBProps();

		try {
			Class.forName(driver);
			DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			throw new DBException();
		}
	}

	public static synchronized Connection getConnection() throws DBException {
		if (con == null)
			try {
				con = DriverManager.getConnection(url, userName, passWord);
			} catch (Exception e) {
				throw new DBException();
			}

		return con;
	}

	public void closeConnection() throws DBException {
		if (this.con != null)
			try {
				con.close();
			} catch (Exception e) {
				throw new DBException();
			}
	}

	private static void loadDBProps() throws DBException {

		try {
			InputStream in = new FileInputStream(new File(DBPROP));
			Properties properties = new Properties();
			properties.load(in);

			userName = properties.getProperty("USERNAME");
			passWord = properties.getProperty("PASSWORD");
			driver = properties.getProperty("DRIVER");
			url = properties.getProperty("JDBC_URL");

		} catch (Exception e) {
			throw new DBException();
		}
	}
}
