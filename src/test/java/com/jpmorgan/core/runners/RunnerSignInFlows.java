package com.jpmorgan.core.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = { "pretty", "com.jpmorgan.core.AllureListener" },
  snippets = CucumberOptions.SnippetType.CAMELCASE,
  features = "src/test/resources/features/ValidateSignIn.feature",
  glue = "com.jpmorgan.core",
  tags = "@HappyPath"
)
public class RunnerSignInFlows {}
