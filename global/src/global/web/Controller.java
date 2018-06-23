package global.web;

import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import global.generic.Validate;

/** HTTPリクエスト受け付け、それに必要な各種処理を呼び出した後、適切なJSPファイルを呼び出すディスパッチャー(配送)クラス。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	/** リクエスト回数を数えるカウンター。（オプション） */
	private static int counter = 0;

	/** ServletContext */
	ServletContext servletContext;
	/** RequestDispatcher */
	RequestDispatcher dispatcher;

	/** doGetに転送する。
	 * @param req Servletリクエスト。
	 * @param res Servletレスポンス。
	 * @throws IOException IO例外。
	 * @throws ServletException Servlet例外。
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {

		doGet(req, res);

	}

	/** リクエスト内に含まれるactionというパラメータを元に、Actionオブジェクトを取得する。ActionオブジェクトのdoActionメソッドを実行した上で、その結果の取得、JSPの取得を行い、適切なJSPへフォワードする。
	 * @param req Servletレスポンス。
	 * @param res Servletリクエスト。
	 * @throws IOException IO例外。
	 * @throws ServletException Servlet例外。
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");

		Action action;
		Parameters parameters = null;

		String actionTag = req.getParameter("action");

		if (actionTag == null)
			actionTag = "";


		 parameterTrace(req);

		try {
			if (Validate.isEmpty(actionTag)) {
				throw new ActionException("actionTag に指定がありません");
			}

			action = (Action) ActionFactory.getObject(actionTag + ".action");

			action.doAction(req, res);
			  System.out.println("Controller: Action was OK");
			  parameters = action.getParameters();
			  parameters = action.getParameters();
			  System.out.println("Controller: getParameter was OK");
			  forwardedParameterTrace(action, parameters);
			  System.out.println("Controller: ParameterTrace was OK");
			  System.out.println("Controller: getJSP: " + action.getJSP());
			forward(req, res, action.getJSP(), parameters);


		} catch (ActionException e) {

			System.out.println("Action: " + e);
			System.out.println("Action: " + e.getMessage());
			parameters = new Parameters();
			parameters.put("error", e);
			forward(
				req,
				res,
				ActionFactory.findValue("error.Exception.jsp"),
				parameters);

		} catch (Exception e) {

			System.out.println("Others: " + e);
			parameters = new Parameters();
			parameters.put("error", e);
			forward(
				req,
				res,
				ActionFactory.findValue("error.Exception.jsp"),
				parameters);

		}
	}

	/** JSPを呼び出す際の手順（ディスパッチング）を簡単にしたもの。
	 * @param req Servletリクエスト。
	 * @param res Servletレスポンス。
	 * @param uri 呼び出したいJSPのURI。
	 * @param parameters JSPに渡したいパラメータ。
	 * @throws IOException IO例外。
	 * @throws ServletException Servlet例外。
	 */
	private void forward(
		HttpServletRequest req,
		HttpServletResponse res,
		String uri,
		Parameters parameters)
		throws IOException, ServletException {

		servletContext = getServletContext();
		dispatcher = servletContext.getRequestDispatcher(uri);
		req.setAttribute("parameters", parameters);
		req.getAttribute("parameters", parameters);

		dispatcher.forward(req, res);
	}


	/** デバッグ用メッセージ。
	 * @param req Servletリクエスト。
	 */
	private void parameterTrace(HttpServletRequest req) {

		Enumeration<String> paramNames = req.getParameterNames();

		Date now = new Date();
		counter++;

		System.out.println(
			"======== parameter trace : " + counter + " : " + now + " =======");

		while (paramNames.hasMoreElements()) {

			String paramName = (String) paramNames.nextElement();
			String paramValue = req.getParameter(paramName);

			System.out.println(paramName + ":" + paramValue);
		}
		System.out.println("===========================");
		System.out.println("");
	}
	
	

	/** デバッグ用メッセージ。
	 * @param action アクション名。
	 * @param params パラメーター名。
	 */
	private void forwardedParameterTrace(Action action, Parameters params) {

		Enumeration<Object> keys = params.keys();

		//System.out.println("JSP>> " + action.getJSP());

		while (keys.hasMoreElements()) {

			String key = (String) keys.nextElement();
			String value = params.getParam(key).toString();
			System.out.println("\t" + key + ":" + value);
		}
	}
}