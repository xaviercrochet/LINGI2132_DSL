package sim.models

object Twitter
{
  var nbSubscriber = 0

  def count(nb: Int) {
		nbSubscriber += nb
	}
}
