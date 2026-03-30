func productExceptSelf(nums []int) []int {
	productWhole := 1
	result := make([]int, len(nums))

	for _, num := range nums {
		productWhole *= num
	}

	for i, num := range nums {
		if num == 0 {
			product := 1
			for _, n := range append(nums[:i], nums[i+1:]...) {
				product *= n
			}
			result[i] = product
		} else {
			result[i] = productWhole/num
		}
	}

	return result
}
