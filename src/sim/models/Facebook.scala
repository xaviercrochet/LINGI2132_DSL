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

  def when(v: Vector[Any]): Vector[Any] = Vector("facebook") ++ v
  def when_more_than(v: Vector[Any]): Vector[Any] = Vector("facebook", "when_more_than") ++v
  def when_less_than(v: Vector[Any]): Vector[Any] = Vector("facebook", "when_less_than") ++v
}
