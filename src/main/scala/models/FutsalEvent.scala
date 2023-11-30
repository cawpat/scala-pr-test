package models

sealed trait FutsalEvent

final case class KickOff(to: FutsalPlayer) extends FutsalEvent
final case class Pass(to: FutsalPlayer) extends FutsalEvent
final case class Tackle(attacker: FutsalPlayer) extends FutsalEvent
final case class Goal(scorer: FutsalPlayer) extends FutsalEvent
final object Undo extends FutsalEvent


