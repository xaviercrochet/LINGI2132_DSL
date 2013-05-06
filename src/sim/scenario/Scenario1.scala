package sim.scenario

import sim.models._
import sim._

class Scenario1 extends Scenario {

	var listScenario

	override def notifySc(p: People) {

		// If 3 invitations received, the people join Facebook
		if(p.facebookInvitations.size == 3 && !p.facebook) {
      		p.joinFacebook()
    	}

    	if(p.twitterInvitations.size == 3 && !p.twitter) {
      		p.joinTwitter()
    	}

    	if(p.youtubeInvitations.size == 3 && !p.youtube) {
      		p.joinYoutube()
    	}
	}
}

object Scenario1 {
	def apply(o: Observer) {
		var sc1: Scenario1 = new Scenario1()

		// Observe the Facebook's invitation
		o.fbInvitationsObs += sc1
		o.twiInvitationsObs += sc1
		o.ytInvitationsObs += sc1
	}

	def students_join(v: Vector[Any]) {
		println("Scenario1 : " + v(0) + " " + v(1))
	}
}
