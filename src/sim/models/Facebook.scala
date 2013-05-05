package sim.models

object Facebook extends SocialNetwork
{
  override val name = "facebook"
  var nbSub = 0

  def count(nb: Int) {
		nbSub += nb
	}
}
