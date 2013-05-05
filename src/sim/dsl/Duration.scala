package sim.dsl

case class Duration(val amount: Double) {

	def weeks = amount * 7

	def months = amount * 31

	def years = amount * 365

}