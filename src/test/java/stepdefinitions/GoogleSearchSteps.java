package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import com.constants.Constants;
import com.driver.DriverFactory;
import com.pages.googlesearch.GoogleSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {
	GoogleSearchPage googleSearchPage = new GoogleSearchPage(DriverFactory.getDriver());
	public static Logger log = LogManager.getLogger(GoogleSearchSteps.class.getName());

	@Given(Constants.USER_ON_SEARCH_PAGE_WITH_SEARCH_BOX)
	public void user_is_on_the_google_search_page_and_a_search_box_is_displayed() {
		Assert.assertTrue(googleSearchPage.isSearchBarDisplayed());
		log.info("Step 1 : User is on the Google Search page and a search box is displayed");
	}

	@When(Constants.USER_ENTERS_SEARCH_TEXT)
	public void user_enters_search_text_on_the_search_box(String searchText) {
		googleSearchPage.search(searchText);
		log.info("Step 2 : user enters " + searchText + " on the search box");
	}

	@And(Constants.USER_CLICKS_ON_FIRST_LINK)
	public void user_clicks_on_the_first_link_available_in_the_search_results() {
		googleSearchPage.clickFirstLink();
		log.info("Step 3 : User clicks on the first link available on the search results");
	}

	@Then(Constants.SEARCHED_TEXT_SHOULD_DISPLAYED)
	public void searched_text_should_be_displayed_in_the_page(String searchText) {
		try {
			Assert.assertTrue(googleSearchPage.getSearchKeywordPresentInThePage(searchText));
			log.info("Step 4 :Searched Text " + searchText + " is present in the page.");
		}

		catch (Exception E) {
			log.info("Step 4 : " + searchText + " is not present in the Webpage");
		}
	}

}