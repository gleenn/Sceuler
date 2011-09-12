#!/bin/sh
exec scala $0 $@
!#

import scala.collection.mutable.ArrayBuffer

def largestPossiblePrimeFactor(num : Long) : Long = {
  math.sqrt(num).ceil.toLong + 1
}

def largestPrimeFactor(num : Long) : Long = {

}

println(largestPrimeFactor(600851475143L))


def test {
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


}
test