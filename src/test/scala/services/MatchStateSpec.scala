package services

import models._
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class MatchStateSpec extends AnyFlatSpec with Matchers {
  "addEvent" should "add event to list" in {
    val matchState = MatchState.empty
    val newEvent = KickOff(FutsalPlayer(1, "Bob"))
    val newMatchState = matchState.addEvent(newEvent)

    newMatchState.matchEvents shouldBe List(newEvent)
  }

  "addEvent with Undo" should "remove last event" in {
    val events = List(KickOff(FutsalPlayer(1, "Bob")), Pass(FutsalPlayer(2, "Sarah")))
    val matchState = new MatchState(events)
    val expectedEvents = List(KickOff(FutsalPlayer(1, "Bob")))
    val newMatchState = matchState.addEvent(Undo)

    newMatchState.matchEvents shouldBe expectedEvents
  }

  "addEvent with Undo" should "return same MatchState if already empty" in {
    val matchState = MatchState.empty
    val newMatchState = matchState.addEvent(Undo)

    newMatchState shouldBe matchState
  }
}
