object prob5 extends App {
  def gcd(a : Int, b : Int) : Int = {
      if(b == 0) return a
      gcd(b, a % b)
  }

  def lcm(a : Int, b : Int) : Int = {
    (a / gcd(a, b)) * b
  }

  def leastCommonMultiple(nums : Range) : Int = {
    nums.foldLeft(1)((previousLCM, num) => lcm(previousLCM, num))
  }

  println(leastCommonMultiple(1 to 20))
//  test

  def expectedLCM(expected : Int, nums : Range) {
    val actual: Int = leastCommonMultiple(nums)
    if(expected == actual) {
      println("passed leastCommonMultiple(" + nums + ")")
    } else {
      println("failed leastCommonMultiple(" + nums + ") != " + actual)
    }
  }

  def test() {
    expectedLCM(2, 1 to 2)
    expectedLCM(6, 1 to 3)
    expectedLCM(60, 1 to 5)
    expectedLCM(60, 1 to 6)
    expectedLCM(420, 1 to 7)
  }
}