/*
 * Filename: NoteBookScreen.java
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
public class NoteBookScreen{

	/**
	 * Declaring Page Factory variables
	 */
	@FindBy(xpath = ".//*[@id='renameButton']/div[1]/div[1]")
	public WebElement unnamedTxtField;
	
	@FindBy(xpath = ".//*[@id='toolbarRenameInputField']")
	public WebElement unnamedTxtFieldBox;
	
	@FindBy(xpath = ".//*[@id='header-account-icon']")
	public static WebElement userIcon;
	
	@FindBy(xpath = ".//*[@id='account-signout']")
	public static WebElement logoutLink;
	
	/**
	 * 
	 * Constructor
	 */
	public NoteBookScreen(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * return NoteBookScreen
	 */
	public NoteBookScreen clickOnUnnamedTextField(){
		unnamedTxtField.click();
		return new NoteBookScreen(MainTestClass.driver);
	}
	
	/*
	 * return NoteBookScreen
	 */
	public NoteBookScreen clickOnUserIconForLogout(){
		userIcon.click();
		return new NoteBookScreen(MainTestClass.driver);
	}
	
	/*
	 * return HomePage
	 */
	public HomePage clickOnLogoutLink(){
		logoutLink.click();
		return new HomePage(MainTestClass.driver);
	}
}
