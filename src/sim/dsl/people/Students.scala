package sim.dsl.people

import sim.dsl.Population

object Students {
	
	def represent(pc: Int) {

		Population.students = (Population.population / 100) * pc

	}

}