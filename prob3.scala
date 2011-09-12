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
			sieve(currentMultiple-1) = true
			currentMultiple += i
		}
	}
	sieve
}

def getPrimeFactors(max : Int) = {
	buildSieve(max).zipWithIndex.filter{case(isFactorable,num) => !isFactorable}.map{case(isPrime,num)=>num}
}

def largestPrimeFactor(num : Int) = {
	val largestPossiblePrimeFactor = math.sqrt(num).ceil.toInt + 1
	val primeFactorsToCheck = getPrimeFactors(largestPossiblePrimeFactor)
}

//println(getPrimeFactors(10).toList)

def test_getPrimeFactors {
	val expected10 = List(1, 2, 3, 5, 7)
	val actual10 = getPrimeFactors(10).toList
	assert(actual10 == expected10)
}
test_getPrimeFactors

def test_buildSieve {
	val expected4 = List(false, false, false, true)
  val actual4 = buildSieve(4).toList
	//println(actual4)
	//println(expected4)
	assert(actual4 == expected4)

	val expected10 = List(false, false, false, true, false, true, false, true, true, true)
	val actual10 = buildSieve(10).toList
	//println(actual10)
	//println(expected10)
	assert(actual10 == expected10)
}
//test_buildSieve
