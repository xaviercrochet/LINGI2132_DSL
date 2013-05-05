package sim.models

object Facebook extends SocialNetwork
{
  override val name = "facebook"
  var nbSubscriber = 0

  def count(nb: Int) {
		nbSubscriber += nb
	}
}
