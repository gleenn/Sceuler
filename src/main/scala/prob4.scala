object Problem4 extends App {
  def isPalindrome(candidatePalindrome: Int): Boolean = {
    var isPalindrome = true
    val string = candidatePalindrome.toString
    val length = string.length
    for (i <- 0 until (length / 2)) {
      if (string(i) != string(length - i - 1)) return false
    }
    isPalindrome
  }

  def maxPalindrome() = {
    var maxPalindrome = 0
    var candidatePalindrome = 0
    for (i <- 100 to 999) {
      for (j <- 100 to 999) {
        candidatePalindrome = i * j
        if (candidatePalindrome > maxPalindrome && isPalindrome(candidatePalindrome))
          maxPalindrome = candidatePalindrome
      }
    }
    maxPalindrome
  }

//  test
  println(maxPalindrome())

  def expect(palindrome: Int, expected: Boolean) {
    val actual = isPalindrome(palindrome)
    if (expected == actual) {
      println(palindrome + " passed")
    } else {
      println(palindrome + " failed")
    }
  }

  def test() {
    expect(0, true)
    expect(1, true)
    expect(44, true)
    expect(404, true)
    expect(4004, true)

    expect(17, false)
    expect(117, false)
  }
}