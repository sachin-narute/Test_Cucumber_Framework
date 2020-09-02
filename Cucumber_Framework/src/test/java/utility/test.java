package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import testBase.TestBase;

public class test extends TestBase {
	public static Logger logger = LogManager.getLogger(test.class.getName());
	

	public static void main(String[] args) {
		TestBase tb=new TestBase();

		System.out.println(TestBase.prop.getProperty("url"));
		//driver.get(prop.getProperty("url"));			
			
		
			/*logger.trace("We've just greeted the user!");
	        logger.debug("We've just greeted the user!");
	        logger.info("We've just greeted the user!");
	        logger.warn("We've just greeted the user!");
	        logger.error("We've just greeted the user!");
	        logger.fatal("We've just greeted the user!");*/
	}

}
	