class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        lista = []
        for row in matrix:
            lista += row

        l = 0
        r = len(lista)-1

        while l <= r:
            mid = l + (r - l) // 2
            if lista[mid] == target:
                return True
            if target > lista[mid]:
                l = mid + 1
            else:
                r = mid - 1

        return False