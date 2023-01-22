from collections import deque
def solution(want, number, discount):
    answer = 0
    goal = dict(zip(want, number))
    shop = {x:0 for x in want}
    que = deque(discount[0:10])
    for s in shop:
        shop[s] = que.count(s)
    if shop == goal:
        answer += 1

    for idx in range(10, len(discount)):
        a = que.popleft()
        b = discount[idx]
        que.append(b)
        if a in shop:
            shop[a] -= 1
        if b in shop:
            shop[b] += 1

        if shop == goal:
            answer += 1
        
    return answer