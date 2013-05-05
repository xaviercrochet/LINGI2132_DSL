package sim.dsl.people

import sim.dsl.Population
import sim.models.SocialNetwork

object Students extends PeopleType {
	
	// Default preferences
	var fb_pref = super.dont_care_of_pc
	var yt_pref = super.dont_care_of_pc
	var twi_pref = super.dont_care_of_pc

	def represent(pc: Double) {

		Population.students = (Population.nbPop / 100) * pc

	}

	def love (sm: SocialNetwork) {

		println("Students love " + sm.name)

		if(sm.name == "facebook") {
			fb_pref = super.love_pc
		}
		else if(sm.name == "twitter") {
			twi_pref = super.love_pc
		}
		else if(sm.name == "youtube") {
			yt_pref = super.love_pc
		}

	}

	def dont_care_of(sm: SocialNetwork) {

		println("Students don't care of " + sm.name)

		if(sm.name == "facebook") {
			fb_pref = super.dont_care_of_pc
		}
		else if(sm.name == "twitter") {
			twi_pref = super.dont_care_of_pc
		}
		else if(sm.name == "youtube") {
			yt_pref = super.dont_care_of_pc
		}

	}

	def hate(sm: SocialNetwork) {

		println("Students hate " + sm.name)

		if(sm.name == "facebook") {
			fb_pref = super.hate_pc
		}
		else if(sm.name == "twitter") {
			twi_pref = super.hate_pc
		}
		else if(sm.name == "youtube") {
			yt_pref = super.hate_pc
		}
	}
}