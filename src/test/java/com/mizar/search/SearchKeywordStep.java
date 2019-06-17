package com.mizar.search;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchKeywordStep {
    private Response response;

	@Given("^the system is available$")
    public void the_system_is_available() throws Throwable {
        Response response = get("http://www.google.com");
        assertThat(response, notNullValue());
        assertThat(response.getStatusCode(), equalTo(200));
    }

    @When("^the user searches for the word \"([^\"]*)\"$")
    public void the_user_searches_for_the_word_something(String strArg1) throws Throwable {
        response = get("http://www.google.com/search?q=" + strArg1);
    }

    @Then("^the results page should mention \"([^\"]*)\"$")
    public void the_results_page_should_mention_something(String strArg1) throws Throwable {
        assertThat(response, notNullValue());
        assertThat(response.getBody().asString().toLowerCase(), 
        		containsString(strArg1));
    }
}
