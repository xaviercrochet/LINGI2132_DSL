package sim.models

object Twitter extends SocialNetwork
{

  override val name = "twitter"
  var nbSubscriber = 0

  def count(nb: Int) {
		nbSubscriber += nb
	}
}
