import (
	"slices"
)

func longestConsecutive(nums []int) int {
	currentLongest := 1
	totalLongest := 0
	sort.Ints(nums)
	nums = slices.Compact(nums)

	if len(nums) < 2 {
		return len(nums)
	}

	for i := 1; i < len(nums); i++ {
		if nums[i] != nums[i-1]+1 {
			currentLongest = 1
		} else {
			currentLongest++
		}
		totalLongest = max(totalLongest, currentLongest)
	}
	return totalLongest
}