/*
 * Filename: SignInPage.java
 *
 * Programmer: Nikunj Ratnaparkhi
 * Date:  10/31/2015
 */
package pageobjectspackage;

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
public class SignInPage {
	
	/**
	 * Declaring Page Factory variables
	 */
	@FindBy(xpath = ".//*[@id='createAccount']")
	public WebElement createOneLink;
	
	@FindBy(xpath = ".//*[@id='signIn']")
	public WebElement signInBtn;
	
	/**
	 * 
	 * Constructor
	 */
	
	public SignInPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * return SignUpPage
	 */
	public SignUpPage clickOnCreateOneLink(){
		this.createOneLink.click();
		return new SignUpPage(MainTestClass.driver);
	}
	
	/*
	 * return HomeScreen
	 */
	public HomeScreen fillTheCredentials() throws InterruptedException{		
		SignUpPage.emailX.sendKeys(MainTestClass.email);
		SignUpPage.passwordX.sendKeys(MainTestClass.password);
		Thread.sleep(1000);
		signInBtn.click();
		return new HomeScreen(MainTestClass.driver);
	}
}
