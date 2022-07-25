package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilclasses.utilClass;

public class SearchResultPage extends utilClass {
	WebDriver driver;
	
	@FindBy(xpath="(//h1)[2]")
	private WebElement noOfResult;
	
	
	@FindBy(xpath="//a[text()='The Godfather']")
	private WebElement clickonMove;
	
	
	public SearchResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public String NumberOfResult()
	{
		return explicitWait(driver, noOfResult).getText();
			
	}

	public void clickOnMovie()
	{
		clickonMove.click();
	}
}
