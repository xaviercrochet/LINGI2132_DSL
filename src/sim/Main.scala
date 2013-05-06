package sim

import sim.models._
import sim.dsl._
import sim.dsl.Preamble._
import sim.dsl.people._
import sim.scenario._

object App {

  def main(args: Array[String]): Unit = {

    /////////////////////////////////////
    //            THE DSL              //
    /////////////////////////////////////

    /* POPULATION CONFIGURATION */
    Population is_composed_by 20.people
            
        Students  represent 25.percent
        Adults    represent 50.percent
        Teenagers represent 25.percent


    /* SOCIAL NETWORK CONFIGURATION */
    Facebook count 2.people

        Students  love         Facebook
        Adults    dont_care_of Facebook
        Teenagers love         Facebook

    Twitter  count 10.people

        Adults    hate         Twitter
        Teenagers love         Twitter

    Youtube  count 10.people

        Teenagers hate         Youtube
        Students  hate         Youtube

    /* TESTING */
    println("############")
    println("DSL Population : " + Population.nbPop)
    println("DSL Students : " + Population.students)
    println("DSL Adults : " + Population.adults)
    println("DSL Teenagers : " + Population.teenagers)
    println("DSL Facebook : " + Facebook.nbSub)
    println("DSL Twitter : " + Twitter.nbSub)
    println("DSL Youtube : " + Youtube.nbSub)
    println("############")
    
    /* RUN THE SIMULATION ! */
    Run the_simulation
    
    println("############")
    println("DSL Population : " + Population.nbPop)
    println("DSL Students : " + Population.students)
    println("DSL Adults : " + Population.adults)
    println("DSL Teenagers : " + Population.teenagers)
    println("DSL Facebook : " + Facebook.nbSub)
    println("DSL Twitter : " + Twitter.nbSub)
    println("DSL Youtube : " + Youtube.nbSub)
    println("############")  

    /* SCENARIOS CONFIGURATION */
    
    Scenario1 students_join(Facebook when_receive 3.invitations)
    //Scenario2 adults_join Twitter when_count 10.people
    
  }
}
