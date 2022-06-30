package com.pages.googlesearch;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.constants.Constants;


public class GoogleSearchPage {
	private WebDriver driver;
	private WebDriverWait wait;
	public static Logger log = LogManager.getLogger(GoogleSearchPage.class.getName());
	@FindBy(name = Constants.GOOGLE_SEARCH_BAR)
	WebElement searchBar;

	@FindBy(xpath = Constants.FIRST_LINK)
	WebElement firstLink;

	@FindBy(linkText = Constants.SEARCH_KEYWORD)
	WebElement searchKeywordInThePage;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));

	}

	// Verify the search box is displayed
	public boolean isSearchBarDisplayed() {
		return searchBar.isDisplayed();
	}

	// User enters the search text in the search box
	public void search(String key) {
		searchBar.sendKeys(key);
		log.info("Entered search key: " + key);
		searchBar.click();
		searchBar.sendKeys(Keys.ENTER);
	}

	// User clicks on the first link available on the search results
	public void clickFirstLink() {
		wait.until(ExpectedConditions.visibilityOf(firstLink));
		String text = firstLink.getText();
		firstLink.click();
		log.info("Clicked on the first link" + text);

	}

	// Verify the presence of searched text in the web page
	public boolean getSearchKeywordPresentInThePage(String searchText) {

		return driver.getPageSource().contains(searchText);

	}

}
