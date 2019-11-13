package com.epam.reportportal.example.scalatest.logback.logging

import java.io.File

import com.epam.reportportal.example.scalatest.logback.LoggingUtils
import com.google.common.io.{Files, Resources}
import org.scalatest.{FunSuite, Matchers}

class LoggingTest extends FunSuite with Matchers {

  test("Log CSS") {
    val file = File.createTempFile("rp-test", ".css")
    Resources.asByteSource(Resources.getResource("files/css.css")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging CSS")
  }

  test("Log HTML") {
    val file = File.createTempFile("rp-test", ".html")
    Resources.asByteSource(Resources.getResource("files/html.html")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging HTML")
  }

  test("Log PDF") {
    val file = File.createTempFile("rp-test", ".pdf")
    Resources.asByteSource(Resources.getResource("files/test.pdf")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging PDF")
  }

  test("Log ZIP") {
    val file = File.createTempFile("rp-test", ".zip")
    Resources.asByteSource(Resources.getResource("files/demo.zip")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging ZIP")
  }

  test("Log JavaScript") {
    val file = File.createTempFile("rp-test", ".js")
    Resources.asByteSource(Resources.getResource("files/javascript.js")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging JS")
  }

  test("Log PHP") {
    val file = File.createTempFile("rp-test", ".php")
    Resources.asByteSource(Resources.getResource("files/php.php")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging PHP")
  }

  test("Log Plain Text") {
    val file = File.createTempFile("rp-test", ".txt")
    Resources.asByteSource(Resources.getResource("files/plain.txt")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging TXT")
  }

  test("Log CSV") {
    val file = File.createTempFile("rp-test", ".csv")
    Resources.asByteSource(Resources.getResource("files/Test.csv")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging CSV")
  }

  test("Log CMD") {
    val file = File.createTempFile("rp-test", ".cmd")
    Resources.asByteSource(Resources.getResource("files/Test.cmd")).copyTo(Files.asByteSink(file))
    LoggingUtils.log(file, "I'm logging CMD")
  }
}
