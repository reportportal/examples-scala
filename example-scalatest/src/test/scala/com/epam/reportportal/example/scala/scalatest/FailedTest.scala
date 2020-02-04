package com.epam.reportportal.example.scala.scalatest

import com.epam.reportportal.annotations.TestCaseId
import org.scalatest.FunSuite

/**
 * @author <a href="mailto:ihar_kahadouski@epam.com">Ihar Kahadouski</a>
 */
class FailedTest extends FunSuite {

  test("failed") {
    assert(false)
  }

  @TestCaseId def value = "test-case-id"
  test("failed with exception") {
    throw new IllegalArgumentException()
  }
}
