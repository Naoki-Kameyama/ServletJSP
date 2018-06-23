package global.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** Actionインターフェイスが定義しているいくつかのメソッドの実装と、Actionオブジェクトの初期化、及び、doAction()によって実行されるほかのメソッドを実行の順番を記述したサブクラスのためのテンプレート・クラス。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
abstract public class ActionTemplate implements Action {

	/** アクションの結果を表示するJSPのURI。 */
	protected String JSP = "/default.jsp";
	/** パラメータ。 */
	protected Parameters parameters = new Parameters();

	/** 抽象メソッド。パラメータの妥当性をチェックする。もし、値が不適当ならば、例外(ActionValidateException)を発生させる。
	 * @param parameters このActionに与えられたパラメータ。
	 * @throws ActionValidateException 入力パラメータが不適当な際に発生させる。
	 */
	abstract public void doValidate(Parameters parameters)
		throws ActionValidateException;

	/** 抽象メソッド。業務ロジックを実行する。実行がうまくできなければ、ActionInvokeExceptinを発生させる。
	 * @param parameters このActionに与えられたパラメータ。
	 * @throws ActionInvokeException 業務ロジックの実行が不正に終わったときは、ActionInvokeExceptionとして転送する。
	 */
	abstract public void doInvoke(Parameters parameters)
		throws ActionInvokeException;

	/** Actionオブジェクトの初期化を行う。 JSP,parametersに値をセットする。
	 * @param req Servletリクエスト。
	 * @param res Servletレスポンス。
	 * @throws ActionInitException 本メソッド内で生じた例外はActionInitExceptionとして転送する。
	 */
	private void initAction(HttpServletRequest req, HttpServletResponse res)
		throws ActionInitException {
		try {
			this.JSP =
				ActionFactory.findValue(req.getParameter("action") + ".jsp");

			Enumeration<String> keys = req.getParameterNames();

			HttpSession session = req.getSession();
			this.parameters.put("session", session);

			while (keys.hasMoreElements()) {

				String key = keys.nextElement();
				String value = (String) req.getParameter(key);
				parameters.put(key, value);
			}

		} catch (Exception e) {

			throw new ActionInitException("パラメーターが取得できません");

		}
	}

	/** Controllerから呼び出される。Actionオブジェクトの起動メソッド。initAction(), doValidate(), doInvoke()の順番で呼び出す。
	 * @param req Servletリクエスト。
	 * @param res Serlvetレスポンス。
	 * @throws ActionException 本メソッド内で生じた例外はActionExceptionとして転送する。
	 */
	public void doAction(HttpServletRequest req, HttpServletResponse res)
		throws ActionException {

		initAction(req, res);

		try {
			doValidate(parameters);
			doInvoke(parameters);
			

		} catch (ActionValidateException e) {

			throw new ActionException(e.getMessage());

		} catch (ActionInvokeException e) {

			throw new ActionException(e.getMessage());
		}
	}

	/** フィールドに対するgetterメソッド。
	 * @return フィールドの値。
	 */
	public String getJSP() {

		return this.JSP;

	}

	/** フィールドに対するsetterメソッド。
	 * @param JSPURL JSPのURI。
	 */
	protected void setJSP(String JSPURL) {

		this.JSP = JSPURL;

	}

	/** フィールドに対するgetterメソッド。
	 * @return フィールドの値。
	 */
	public Parameters getParameters() {

		return this.parameters;

	}
}