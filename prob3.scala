#!/bin/sh
exec scala $0 $@
!#

//def go(i : Int, f : Int => Unit) = { for( j <-0.until(i)) { f(j) } }

def findPrimesUnder(num : Int) = {
	var checkLimit = math.sqrt(num)
	
}

println(findPrimesUnder(4))
