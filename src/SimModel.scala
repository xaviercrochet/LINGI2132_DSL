import scala.collection.mutable.PriorityQueue

class SimModel {
	private val eventQueue = new PriorityQueue[SimEvent]()
	private var currentTime = 0.0
	
	def clock = currentTime
	
	def simulate(horizon: Int) {
	  while(eventQueue.nonEmpty) {
	    val e = eventQueue.dequeue()
	    currentTime = e.time
	    
	    if(currentTime <= horizon) {
	      println("Time : " + currentTime)
	      e.process()
	    }
	    else {
	      currentTime = horizon
	      return
	    }
	  }
	}
	
	def wait(duration: Double)(block : => Unit) {
	  eventQueue += new SimEvent(clock + duration, block)
	}
}