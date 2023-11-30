package models

sealed trait FutsalEvent
trait FutsalMatchEvent extends FutsalEvent

final case class KickOff(to: FutsalPlayer) extends FutsalMatchEvent
final case class Pass(to: FutsalPlayer) extends FutsalMatchEvent
final case class Tackle(attacker: FutsalPlayer) extends FutsalMatchEvent
final case class Goal(scorer: FutsalPlayer) extends FutsalMatchEvent

final object Undo extends FutsalEvent


