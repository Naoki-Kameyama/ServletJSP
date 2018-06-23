/*
 * ConcreteActionの実装例
 */

package template;

import global.customermgr.Customer;
import global.customermgr.CustomerDAO;
import global.dbmgr.DBValueException;
import global.dbmgr.NoSuchPrimaryKeyException;
import global.generic.Validate;
import global.web.ActionInvokeException;
import global.web.ActionValidateException;
import global.web.Parameters;

/**
 * 顧客のメールアドレスの更新処理を行う際に必要な内容を具体的に記したクラス。
 *
 * @author Yuki Yamazaki
 * @version 2.0b
 */
public class UpdateEmailAction extends global.web.ActionTemplate {

	String email;
	String customerId;

	/**
	 * パラメータの妥当性をチェックする。もし、値が不適当ならば、例外(ActionValidateException)を発生させる。
	 *
	 * @param parameters
	 *            このActionに与えられたHTTPのパラメータ。
	 * @throws ActionValidateException
	 *             本アクション実行に必要な前提となるパラメータ条件をクリアしていなければ、
	 *             ActionValidateExceptionを発生させる。
	 */
	public void doValidate(Parameters parameters)
			throws ActionValidateException {

		this.email = (String) parameters.get("email");
		this.customerId = (String) parameters.getParam("customerid");

		if (Validate.isEmpty(email)) {
			throw new ActionValidateException("メールアドレスが指定されていません");
		}
		if (Validate.isEmpty(customerId)) {
			throw new ActionValidateException("顧客番号が指定されていません");
		}

		// データアクセスを伴う厳密なバリデーションを行う場合
		try {
			CustomerDAO.getInstance().isExistPK(this.customerId);
		} catch (NoSuchPrimaryKeyException e) {
			throw new ActionValidateException("指定された顧客番号が存在しません: customerId:"
					+ this.customerId);
		} catch (DBValueException e) {
			throw new ActionValidateException(e.getMessage());
		}
	}

	/**
	 * 業務ロジックを実行する。業務ロジックを実行した結果
	 * は、スーパークラスが持っているparametersに保管するようにする。
	 *
	 * @param parameters
	 *            このActionに与えられたHTTPのパラメータ。
	 * @throws ActionInvokeException
	 *             本メソッドで生じた例外は全て、ActionInvokeExceptionとして転送する。
	 */
	public void doInvoke(Parameters parameters) throws ActionInvokeException {

		try {
			CustomerDAO customerDAO = CustomerDAO.getInstance();
			Customer customer = (Customer) customerDAO
					.findByPrimaryKey(this.customerId);

			customer.setEmail(this.email);
			customer = (Customer) customerDAO.update(customer);

			// JSPに渡したいデータをthis.parametersに設定
			this.parameters.put("customer", customer);

		} catch (Exception e) {
			throw new ActionInvokeException(e.getMessage());
		}
	}
	
	
}