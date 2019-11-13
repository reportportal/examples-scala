package com.epam.reportportal.example.scalatest.logback.logging

import java.io.File
import java.util.Date

import com.epam.reportportal.example.scalatest.logback.LoggingUtils
import com.epam.reportportal.service.ReportPortal
import com.google.common.io.{BaseEncoding, Files, Resources}
import org.scalatest.{FunSuite, Matchers}
import org.slf4j.LoggerFactory

class JsonLoggingTest extends FunSuite with Matchers {
  private val LOGGER = LoggerFactory.getLogger(classOf[JsonLoggingTest])
  val jsonFilePath = "xml/file.json"

  test("Log JSON Base64"){
    LOGGER.debug("Logging JSON as Base64")
    /* here we are logging some binary data as BASE64 string */
    ReportPortal.emitLaunchLog("LAUNCH LOG MESSAGE", "error", new Date)

    val file = File.createTempFile("rp-test", ".css")
    Resources.asByteSource(Resources.getResource("files/css.css")).copyTo(Files.asByteSink(file))
    ReportPortal.emitLaunchLog("LAUNCH LOG MESAGE WITH ATTACHMENT", "error", new Date, file)

    LoggingUtils.log(Resources.asByteSource(Resources.getResource(jsonFilePath)).read, "I'm logging content via BASE64")
  }

  test("Log JSON as File"){
    val file = File.createTempFile("rp-test", ".json")
    Resources.asByteSource(Resources.getResource(jsonFilePath)).copyTo(Files.asByteSink(file))

    for(i <- 0 until 1) {
      LoggingUtils.log(file, "I'm logging content via temp file")
    }
  }

}
