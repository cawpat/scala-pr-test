package services

import models.{FutsalEvent, FutsalMatchEvent, Undo}

class MatchState(val matchEvents: List[FutsalMatchEvent]) {
  def addEvent(futsalEvent: FutsalEvent): MatchState = {
    futsalEvent match {
      case Undo => removeLastEvent
      case event: FutsalMatchEvent => new MatchState(event :: matchEvents)
    }
  }
  private def removeLastEvent: MatchState = matchEvents match {
    case ::(_, tail) => new MatchState(tail)
    case Nil => new MatchState(Nil)
  }
}

object MatchState {
  val empty = new MatchState(Nil)
}
