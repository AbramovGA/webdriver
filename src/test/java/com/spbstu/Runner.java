package com.spbstu;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by germanium on 30.05.17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "json:target/reports/mainReport.json"},
        features = {"src/test/resources/features"},
        glue = {"com.spbstu.stepdefs"} )
public class Runner {

}
