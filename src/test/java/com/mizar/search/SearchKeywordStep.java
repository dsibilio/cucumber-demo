package com.mizar.search;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchKeywordStep {
  private Response response;

  @Given("the system is available")
  public void the_system_is_available() {
    get("http://www.google.com").then().statusCode(200);
  }

  @When("the user searches for the word {string}")
  public void the_user_searches_for_the_word_something(String keyword) {
    response = get("http://www.google.com/search?q=" + keyword);
  }

  @Then("the results page should mention {string}")
  public void the_results_page_should_mention_something(String expected) {
    assertThat(response.getBody(), notNullValue());
    assertThat(response.getBody().asString().toLowerCase(), containsString(expected));
  }

}
