package sim.models

object Youtube
{
  var nbSubscriber = 0

  def count(nb: Int) {
		nbSubscriber += nb
	}
}
