#!/bin/sh
exec scala $0 $@
!#

import scala.collection.mutable.ArrayBuffer

//def go(i : Int, f : Int => Unit) = { for( j <-0.until(i)) { f(j) } }

def findPrimesUpto(num : Int) = {
	val checkLimit = math.sqrt(num).ceil.toInt + 1
	val sieve = new Array[Boolean](checkLimit)
	for(i : Int <- 2.until(checkLimit)) {
		var currentMultiple = i + i
		while(currentMultiple < checkLimit){ 
			sieve(currentMultiple) = true
			currentMultiple += i
		}
	}
	sieve
}

val expected20 = Array(false, false, false, false, true)
assert(findPrimesUpto(20) == expected20)

val expected100 = Array(false, false, false, false, true, false, true, false, true, true, true)
assert(findPrimesUpto(100) == expected100)
println(expected100)
println(findPrimesUpto(100))
