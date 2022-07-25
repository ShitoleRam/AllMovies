package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class MoviePage extends utilClass {
	WebDriver driver;
	
	
	@FindBy(xpath="//span[@class='header-movie-genres']")
	private WebElement movieGenrs;
	
	@FindBy(xpath="(//div[@class='details']//child::span)[10]")
	private WebElement mpaaRating;
	
	@FindBy(xpath="//a[@title='Cast & Crew']")
	private WebElement castandcrewTab;
	
	@FindBy(xpath="//dt[@class='name artist-name']")
	private WebElement directorName;
	
	@FindBy(xpath="(//div[@class='cast_container']/div)[6]")
	private WebElement castRole;
	
	public MoviePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public Boolean MovieGenrs()
	{
		String a = explicitWait(driver, movieGenrs).getText();
		if(a.contains("Crime"))
		{
			return true;
		}
		else {
			return false;
		}
	}
	public Boolean MpaaRating()
	{
		String b = explicitWait(driver, mpaaRating).getText();
		if(b.contains("R"))
		{
			return true;
		}else {
			return false;
		}
	}
	public void clickCastAndCrew()
	{
		castandcrewTab.click();
	}
	public Boolean directorName()
	{
		String a = explicitWait(driver, directorName).getText();
		if(a.equalsIgnoreCase("Francis Ford Coppola"))
		{
			return true;
		}else {
			return false;
		}
	}
	public boolean alPacinoCharacterName()
	{
		String a = castRole.getText();
		if(a.contains("Michael Corleone"))
		{
			return true;
		}else {
			return false;
		}
	}

}
