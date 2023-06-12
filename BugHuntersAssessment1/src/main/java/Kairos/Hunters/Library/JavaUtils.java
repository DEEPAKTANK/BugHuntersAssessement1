package Kairos.Hunters.Library;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class JavaUtils {
	public static String getDateNTime(String dateFormat) {
		 // Get the current date and time
       LocalDateTime now = LocalDateTime.now();
       
       // Format the date and time as a string using a DateTimeFormatter
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
       String formattedDateTime = now.format(formatter);
       
       // Print the formatted date and time to the console
      return  formattedDateTime;
	}
	
	public static void captureScreenShot(WebDriver driver) {
		TakesScreenshot sh = (TakesScreenshot) driver;
		File src = sh.getScreenshotAs(OutputType.FILE);
		File dist = new File("./Screenshots/image"+getDateNTime("YYYY_MM_dd_hh_mm_ss")+".png");
		try {
			Files.copy(src, dist);
		}
		catch (IOException e) {

			e.printStackTrace();
			}
	}	
	public static void main(String[] args) {
		System.out.println(getDateNTime("YYYY_MM_dd_hh_mm_ss"));
	}

}
