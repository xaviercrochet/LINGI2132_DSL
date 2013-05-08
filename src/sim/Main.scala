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
    Population is_composed_by 50.people
            
        Students  represent 25.percent
        Adults    represent 50.percent
        Teenagers represent 25.percent


    /* SOCIAL NETWORK CONFIGURATION */
    Facebook count 2.people

        Students  love         Facebook
        Adults    dont_care_of Facebook
        Teenagers love         Facebook

    Twitter  count 4.people

        Adults    love         Twitter
        Teenagers love         Twitter
        Students  love         Twitter

    Youtube  count 2.people

        Teenagers love         Youtube
        Students  love         Youtube
        Adults    love         Youtube


    /* SCENARIOS CONFIGURATION */
    Scenario1 ( Teenagers join  ( Twitter  when_receive   2.invitations ))
    Scenario1 ( Adults    join  ( Facebook when_receive   2.invitations ))
    Scenario1 ( Adults    join  ( Youtube  when_receive   2.invitations ))
    Scenario1 ( Teenagers leave ( Youtube  when_more_than 4.subscribers ))
    Scenario1 ( Teenagers leave ( Twitter  when_more_than 3.followers   ))

    Scenario2 ( Teenagers leave  ( Twitter when 5.adults are_on Youtube ))
    
    /* RUN THE SIMULATION ! */
    Run the_simulation_for 50.weeks
    
    Show chart
  }
}
