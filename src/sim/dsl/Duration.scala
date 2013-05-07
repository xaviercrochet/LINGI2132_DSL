package sim.dsl

case class Duration(val amount: Int) {

	def weeks = amount

	def months = amount * 31

	def years = amount * 365

}