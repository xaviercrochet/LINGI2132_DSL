import scala.util.Random
import scala.collection.mutable.ListBuffer

object PeopleManager {

	def createPeople(nbPeople: Int, m: SimModel): ListBuffer[People] = {

		var population = new ListBuffer[People]()

		// People creation
		for(i <- 0 until nbPeople) {

			val onePeople = new People("MyName"+i, m, false)
			population += onePeople

		}

		// Link between people
		population.foreach { onePeople: People =>

			// Make a copy of the population except the actual people
			var populationCopy = population - onePeople

			// Take randomly 3 people from the population
			onePeople.circle = Random.shuffle(populationCopy) take Random.nextInt(population.length)
		}

		population
	}
}