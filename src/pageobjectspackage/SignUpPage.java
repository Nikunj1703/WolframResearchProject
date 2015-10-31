/*
 * Filename: SignUpPage.java
 *
 * Programmer: Nikunj Ratnaparkhi
 * Date:  10/31/2015
 */
package pageobjectspackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.MainTestClass;

/**
 * @author Nikunj 
 *
 */
public class SignUpPage{
	
	/**
	 * Declaring Page Factory variables
	 */
	@FindBy(xpath = ".//*[@id='email']")
	public static WebElement emailX; 
	
	@FindBy(xpath = ".//*[@id='firstname']")
	public WebElement firstNameX;
	
	@FindBy(xpath = ".//*[@id='lastname']")
	public WebElement lastNameX;
	
	@FindBy(xpath = ".//*[@id='password']")
	public static WebElement passwordX;
	
	@FindBy(xpath = ".//*[@id='password2']")
	public WebElement password2X;
	
	@FindBy(xpath = ".//*[@id='signIn']")
	public WebElement createWolframIdBtn;
	
	/**
	 * 
	 * Constructor
	 */
	public SignUpPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * return SignUpPage
	 */
	public SignUpPage fillSignUpDetails() throws InterruptedException{
		emailX.sendKeys(MainTestClass.email);
		firstNameX.sendKeys(MainTestClass.firstName);
		lastNameX.sendKeys(MainTestClass.lastName);
		passwordX.sendKeys(MainTestClass.password);
		password2X.sendKeys(MainTestClass.password);
		Thread.sleep(1000);
		
		//Scroll Down
		JavascriptExecutor jse = (JavascriptExecutor)MainTestClass.driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(1000);
		
		
		
		return new SignUpPage(MainTestClass.driver);
	}
	
	//Creating because if I may want to check the error on empty form submission
	/*
	 * return HomeScreen
	 */
	public HomeScreen clickOnCreateWolframId(){
		createWolframIdBtn.click();
		return new HomeScreen(MainTestClass.driver);
	}
	

}
