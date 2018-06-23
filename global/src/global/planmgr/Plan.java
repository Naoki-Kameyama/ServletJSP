package global.planmgr;

import global.generic.GlobalDate;
import global.generic.ValueObject;

/**
 *
 * @author Dongyoung Jung
 * @version 0.0.1
 *
 */
public class Plan extends ValueObject {

	private int qty;						// 生産予定個数
	private String status;					// 生産計画ステータス
	private String reserveStatus;			// 予約ステータス
	private String productId;				// 製品番号
	private GlobalDate completionDate;		// 完了予定日時

	public Plan() {
		this.completionDate = new GlobalDate();
	}

	public GlobalDate getCompletionDate() {
		return this.completionDate;
	}

	public String getProductId() {
		return this.productId;
	}

	public int getQty() {
		return this.qty;
	}

	public String getReserveStats() {
		return reserveStatus;
	}

	public String getStats() {
		return this.status;
	}

	public void setCompletionDate(GlobalDate completionDate) {
		this.completionDate = completionDate;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setReserveStatus(String reserveStatus) {
		this.reserveStatus = reserveStatus;
	}

	public void setStatus(String status) throws PlanValueException {
		this.status = status;
	}
}
