import java.util.HashMap

object Math extends App {

  def lcm(a: Int, b: Int): Int = {
    (a / gcd(a, b)) * b
  }

  def gcd(a: Int, b: Int): Int = {
    if (b == 0) return a
    gcd(b, a % b)
  }

  def isPrime(calculateNumber: BigInt): Boolean = {
    if (calculateNumber == BigInt(1) || calculateNumber == BigInt(2)) return true
    var candidate = BigInt(2)
    //    while(candidate <= (calculateNumber/2)) {
    while (candidate < calculateNumber) {
      if (calculateNumber % candidate == 0) return false
      candidate += 1
    }
    true
  }

  val isPrimeCache = new HashMap[BigInt, Boolean]
  def isPrimeCached(number: BigInt): Boolean = {
    if (isPrimeCache.containsKey(number))
      return isPrimeCache.get(number)
    val isPrimeCalculated: Boolean = isPrime(number)
    if (isPrimeCalculated)
      isPrimeCache.put(number, isPrimeCalculated)
    isPrimeCalculated
  }
}

/*
  //  testGCD

  def expectedGCD(expected: Int, a: Int, b: Int) {
    if (expected == gcd(a, b)) {
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
*/