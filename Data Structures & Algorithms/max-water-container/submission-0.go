func maxArea(heights []int) int {
	l := 0
	r := len(heights) - 1
	mostWater := 0

	for l < r {
		currentWater := min(heights[l], heights[r]) * (r - l) 
		if heights[l] < heights[r] {
			l++
		} else {
			r--
		}
		mostWater = max(mostWater, currentWater)
	}
	return mostWater
}
