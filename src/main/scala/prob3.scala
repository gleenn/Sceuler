// use map
import java.util.HashMap

object Problem3 {

	val isPrimeCache = new HashMap[BigInt, Boolean]

	def isPrime(number : BigInt) : Boolean = {
		def calculateIsPrime(calculateNumber : BigInt) : Boolean = {
			if(calculateNumber == BigInt(1) || calculateNumber == BigInt(2)) return true
			var candidate = BigInt(2)
	//    while(candidate <= (calculateNumber/2)) {
			while(candidate < calculateNumber) {
				if(calculateNumber % candidate == 0) return false
				candidate += 1
			}
			true
		}
		if(isPrimeCache.containsKey(number))
			return isPrimeCache.get(number)
		val isPrime: Boolean = calculateIsPrime(number)
		if(isPrime)
			isPrimeCache.put(number, isPrime)
		isPrime
	}

	def largestPrimeFactor(number : BigInt) : BigInt = {
		def largestPrimeFactor(currentNumber : BigInt, maxFactor : BigInt, currentFactor : BigInt) : BigInt = {
			if(currentFactor > currentNumber) return maxFactor
			val ((div, mod)) = currentNumber /% currentFactor
			if(mod == 0 && isPrime(currentFactor))
				largestPrimeFactor(div, currentFactor, currentFactor)
			else
				largestPrimeFactor(currentNumber, maxFactor, currentFactor+1)
		}
		if(isPrime(number)) return BigInt(1)
		largestPrimeFactor(number, BigInt(1), BigInt(2))
	}

	println(largestPrimeFactor(BigInt(600851475143L)))

	def test {
		def assertLargestPrimeFactor(num : BigInt, expected : BigInt) {
			val actualFactor = largestPrimeFactor(num)
			if(actualFactor != expected) {
				println("failed for largestPrimeFactor(" + num + ") = " + actualFactor + " != " + expected)
			} else {
				println("passed for largestPrimeFactor(" + num + ")")
			}
		}

		def test_largestPrimeFactor {
			assertLargestPrimeFactor(1, 1)
			assertLargestPrimeFactor(2, 1)
			assertLargestPrimeFactor(3, 1)
			assertLargestPrimeFactor(4, 2)
			assertLargestPrimeFactor(5, 1)
			assertLargestPrimeFactor(6, 3)
			assertLargestPrimeFactor(7, 1)
			assertLargestPrimeFactor(8, 2)
			assertLargestPrimeFactor(9, 3)
			assertLargestPrimeFactor(10, 5)
			assertLargestPrimeFactor(100, 5)
			assertLargestPrimeFactor(300, 5)
			assertLargestPrimeFactor(333, 37)
		}
		test_largestPrimeFactor
	}
	//test
}
