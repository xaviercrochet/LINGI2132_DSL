package sim.scenario

import sim.models._
import sim._

import scala.collection.immutable.Vector
import scala.collection.mutable.ListBuffer

class Scenario1(rules: ListBuffer[Vector[Any]]) extends Scenario {

	override def notifySc(p: People) {

		rules.foreach { rule =>

			println("-> " + rule)

			val people_type = rule(0)
			// val action = rule(1)
			val network = rule(2)
			val nbInv = rule(3)

			println("-> " + people_type + " vs " + p.pt.name)

			if(people_type == p.pt.name) {

				println("-> Good people type")

				println("Facebook ? " + p.facebook)
				println("Twitter ? " + p.twitter)
				println("Youtube ? " + p.youtube)

				if(network == "facebook" && !p.facebook) {

					println("-> facebook detected")

					if(p.facebookInvitations.size == nbInv) {
  						p.joinFacebook()
  						println("-> join !")
					}
				}
				else if(network == "twitter" && !p.twitter) {

					println("-> twitter detected")

					if(p.twitterInvitations.size == nbInv) {
  						p.joinTwitter()
  						println("-> join !")
					}
				}
				else if(network == "youtube" && !p.youtube) {

					println("-> youtube detected")

					if(p.youtubeInvitations.size == nbInv) {
  						p.joinYoutube()
  						println("-> join !")
					}
				}
			}
		}
	}
}

object Scenario1 {

	var rules: ListBuffer[Vector[Any]] = ListBuffer()

	def apply(o: Observer) {

		var sc: Scenario1 = new Scenario1(rules)

		// Observe the Facebook's invitation
		o.fbInvitationsObs += sc
		o.twiInvitationsObs += sc
		o.ytInvitationsObs += sc
	}

	def apply(v: Vector[Any]) {

		// Add the rule to the rules list
		rules += v

		println(rules)
	}
}
