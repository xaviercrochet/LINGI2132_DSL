package sim.models

object Youtube extends SocialNetwork
{
  override val name = "youtube"
  var nbSubscriber = 0

  def count(nb: Int) {
		nbSubscriber += nb
	}
}
