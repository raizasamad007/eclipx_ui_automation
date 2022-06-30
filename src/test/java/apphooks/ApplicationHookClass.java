package apphooks;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.propertiesloader.PropertiesLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHookClass {

	private DriverFactory driverFactory;
	private WebDriver driver;
	Properties prop;
	public static Logger log = LogManager.getLogger(ApplicationHookClass.class.getName());
	@Before(order = 0)
	public void getProperties() {
		prop = PropertiesLoader.initProp();
	}

	@Before(order = 1)
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		String browserName = prop.getProperty(Constants.BROWSER);
		driver = driverFactory.initDriver(browserName);
		driver.get(prop.getProperty(Constants.URL));
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
		log.info("Closed Browser");
	}

	
}
