package sim
import scala.collection.mutable.ListBuffer
import sim.models._
import sim.scenario._

object App {
  def main(args: Array[String]): Unit = {

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
    model.simulate(30)
    println("--- Nombre inscrit after : " + Facebook.nbSubscriber)
    
  }
}
