package smarttech.usa.generic;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import smarttech.usa.basepage.BasePage;

public class WaitHelper extends BasePage {

	public static boolean isElementPresent(WebElement element, long timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static WebElement seleniumWait(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitUntilVisibelityOfElements(List<WebElement> ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
}
