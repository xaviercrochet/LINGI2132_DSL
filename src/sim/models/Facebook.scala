package sim.models

object Facebook
{
  var nbSubscriber = 0

  def count(nb: Int) {
		nbSubscriber += nb
	}
}
