import scala.collection.mutable.ListBuffer

object PeopleManager {

	def createPeople(nbPeople: Int, m: SimModel): ListBuffer[People] = {

		var population = new ListBuffer[People]()

		for(i <- 0 until nbPeople) {

			val onePeople = new People("MyName", m, false)
			population += onePeople
		}

		population
	}
}