class Solution:
    def reverseBits(self, n: int) -> int:
        bits = [0] * 32
        i = 0
        binary = bin(n)
        num = str(binary)
        num = num[2:]
        num = num[::-1]
        num += '0' * (32 - len(num))

        print(num)
        return int(num, 2)
        
        