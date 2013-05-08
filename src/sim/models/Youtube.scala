package sim.models

import scala.collection.immutable.Vector

object Youtube extends SocialNetwork
{
	override val name = "youtube"
		var nbSub = 0.

	def count(nb: Double) {
		nbSub += nb
	}

	def when_receive(v: Vector[Any]): Vector[Any] = Vector("youtube", "when_receive") ++v
    def when_more_than(v: Vector[Any]): Vector[Any] = Vector("youtube", "when_more_than") ++v
	def when(v: Vector[Any]): Vector[Any] = Vector("facebook") ++ v
    def when_less_than(v: Vector[Any]): Vector[Any] = Vector("youtube", "when_less_than") ++v
}
