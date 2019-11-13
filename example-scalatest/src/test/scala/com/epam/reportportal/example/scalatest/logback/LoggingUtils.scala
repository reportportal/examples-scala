package com.epam.reportportal.example.scalatest.logback

import java.io.File

import com.google.common.io.BaseEncoding
import org.slf4j.LoggerFactory

object LoggingUtils {
  private val LOGGER = LoggerFactory.getLogger("binary_data_logger")

  def log(file: File, message: String): Unit = {
    LOGGER.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath.asInstanceOf[Any], message.asInstanceOf[Any])
  }

  def log(bytes: Array[Byte], message: String): Unit = {
    LOGGER.info("RP_MESSAGE#BASE64#{}#{}", BaseEncoding.base64.encode(bytes).asInstanceOf[Any], message.asInstanceOf[Any])
  }
}
