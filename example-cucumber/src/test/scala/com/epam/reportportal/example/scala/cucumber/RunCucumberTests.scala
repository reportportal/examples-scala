package com.epam.reportportal.example.scala.cucumber

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  plugin = Array("pretty", "com.epam.reportportal.cucumber.ScenarioReporter"),
  features = Array("example-cucumber/src/test/resources/features"),
  glue = Array("com.epam.reportportal.example.scala.cucumber"))
class RunCucumberTests {}
