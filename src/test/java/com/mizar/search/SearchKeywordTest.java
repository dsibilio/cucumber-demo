package com.mizar.search;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/searchKeyword-report"})
public class SearchKeywordTest {

}
