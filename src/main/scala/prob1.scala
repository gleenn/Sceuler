object Problem1 extends App {
	println((0 until 1000).foldLeft(0) {(sum, i) => sum + (if(i % 3 == 0 || i % 5 == 0) i else 0) })
}
