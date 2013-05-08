package sim

import sim.models._

//import scala.collection.mutable.ListBuffer
import scala.collection.immutable.TreeMap
import scala.collection.immutable.Map

object Stats {
	
	var records: TreeMap[Double, List[Double]] = TreeMap()

	def record(t: Double) {

		records += (t -> List(Facebook.nbSub, Twitter.nbSub, Youtube.nbSub))
	}

	def show {

		records.foreach { record =>

			println(record)
		}
	}
}