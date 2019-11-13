package com.epam.reportportal.example.scala.cucumber

import com.codeborne.selenide.WebDriverRunner
import com.epam.reportportal.example.scala.LoggingUtils
import io.cucumber.core.api.Scenario
import io.cucumber.java.After
import org.openqa.selenium.{OutputType, TakesScreenshot}
import org.slf4j.{Logger, LoggerFactory}

/**
 * @author Danila Morokov
 */
object Hooks {
  def takeScreenshot(): Option[Array[Byte]] = {
    Option(WebDriverRunner.getWebDriver.asInstanceOf[TakesScreenshot].getScreenshotAs(OutputType.BYTES))
  }
}

/**
 * @author Danila Morokov
 */
class Hooks {
  val logger: Logger = LoggerFactory.getLogger(classOf[Hooks])

  @After def afterMethod(scenario: Scenario): Unit = {
    if (scenario.isFailed) {
      Hooks.takeScreenshot().foreach(s => LoggingUtils.log(s, "Failed scenario screenshot"))
      WebDriverRunner.closeWebDriver()
    }
  }
}
