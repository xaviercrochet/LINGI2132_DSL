package sim.models

object Facebook extends SocialNetwork
{
  override val name = "facebook"
  var nbSub = 0.

  def count(nb: Double) {
		nbSub += nb
	}

  def when_receive(i: Double): Vector[Any] = Vector("facebook", i)
}
