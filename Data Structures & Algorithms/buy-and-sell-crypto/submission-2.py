class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        profit = 0
        buy = prices[0]
        sell = prices[0]

        for price in prices:
            if price > sell:
                sell = price
                profit = max(profit, sell - buy)
            if price < buy:
                buy = price
                sell = price
        return max(profit, sell - buy)
