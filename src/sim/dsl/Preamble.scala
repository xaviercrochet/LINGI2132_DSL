package sim.dsl

import sim.models._

import scala.collection.immutable.Vector

object Preamble {

	implicit def double2Scale(i: Int) = Scale(i)

	implicit def double2Percent(i: Int) = PopulationHelper(i)

	implicit def vector2LinkBuilder(v: Vector[Any]) = LinkBuilder(v)

}