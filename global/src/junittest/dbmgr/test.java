package junittest.dbmgr;

import junit.framework.TestCase;

public class test extends TestCase {

	public void test1() throws Exception {
		try {
			tested t = new tested();
			t.t1();
		} catch (Exception e) {
			fail("Fail");
		}
	}

	public void test2() throws Exception {
		try {
			tested t2 = tested.getInstance("Naoki", "Meet");
		}catch(Exception e) {
			fail("Fail");
		}
	}

}
