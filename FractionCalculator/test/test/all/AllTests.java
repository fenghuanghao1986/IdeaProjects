package test.all;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(testAdd.class);
		suite.addTestSuite(testDivide.class);
		suite.addTestSuite(testMinus.class);
		suite.addTestSuite(testMultiply.class);
		suite.addTestSuite(testPower.class);
		suite.addTestSuite(testMain.class);
		//$JUnit-END$
		return suite;
	}

}
