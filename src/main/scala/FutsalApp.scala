import models._
import services.MatchState

object FutsalApp extends App {
  def createFakeMatch() = {
    val team1Player1 = FutsalPlayer(1, "Harry")
    val team1Player2 = FutsalPlayer(2, "Brandon")
    val team1Player3 = FutsalPlayer(3, "Jon")
    val team1Player4 = FutsalPlayer(4, "Alex")
    val team1Player5 = FutsalPlayer(5, "Jude")
    val team1Players = List(
      team1Player1,
      team1Player2,
      team1Player3,
      team1Player4,
      team1Player5,
    )
    val team2Player1 = FutsalPlayer(6, "Colm")
    val team2Player2 = FutsalPlayer(7, "Juan")
    val team2Player3 = FutsalPlayer(8, "Mustafa")
    val team2Player4 = FutsalPlayer(9, "Nigel")
    val team2Player5 = FutsalPlayer(10, "Santiago")
    val team2Players = List(
      team2Player1,
      team2Player2,
      team2Player3,
      team2Player4,
      team2Player5,
    )

    val futsalMatch = FutsalMatch(
      team1 = FutsalTeam("Players United", team1Players),
      team2 = FutsalTeam("Team FC", team2Players)
    )

    val events = List(
      KickOff(team1Player1),
      Pass(team1Player4),
      Pass(team1Player2),
      Pass(team1Player3),
      Tackle(team2Player1),
      Pass(team2Player2),
      Pass(team2Player4),
      Undo,
      Goal(team2Player2),
      KickOff(team1Player1),
      Pass(team1Player4),
      Tackle(team2Player4),
      Pass(team2Player2),
      Tackle(team1Player3),
      Goal(team1Player3),
      KickOff(team2Player3),
      Pass(team2Player1),
      Pass(team2Player3),
      Goal(team1Player3),
    )

    events.foldLeft(MatchState.empty)((matchState, event) => matchState.addEvent(event))
  }

  createFakeMatch()
}