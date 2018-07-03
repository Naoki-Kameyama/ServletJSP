package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Mori;
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
			String sql = "INSERT INTO SC (DATE, INPUT, OUTPUT, TOTAL, TYPE) VALUES(?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setDate(1, salary.getMonth());
			pStmt.setDouble(2, salary.getInput());
			pStmt.setDouble(3, salary.getOutput());
			pStmt.setDouble(4, salary.getTotal());
			pStmt.setString(5, salary.getType());
			pStmt.executeUpdate();
			Salary salary2 = new Salary(salary.getMonth(), salary.getInput(), salary.getOutput(), salary.getTotal(), salary.getType());
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
			String sql = "SELECT DATE, INPUT, OUTPUT, TOTAL, TYPE FROM SC ORDER BY DATE ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Date month = rs.getDate("DATE");
				double input = rs.getDouble("INPUT");
				double output = rs.getDouble("OUTPUT");
				double total = rs.getDouble("TOTAL");
				String type = rs.getString("TYPE");
				Salary salary = new Salary(month, input, output, total, type);
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


	public ArrayList<Salary> findKey(String year, String month) {
		Connection conn = null;
		String sql = null;
		ArrayList<Salary> salaryList = new ArrayList<Salary>();
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			if(month.length()==2) {
				sql = "SELECT DATE, INPUT, OUTPUT, TOTAL, TYPE FROM SC WHERE DATE LIKE '"+year+"-"+month+"%' ORDER BY DATE ASC";
			}else if(month.length()==1) {
				sql = "SELECT DATE, INPUT, OUTPUT, TOTAL, TYPE FROM SC WHERE DATE LIKE '"+year+"-0"+month+"%' ORDER BY DATE ASC";
			}
			//String sql = "SELECT DATE, INPUT, OUTPUT, TOTAL FROM SC WHERE DATE LIKE '2018-04%'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				Salary salary = new Salary();
				salary.setMonth(rs.getDate("DATE"));
				salary.setInput(rs.getDouble("INPUT"));
				salary.setOutput(rs.getDouble("OUTPUT"));
				salary.setTotal(rs.getDouble("TOTAL"));
				salary.setType(rs.getString("TYPE"));
				salaryList.add(salary);
			}

		}catch (SQLException e) {
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
			String sql = "DELETE FROM SC";
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


	public void singleDelete(String dd) {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String sql = "DELETE FROM SC WHERE DATE='"+dd+"'";
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

	public void singleUpdate(Salary salary, Date updateDate) {
		Connection conn = null;

		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String sql = "UPDATE SC SET DATE = ?, INPUT = ?, OUTPUT = ?, TOTAL = ?, TYPE = ? WHERE DATE = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setDate(1, updateDate);
			pStmt.setDouble(2, salary.getInput());
			pStmt.setDouble(3, salary.getOutput());
			pStmt.setDouble(4, salary.getTotal());
			pStmt.setString(5, salary.getType());
			pStmt.setDate(6, salary.getMonth());
			pStmt.executeUpdate();
			//Salary salary2 = new Salary(salary.getMonth(), salary.getInput(), salary.getOutput(), salary.getTotal(), salary.getType());
			//salaryList.add(salary2);
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


	public ArrayList<Mori> insertQuestion(Mori mori) {
		Connection conn = null;
		ArrayList<Mori> moriList = new ArrayList<Mori>();
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String sql = "INSERT INTO QNA (ID, QUESTION, ANSWER) VALUES(?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, mori.getUserId());
			pStmt.setString(2, mori.getQuestion());
			pStmt.setString(3, mori.getAnswer());
			pStmt.executeUpdate();
			Mori mori2 = new Mori(mori.getUserId(), mori.getQuestion(), mori.getAnswer());
			moriList.add(mori2);

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
		return moriList;
	}


	public ArrayList<Mori> findQuestionList(String uI) {
		Connection conn = null;
		ArrayList<Mori> moriList = new ArrayList<Mori>();
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
			String sql = "SELECT ID, QUESTION, ANSWER FROM QNA WHERE ID like '"+ uI +"'";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String userId = rs.getString("ID");
				String Question = rs.getString("QUESTION");
				String Answer = rs.getString("ANSWER");
				Mori mori = new Mori(userId, Question, Answer);

				System.out.println("1"+userId);
				System.out.println("2"+Question);
				System.out.println("3"+Answer);

				moriList.add(mori);
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


		return moriList;

	}



}
