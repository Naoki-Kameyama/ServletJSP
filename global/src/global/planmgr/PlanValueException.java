package global.planmgr;

import global.dbmgr.DBValueException;

/**
 * 生産計画管理パッケージ内の操作時に発生する例外。
 * @author Kohei Shimoyama
 * @version 1.0
 */

public class PlanValueException extends DBValueException {
	//コンストラクタ
		public PlanValueException() {
			super(" Plan Value Exception ");
		}

		public PlanValueException(String message) {
			super(message);
		}

}
