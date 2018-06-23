package global.planmgr;

/**
 *
 * @author Dongyoung Jung
 * @version 0.0.1
 */

public class PlansSQL {

	public static final String SELECT_ALL =
			"SELECT "
			+ "PLANID, PRODUCTID, PLANQTY, RESERVESTATUS, PLANSTATUS, COMPLETIONDATE "
			+ "FROM PLANS ";

	public static final String SELECT_BY_PK =
			SELECT_ALL + " WHERE PLANID = ? ";

	public static final String INSERT_PLAN =
			"INSERT INTO "
			+ "PLANS "
			+ "VALUES"
			+ "( ?, ?, ?, ?, ?, ? )";

	public static final String UPDATE_PLAN =
			"UPDATE "
			+ "PLANS SET PLANID = ?, PRODUCTID = ?, PLANQTY = ?, RESERVESTATUS = ?, PLANSTATUS = ?, COMPLETIONDATE = ? "
			+ "WHERE "
			+ "PLANID = ? ";

	public static final String DELETE_PLAN =
			"DELETE "
			+ "FROM PLANS "
			+ "WHERE "
			+ "PLANID = ?";

	public static final String SELECT_MAX_ID =
			"SELECT "
			+ "MAX(PLANID) "
			+ "FROM PLANS ";

	public static final String SELECT_BY_PRODUCTID =
			SELECT_ALL + " WHERE PRODUCTID = ? ";

	public static final String SELECT_BY_PERIOD =
			SELECT_ALL
			+ " WHERE PRODUCTID = ? "
			+ "AND COMPLETIONDATE <= ? "
			+ "AND NOT( PLANSTATUS = 'COMPLETED' OR PLANSTATUS = 'CANCELED' )";

	public static final String SELECT_BY_BEFORE_COMPLETED_BY_ID =
			SELECT_ALL
			+ " WHERE NOT( PLANSTATUS = 'COMPLETED' OR PLANSTATUS = 'CANCELED' ) "
			+ "AND PRODUCTID = ? ";

	public static final String SELECT_TOTAL_BEFORE_COMPLETED_BY_ID =
			"SELECT "
			+ "PRODUCTID, SUM( PLANQTY ) "
			+ "FROM PLANS "
			+ "WHERE NOT( PLANSTATUS = 'COMPLETED' OR PLANSTATUS = 'CANCELED' ) "
			+ "AND PRODUCTID = ? GROUP BY PRODUCTID";

	public static final String SELECT_TOTAL_PROCESSING_BY_ID =
			"SELECT "
			+ "PRODUCTID, SUM( PLANQTY ) "
			+ "FROM PLANS "
			+ "WHERE PLANSTATUS = 'PROCESSING' "
			+ "AND PRODUCTID = ? GROUP BY PRODUCTID";
}
