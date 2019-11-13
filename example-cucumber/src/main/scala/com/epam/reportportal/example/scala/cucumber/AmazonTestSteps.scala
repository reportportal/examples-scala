package com.epam.reportportal.example.scala.cucumber

import com.codeborne.selenide.Selenide.{$, open}
import com.epam.reportportal.example.scala.LoggingUtils
import io.cucumber.java.en.{Given, Then, When}
import org.openqa.selenium.By
import org.slf4j.{Logger, LoggerFactory}

/**
 * @author Danila Morokov
 */
class AmazonTestSteps {
  val logger: Logger = LoggerFactory.getLogger(classOf[AmazonTestSteps])

  @Given("^User opens page$") def userOpenPage(): Unit = {
    open("https://www.amazon.com/")
  }

  @Then("^User typing a search query$") def userTypingSearchQuery(): Unit = {
    $(By.id("twotabsearchtextbox")).sendKeys("apple")
  }

  @When("^User clicks search button$") def userClicksSearchButton(): Unit = {
    $(By.xpath("//*[@id='nav-search']/form/div[2]/div/input")).click()

    Hooks.takeScreenshot().foreach(s => LoggingUtils.log(s, "Inline scenario screenshot"))
    $(By.xpath("//*[@id='nav-search1']/form/div[2]/div/input")).click()
  }
}
