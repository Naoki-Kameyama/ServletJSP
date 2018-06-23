package global.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Actionオブジェクトが持たなくてはならないメソッドを定義したインターフェイス。
 * @author Yuki Yamazaki, Masashi Okamura
 * @version 2.1c
 */
public interface Action {

	/** Controllerから呼び出される。Actionオブジェクトの起動メソッド。
	 * @param req Servletリクエスト。
	 * @param res Servletレスポンス。
	 * @throws ActionException Controllerから呼び出される。Actionオブジェクトの起動メソッド。
	 */
	public void doAction(HttpServletRequest req, HttpServletResponse res)
		throws ActionException;

	/** パラメータの妥当性をチェックする。もし、値が不適当ならば、例外(ActionValidateException)を発生させる。
	 * @param parameters このActionに与えられたパラメータ。
	 * @throws ActionValidateException 入力パラメータが不適当な際に発生させる。
	 */
	public void doValidate(Parameters parameters)
		throws ActionValidateException;

	/** 業務ロジックを実行する。実行がうまくできなければ、ActionInvokeExceptinを発生させる。
	 * @param parameters このActionに与えられたパラメータ。
	 * @throws ActionInvokeException 業務ロジックの実行が不正に終わったときは、ActionInvokeExceptionとして転送する。
	 */
	public void doInvoke(Parameters parameters) throws ActionInvokeException;

	/** 本Actionを表示するためのJSPのURLを戻す。
	 * @return このアクションのためのJSPのURL。
	 */
	public String getJSP();

	/** 本Actionの実行の結果、与えられた値を戻す。パラメータはサブクラスが持つ。
	 * @return Actionオブジェクトが保持しているParameterオブジェクト。
	 */
	public Parameters getParameters();

}
