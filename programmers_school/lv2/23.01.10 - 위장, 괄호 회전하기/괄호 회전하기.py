def check(s):
    stack = []
    for c in s:
        if c=='(' or c=='{' or c=='[':
            stack.append(c)
        else:
            if len(stack) == 0:
                return False
            elif c==')' and stack.pop()=='(':
                continue
            elif c==']' and stack.pop()=='[':
                continue
            elif c=='}' and stack.pop()=='{':
                continue
            else:
                return False
    if len(stack) != 0:
        return False
    return True


def solution(s):        
    answer = 0
    for x in range(len(s)):
        new_s = s[x:] + s[:x]
        if check(new_s):        
            answer += 1
    return answer