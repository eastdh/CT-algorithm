def solution(s):
    stk = []
    for c in s:
        if c == "(":
            stk.append(1)
        elif c == ")":
            if len(stk) == 0:
                return False
            else:
                stk.pop()
    if len(stk) == 0:
        return True
    else:
        return False