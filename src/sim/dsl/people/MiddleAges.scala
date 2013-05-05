package sim.dsl.people

import sim.dsl.Population
import sim.models.SocialNetwork

object MiddleAges extends PeopleType {
	
	def represent(pc: Double) {

		Population.middle_ages = (Population.nbPop / 100) * pc

	}

	def love (sm: SocialNetwork) {
		println("Students love " + sm.name)
	}

	def dont_care_of(sm: SocialNetwork) {
		println("Students don't care of " + sm.name)
	}

	def hate(sm: SocialNetwork) {
		println("Students hate " + sm.name)
	}
}