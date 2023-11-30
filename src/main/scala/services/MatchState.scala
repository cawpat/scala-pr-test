package services

import models.{FutsalEvent, Undo}

class MatchState(val matchEvents: List[FutsalEvent]) {
  def addEvent(futsalEvent: FutsalEvent): MatchState = {
    futsalEvent match {
      case Undo => removeLastEvent
      case event => new MatchState(matchEvents :+ event)
    }
  }
  private def removeLastEvent: MatchState = matchEvents match {
    case Nil => this
    case events: List[FutsalEvent] => new MatchState(events.reverse.tail.reverse)
  }
}

object MatchState {
  val empty = new MatchState(Nil)
}
