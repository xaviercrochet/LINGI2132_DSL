package sim.dsl

object Preamble {

	implicit def double2Scale(i: Int) = Scale(i)

	implicit def double2Percent(i: Int) = PopulationHelper(i)

}