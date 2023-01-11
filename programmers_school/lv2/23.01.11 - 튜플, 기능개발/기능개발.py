import math
def solution(progresses, speeds):
    day_left = []
    for i in range(len(progresses)):
        dayleft = int(math.ceil((100-progresses[i])/speeds[i])) # 배포까지 남은 날짜
        day_left.append(dayleft)
    
    answer = []
    maxi = day_left[0]
    vepo = 0
    for l in day_left:
        if maxi < l: # 최고값이 바뀌면 배포할 기능 수를 append
            maxi = l
            answer.append(vepo)
            vepo = 0
        vepo += 1 # 배포할 기능 수 추가
    answer.append(vepo)
    return answer