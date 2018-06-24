package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;


public class EmployeeDAO {
	public List<Employee> findAll(){
	Connection conn = null;
	List<Employee> empList = new ArrayList<Employee>();
		try {
			System.out.println("1");
			Class.forName("org.h2.Driver");
			//jdbc:h2:~/test
			System.out.println("2");
			//http://192.168.138.22:8082/login.do?jsessionid=865b7d31b2da2de6a44364d5fc7cf9cf
//			conn = DriverManager.getConnection("jdbc:h2:file:C:/data/example", "sa", "");
			conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

			System.out.println("3");
			String sql = "SELECT ID, NAME, AGE FROM EMPLOYEE";
			//String sql2 = "INSERT INTO EMPLOYEE (ID, NAME, AGE) VALUES('EMP003', '亀山 直起', '24')";
			//PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			//pStmt2.executeUpdate();
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			System.out.println("4");
			while(rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");
//				System.out.println("ID:" + id);
//				System.out.println("名前:" + name);
//				System.out.println("年齢:" + age);
				Employee employee = new Employee(id, name, age);
				empList.add(employee);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return empList;
	}


}
