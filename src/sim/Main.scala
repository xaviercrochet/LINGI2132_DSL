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

    Twitter  count 2.people

        Adults    love         Twitter
        Teenagers love         Twitter
        Students  love         Twitter

    Youtube  count 2.people

        Teenagers love         Youtube
        Students  love         Youtube
        Adults    love         Youtube

    /* SCENARIOS CONFIGURATION */
    Scenario1 ( Teenagers join ( Facebook when_receive 2.invitations ))
    Scenario1 ( Adults    join ( Facebook when_receive 2.invitations ))
    Scenario1 ( Students  join ( Twitter  when_receive 2.invitations ))
    Scenario1 ( Adults    join ( Youtube  when_receive 2.invitations ))
    Scenario1 ( Students  join ( Youtube  when_receive 2.invitations ))
    Scenario1 ( Teenagers leave ( Youtube when_receive 2.subscribers ))
    Scenario1 ( Teenagers leave ( Facebook when_receive 2.messages ))
    Scenario1 (Teenagers leave (Twitter when_receive 2.followers))

    Scenario2 ( Teenagers join  ( Facebook when 5.adults are_on Facebook ))

    // Scenario1 ( Students  leave ( Facebook when_receive_more_than 5.messages ))

    //Scenario2 ( Teenagers leave ( Facebook when 5.adults are_on Facebook )))

    // Scenario3 ( Students switch_from ( Facebook to ( Twitter when 5.friends_switch )))

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
    Run the_simulation_for 30.weeks
    
    println("############")
    println("DSL Population : " + Population.nbPop)
    println("DSL Students : " + Population.students)
    println("DSL Adults : " + Population.adults)
    println("DSL Teenagers : " + Population.teenagers)
    println("DSL Facebook : " + Facebook.nbSub)
    println("DSL Twitter : " + Twitter.nbSub)
    println("DSL Youtube : " + Youtube.nbSub)
    println("############") 
  }
}
