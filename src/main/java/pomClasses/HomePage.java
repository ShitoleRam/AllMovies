package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class HomePage extends utilClass {
	WebDriver driver;
	
	@FindBy(xpath="//input[@type='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement searchButton;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public void searchMovieName()
	{
		explicitWait(driver, searchBox).sendKeys("The Godfather");
		searchButton.click();
		
	}

}
