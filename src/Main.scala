object App {
  def main(args: Array[String]): Unit = {
    val model = new SimModel()
    //val(m1, m2) = (new Machine(model, "m1"), new Machine(model, "m2"))
    //m1.beRunning()
    //m2.beRunning()
    val(p1, p2) = (new People("xavier", model, false), new People("Julien", model, false))
    val population = List(p1, p2)
    val facebook = new Facebook(model, population)
    facebook.idle()
    model.simulate(100)
  }
}
