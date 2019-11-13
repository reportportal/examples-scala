package com.epam.reportportal.example.scala.scalatest.logging

import java.io.File

import com.epam.reportportal.example.scala.LoggingUtils
import com.google.common.io.{Files, Resources}
import org.scalatest.{FunSuite, Matchers}

class XmlLoggingTest extends FunSuite with Matchers {

  val xmlFilePath = "xml/file.xml"

  test("Log XML Base64"){
    LoggingUtils.log(Resources.asByteSource(Resources.getResource(xmlFilePath)).read, "I'm logging content via BASE64")
  }

  test("Log XML as File"){
    val file = File.createTempFile("rp-test", "xml")
    Resources.asByteSource(Resources.getResource(xmlFilePath)).copyTo(Files.asByteSink(file))

    LoggingUtils.log(file, "I'm logging content via temp file")
  }
}
