func trap(height []int) int {
	total := 0

	prefix := make(map[int]int)
	suffix := make(map[int]int)

	for i := 1; i < len(height); i++ {
		prefix[i] = max(prefix[i-1], height[i-1])
	}

	for j := len(height) - 2; j >= 0; j-- {
		suffix[j] = max(suffix[j+1], height[j+1])
	} 

	for i, val := range height {
		water := min(prefix[i], suffix[i]) - val
		if water > 0 {
			total += water
		}
	}
	
	return total
}
