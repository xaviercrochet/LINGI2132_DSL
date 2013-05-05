package sim.models

object Youtube extends SocialNetwork
{
  override val name = "youtube"
  var nbSub = 0

  def count(nb: Int) {
		nbSub += nb
	}
}
