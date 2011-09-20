object GCD extends App {
  def gcd(a : Int, b : Int) : Int = {
      if(b == 0) return a
      gcd(b, a % b)
  }

//  testGCD

  def expectedGCD(expected : Int, a : Int, b : Int) {
    if(expected == gcd(a, b)) {
      println("passed gcd(" + a + ", " + b + ")")
    } else {
      println("failed gcd(" + a + ", " + b + ")")
    }
  }

  def testGCD() {
    expectedGCD(1, 1, 1)
    expectedGCD(1, 1, 2)
    expectedGCD(2, 2, 2)
    expectedGCD(1, 3, 2)
    expectedGCD(1, 4, 5)
    expectedGCD(10, 10, 100)
    expectedGCD(5, 35, 40)
    expectedGCD(3, 9, 12)
  }
}