func topKFrequent(nums []int, k int) []int {
	keys := make([]int, 0, len(nums))
	frequency := make(map[int]int)

	for _, num := range nums {
		frequency[num]++
	}

	for key := range frequency {
		keys = append(keys, key)
	}

	sort.Slice(keys, func(i, j int) bool { return frequency[keys[i]] > frequency[keys[j]] })

	return keys[:k]
}