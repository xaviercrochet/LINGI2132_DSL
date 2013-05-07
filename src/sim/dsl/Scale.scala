package sim.dsl

import scala.collection.immutable.Vector

case class Scale(val amount: Double) {
	
	def thousands_of_people = amount * 1000

	def millions_of_people = amount * 1000000

	def people = amount

	def invitations = amount.toInt

	def friends = amount

	def adults: Vector[Any] = Vector("adults", amount.toInt)
}