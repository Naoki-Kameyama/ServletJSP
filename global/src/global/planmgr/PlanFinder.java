package global.planmgr;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.Vector;

import global.generic.GlobalDate;

/**
 *
 * @author Dongyoung Jung
 * @version 0.0.1
 */

public class PlanFinder {

	private PlanDAO planDAO;					// PlanDAOオブジェクト
	private static PlanFinder planFinder;		// PlanFinderオブジェクト
	private int plansCount;					// 生産計画のオブジェクトの検索結果数

	private PlanFinder() {
//		planDAO = PlanDAO.getInstance();
	}

	public static PlanFinder getInstance() {

		if (planFinder == null)
			planFinder = new PlanFinder();

		return planFinder;
	}

	public Enumeration<Plan> getPlansAll() throws PlanValueException {
		Enumeration<Plan> planObjects = null;

		try {
			PreparedStatement pstmt = planDAO.getPreparedStatement(PlansSQL.SELECT_ALL);
			planObjects = this.makePlans(pstmt);
		} catch (Exception e) {
			throw new PlanValueException();
		}
		return planObjects;
	}

	public Enumeration<Plan> getPlansBeforeComplete (String productId) throws PlanValueException {
		Enumeration<Plan> planBC = null;

		// incomplete;

		try {
			PreparedStatement pstmt = planDAO.getPreparedStatement(PlansSQL.SELECT_BY_BEFORE_COMPLETED_BY_ID);
			planBC = this.makePlans(pstmt);
		} catch(Exception e) {
			throw new PlanValueException();
		}

		return planBC;
	}

	public Enumeration<Plan> getPlansByPeriod (GlobalDate planDate, String productId)
			throws PlanValueException {
		Enumeration<Plan> planBP = null;

		// incomplete;

		return planBP;
	}

	public int getTotalPlanByProductId (String productId)
			throws PlanValueException {
		int planBPI = 0;

		// incomplete;

		return planBPI;
	}

	public int getTotalPlanProcessingByProductId (String productId)
			throws PlanValueException {
		int planPBPI = 0;

		// incomplete;

		return planPBPI;
	}

	public int getPlansCount() {
		plansCount = 0;

		// incomplete;

		return plansCount;
	}

	private Enumeration<Plan> makePlans ( PreparedStatement prep) throws Exception {
		Enumeration<Plan> makeplan = null;

		Vector<Plan> v = new Vector<Plan>();
		ResultSet rs = planDAO.getResultset(prep);

		while(rs.next()) {
			Plan planObject = new Plan();

			planObject.setId(rs.getString(1));
			planObject.setProductId(rs.getString(2));
			planObject.setQty(Integer.parseInt(rs.getString(3)));
			planObject.setReserveStatus(rs.getString(4));
			planObject.setStatus(rs.getString(5));
			planObject.setCompletionDate(new GlobalDate(rs.getTimestamp(6)));


			v.addElement((Plan) planObject);
		}

		plansCount = v.size();

		return v.elements();
	}
















}
