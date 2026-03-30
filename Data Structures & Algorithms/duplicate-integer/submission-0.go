func hasDuplicate(nums []int) bool {
    numbers := make(map[int]int)

    for _, num := range nums {
        numbers[num]++
        if numbers[num] > 1 {
            return true
        }
    }
    return false 
}
