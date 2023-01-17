def solution(prices):
    answer = []
    for p in range(len(prices)):
        for k in range(p+1, len(prices)):
            if prices[k]<prices[p]:
                break            
        answer.append(k-p)
    return answer