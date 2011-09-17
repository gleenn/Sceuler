object Problem2 {

	var sum = 0
	var prev = 0
	var cur = 1
	var temp = 0

	while(cur < 4000000) {
		temp = cur
		cur = prev + cur
		prev = temp

		if(cur % 2 == 0)
			sum += cur
	}

	println(sum)
}
