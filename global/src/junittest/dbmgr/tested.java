package junittest.dbmgr;

import java.util.Enumeration;
import java.util.Vector;

public class tested {

	public String name;
	public String food;
	private static tested tested;

	public static tested getInstance(String name, String food) {
		if (tested == null)
			tested = new tested(name, food);
		return tested;
	}

	public tested() {
	}


	private tested(String name, String food) {
		this.name = name;
		this.food = food;
	}


	public Enumeration<String> t1() throws DBValueException {

		Enumeration<String> enu = null;

		try {
			Vector<String> vec = new Vector<String>();
			System.out.println("要素数は" + vec.size());

			vec.add("2015");
			System.out.println("要素数は" + vec.size());

			vec.addElement("2016");
			System.out.println("要素数は" + vec.size());

			vec.add("2017");
			System.out.println("要素数は" + vec.size());

			vec.addElement("2018");
			System.out.println("要素数は" + vec.size());

			enu = vec.elements();

		} catch (Exception e) {
			throw new DBValueException();
		}
		return enu;
	}
}