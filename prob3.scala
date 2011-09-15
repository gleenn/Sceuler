#!/bin/sh
exec scala $0 $@
!#

//import scala.collection.mutable.ArrayBuffer
import java.util.HashMap

val isPrimeCache = new HashMap[BigInt, Boolean]

def isPrime(number : BigInt) : Boolean = {
  def calculateIsPrime(calculateNumber : BigInt) : Boolean = {
    println("calculating prime " + calculateNumber + " " + isPrimeCache)
    if(calculateNumber == BigInt(1) || calculateNumber == BigInt(2)) return true
    var candidate = BigInt(2)
//    while(candidate <= (calculateNumber/2)) {
    while(candidate < calculateNumber) {
      println(calculateNumber + " " + candidate)
      if(calculateNumber % candidate == 0) return false
      candidate += 1
    }
    true
  }
  if(isPrimeCache.containsKey(number)) {
     return isPrimeCache.get(number)
  }
  val isPrime: Boolean = calculateIsPrime(number)
  if(isPrime) {
    isPrimeCache.put(number, isPrime)
//    println("adding " + number + " " + isPrimeCache)
  }
  isPrime
}

def largestPrimeFactor(number : BigInt) : BigInt = {
  def largestPrimeFactor(currentNumber : BigInt, maxFactor : BigInt, currentFactor : BigInt) : BigInt = {
    println("largestPrimeFactor(" + currentNumber + ", " + maxFactor + ", " + currentFactor + ")")
    if(currentFactor > currentNumber) return maxFactor

    val ((div, mod)) = currentNumber /% currentFactor
    if(mod == 0 && isPrime(currentFactor)) {
      println(div)
      largestPrimeFactor(div, currentFactor, currentFactor)
    } else {
      println("didn't divide")
      largestPrimeFactor(currentNumber, maxFactor, currentFactor+1)
    }
  }
  if(isPrime(number)) return BigInt(1)
  largestPrimeFactor(number, BigInt(1), BigInt(2))
}

/*
def largestPrimeFactor3(number : BigInt) : BigInt = {
  var num = number
  if(num == 2 || num == 1) return 1

  var result = ((BigInt(0), BigInt(0)))
  val limit: BigInt = (num / 2) + 1
  var candidate = limit
  var largest: BigInt = BigInt(1)
  while(candidate >= BigInt(2)) {
    result = num /% candidate
//      println("candidate: " + candidate + " result._1: " + result._1 + " result._2 " + result._2)
    println(candidate + " " + num)
    if(result._2 == 0 && isPrime(candidate)) {
//      num = result._1
//      if(isPrime(candidate)) {
        return candidate
//      }
    }
    candidate -= 1
//    candidate += 1
  }
  1
}

def largestPrimeFactor2(number : BigInt) : BigInt = {
  var num = number
  var maxPrimeFactor = BigInt(0)
  val limit: BigInt = (num / 2) + 1
  var candidate = limit
  var result = ((BigInt(0), BigInt(0)))
  while(candidate <= limit) {
    println("attempting to remove " + candidate)
    result = num /% candidate
    if(result._2 == 0 && isPrime(candidate)) {
      maxPrimeFactor = candidate
      println("new maxPrimeFactor = " + maxPrimeFactor)
      num = result._1
      result = num /% candidate
      while(result._2 == 0) {
        println("removing more of " + candidate)
        num = result._1
        result = num /% candidate
      }
    }
    candidate += 1
  }
  maxPrimeFactor
}
*/

//println(largestPrimeFactor2(BigInt(600851475143L)))

def test {
  def assertLargestPrimeFactor(num : BigInt, expected : BigInt) {
    val actualFactor = largestPrimeFactor(num)
    if(actualFactor != expected) {
      val message = "failed for largestPrimeFactor(" + num + ") = " + actualFactor + " != " + expected
      println(message)
      println(isPrimeCache)
//      throw new RuntimeException(message)
//      assert(false)
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
//  	assertLargestPrimeFactor(300, 5)
//  	assertLargestPrimeFactor(333, 11)
  }
  test_largestPrimeFactor
}
test