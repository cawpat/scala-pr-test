package utils

import models.{FutsalMatch, FutsalPlayer, FutsalTeam, Goal, KickOff, Pass, Tackle, Undo}

object TestUtils {
  val testTeam1Player1 = FutsalPlayer(1, "Harry")
  val testTeam1Player2 = FutsalPlayer(2, "Brandon")
  val testTeam1Player3 = FutsalPlayer(3, "Jon")
  val testTeam1Player4 = FutsalPlayer(4, "Alex")
  val testTeam1Player5 = FutsalPlayer(5, "Jude")
  val testTeam1Players = List(
    testTeam1Player1,
    testTeam1Player2,
    testTeam1Player3,
    testTeam1Player4,
    testTeam1Player5,
  )
  val testTeam2Player1 = FutsalPlayer(6, "Colm")
  val testTeam2Player2 = FutsalPlayer(7, "Juan")
  val testTeam2Player3 = FutsalPlayer(8, "Mustafa")
  val testTeam2Player4 = FutsalPlayer(9, "Nigel")
  val testTeam2Player5 = FutsalPlayer(10, "Santiago")
  val testTeam2Players = List(
    testTeam2Player1,
    testTeam2Player2,
    testTeam2Player3,
    testTeam2Player4,
    testTeam2Player5,
  )

  val testFutsalMatch = FutsalMatch(
    team1 = FutsalTeam("Players United", testTeam1Players),
    team2 = FutsalTeam("Team FC", testTeam2Players)
  )

  val testEvents = List(
    KickOff(testTeam1Player1),
    Pass(testTeam1Player4),
    Pass(testTeam1Player2),
    Pass(testTeam1Player3),
    Tackle(testTeam2Player1),
    Pass(testTeam2Player2),
    Pass(testTeam2Player4),
    Goal(testTeam2Player2),
    KickOff(testTeam1Player1),
    Pass(testTeam1Player4),
    Tackle(testTeam2Player4),
    Pass(testTeam2Player2),
    Tackle(testTeam1Player3),
    Goal(testTeam1Player3),
    KickOff(testTeam2Player3),
    Pass(testTeam2Player1),
    Pass(testTeam2Player3),
    Goal(testTeam1Player3),
  )
}
