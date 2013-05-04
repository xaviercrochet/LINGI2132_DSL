package sim.dsl.people

import sim.dsl.Population

object MiddleAges {
	
	def represent(pc: Int) {

		Population.middle_ages = (Population.population / 100) * pc

	}

}