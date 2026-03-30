func threeSum(nums []int) [][]int {
	var results [][]int
	sort.Ints(nums)

	length := len(nums)

	for i := 0; i < length; i++ {
		if i > 0 && nums[i-1] == nums[i] {
			continue
		}	
		j := i + 1
		k := length - 1
		for j < k {
			threeSum := nums[i] + nums [j] + nums[k]
			if threeSum > 0 {
				k--
			} else if threeSum < 0 {
				j++
			} else {
				results = append(results, []int{nums[i], nums[j], nums[k]})
				j++
				for nums[j] == nums[j-1] && j < k {
					j++
				}
			}
		}
	}
	return results
}
