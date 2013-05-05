package sim

import scala.collection.mutable.ListBuffer

import sim.models._
import sim.scenario._
import sim.dsl._
import sim.dsl.Preamble._
import sim.dsl.people._

object App {

  def main(args: Array[String]): Unit = {

    /////////////////////////////////////
    //            THE DSL              //
    /////////////////////////////////////

    /* POPULATION CONFIGURATION */

    Population is_composed_by 5.thousands_of_people
            
        Students    represent 25.percent
        MiddleAges  represent 50.percent
        Teenagers   represent 25.percent

    /* SOCIAL NETWORK CONFIGURATION */
    
    Facebook count (2.thousands_of_people)
    Twitter count (10.thousands_of_people)
    Youtube count (5.thousands_of_people)

    /* TESTING */
    
    println("############")
    println("DSL Population : " + Population.population)
    println("DSL Students : " + Population.students)
    println("DSL MiddleAges : " + Population.middle_ages)
    println("DSL Teenagers : " + Population.teenagers)
    println("DSL Facebook : " + Facebook.nbSubscriber)
    println("DSL Twitter : " + Twitter.nbSubscriber)
    println("DSL Youtube : " + Youtube.nbSubscriber)
    println("############")
    
    // simulate_for 30.days
    
    // Config
    val nbSub = 3
    val nbPop = 10

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
