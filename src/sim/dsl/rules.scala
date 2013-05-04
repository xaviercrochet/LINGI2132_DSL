package sim.dsl

object rules {
	
	def apply(rules: Population => ListBuffer[People]) = new PopulationBuilderRules(rules)

	implicit def int2Scale(i: Int) = Scale(i)

	implicit def 
}