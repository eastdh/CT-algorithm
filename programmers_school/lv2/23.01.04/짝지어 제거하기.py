def solution(s):
    if len(s)%2 != 0:
        return 0
    
    stack = []
    
    for c in s:
        if len(stack) == 0 or stack[-1] != c:
            stack.append(c)
        else:
            stack.pop()
    
    if len(stack) == 0:
        return 1
    else:
        return 0