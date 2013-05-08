package sim.dsl

import sim.models._

import scala.collection.immutable.Vector

case class LinkBuilder(v: Vector[Any]) {
	
	def are_on(s: SocialNetwork): Vector[Any] = Vector(s.name) ++ v
	
}