object prob7 extends App {
  def findNthPrime(num : Int) = {
    def findNthPrime(n : Int, candidate : Int) : Int = {
      if(n == 1 && Math.isPrime(candidate)) return candidate
      var candidate : Int = candidate
      while(!Math.isPrime(candidate)) {
        candidate += 1
      }
      findNthPrime(n-1, candidate+1)
    }
    findNthPrime(num, 1)
  }

//  println(findNthPrime(10001))
  test

  def expectedFindNthPrime(expected : Int, num : Int) {
    val actual: Long = findNthPrime(num)
    if(expected == actual) {
      println("passed findNthPrime(" + num + ")")
    } else {
      println("failed findNthPrime(" + num + ") != " + actual)
    }
  }

  def test() {
    expectedFindNthPrime(1, 1)
    expectedFindNthPrime(2, 2)
    expectedFindNthPrime(3, 3)
    expectedFindNthPrime(5, 4)
    expectedFindNthPrime(7, 5)
    expectedFindNthPrime(11, 6)
    expectedFindNthPrime(13, 7)
    expectedFindNthPrime(17, 8)
    expectedFindNthPrime(19, 9)
    expectedFindNthPrime(23, 10)
    expectedFindNthPrime(29, 11)
    expectedFindNthPrime(31, 12)
    expectedFindNthPrime(1337, 10001)
  }
}