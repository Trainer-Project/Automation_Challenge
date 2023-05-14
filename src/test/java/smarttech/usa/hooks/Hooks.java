package smarttech.usa.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import smarttech.usa.basepage.BasePage;
import smarttech.usa.elementspage.MasterElementsPage;

public class Hooks extends BasePage {
	public Scenario scenario;
	
	@Before
	public void suiteSetup(Scenario scenario) {
		this.scenario = scenario;
		initialization();
		MasterElementsPage pf = new MasterElementsPage();
		pf.getApplicationLogin(prop.getProperty("userName"), prop.getProperty("textPassword"));
		logger.info("");
		logger.info("...........START AUTOMATION.............");
		logger.info("");
	}

	@After(order = 1)
	public void takeScraenshotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			logger.info(">>>>> Takes Screenshot <<<<<<");
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");		}

	}

	@After(order = 0)
	public void tearDown() {
		driver.quit();
		logger.info("");
		logger.info("...........END AUTOMATION.............");
		logger.info("");

	}
}
