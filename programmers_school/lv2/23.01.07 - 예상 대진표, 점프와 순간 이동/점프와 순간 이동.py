def solution(n):
    # 1 부터 n 까지 모든 수의 방법을 모두 구하면 오래 걸리기 때문에,
    # n, n//2, (n//2)//2, ((n//2)//2)//2, ..., 1 만 구함
    index = []
    idx = n
    while idx>=1:
        index.append(idx)
        idx //= 2
    index = index[::-1]

    # 1 부터 순차적으로 채워나감
    # n이 짝수면 k[n] == k[n//2]
    # n이 홀수면 k[n] == k[n//2] + 1
    k = []
    for i in index:
        if i == 1:
            k.append(1)
        # elif i%2 == 0:
        #     k.append(k[-1])
        elif i%2 == 1:
            k.append(k[-1]+1)
    
    return k[-1]