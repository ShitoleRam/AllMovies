package testPkg;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utilclasses.utilClass;
import baseClass.BaseClass;
import graphql.Assert;
import pomClasses.HomePage;
import pomClasses.MoviePage;
import pomClasses.SearchResultPage;

public class MovieSearch {
	WebDriver driver;
	HomePage hp;
	SearchResultPage sr;
	MoviePage mp;
	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	
	
	@BeforeClass
	public void beforeClass()
	{
		htmlReporter = new ExtentHtmlReporter("VerifyMovies.html");
		 report = new ExtentReports();
		report.attachReporter(htmlReporter);
		test = report.createTest("MovieSearch");
		driver = BaseClass.getDriver("edge");
	}
	@BeforeMethod
	public void beforeMethod()
	{
		hp = new HomePage(driver);
		sr = new SearchResultPage(driver);
		mp = new MoviePage(driver);
	}
	@Test
	public void searchResultPrint()
	{
		hp.searchMovieName();
		System.out.println(sr.NumberOfResult());
		
	}
	@Test(priority= 1)
	public void clickOnMovieRelease1972()
	{
		sr.clickOnMovie();
	}
	@Test(priority= 2)
	public void verifyGenreAndMpaaRating()
	{
		SoftAssert soft = new SoftAssert();
		utilClass.scroll(driver);
		
	    soft.assertTrue(mp.MovieGenrs());
		soft.assertTrue(mp.MpaaRating());
		
		soft.assertAll();
		
	}
	@Test(priority= 3)
	public void verifyDirectorName()
	{
		
		mp.clickCastAndCrew();
		Assert.assertTrue(mp.directorName());
		
	}
	@Test(priority= 4)
	public void verifyChareterName()
	{
		
		Assert.assertTrue(mp.alPacinoCharacterName());
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName()+"test passed");
		}
		else if(result.getStatus()==ITestResult.FAILURE) {
			String path = hp.getScreenShot(driver, result.getName());
			test.log(Status.FAIL, result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		else {
			test.log(Status.SKIP, result.getName()+"test skipped");
		}
		
	}
	
	
  @AfterClass
   public void afterClass() {
	report.flush();
	driver.quit();
}
	

}
