package sim

import scala.collection.mutable.ListBuffer

import sim.models._
import sim.scenario._
import sim.dsl._
import sim.dsl.Preamble._
import sim.dsl.people._

object App {

  def main(args: Array[String]): Unit = {

    // Config
    val nbSub = 3
    val nbPop = 10

    /* POPULATION CONFIGURATION */

    Population is_composed_by 5.thousands_of_people
            
        Students    represent 25.percent
        MiddleAges  represent 50.percent
        Teenagers   represent 25.percent

    /* SOCIAL NETWORK CONFIGURATION */
    /*
    Facebook count (5. percent_of globalPopulation)
    Twitter count (10. percent_of globalPopulation)
    */

    /* TESTING */
    
    println("############")
    println("DSL Population : " + Population.population)
    println("DSL Students : " + Population.students)
    println("DSL MiddleAges : " + Population.middle_ages)
    println("DSL Teenagers : " + Population.teenagers)
    println("############")

    
    // simulate_for 30.days
    

    val model = new SimModel()
    val observer = new Observer()
    Facebook.nbSubscriber = nbSub

    var listOfPeople: ListBuffer[People] = PeopleManager.createPeople(nbPop, nbSub, 7, 77, model, observer)
    println(listOfPeople)

    listOfPeople.foreach { one: People => 
        println(one.name + " is linked to " + one.circle)
    }

    // Scenario
    Scenario1(observer)

    println("--- Nombre inscrit before : " + Facebook.nbSubscriber)
    PeopleManager.activatePeople(listOfPeople)
    model.simulate(2)
    println("--- Nombre inscrit after : " + Facebook.nbSubscriber)
    
  }
}
