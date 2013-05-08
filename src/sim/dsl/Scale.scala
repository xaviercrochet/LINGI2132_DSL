package sim.dsl

import scala.collection.immutable.Vector

case class Scale(val amount: Double) {
	
    def thousands_of_people = amount * 1000

    def millions_of_people = amount * 1000000

    def people = amount

    def invitations : Vector[Any] = Vector("invitation", amount.toInt)

    def subscribers : Vector[Any] = Vector("subscriber", amount.toInt)

    def followers : Vector[Any] = Vector("follower", amount.toInt)

    def messages : Vector[Any] = Vector("message", amount.toInt)

    def friends : Vector[Any] = Vector("friends", amount.toInt)

    def adults: Vector[Any] = Vector("adults", amount.toInt)
}
