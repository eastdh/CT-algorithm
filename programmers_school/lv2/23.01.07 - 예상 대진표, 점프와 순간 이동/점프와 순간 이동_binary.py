def solution(n):
    ones = 0
    bi = str(format(n, 'b'))
    for c in bi:
        if c == '1':
            ones += 1
    
    return ones