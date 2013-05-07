package sim.models

import scala.collection.immutable.Vector

object Youtube extends SocialNetwork
{
	override val name = "youtube"
		var nbSub = 0.

	def count(nb: Double) {
		nbSub += nb
	}

	def when_receive(i: Int): Vector[Any] = Vector("youtube", i)
}
