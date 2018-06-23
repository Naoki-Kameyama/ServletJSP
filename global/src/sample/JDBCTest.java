package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest{

	static String DB_PROPERTIES = "C:/db.properties";

	static String USERNAME;
	static String PASSWORD;
	static String DATABASE;
	static String JDBC_URL;
	static String DRIVER;
	static String TESTQUERY;
	static String DBSERVER;

	public static void main( String[] args ){

		try{

			if( args.length != 1 )
				throw new Exception( "サーバー名を指定してください" );
			else
				DBSERVER=args[0];

			loadProperties();

			System.out.println( "JDBC URL is : " + JDBC_URL + "\n\n" );

			Class.forName( DRIVER );

			Connection con = DriverManager.getConnection( JDBC_URL, USERNAME, PASSWORD );

			System.out.println( "DRIVER is OK" );
			System.out.println( "USERNAME and PASSWORD is OK" );
			System.out.println( "JDBC URL is OK" );
			System.out.println( "===================" );
			System.out.println( "test phase 1: PASS" );
			System.out.println( "===================" );

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery( TESTQUERY );

			System.out.println( "QUERY Executed" );
			System.out.println( "===================" );
			System.out.println( "test phase 2: PASS" );
			System.out.println( "===================" );

			while( rs.next() ){
				String productName = rs.getString( "PRODUCTNAME" );
				System.out.print( productName + ":" );
			}
			System.out.println( "" );


			System.out.println( "===================" );
			System.out.println( "test phase 3: PASS" );
			System.out.println( "===================" );

			con.close();

			System.out.println( "" );
			System.out.println( "===================" );
			System.out.println( "test completed" );
			System.out.println( "===================" );

		}catch( ClassNotFoundException e ){
			System.out.println( "JDBC Driverが見つかりません" );
			System.out.println( "適切な場所にJDBC Driverを配備してください" );
		}catch( Exception e ){
			System.out.println( "異常が認められます" + e  );
			System.out.println( e.getMessage() );
		}

	}

	public static void loadProperties(){
		try{
			InputStream in = new FileInputStream( new File( DB_PROPERTIES ) );
			Properties properties = new Properties();
			properties.load( in );

			USERNAME = properties.getProperty( "USERNAME" );
			PASSWORD = properties.getProperty( "PASSWORD" );
			DRIVER = properties.getProperty( "DRIVER" );
			TESTQUERY = properties.getProperty( "TESTQUERY" );
			DATABASE = properties.getProperty( "DATABASE" );

			JDBC_URL= "jdbc:postgresql://" + DBSERVER + "/" + DATABASE;

		}catch( FileNotFoundException e ){
			System.out.println( "データベース接続定義ファイル( " + DB_PROPERTIES + " )が見つかりません" );
			System.exit( 1 );
		}catch( IOException e ){
			System.out.println( "データベース接続定義ファイルからデータが読み込めません" );
			System.exit( 1 );
		}
	}

}