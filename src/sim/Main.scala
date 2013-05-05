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
            
        Students    represent 25.percent
        MiddleAges  represent 50.percent
        Teenagers   represent 25.percent


    /* SOCIAL NETWORK CONFIGURATION */
    
    Facebook count 2.people

        Students    love         Facebook
        MiddleAges  dont_care_of Facebook

    Twitter  count 30.people

        MiddleAges  hate         Twitter

    Youtube  count 10.people

        Teenagers   love         Youtube
        Students    love         Youtube

    /* SCENARIOS */



    /* TESTING */
    
    println("############")
    println("DSL Population : " + Population.nbPop)
    println("DSL Students : " + Population.students)
    println("DSL MiddleAges : " + Population.middle_ages)
    println("DSL Teenagers : " + Population.teenagers)
    println("DSL Facebook : " + Facebook.nbSub)
    println("DSL Twitter : " + Twitter.nbSub)
    println("DSL Youtube : " + Youtube.nbSub)
    println("############")
    
    // simulate_for 30.days
    
    // Config
    //val nbSub = 3
    //val nbPop = 10

    val model = new SimModel()
    val observer = new Observer()

    //Facebook.nbSub = nbSub

    var listOfPeople: ListBuffer[People] = PeopleManager.createPeople(model, observer)
    println(listOfPeople)

    listOfPeople.foreach { one: People => 
        println(one.name + " is linked to " + one.circle)
    }

    // Scenario
    Scenario1(observer)

    println("--- Nombre inscrit before : " + Facebook.nbSub)
    PeopleManager.activatePeople(listOfPeople)
    model.simulate(15)
    println("--- Nombre inscrit after : " + Facebook.nbSub)
    
  }
}
