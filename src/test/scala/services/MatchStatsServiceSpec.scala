package services

import models.KickOff
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import utils.TestUtils._

class MatchStatsServiceSpec extends AnyFlatSpec with Matchers {
	"topGoalScorer" should "return top goal scorer" in {
		val testMatchState = new MatchState(testEvents)
		val matchStatsService = new MatchStatsService(testFutsalMatch, testMatchState)

		matchStatsService.topGoalScorer shouldBe Some(testTeam1Player3)
	}

	"topGoalScorer2" should "return top goal scorer" in {
		val testMatchState = new MatchState(List(KickOff(testTeam1Player3)))
		val matchStatsService = new MatchStatsService(testFutsalMatch, testMatchState)

		matchStatsService.topGoalScorer shouldBe None
	}

	"topTackler" should "return top tackler" in {
		val testMatchState = new MatchState(testEvents)
		val matchStatsService = new MatchStatsService(testFutsalMatch, testMatchState)

		matchStatsService.topTackler shouldBe testTeam2Player1
	}
}