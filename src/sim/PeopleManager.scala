package sim
import scala.util.Random
import scala.collection.mutable.ListBuffer
import sim.models._

object PeopleManager {

	def createPeople(nbPeople: Int, minAge: Int, maxAge: Int, nbSub: Int, m: SimModel, o: Observer): ListBuffer[People] = {

		var population = new ListBuffer[People]()
		var nbSubVar = nbSub

		// People creation
		for(i <- 0 until nbPeople) {

      	val onePeople = new People("MyName"+i, o, m, minAge+Random.nextInt(maxAge-minAge), Random.nextBoolean(), nbSubVar > 0 , nbSubVar >0, nbSubVar > 0)
			population += onePeople
			nbSubVar -= 1
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

  def activatePeople(listOfPeople: ListBuffer[People]) {
    for (p <- listOfPeople) {
      println("Activating: "+ p)
      p.run()
    }
  }
}
