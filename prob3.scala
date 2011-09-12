#!/bin/sh
exec scala $0 $@
!#

//import scala.collection.mutable.ArrayBuffer
import java.util.HashMap

val isPrimeCache = new HashMap[BigInt, Boolean]

def calculateIsPrime(num : BigInt) : Boolean = {
  println("calculating prime")
  var candidate = BigInt(2)
  while(candidate <= (num/2)) {
    if(num % candidate == 0) return false
    candidate += 1
  }
  true
}

def isPrime(num : BigInt) = {
  if(isPrimeCache.containsKey(num)) isPrimeCache.get(num)
  isPrimeCache.put(num, calculateIsPrime(num))
}

def largestPrimeFactor(number : BigInt) : BigInt = {
  var num = number
  if(num == 2 || num == 1) return 1

  var result = ((BigInt(0), BigInt(0)))
  val limit: BigInt = (num / 2) + 1
  var candidate = limit
  var largest: BigInt = BigInt(0)
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

println(largestPrimeFactor2(BigInt(600851475143L)))


def test {
  def assertLargestPrimeFactor(num : BigInt, expected : BigInt) {
    val actualFactor = largestPrimeFactor(num)
    if(actualFactor != expected) {
      println("largestPrimeFactor(" + num + ") = " + actualFactor + " != " + expected)
      println(isPrimeCache)
      assert(false)
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
  }
  test_largestPrimeFactor


}
test