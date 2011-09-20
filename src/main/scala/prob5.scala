object prob5 extends App {

  def smallestNumDivisibleBy(range : Range) : Int = {
    def divides(num : Int, denom : Int) = {
      println(num + " " + denom)
      num % denom == 0
    }
    for(i <- 1 to range.fold(*)) {
      if(range.forall(divides(i,_))) return i
    }
    -1
  }

  println(smallestNumDivisibleBy(1 to 20))
//  test

  def expectedSmallest(expected : Int, divisors : Range) {
    if(expected == smallestNumDivisibleBy(divisors)) {
      println("passed smallestNumDivisibleBy(" + divisors + ")")
    } else {
      println("failed smallestNumDivisibleBy(" + divisors + ")")
    }
  }

  def test() {
    expectedSmallest(2, 1 to 2)
    expectedSmallest(6, 1 to 3)
    expectedSmallest(60, 1 to 5)
  }
}