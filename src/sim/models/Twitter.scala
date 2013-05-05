package sim.models

object Twitter extends SocialNetwork
{

  override val name = "twitter"
  var nbSub = 0

  def count(nb: Int) {
		nbSub += nb
	}
}
