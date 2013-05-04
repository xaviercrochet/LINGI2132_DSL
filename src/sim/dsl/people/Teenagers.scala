package sim.dsl.people

import sim.dsl.Population

object Teenagers {
	
	def represent(pc: Int) {

		Population.teenagers = (Population.population / 100) * pc

	}

}