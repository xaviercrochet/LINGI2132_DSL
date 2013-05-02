// Classes test
class BigClass() {
	def incVal: Int = 5
}

class SmallClass extends BigClass {
	println(super.incVal)
}