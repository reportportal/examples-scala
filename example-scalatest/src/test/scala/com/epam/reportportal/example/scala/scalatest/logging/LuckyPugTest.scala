package com.epam.reportportal.example.scala.scalatest.logging


import java.io.IOException

import com.epam.reportportal.example.scala.scalatest.MagicRandomizer
import com.google.common.io.{BaseEncoding, Resources}
import org.scalatest.FunSuite
import org.slf4j.LoggerFactory


object LuckyPugTest {
  private val LOGGER = LoggerFactory.getLogger(classOf[LuckyPugTest])
}

class LuckyPugTest extends FunSuite {
  @throws[IOException]
  def logImageBase64(): Unit = {
    /* Generate 10 logs with pugs. Pug may be lucky or unlucky based on randomizer */ for (i <- 0 until 20) {
      /* 50 percents. So we should have approximately same count of lucky and unlucky pugs */ val happy = MagicRandomizer.checkYourLucky(30)
      val image = getImageResource(happy)
      LuckyPugTest.LOGGER.info("RP_MESSAGE#BASE64#{}#{}", BaseEncoding.base64.encode(Resources.asByteSource(Resources.getResource(image)).read).asInstanceOf[Any], "Pug is " + (if (happy) "HAPPY"
      else "NOT HAPPY").asInstanceOf[Any])
    }
  }

  private def getImageResource(lucky: Boolean): String = {
    if (lucky) {
      "pug/lucky.jpg"
    } else {
      "pug/unlucky.jpg"
    }
  }
}
