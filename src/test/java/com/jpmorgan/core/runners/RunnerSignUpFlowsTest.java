package com.jpmorgan.core.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = { "pretty" },
  snippets = CucumberOptions.SnippetType.CAMELCASE,
  features = "src/test/resources/features/validateSignUp.feature",
  glue = "com.jpmorgan.core",
  tags = "@SignUp"
)
public class RunnerSignUpFlowsTest {}
