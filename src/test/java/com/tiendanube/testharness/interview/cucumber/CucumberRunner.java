package com.tiendanube.testharness.interview.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@Test
@CucumberOptions(
    features = {"src/test/resources/features/"},
    glue = {"com.tiendanube.qe.e2e.interview.stepdefinitions"},
    tags = {"@smoke"},
    plugin = {
        "pretty",
        "json:build/test-harness-results/cucumber/cucumber.json",
        "json:build/test-harness-results/cucumber/results.cucumber"
    })
public class CucumberRunner extends AbstractTestNGCucumberTests {

}