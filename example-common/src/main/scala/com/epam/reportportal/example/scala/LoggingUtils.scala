package com.epam.reportportal.example.scala

import java.io.File

import org.slf4j.LoggerFactory
import rp.com.google.common.io.BaseEncoding

object LoggingUtils {
  private val LOGGER = LoggerFactory.getLogger("binary_data_logger")

  def log(file: File, message: String): Unit = {
    LOGGER.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath.asInstanceOf[Any], message.asInstanceOf[Any])
  }

  def log(bytes: Array[Byte], message: String): Unit = {
    LOGGER.info("RP_MESSAGE#BASE64#{}#{}", BaseEncoding.base64.encode(bytes).asInstanceOf[Any], message.asInstanceOf[Any])
  }
}
