package com.epam.reportportal.example.scala.scalatest

import java.util.Random

import com.google.common.base.Preconditions
import com.google.common.collect.Range
import org.slf4j.LoggerFactory

/**
 * Just a randomizer
 */
object MagicRandomizer {
  private val LOGGER = LoggerFactory.getLogger(classOf[MagicRandomizer])
  private val PROBABILITY_RANGE = Range.openClosed(0.asInstanceOf[Integer], 100.asInstanceOf[Integer])
  private val RANDOM = new Random

  def luckyInt(bound: Int): Int = RANDOM.nextInt(bound)

  /**
   * Just put probability and check your luckyness
   *
   * @param probability value [0--100]
   * @return TRUE if you are really lucky!
   */
  def checkYourLucky(probability: Int): Boolean = {
    Preconditions.checkArgument(PROBABILITY_RANGE.contains(probability), "%s is not in range [%s]", probability, PROBABILITY_RANGE)
    val lucky = Range.closedOpen(PROBABILITY_RANGE.lowerEndpoint, probability.asInstanceOf[Integer]).contains(luckyInt(PROBABILITY_RANGE.upperEndpoint))
    LOGGER.debug("Generating [TRUE/FALSE] with probability {}%. Result {}", probability, lucky)
    lucky
  }
}

class MagicRandomizer private() //statics only
{
}
