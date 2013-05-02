import scala.collection.mutable.ListBuffer

object App {
  def main(args: Array[String]): Unit = {

    // Config
    val nbSub = 3
    val nbPop = 10

    val model = new SimModel()
    val observer = new Observer()
    observer.nbSubscriber = nbSub

    var listOfPeople: ListBuffer[People] = PeopleManager.createPeople(nbPop, nbSub, model, observer)
    println(listOfPeople)

    listOfPeople.foreach { one: People => 
        println(one.name + " is linked to " + one.circle)
    }

    val facebook = new Facebook(model, observer, listOfPeople)

    println("--- Nombre inscrit before : " + observer.nbSubscriber)
    PeopleManager.activatePeople(listOfPeople)
    model.simulate(20)
    println("--- Nombre inscrit after : " + observer.nbSubscriber)
    
  }
}
