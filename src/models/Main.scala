import scala.collection.mutable.ListBuffer

object App {
  def main(args: Array[String]): Unit = {

    // Config
    val nbSub = 3
    val nbPop = 10

    val model = new SimModel()
    val observer = new Observer()
    //observer.nbSubscriber = nbSub
    Facebook.nbSubscriber = nbSub

    var listOfPeople: ListBuffer[People] = PeopleManager.createPeople(nbPop, nbSub, 7, 77, model, observer)
    println(listOfPeople)

    listOfPeople.foreach { one: People => 
        println(one.name + " is linked to " + one.circle)
    }

    //val facebook = new Facebook(model, observer, listOfPeople)

    // Scenario
    Scenario1(observer)

    println("--- Nombre inscrit before : " + Facebook.nbSubscriber)
    PeopleManager.activatePeople(listOfPeople)
    model.simulate(2)
    println("--- Nombre inscrit after : " + Facebook.nbSubscriber)
    
  }
}
