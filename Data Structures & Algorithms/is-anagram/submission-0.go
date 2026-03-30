import(
    "reflect"
)

func isAnagram(s string, t string) bool {
    sToMap := make(map[rune]int)
    tToMap := make(map[rune]int)
    for _, char := range s {
        sToMap[char]++
    }
    for _, char := range t {
        tToMap[char]++
    }    
    if reflect.DeepEqual(sToMap, tToMap) {
        return true
    } else {
        return false
    }
}
