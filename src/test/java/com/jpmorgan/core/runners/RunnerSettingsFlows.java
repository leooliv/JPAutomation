package com.jpmorgan.core.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = { "pretty", "com.jpmorgan.core.AllureListener" },
  snippets = CucumberOptions.SnippetType.CAMELCASE,
  features = "src/test/resources/features/ValidateSettings.feature",
  glue = "com.jpmorgan.core",
  tags = "@Settings"
)
public class RunnerSettingsFlows {}
