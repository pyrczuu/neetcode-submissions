from math import ceil, floor

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []

        for token in tokens:
            if token in "+-*/":
                b, a = stack.pop(), stack.pop()
                match token:
                    case '+':
                        stack.append(a + b)
                    case '-':
                        stack.append(a - b)
                    case '*':
                        stack.append(a * b)
                    case '/':
                        division = a / b
                        if division < 0:
                            stack.append(ceil(division))
                        else:
                            stack.append(floor(division))
            else:
                stack.append(int(token))


        return stack.pop()