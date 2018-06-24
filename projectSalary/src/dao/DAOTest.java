package dao;

import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.TestCase;
import model.Salary;

public class DAOTest extends TestCase {

//	public void testinsert() {
//		try {
//			Salary salary = new Salary();
//			salary.setMonth(1);
//			salary.setInput(25);
//			salary.setOutput(5);
//			salary.setTotal(salary.getInput() - salary.getOutput());
//			SalaryDAO sdao = new SalaryDAO();
//			sdao.insert(salary);
//		} catch (Exception e) {
//			fail("fail");
//		}
//	}


	public void testselectall() {
		try {
			SalaryDAO sdao = new SalaryDAO();
			ArrayList<Salary> list = sdao.findAll();
			Iterator<Salary> itr = list.iterator();
			while(itr.hasNext()) {
				Salary s = itr.next();
				System.out.println(s.getMonth());
				System.out.println(s.getInput());
				System.out.println(s.getOutput());
				System.out.println(s.getTotal());
			}
		} catch (Exception e) {
			fail("fail");
		}
	}

}
