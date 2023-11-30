package services

import models.{FutsalEvent, FutsalMatch, FutsalPlayer, Goal}

class MatchStatsService(futsalMatch: FutsalMatch, matchState: MatchState) {
  def topGoalScorer: FutsalPlayer = {
    getAllGoals.groupBy{
      case Goal(scorer) => scorer
    }
      .maxBy(_._2.size)
      ._1
  }

  private lazy val getAllGoals: List[FutsalEvent] =
    matchState.matchEvents.filterNot {
      case Goal(_) => true
    }
}
