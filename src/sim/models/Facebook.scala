package sim.models

import scala.collection.immutable.Vector

object Facebook extends SocialNetwork
{
  override val name = "facebook"
  var nbSub = 0.

  def count(nb: Double) {
		nbSub += nb
	}

  def when_receive(v: Vector[Any]): Vector[Any] = Vector("facebook", "when_receive") ++v
}
