package Kairos.Hunters.Library;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggerClass {
	Logger logger = LogManager.getLogger(LoggerClass.class);
	   public void info(String message) {
		   logger.info(message);
	   }
	   public void error(String message) {
		   logger.error(message);
	   }
	   public void trace(String message) {
		   logger.trace(message);
	   }
	   public void warn(String message) {
		   logger.warn(message);
	   }
	  

}
