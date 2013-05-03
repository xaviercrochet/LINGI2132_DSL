package sim.dsl

case class Scale(val amount: Int) {
	
	def thousands = amount * 1000

	def millions = amount * 1000000

}