class Machine(val m: SimModel, val n: String) {
	def beRunning() {
	  println(n + " beRunning !")
	  m.wait(20.0) {
		  beBroken()
	  }
	}
	
	def beBroken() {
	  println(n + " beBroken !")
	  m.wait(20.0) {
		  beRunning()
	  }
	}
}