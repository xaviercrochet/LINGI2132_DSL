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

    Population is_composed_by 100.people
            
        Students  represent 25.percent
        Adults    represent 50.percent
        Teenagers represent 25.percent


    /* SOCIAL NETWORK CONFIGURATION */
    
    Facebook count 2.people

        Students  hate         Facebook
        Adults    hate         Facebook
        Teenagers hate         Facebook

    Twitter  count 30.people

        Adults    hate         Twitter

    Youtube  count 10.people

        Teenagers love         Youtube
        Students  love         Youtube


    /* SCENARIOS */


    /* LAUNCH THE SIMULATION */

    // simulate_for 30.days

    /* TESTING */
    
    println("############")
    println("DSL Population : " + Population.nbPop)
    println("DSL Students : " + Population.students)
    println("DSL MiddleAges : " + Population.adults)
    println("DSL Teenagers : " + Population.teenagers)
    println("DSL Facebook : " + Facebook.nbSub)
    println("DSL Twitter : " + Twitter.nbSub)
    println("DSL Youtube : " + Youtube.nbSub)
    println("############")
    
    // Config
    val model = new SimModel()
    val observer = new Observer()

    var listOfPeople: ListBuffer[People] = PeopleManager.createPeople(model, observer)
    println(listOfPeople)

    listOfPeople.foreach { one: People => 
        println(one.name + " is linked to " + one.circle)
    }

    // Scenario
    Scenario1(observer)

    println("--- Nombre inscrit before : " + Facebook.nbSub)
    PeopleManager.activatePeople(listOfPeople)
    model.simulate(100)
    println("--- Nombre inscrit after : " + Facebook.nbSub)
    
  }
}
