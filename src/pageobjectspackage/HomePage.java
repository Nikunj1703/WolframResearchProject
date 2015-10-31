/*
 * Filename: HomePage.java
 *
 * Programmer: Nikunj Ratnaparkhi
 * Date:  10/31/2015
 */
package pageobjectspackage;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.MainTestClass;

/**
 * @author Nikunj
 *
 */
public class HomePage{

	/**
	 * Declaring Page Factory variables
	 */
	@FindBy(tagName = "iframe")
	public WebElement iFrame;
	
	@FindBy(xpath = ".//*[@id='productSelection']/footer/div/a[1]")
	public WebElement footer;
	
	@FindBy(xpath = ".//*[@id='wdp-tile']/a")
	public WebElement wolframDevLink;
	
	private String expected = "Wolfram";
	private String actual = "";
	
	/**
	 * 
	 * Constructor
	 */
	public HomePage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * 
	 * @return HomePage
	 */
	public HomePage findFooterOfHomePage(){
		MainTestClass.driver.switchTo().defaultContent();
		WebElement footerInFrame = this.iFrame;
		MainTestClass.driver.switchTo().frame(footerInFrame);
		this.setActual(this.footer.getText()); 
		
		MainTestClass.driver.switchTo().defaultContent();
		
		return new HomePage(MainTestClass.driver);
	}
	
	/**
	 * 
	 * @return HomePage
	 */
	public HomePage launchingApp(){
		MainTestClass.driver.navigate().to("http://www.wolframcloud.com/");
		//Maximize the window (if it's not)
		MainTestClass.driver.manage().window().maximize();
		MainTestClass.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return new HomePage(MainTestClass.driver);
	}
	
	/**
	 * 
	 * @return SignInPage
	 */
	public SignInPage clickOnWolframDevPlatform(){
		
		WebElement frameEl = this.iFrame;
		MainTestClass.driver.switchTo().frame(frameEl);
		this.wolframDevLink.click();
		
		return new SignInPage(MainTestClass.driver);
	}

	/**
	 * 
	 * @return String
	 */
	public String getExpected() {
		return expected;
	}

	
	/**
	 * 
	 * @return String
	 */
	public String getActual() {
		return actual;
	}

	/**
	 * 
	 * @param actual
	 */
	public void setActual(String actual) {
		this.actual = actual;
	}
	
	
}
