package services

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import utils.TestUtils._

class MatchStatsServiceSpec extends AnyFlatSpec with Matchers {
  "topGoalScorer" should "return top goal scorer" in {
    val testMatchState = new MatchState(testEvents)
    val matchStatsService = new MatchStatsService(testFutsalMatch, testMatchState)

    matchStatsService.topGoalScorer shouldBe None
  }
}
