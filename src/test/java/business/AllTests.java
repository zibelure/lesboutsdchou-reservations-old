package business;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
	
		String vcap_services = java.lang.System.getenv("VCAP_SERVICES");
		System.out.println("vcap_services : " + vcap_services);
	
		
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(AdministrationBusinessTest.class);
		//$JUnit-END$
		return suite;
	}

}
