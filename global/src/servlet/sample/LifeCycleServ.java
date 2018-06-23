
package servlet.sample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycleServ")
public class LifeCycleServ extends HttpServlet {

	// JDBCの型宣言
	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;

	// Servlet起動時に呼び出されるメソッド
	public void init(ServletConfig config) throws ServletException
	{
		String JDBC_URL = "jdbc:postgresql://localhost:5432/test00";
		String USER = "postgres";
		String PASSWORD = "postgres";

		super.init(config);

		// JDBCのコネクション接続
		try
		{

			Class.forName("org.postgresql.Driver");
			// 接続
			con = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
			System.out.println("データベースに接続しました");

			// Statementオブジェクトの獲得
			stmt = con.createStatement();
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// GETリクエストを処理するメソッド
	public void doGet(HttpServletRequest reqest, HttpServletResponse response)
			throws ServletException, IOException
	{
		// MIME形式をセット
		reqest.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		// JDBC処理
		try
		{
			// ResultSetオブジェクトの獲得
			res = stmt.executeQuery("select * from MYSQLDATA");

			// 文字列表示
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet with JDBC on LifeCycle</title>");
			out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
			out.println("</head>");
			out.println("<body bgcolor=\"White\"><table width=\"100%\" border=\"0\">");
			out.println("<tr><td bgcolor=\"#0033CC\" height=\"14\"><font color=\"#FFFFFF\">");
			out.println("<b>例題1 ServletとJDBCの連携 </b></font></td></tr></table>");

			// テーブル表示
			out.println("<p></p><table border=1 align=left><tr bgcolor=\"#FFAD00\">");
			out.println("<th>No.<th>タイトル<th>監督<th>配給会社<th>製作日<th>主演</tr>");

			// 結果の処理
			while (res.next())
			{
				// カウントは1から始まる事に注意。
				out.print("<tr><td>" + res.getInt("NO"));
				out.print("<td>" + res.getString("TITLE") + "</td>");
				out.print("<td>" + res.getString("DIRECTOR") + "</td>");
				out.print("<td>" + res.getString("CORPRATION") + "</td>");
				out.print("<td>" + res.getString("MADE") + "</td>");
				out.print("<td>" + res.getString("ACTOR") + "</td>");
				out.println("</tr>");
			}
		} catch (SQLException e)
		{
			e.printStackTrace();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		out.println("</table></body></html>");
	}

	// Servletが終了するときに呼び出されるメソッド
	public void destroy()
	{
		try {
			// ⑥データベース処理のクローズ
			if (res != null) {
				res.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}