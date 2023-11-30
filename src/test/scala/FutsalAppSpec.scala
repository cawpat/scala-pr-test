import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class FutsalAppSpec extends AnyFlatSpec with Matchers {
  "FutsalApp.createFakeMatch" should "return full MatchState" in {
    FutsalApp.createFakeMatch.matchEvents.length shouldBe 17
  }
}
