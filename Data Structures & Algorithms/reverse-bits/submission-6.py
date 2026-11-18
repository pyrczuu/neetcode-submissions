class Solution:
    def reverseBits(self, n: int) -> int:
        binary = bin(n)
        num = str(binary)
        num = num[2:]
        num = num[::-1]
        num += '0' * (32 - len(num))

        return int(num, 2)
        
        