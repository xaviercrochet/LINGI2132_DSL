package sim.scenario

import sim.models._
import sim._

import scala.collection.immutable.Vector
import scala.collection.mutable.ListBuffer

class Scenario2(rules: ListBuffer[Vector[Any]]) extends Scenario {

	override def notifySc(p: People) {

		println("lol !")
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