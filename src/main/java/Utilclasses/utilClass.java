package Utilclasses;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class utilClass {
	 
	
	
		
	
 public static WebElement explicitWait(WebDriver driver, WebElement ele) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
	return element;
 }
 
 public String getScreenShot(WebDriver driver,String Testname) throws IOException {
		
		SimpleDateFormat Frt = new SimpleDateFormat("dd-mm-yyyy-hh--mm");
		String date = Frt.format(new Date());
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = Testname+".png";
		File Desti =  new  File(path);
		
		org.openqa.selenium.io.FileHandler.copy(source, Desti);
		return path;
	}
 public static void scroll(WebDriver driver)
 {
	 JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,300)","");
 }
 
}
