object prob6 extends App {
  def diffSumSquaresAndSquareSums(num : Int) : Long = {
    val sum : Long = num*(num+1L)/2
    val squareOfSums : Long = sum*sum

    val sumOfSquares : Long = (1 to num).map((i)=>i*i).sum

    squareOfSums - sumOfSquares
  }

  println(diffSumSquaresAndSquareSums(100))
  test

  def expectedDiffSumSquaresAndSquareOfSums(expected : Int, num : Int) {
    val actual: Long = diffSumSquaresAndSquareSums(num)
    if(expected == actual) {
      println("passed diffSumSquaresAndSquareSums(" + num + ")")
    } else {
      println("failed diffSumSquaresAndSquareSums(" + num + ") != " + actual)
    }
  }

  def test() {
    expectedDiffSumSquaresAndSquareOfSums(9-5, 2)
    expectedDiffSumSquaresAndSquareOfSums(36-14, 3)
    expectedDiffSumSquaresAndSquareOfSums(100-30, 4)
    expectedDiffSumSquaresAndSquareOfSums(3025-385, 10)
    expectedDiffSumSquaresAndSquareOfSums(25164150, 100)
  }
}