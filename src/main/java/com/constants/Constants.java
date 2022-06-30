package com.constants;

public class Constants {
	public static final long IMPLICIT_WAIT = 10;
	public static final long EXPLICIT_WAIT = 10;
	public static final String CONFIG_FILE_PATH = "config.properties";

	// TestRunner Constants
	public static final String FEATURE_FILES = "src/test/resources/featureFiles";
	public static final String GLUE = "stepdefinitions";
	public static final String APP_HOOKS = "apphooks";

	// DriverFactoryClass Constants
	public static final String CHROME_BROWSER = "chrome";
	public static final String FIREFOX_BROWSER = "firefox";
	public static final String SAFARI_BROWSER = "safari";

	// GoogleSearchPage Constants
	public static final String GOOGLE_SEARCH_BAR = "q";

	// SearchResultsPage Constants
	public static final String FIRST_LINK = "//div[@class = 'BYM4Nd']/div/div/div/div/div/a/h3";

	// OntheFirstLinkPage
	public static final String SEARCH_KEYWORD = "Eclipx Group";

	// ApplicationHookClass Constants
	public static final String BROWSER = "browser";
	public static final String URL = "url";
	public static final String WHITE_SPACE = " ";
	public static final String UNDERSCORE = "_";
	public static final String IMAGE_FORMAT = "image/png";

	// GooglePageSteps Constants
	public static final String USER_ON_SEARCH_PAGE_WITH_SEARCH_BOX = "User is on the Google Search page and a search box is displayed";
	public static final String USER_ENTERS_SEARCH_TEXT = "User enters search text {string} on the search box";
	public static final String USER_CLICKS_ON_FIRST_LINK = "User clicks on the first link available in the search results";
	public static final String SEARCHED_TEXT_SHOULD_DISPLAYED = "Searched text {string} should be displayed in the page.";

}
