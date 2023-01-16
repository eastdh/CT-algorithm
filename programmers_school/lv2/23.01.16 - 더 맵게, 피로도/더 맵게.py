import heapq
def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while len(scoville) >= 2:
        min_1 = heapq.heappop(scoville)
        min_2 = 2*heapq.heappop(scoville)
        if min_1 >= K:
            return answer
        
        answer += 1
        new_food = min_1 + min_2
        heapq.heappush(scoville, new_food)
    if scoville[0] >= K:
        return answer
    else:
        return -1