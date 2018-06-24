package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Salary;

public class SalaryDAO {

	/**
	 * サラリー情報登録
	 * @param salary
	 * @return
	 */
	public ArrayList<Salary> insert(Salary salary) {
		Connection conn = null;
		ArrayList<Salary> salaryList = new ArrayList<Salary>();
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String sql = "INSERT INTO SALARY (MONTH, INPUT, OUTPUT, TOTAL) VALUES(?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, salary.getMonth());
			pStmt.setDouble(2, salary.getInput());
			pStmt.setDouble(3, salary.getOutput());
			pStmt.setDouble(4, salary.getTotal());
			pStmt.executeUpdate();
			Salary salary2 = new Salary(salary.getMonth(), salary.getInput(), salary.getOutput(), salary.getTotal());
			System.out.println("month3: "+salary.getMonth());
			salaryList.add(salary2);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return salaryList;
	}



	/**
	 * 全検検索
	 * @return
	 */
	public ArrayList<Salary> findAll() {
		Connection conn = null;
		ArrayList<Salary> salaryList = new ArrayList<Salary>();
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String sql = "SELECT MONTH, INPUT, OUTPUT, TOTAL FROM SALARY";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				int month = rs.getInt("MONTH");
				System.out.println("month4: "+rs.getInt("MONTH"));
				double input = rs.getDouble("INPUT");
				double output = rs.getDouble("OUTPUT");
				double total = rs.getDouble("TOTAL");
				Salary salary = new Salary(month, input, output, total);
				salaryList.add(salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return salaryList;
	}


	/**
	 *
	 */
	public void delete() {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String sql = "DELETE FROM SALARY";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
