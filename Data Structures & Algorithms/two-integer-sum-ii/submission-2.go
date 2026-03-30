func twoSum(numbers []int, target int) []int {
	for i, val := range numbers {
		for j, v := range numbers[i+1:] {
			if v == (target - val) {
				return []int{i + 1, i + j + 2}
			}
		}
	}
	return []int{0,0}
}
