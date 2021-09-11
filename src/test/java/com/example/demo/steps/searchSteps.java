package com.example.demo.steps;

import com.example.demo.page.BasePage;
import com.example.demo.page.SearchResultPage;
import com.example.demo.page.WikiPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

public class searchSteps {

    @Autowired
    private WikiPage wikiPage;

    @Autowired
    private SearchResultPage searchResultPage;

    @Given("User navigate to application")
    public void userNavigateToApplication() {
        wikiPage.goToApp();
    }

    @When("Perform search for {string}")
    public void performSearchFor(String arg0) {
        wikiPage.search(arg0);
    }

    @Then("User should land on {string} page")
    public void userShouldLandOnPage(String arg0) {
        Assert.assertTrue(searchResultPage.getPageHeading().equals(arg0));
    }
}
