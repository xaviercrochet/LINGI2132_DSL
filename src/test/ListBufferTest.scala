// ListBuffer Test

import scala.collection.mutable.ListBuffer

object ListBufferClass {
	
	def ListBufferTest(inc: Int): ListBuffer[Int] = {

		var ListBufferVar = new ListBuffer[Int]()

		for(i <- 0 until inc) {
			ListBufferVar += i
		}

		ListBufferVar
	}
}

object Main {

	def main(args: Array[String]): Unit = {

		var ListBufferResult: ListBuffer[Int] = ListBufferClass.ListBufferTest(5)
		println(ListBufferResult)
	}

}