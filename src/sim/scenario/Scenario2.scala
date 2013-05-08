package sim.scenario

import sim.models._
import sim._

import scala.collection.immutable.Vector
import scala.collection.mutable.ListBuffer

class Scenario2(rules: ListBuffer[Vector[Any]]) extends Scenario {

	def do_action(p: People, target_people: String, target_network: String, nb_people: Int): Boolean = {

		// Check the condition :
		var nb = 0

		for (people <- p.circle) {

			if(people.pt.name == target_people) {

				if(target_network == "facebook" && people.facebook) nb += 1
				else if(target_network == "twitter" && people.twitter) nb += 1
				else if(target_network == "youtube" && people.youtube) nb += 1
			}
		}

		// Would the people do the action to join or leave ?
		(nb >= nb_people)
	}

	override def notifySc(p: People) {

		rules.foreach { rule =>

			val people_type = rule(0).toString
			val action = rule(1).toString
			val target_network = rule(2).toString
			val action_network = rule(3).toString
			val target_people = rule(4).toString
			val nb_people = rule(5).toString.toInt

			// Check if the rule concern the people
			if(people_type == p.pt.name && do_action(p, target_people, target_network, nb_people)) {

				if(action == "join") {

					if(action_network == "facebook" && !p.facebook) p.joinFacebook()
					else if(action_network == "twitter" && !p.twitter) p.joinTwitter()
					else if(action_network == "youtube" && !p.youtube) p.joinYoutube()
				}
				else if(action == "leave") {

					if(action_network == "facebook" && p.facebook) p.leaveFacebook()
					else if(action_network == "twitter" && p.twitter) p.leaveTwitter()
					else if(action_network == "youtube" && p.youtube) p.leaveYoutube()
				}
			}
		} 
	}
}

object Scenario2 {

	var rules: ListBuffer[Vector[Any]] = ListBuffer()

	def apply(o: Observer) {

		var sc: Scenario2 = new Scenario2(rules)

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