def solution(k, tangerine):
    tan = dict()
    for t in tangerine:
        if t in tan:
            tan[t] += 1
        else:
            tan[t] = 1
    tan = sorted(tan.values(), reverse = True)
    #print(tan)
    
    answer = 0
    temp = 0
    while temp < k:
        temp += tan[answer]
        answer += 1
        
        
    return answer