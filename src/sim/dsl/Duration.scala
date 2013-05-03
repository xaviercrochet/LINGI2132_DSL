package sim.dsl

case class Duration(val amount: Int) {

	def weeks = amount * 7

	def months = amount * 31

	def years = amount * 365

}