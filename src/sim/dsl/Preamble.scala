package sim.dsl

import sim.models._

object Preamble {

	implicit def double2Scale(i: Int) = Scale(i)

	implicit def double2Percent(i: Int) = PopulationHelper(i)

	implicit def socialNetwork2ScenarioHelper(s: SocialNetwork) = ScenarioHelper(s)

}