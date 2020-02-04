package com.epam.reportportal.example.scala.scalatest

import org.scalatest.{BeforeAndAfter, FunSuite}
import org.slf4j.LoggerFactory

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
class BeforeAfterTest extends FunSuite with BeforeAndAfter {
  private val LOGGER = LoggerFactory.getLogger(classOf[BeforeAfterTest])

  var value: String = _;

  before {
    value = randomString()
    LOGGER.info("Before method with value = {}", value)
  }

  test("first") {
    LOGGER.info("First method with value = {}", value)
  }

  test("second") {
    LOGGER.info("Second method with value = {}", value)
  }

  after {
    LOGGER.info("after method")
  }

  private def randomString() = {
    val r = new scala.util.Random
    val sb = new StringBuilder
    for (i <- 1 to 10) {
      sb.append(r.nextPrintableChar)
    }
    sb.toString
  }

}
