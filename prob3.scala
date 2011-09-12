#!/bin/sh
exec scala $0 $@
!#

import scala.collection.mutable.ArrayBuffer

//def go(i : Int, f : Int => Unit) = { for( j <-0.until(i)) { f(j) } }

def buildSieve(max : Int) = {
	val sieve = new Array[Boolean](max)
	for(i : Int <- 2.until(max)) {
		var currentMultiple = i + i
		while(currentMultiple <= max){
			sieve(currentMultiple - 1) = true
			currentMultiple += i
		}
	}
	sieve
}

def getPrimeFactors(max : Int) = {
	buildSieve(max).zipWithIndex.filter{case(isFactorable,num) => !isFactorable}.map{case(isPrime,num)=>num+1}
}

def largestPossiblePrimeFactor(num : Int) : Int = {
//  val result = math.sqrt(num).ceil.toInt + 1
//  if(num % result == 0) return result + 1
//  result
  math.sqrt(num).ceil.toInt + 1
}

def largestPrimeFactor(num : Int) : Int = {
  if(num == 1) return 1

	val primeFactorsToCheck = getPrimeFactors(largestPossiblePrimeFactor(num))
//  println("largestPrimeFactorToCheck("+num+") = " + largestPossiblePrimeFactor(num) + " " + primeFactorsToCheck.toList)
	for(possiblePrimeFactor : Int <- primeFactorsToCheck.reverse) {
//    println("checking " + possiblePrimeFactor)
		if(num % possiblePrimeFactor == 0 && num != possiblePrimeFactor)
        return possiblePrimeFactor
	}
	-1
}

//println(getPrimeFactors(10).toList)

def assertLargestPrimeFactor(num : Int, expected : Int) {
  val actualFactor: Int = largestPrimeFactor(num)
  if(actualFactor != expected) {
//    println("largestPrimeFactor(" + num + ") = " + actualFactor + " != " + expected)
    assert(false)
  }
}

def test_largestPrimeFactor {
//	assertLargestPrimeFactor(1, 1)
//	assertLargestPrimeFactor(2, 1)
//	assertLargestPrimeFactor(3, 1)
//	assertLargestPrimeFactor(4, 2)
//	assertLargestPrimeFactor(5, 1)
//	assertLargestPrimeFactor(6, 3)
//	assertLargestPrimeFactor(7, 1)
//	assertLargestPrimeFactor(8, 2)
//	assertLargestPrimeFactor(9, 3)
	assertLargestPrimeFactor(10, 5)
//	assertLargestPrimeFactor(100, 5)
}
test_largestPrimeFactor

def test_largestPossiblePrimeFactor {
  
}
test_largestPossiblePrimeFactor

def test_getPrimeFactors {
	val expected10 = List(1, 2, 3, 5, 7)
	val actual10 = getPrimeFactors(10).toList
//	println(actual10.zip(expected10))
	assert(actual10 == expected10)
}
test_getPrimeFactors

def test_buildSieve {
  assert(buildSieve(1).toList == List(false))
  assert(buildSieve(2).toList == List(false, false))

	val expected4 = List(false, false, false, true)
  val actual4 = buildSieve(4).toList
	//println(actual4)
	//println(expected4)
	assert(actual4 == expected4)

	val expected10 = List(false, false, false, true, false, true, false, true, true, true)
	val actual10 = buildSieve(10).toList
//	println(actual10)
	//println(expected10)
	assert(actual10 == expected10)
}
test_buildSieve
