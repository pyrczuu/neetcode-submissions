func groupAnagrams(strs []string) [][]string {
	isAnagram := func(a, b string) bool {
		frequencyA := [26]int{}
		frequencyB := [26]int{}

		for _, char := range a {
			frequencyA[char - 97]++
		}
		for _, char := range b {
			frequencyB[char - 97]++
		}    
		if frequencyA == frequencyB {
			return true
		} else {
			return false
		}
	}
	var result [][]string
	taken := make([]bool, len(strs))

	for idx := range strs {
		taken[idx] = false
	}

	for i, str := range strs {
		group := []string{}
		for j := i; j < len(strs); j++ {
			if isAnagram(str, strs[j]) && !taken[j] {
				group = append(group, strs[j])
				taken[j] = true
			}
		}
		if len(group) > 0 {
		result = append(result, group)
		}
	}
	return result
}
