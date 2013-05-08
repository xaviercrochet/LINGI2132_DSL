package sim.models

import scala.collection.immutable.Vector

object Twitter extends SocialNetwork
{

	override val name = "twitter"
	var nbSub = 0.

	def count(nb: Double) {
		nbSub += nb
	}

    def when_more_than(v: Vector[Any]): Vector[Any] = Vector("twitter", "when_more_than") ++v
	def when_receive(v: Vector[Any]): Vector[Any] = Vector("twitter", "when_receive") ++v

	def when(v: Vector[Any]): Vector[Any] = Vector("twitter") ++ v
}
