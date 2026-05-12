class MedianFinder:

    def __init__(self):
        self.nums = []

    def addNum(self, num: int) -> None:
        self.nums.append(num)

    def findMedian(self) -> float:
        self.nums.sort()
        length = len(self.nums)

        if length % 2 == 0:
            return (self.nums[length // 2] + self.nums[length // 2 - 1]) / 2
        else:
            return float(self.nums[math.floor(length / 2)])