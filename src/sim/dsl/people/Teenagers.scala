package sim.dsl.people

import sim.dsl.Population
import sim.models.SocialNetwork

object Teenagers extends PeopleType {
	
	var fb_pref_pc = 50
	var yt_pref_pc = 50
	var twi_pref_pc = 50

	override def fb_pref = fb_pref_pc
	override def twi_pref = twi_pref_pc
	override def yt_pref = yt_pref_pc

	def represent(pc: Double) {

		Population.teenagers = (Population.nbPop / 100) * pc

	}

	def love (sm: SocialNetwork) {

		println("Teenagers love " + sm.name)

		if(sm.name == "facebook") {
			fb_pref_pc = 40
		}
		else if(sm.name == "twitter") {
			twi_pref_pc = 40
		}
		else if(sm.name == "youtube") {
			yt_pref_pc = 40
		}

	}

	def dont_care_of(sm: SocialNetwork) {

		println("Teenagers don't care of " + sm.name)

		if(sm.name == "facebook") {
			fb_pref_pc = 20
		}
		else if(sm.name == "twitter") {
			twi_pref_pc = 20
		}
		else if(sm.name == "youtube") {
			yt_pref_pc = 20
		}

	}

	def hate(sm: SocialNetwork) {

		println("Teenagers hate " + sm.name)

		if(sm.name == "facebook") {
			fb_pref_pc = 10
		}
		else if(sm.name == "twitter") {
			twi_pref_pc = 10
		}
		else if(sm.name == "youtube") {
			yt_pref_pc = 10
		}
	}
}