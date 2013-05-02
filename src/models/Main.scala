import scala.collection.mutable.ListBuffer

object App {
  def main(args: Array[String]): Unit = {
    val model = new SimModel()
    val observer = new Observer()
    var listOfPeople: ListBuffer[People] = PeopleManager.createPeople(10, model, observer)
    println(listOfPeople)

    listOfPeople.foreach { one: People => 
        println(one.name + " is linked to " + one.circle)
    }
    val facebook = new Facebook(model, observer, listOfPeople)
    PeopleManager.activatePeople(listOfPeople)
    
  }
}
