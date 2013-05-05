package sim

import sim.models._
import sim.dsl._

import scala.util.Random
import scala.collection.mutable.ListBuffer

object PeopleManager {

	def createPeople(m: SimModel, o: Observer): ListBuffer[People] = {

		var population = new ListBuffer[People]()
		//var nbSubVar = nbSub

		var nbFb = Facebook.nbSub
		var nbTwi = Twitter.nbSub
		var nbYt = Youtube.nbSub

		val minAge = 7
		val maxAge = 77

		// People creation
		for(i <- 0 until Population.nbPop) {

      	val onePeople = new People("MyName"+i, o, m, minAge + Random.nextInt(maxAge - minAge), Random.nextBoolean(), nbFb > 0 , nbYt >0, nbTwi > 0)

			population += onePeople

			nbFb -= 1
			nbTwi -= 1
			nbYt -= 1

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
    println("Activating people ... size: "+listOfPeople.length)
    for (p <- listOfPeople) {
      println("Activating: "+ p)
      p.run()
    }
  }
}
