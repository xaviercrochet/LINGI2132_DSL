package sim.models

import scala.collection.immutable.Vector

object Twitter extends SocialNetwork
{

	override val name = "twitter"
	var nbSub = 0.

	def count(nb: Double) {
		nbSub += nb
	}

	def when_receive(v: Vector[Any]): Vector[Any] = Vector("twitter", "when_receive") ++v
}
