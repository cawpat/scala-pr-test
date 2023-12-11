import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import utils.TestUtils._

class FutsalAppSpec extends AnyFlatSpec with Matchers {
  "FutsalApp" should "return full MatchState" in {
    FutsalApp.matchState.matchEvents.length shouldBe 17
  }

  "FutsalApp" should "return correct topScorer" in {
    FutsalApp.topScorer shouldBe testTeam1Player3
  }

  "FutsalApp" should "return correct topTackler" in {
    FutsalApp.topTackler shouldBe testTeam1Player3
  }
}
