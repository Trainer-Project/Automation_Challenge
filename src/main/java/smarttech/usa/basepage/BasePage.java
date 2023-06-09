package smarttech.usa.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import smarttech.usa.listiner.WebEventListener;

public class BasePage {
	public static Logger logger;
	public static WebDriver driver;
	public static Properties prop;
	public Properties configProp;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public BasePage() {
		logger = Logger.getLogger("QA Automation"); // Added logger
		PropertyConfigurator.configure("Log4j.properties");// Added logger
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/smarttech/usa/config/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {
		String browser = prop.getProperty("browserName");
		if (browser.equalsIgnoreCase("chrome")) {
			logger.info(">>>>> Test Execuation will start with Chrome Browser <<<<< ");
			 WebDriverManager.chromedriver().setup();
			// System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			logger.info(">>>>> Test Execuation will start with Edge Browser <<<<< ");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			logger.info(">>>>> Test Execuation will start with FireFox Browser <<<<< ");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			logger.info(">>>>> Thre is no browser for Test Execuation <<<<< ");
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));

	}
	public static void main(String[] args) throws Throwable {

		Class.forName("oracle.jdbc.driver.OracleDriver");   
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "hr");		                                                                            // JDBC URL, Host Number, Database Name, UserName & Password		
			// Statement is an interface 
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(prop.getProperty("innerJoin"));
		    List<String> columnValue = new ArrayList<String>(); 
			while (rs.next()) {
				columnValue.add(rs.getString("First_name"));
			}
		    System.out.println(columnValue); 
		    }
	

}
