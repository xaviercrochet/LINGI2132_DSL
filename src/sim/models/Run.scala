package sim.models

import sim._
import sim.scenario._

import scala.collection.mutable.ListBuffer

object Run {
	
	def the_simulation {

		val model = new SimModel()
	    val observer = new Observer()

	    var listOfPeople: ListBuffer[People] = PeopleManager.createPeople(model, observer)
	    println(listOfPeople)

	    listOfPeople.foreach { one: People => 
	        println(one.name + " is linked to " + one.circle)
	    }

	    // Scenario
	    Scenario1(observer)

	    PeopleManager.activatePeople(listOfPeople)
	    model.simulate(200)
	}
}