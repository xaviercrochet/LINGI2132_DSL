package sim.dsl

object Population {

	var nbPop = 0.

	var students = 0.
	var adults = 0.
	var teenagers = 0.

	def is_composed_by(nb: Double) {

		nbPop += nb

	}
}