def solution(n):
    fibo = [0, 1]
    for idx in range(2, n+1):
        nxt = fibo[idx-2] + fibo[idx-1]
        fibo.append(nxt)
        
    answer = fibo[-1] % 1234567
    return answer