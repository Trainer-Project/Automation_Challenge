package smarttech.usa.elementspage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import smarttech.usa.basepage.BasePage;
import smarttech.usa.generic.CommonUtil;
import smarttech.usa.generic.WaitHelper;

public class MasterElementsPage extends BasePage {

	public MasterElementsPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//*[text()=' Home']")
	@CacheLookup
	private WebElement verifyHomePage;

	public WebElement getVerifyHomePage() {
		return verifyHomePage;
	}
	
	
	@FindBy(xpath = "//*[text()=' Signup / Login']")
	@CacheLookup
	private WebElement clickSignupOrLoginBTN;

	public WebElement getClickSignupOrLoginBTN() {
		return clickSignupOrLoginBTN;
	}

	@FindBy(xpath = "(//*[@name='email'])[1]")
	@CacheLookup
	private WebElement enterUserName;

	public WebElement getEnterUserName() {
		return enterUserName;
	}

	@FindBy(xpath = "(//*[@name='password'])[1]")
	@CacheLookup
	private WebElement enterPassword;

	public WebElement getEnterPassword() {
		return enterPassword;
	}

	@FindBy(xpath = "//*[text()='Login']")
	@CacheLookup
	private WebElement clickOnLoginBTN;

	public WebElement getClickOnLoginBTN() {
		return clickOnLoginBTN;
	}

	public void getApplicationLogin(String userName, String pwd) {
		logger.info(">>>>> User Able To Click On Signup Or Login BTN <<<<< ");
		CommonUtil.highLighterMethod(getClickSignupOrLoginBTN());
		WaitHelper.seleniumWait(getClickSignupOrLoginBTN());
		CommonUtil.clickWithAction(getClickSignupOrLoginBTN());
		
		logger.info(">>>>> User Able To Enter User Name <<<<< ");
		CommonUtil.highLighterMethod(getEnterUserName());
		WaitHelper.seleniumWait(getEnterUserName());
		getEnterUserName().sendKeys(userName);
		
		logger.info(">>>>> User Able To Enter Password <<<<< ");
		CommonUtil.highLighterMethod(getEnterPassword());
		WaitHelper.seleniumWait(getEnterPassword());
		getEnterPassword().sendKeys(pwd);
		
		logger.info(">>>>> User Able To Click On Login BTN <<<<< ");
		CommonUtil.highLighterMethod(getClickOnLoginBTN());
		WaitHelper.seleniumWait(getClickOnLoginBTN());
		CommonUtil.clickWithAction(getClickOnLoginBTN());
	}
}