package models

sealed trait FutsalEvent
trait FutsalMatchEvent extends FutsalEvent

final case class KickOff(to: FutsalPlayer) extends FutsalMatchEvent
final case class Pass(to: FutsalPlayer) extends FutsalMatchEvent
final case class Tackle(attacker: FutsalPlayer) extends FutsalMatchEvent
final case class Goal(scorer: FutsalPlayer) extends FutsalMatchEvent

//Undo only extends FutsalEvent as it shouldn't be added to a MatchState
final object Undo extends FutsalEvent


