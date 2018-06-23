package global.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** HTTPによるリクエストを受け取り、パラメータの検証、業務ロジックの実行、及び、JSPファイルのフォワードを行う。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public class SimpleController extends HttpServlet {

	/** Servletの初期化。
	 * @param config コンテナ情報。
	 * @throws ServletException Servlet例外。
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

	}

	/** Servletの破棄の際に呼ばれる。 */
	public void destroy() {

	}

	/** GET，POSTの両方で呼ばれる処理。
	 * @param request HTTPリクエスト。
	 * @param response HTTPレスポンス。
	 * @throws ServletException Servlet例外。
	 * @throws IOException IO例外。
	 */
	protected void processRequest(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.close();
	}

	/** GET時の処理。HTTPによるリクエストを受け取り、パラメータの検証、業務ロジックの実行、及び、JSPファイルのフォワードを行う。
	 * @param request Servletリクエスト。
	 * @param response Servletレスポンス。
	 * @throws ServletException Servlet例外。
	 * @throws IOException IO例外。
	 */
	protected void doGet(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/** POST時の処理。doGet()へ転送する。
	 * @param request Serlvetリクエスト。
	 * @param response Servletレスポンス。
	 * @throws ServletException Servlet例外。
	 * @throws IOException IO例外。
	 */
	protected void doPost(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {
		processRequest(request, response);
	}

	/** JSPを呼び出す際の手順（ディスパッチング）を簡単にしたもの。引数で渡されたパラメータは、以下のようにJSPに渡すときに"parameters"という名前で渡すこと。
	 * req.setAttribute( "parameters", _parameters );
	 * @param req コンテナより渡されたリクエスト
	 * @param res コンテナに対するレスポンス。
	 * @param uri 呼び出したいJSPのURI。
	 * @param parameters JSPに渡したいパラメータ。
	 * @throws IOException IO例外。
	 * @throws ServletException Servlet例外。
	 */
	@SuppressWarnings("unused")
	private void forward(
		HttpServletRequest req,
		HttpServletResponse res,
		String uri,
		Parameters parameters)
		throws IOException, ServletException {

		ServletContext servletContext = getServletContext();
		RequestDispatcher dispatcher =
			servletContext.getRequestDispatcher(uri);
		req.setAttribute("parameters", parameters);
		dispatcher.forward(req, res);
	}

	/** Servlet情報を返す。
	 * @return Servlet情報。
	 */
	public String getServletInfo() {
		return "Short description";
	}

}
