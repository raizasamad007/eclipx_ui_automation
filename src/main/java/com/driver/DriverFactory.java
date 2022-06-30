package com.driver;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.constants.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverFactory {
	public WebDriver driver;

	public static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	public static Logger log = LogManager.getLogger(DriverFactory.class.getName());

	public WebDriver initDriver(String browser) {
		log.info("Browser value is : " + browser);

		if (browser.equalsIgnoreCase(Constants.CHROME_BROWSER)) {
			WebDriverManager.chromedriver().setup();
			threadLocalDriver.set(new ChromeDriver());
			log.info("Launching Chrome Browser");
			
		} else if (browser.equalsIgnoreCase(Constants.FIREFOX_BROWSER)) {
			WebDriverManager.firefoxdriver().setup();
			threadLocalDriver.set(new FirefoxDriver());
			log.info("Launching FireFox Browser");
			
		} else if (browser.equalsIgnoreCase(Constants.SAFARI_BROWSER)) {
			threadLocalDriver.set(new SafariDriver());
			log.info("Launching Safari Browser");
			
		} else {
			log.info("Please pass the correct browser value : " + browser);

		}

		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return threadLocalDriver.get();
	}
}
