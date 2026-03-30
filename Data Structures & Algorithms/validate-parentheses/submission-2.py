class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        parenthesis = {
            ')': '(',
            ']': '[',
            '}': '{'
        }

        for c in s:
            if c in parenthesis.values():
                stack.append(c)
            elif len(stack) == 0 or stack.pop() != parenthesis[c]:
                return False

        if stack:
            return False
        else:
            return True
