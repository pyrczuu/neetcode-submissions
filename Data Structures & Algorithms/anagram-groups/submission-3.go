import (
	"reflect"
)

func groupAnagrams(strs []string) [][]string {
	isAnagram := func(a, b string) bool {
		aToMap := make(map[rune]int)
		bToMap := make(map[rune]int)
		for _, char := range a {
			aToMap[char]++
		}
		for _, char := range b {
			bToMap[char]++
		}    
		if reflect.DeepEqual(aToMap, bToMap) {
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
