package com.epam.reportportal.example.scala.scalatest

import org.scalatest.{BeforeAndAfterAll, FunSuite}
import org.slf4j.LoggerFactory

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
class BeforeAfterAllTest extends FunSuite with BeforeAndAfterAll {
  private val LOGGER = LoggerFactory.getLogger(classOf[BeforeAfterAllTest])

  override protected def beforeAll(): Unit = {
    LOGGER.info("Before All")
  }

  test("first") {
    LOGGER.info("First method")
  }

  test("second") {
    LOGGER.info("Second Method")
  }

  override protected def afterAll(): Unit = {
    LOGGER.info("After All")
  }
}
