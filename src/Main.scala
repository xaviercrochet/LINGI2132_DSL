object App {
  def main(args: Array[String]): Unit = {
    val model = new SimModel()
    val(m1, m2) = (new Machine(model, "m1"), new Machine(model, "m2"))
    m1.beRunning()
    m2.beRunning()
    model.simulate(100)
  }
}