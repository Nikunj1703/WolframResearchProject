/*
 * Filename: HomeScreen.java
 *
 * Programmer: Nikunj Ratnaparkhi
 * Date:  10/31/2015
 */
package pageobjectspackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import test.MainTestClass;



/**
 * @author Nikunj
 *
 */
public class HomeScreen {
	/**
	 * Declaring Page Factory variables
	 */
	@FindBy(xpath = ".//*[@id='newNotebookBtn']/div[2]/img")
	public WebElement newButtonDownArrow;
	
	@FindBy(id = "nb")
	public WebElement noteBookBtn;
	
	
	@FindBy(xpath = ".//*[@id='nb']")
	public WebElement InnerNoteBookBtn;
	
	@FindBy(xpath = ".//*[@id='wl']")
	public WebElement packageBtn;
	
	@FindBy(xpath = ".//*[@id='temp']")
	public WebElement templateBtn;
	
	@FindBy(xpath = ".//*[@id='js']")
	public WebElement javaScriptBtn;
	
	@FindBy(xpath = ".//*[@id='txt']")
	public WebElement txtBtn;
	
	@FindBy(xpath = ".//*[@id='xml']")
	public WebElement xmlBtn;
	
	@FindBy(xpath = ".//*[@id='css']")
	public WebElement cssBtn;
	
	@FindBy(xpath = ".//*[@id='html']")
	public WebElement htmlBtn;
	

	/**
	 * 
	 * Constructor
	 */
	public HomeScreen(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * return HomeScreen
	 */
	public HomeScreen clickOnNewButtonDownArrow(){
		newButtonDownArrow.click();
		return new HomeScreen(MainTestClass.driver);
	}
	
	/*
	 * return NoteBookScreen
	 */
	public NoteBookScreen clickOnNoteBook(){ 
		noteBookBtn.click();
		String handle = MainTestClass.driver.getWindowHandle();
		
		//Get all the window handles
		Set<String> handles = MainTestClass.driver.getWindowHandles();
		
		for(String hand : handles){
			if(!hand.equals(handle)){
				MainTestClass.driver.switchTo().window(hand);
			}
		}
		
		
		WebElement myDynamicElement = (new WebDriverWait(MainTestClass.driver, 15)).
				until(ExpectedConditions.presenceOfElementLocated(By.className("fileDocumentTitle")));
		
		return new NoteBookScreen(MainTestClass.driver);
	}
	
	/*
	 * return HomeScreen
	 */
	public HomeScreen clickOnUserIconForLogout(){
		NoteBookScreen.userIcon.click();
		return new HomeScreen(MainTestClass.driver);
	}
	
	/*
	 * return HomePage
	 */
	public HomePage clickOnLogoutLink(){
		NoteBookScreen.logoutLink.click();
		return new HomePage(MainTestClass.driver);
	}
}
