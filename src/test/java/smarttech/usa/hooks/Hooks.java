package smarttech.usa.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import smarttech.usa.basepage.BasePage;
import smarttech.usa.elementspage.MasterElementsPage;
import smarttech.usa.generic.CommonUtil;

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

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			CommonUtil.getScreenshot(driver, scenario);
		}
		driver.quit();
		logger.info("");
		logger.info("...........END AUTOMATION.............");
		logger.info("");
	}

}
