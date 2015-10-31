/*
 * Filename: MainTestClass.java
 *
 * Programmer: Nikunj Ratnaparkhi
 * Date:  10/31/2015
 */
package test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjectspackage.*;



/**
 * @author Nikunj
 *
 */
public class MainTestClass{

	/**
	 * Declaring variables
	 */
	public static WebDriver driver = new FirefoxDriver();;
	public static String email = "nikunj.ratnaparkhi@gmail.com";
	public static String password = "nikabc123";
	public static String firstName = "Nikunj";
	public static String lastName = "Ratnaparkhi";

	/**
	 * Creating page objects
	 */
	HomePage homePage = new HomePage(driver);
	SignInPage signInPage = new SignInPage(driver);
	HomeScreen homeScreen = new HomeScreen(driver);
	NoteBookScreen noteBookScreen = new NoteBookScreen(driver);
	
	/**
	 * Test case to launch the application  
	 */
	@Test
	public void launchTheApp(){
		homePage.launchingApp();
		Assert.assertEquals(driver.getCurrentUrl(),"http://www.wolframcloud.com/");
	}
	
	/**
	 * Test case to verfify the footer text on the homepage
	 */
	@Test(dependsOnMethods={"launchTheApp"})
	public void footerOnHomePage(){
		homePage.findFooterOfHomePage();
		assertTrue(homePage.getActual().contains(homePage.findFooterOfHomePage().getExpected()));
	}
	
	/**
	 * Test case to navigate to the Wolfram development platform
	 */
	@Test(dependsOnMethods={"footerOnHomePage"})
	public void navigateToWolframDevPlatform(){
		homePage.clickOnWolframDevPlatform();
		Assert.assertEquals("Wolfram Cloud", driver.getTitle());
	}
	
	/**
	 * Test case to click on link to create new Wolfram ID
	 */
	@Test(dependsOnMethods={"navigateToWolframDevPlatform"})
	public void navigateToSignUpPage(){
		signInPage.clickOnCreateOneLink();
		System.out.println("Title: "+driver.getTitle());
		Assert.assertEquals("Sign Up - Wolfram Development Platform", driver.getTitle());
	}
	
	/**
	 * Test case to fill up the sign-up form
	 */
	SignUpPage signUpPage = new SignUpPage(driver);
	@Test(dependsOnMethods={"navigateToSignUpPage"})
	public void fillTheSignUpForm() throws InterruptedException{
		signUpPage.fillSignUpDetails();
		Assert.assertEquals("Sign Up - Wolfram Development Platform", driver.getTitle());
	}
	
	/**
	 * Test case to submit the sign up form
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"fillTheSignUpForm"})
	public void clickToCreateAccount() throws InterruptedException{
		signUpPage.clickOnCreateWolframId();
		assertTrue(driver.getTitle().contains("Home"));
	}
	
	/**
	 * Test case to click on New dropdown button 
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"clickToCreateAccount"})
	public void checkIfNewButtonExpendsToNoteBookOption() throws InterruptedException{
		homeScreen.clickOnNewButtonDownArrow();
		assertTrue(homeScreen.noteBookBtn.isEnabled());
	}
	
	
	/**
	 * Test case to check if the click on new button enables the link of package
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"checkIfNewButtonExpendsToNoteBookOption"})
	public void checkIfNewButtonExpendsToPackageOption() throws InterruptedException{
		assertTrue(homeScreen.packageBtn.isEnabled());
	}
	
	/**
	 * Test case to check if the click on new button enables the link of template
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"checkIfNewButtonExpendsToNoteBookOption"})
	public void checkIfNewButtonExpendsToTemplateOption() throws InterruptedException{
		assertTrue(homeScreen.templateBtn.isEnabled());
	}
	
	/**
	 * Test case to check if the click on new button enables the link of JavaScript
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"checkIfNewButtonExpendsToNoteBookOption"})
	public void checkIfNewButtonExpendsToJavaScriptOption() throws InterruptedException{
		assertTrue(homeScreen.javaScriptBtn.isEnabled());
	}
	
	/**
	 * Test case to check if the click on new button enables the link of text
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"checkIfNewButtonExpendsToNoteBookOption"})
	public void checkIfNewButtonExpendsToTextOption() throws InterruptedException{
		assertTrue(homeScreen.txtBtn.isEnabled());
	}
	
	/**
	 * Test case to check if the click on new button enables the link of XML
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"checkIfNewButtonExpendsToNoteBookOption"})
	public void checkIfNewButtonExpendsToXMLOption() throws InterruptedException{
		assertTrue(homeScreen.xmlBtn.isEnabled());
	}
	
	/**
	 * Test case to check if the click on new button enables the link of CSS
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"checkIfNewButtonExpendsToNoteBookOption"})
	public void checkIfNewButtonExpendsToCSSOption() throws InterruptedException{
		assertTrue(homeScreen.cssBtn.isEnabled());
	}
	
	
	/**
	 * Test case to check if the click on new button enables the link of HTML
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"checkIfNewButtonExpendsToNoteBookOption"})
	public void checkIfNewButtonExpendsHTMLOption() throws InterruptedException{
		assertTrue(homeScreen.htmlBtn.isEnabled());
	}
	
	
	/**
	 * Test case to click on Notebook
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"checkIfNewButtonExpendsToNoteBookOption"})
	public void clickNoteBookLink() throws InterruptedException{
		homeScreen.clickOnNoteBook();
		assertTrue(driver.getTitle().contains("unnamed"));
	}
	
	/**
	 * Test case to click on unnamed text field
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"clickNoteBookLink"})
	public void clickUnnamedTextField() throws InterruptedException{
		noteBookScreen.clickOnUnnamedTextField();
		Assert.assertEquals(noteBookScreen.unnamedTxtFieldBox.getAttribute("value"),".nb");
	}
	
	/**
	 * Test case to click on user Icon
	 */
	@Test(dependsOnMethods={"clickUnnamedTextField"})
	public void clickOnUserIconLink(){
		noteBookScreen.clickOnUserIconForLogout();
		assertTrue(noteBookScreen.logoutLink.isEnabled());
	}
	
	/**
	 * Test case to click on logout link
	 */
	@Test(dependsOnMethods={"clickOnUserIconLink"})
	public void clickOnLogoutLink(){
		homePage = noteBookScreen.clickOnLogoutLink();
		homePage.findFooterOfHomePage();
		assertTrue(homePage.getActual().contains(homePage.findFooterOfHomePage().getExpected()));
	}
	
	/**
	 * Test case to verify the homepage after logout and go to sign in form
	 */
	@Test(dependsOnMethods={"clickOnLogoutLink"}) 
	public void navigateToWolframDevPlatformWithNewUser(){
		signInPage = homePage.clickOnWolframDevPlatform();
		assertTrue(driver.getTitle().contains("Wolfram Cloud"));
	}
	
	/**
	 * Test case to fill the sign in form
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods={"navigateToWolframDevPlatformWithNewUser"})
	public void fillTheSignInDetails() throws InterruptedException{
		homeScreen = signInPage.fillTheCredentials();
		assertTrue(driver.getTitle().contains("Home"));
	}
	
	/**
	 * Test case to click on the user icon
	 */
	@Test(dependsOnMethods={"fillTheSignInDetails"}) 
	public void ClickOnUserIconAgain() {
		homeScreen.clickOnUserIconForLogout();
		assertTrue(noteBookScreen.logoutLink.isEnabled());
	}
	
	/**
	 * Test case to click on logout
	 */
	@Test(dependsOnMethods={"ClickOnUserIconAgain"})
	public void logOutAgain() {
		homePage = homeScreen.clickOnLogoutLink();
		homePage.findFooterOfHomePage();
		assertTrue(homePage.getActual().contains(homePage.findFooterOfHomePage().getExpected()));
	}
	
	/**
	 * Test case to close the browsers
	 */
	@Test(dependsOnMethods={"logOutAgain"})
	public void shutTheBrowsers() {
		driver.quit();
		assertTrue(driver.toString().contains("null"));
	}
}
