class Scenario1 extends Scenario {

	//override def notifySc

	override def notifySc(p: People) {
		//println("Scenario1 activated !")

		// If 3 invitations received, the people join Facebook
		if(p.facebookInvitations.size == 3) {
      		p.joinFacebook()
    	}
	}

}

object Scenario1 {
	def apply(o: Observer) {
		var sc1: Scenario1 = new Scenario1()

		// Observe the Facebook's invitation
		o.fbInvitationsObs += sc1
	}
}