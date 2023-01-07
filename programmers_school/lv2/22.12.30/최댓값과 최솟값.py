def solution(s):
    num = list(map(int, s.split()))
    mini = min(num)
    maxi = max(num)
    
#   answer = " ".join(map(str, [mini, maxi]))
    answer = str(mini) + " " + str(maxi)
    return answer