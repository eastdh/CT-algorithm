def solution(n):
    # 연속한 자연수의 개수가 2일 때 그 이상의 시행은 의미가 없다.
    # 위 경우는 무조건 n//2 + (n//2)+1 의 경우이다.
    # 따라서 L은 n//2까지만 탐색한다.
    answer = 0
    for L in range(1, n//2+1):
        for R in range(L+1, n+2):
            if sum(range(L,R)) == n:
                #print(range(L,R))
                answer += 1
            elif sum(range(L,R)) > n:
                break
    return answer+1