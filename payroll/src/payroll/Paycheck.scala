package payroll

case class Paycheck(gross: Money, net: Money, deduction: Money) {

  def plusGross(m: Money) 	= Paycheck(gross + m, 	net + m, deduction)
  def plusDeduction(m: Money) = Paycheck(gross, 	net - m, deduction + m)
  
}