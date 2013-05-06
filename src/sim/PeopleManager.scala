package sim

import sim.models._
import sim.dsl._
import sim.dsl.people._

import scala.util.Random
import scala.collection.mutable.ListBuffer

object PeopleManager {

	def createPeople(m: SimModel, o: Observer): ListBuffer[People] = {

		var population = new ListBuffer[People]()

		var nbFb = Facebook.nbSub
		var nbTwi = Twitter.nbSub
		var nbYt = Youtube.nbSub

		var teen = Population.teenagers
		var ma = Population.adults
		var st = Population.students

		val minAge = 7
		val maxAge = 77

		val nbPop = Population.nbPop.toInt

		// People creation
		for(i <- 0 until nbPop) {

			val age = minAge + Random.nextInt(maxAge - minAge)
			val sex = Random.nextBoolean()

			val fb = nbFb > 0
			val yt = nbYt > 0
			val twi = nbTwi > 0

			if(teen > 0) {
				val onePeople = new People("MyName"+i, o, m, age, sex, fb , yt, twi, Teenagers)
				population += onePeople
			}
			else if(ma > 0) {
				val onePeople = new People("MyName"+i, o, m, age, sex, fb, yt, twi, Adults)	
				population += onePeople
			}
			else if(st > 0) {
				val onePeople = new People("MyName"+i, o, m, age, sex, fb, yt, twi, Students)
				population += onePeople
			}

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
    //println("Activating people ... size: "+listOfPeople.length)
    for (p <- listOfPeople) {
      //println("Activating: "+ p)
      p.run()
    }
  }
}
