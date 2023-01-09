def solution(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    
    k = [1, 2]
    for _ in range(2, n+1):
        k.append(k[-2]+k[-1])
    return k[n-1] % 1234567