import scala.collection.mutable.ListBuffer

object App {
  def main(args: Array[String]): Unit = {
    val model = new SimModel()
    //val(m1, m2) = (new Machine(model, "m1"), new Machine(model, "m2"))
    //m1.beRunning()
    //m2.beRunning()
    /*val(p1, p2, p3, p4) = (new People("xavier", model, false), new People("Julien", model, false), new People("Clément", model, false), new People("Adrian", model, false))
    val population = List(p1, p2, p3, p4)
    val facebook = new Facebook(model, population)
    facebook.idle()
    model.simulate(100)*/
    scenario_1(model)

    println("------")

    var listOfPeople: ListBuffer[People] = PeopleManager.createPeople(4, model)
    println(listOfPeople)
  }

  def scenario_1(model: SimModel)
  {
    val(p1, p2, p3, p4) = (new People("xavier", model, false), new People("Julien", model, false), new People("Clément", model, false), new People("Adrian", model, false))
    val population = List(p1, p2, p3, p4)
    val facebook = new Facebook(model, population)
    p1.joinFacebook()
    p2.joinFacebook()
    p3.joinFacebook()
    p4.joinFacebook()
    p1.facebookProfile.askFriend(p2.facebookProfile)
    p2.facebookProfile.refuseFriend(p1.facebookProfile)
    p2.facebookProfile.askFriend(p3.facebookProfile)
    p3.facebookProfile.acceptFriend(p2.facebookProfile)
    p3.facebookProfile.askFriend(p1.facebookProfile)
    p1.facebookProfile.acceptFriend(p3.facebookProfile)
    model.simulate(100)
  }
}
