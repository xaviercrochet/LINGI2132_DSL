package sim
import scala.collection.mutable.ListBuffer
import sim.models._
import sim.scenario._

object App {
  def main(args: Array[String]): Unit = {

    // Config
    val nbSub = 3
    val nbPop = 10

    /*
    val globalPopulation = rules { population =>

        population composed_by 5.millions with_profile { individual =>
            
            students    represent (25. percent_of individual)
            middle_ages represent (50. percent_of individual)
            teenagers   represent (25. percent_of individual)
        }
    }
    */

    /*
    //val globalPopulation = rules { population =>
        
        Population is_composed_by (25.millions student)
        Population is_composed_by (30.millions middle_age)
        Population is_composed_by (10.millions teenager)

    //}

    Facebook count (5. percent_of globalPopulation)
    Twitter coun (10. percent_of globalPopulation)

    simulate_for 30.days
    */

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
    model.simulate(30)
    println("--- Nombre inscrit after : " + Facebook.nbSubscriber)
    
  }
}
