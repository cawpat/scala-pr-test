package services

import models.{FutsalEvent, FutsalMatch, FutsalMatchEvent, FutsalPlayer, Goal, KickOff, Pass, Tackle}

class MatchStatsService(futsalMatch: FutsalMatch, matchState: MatchState) {
	def topGoalScorer = {
		getAllGoals.groupBy{
			case Goal(scorer) => scorer
		}
			.maxByOption(playerAndGoals => {
				val (player, goals) = playerAndGoals
				goals.size
			})
			.map(_._1)
	}

	def topTackler: FutsalPlayer = {
		def calculateTackleCounts(acc: Map[FutsalPlayer, Int], restOfEvents: List[FutsalMatchEvent]): Map[FutsalPlayer, Int] = {
			restOfEvents match {
				case head :: tail =>
					head match {
						case Tackle(attacker) =>
							val newCount = acc.get(attacker)
								.map(count => count + 1)

							newCount match {
								case Some(nc) =>
									val newAcc = acc.removed(attacker) + (attacker -> nc)
									calculateTackleCounts(newAcc, tail)
								case None =>
									val newAcc = acc + (attacker -> 1)
									calculateTackleCounts(newAcc, tail)
							}
						case _ => calculateTackleCounts(acc, tail)
					}
				case Nil => acc
			}
		}

		calculateTackleCounts(Map.empty, matchState.matchEvents)
			.maxBy(playerAndTackles => {
				val (_, tackles) = playerAndTackles
				tackles
			})
			._1
	}

	private lazy val getAllGoals: List[FutsalMatchEvent] =
		matchState.matchEvents.filter {
			case Goal(_) => true
			case _ => false
		}
}