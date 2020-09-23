package com.uj.study.cucumber;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
//  features = {"classpath:features/calculator.feature"}
  features = {"classpath:features/calculator.feature", "classpath:features/calculator-scenario-outline.feature"}
  , plugin = {"pretty", "json:target/reports/json/calculator.json"}
)
public class CalculatorIntegrationTest {
}
