# 더 맵게
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42626)    

### 사용한 개념
- 힙 자료구조에 대해서 배운 적 있지만 활용하지 않고 있었는데, 힙에 대해 다시 공부해볼 수 있는 기회였다.
- 힙 구조는 이 문제와 같이 정렬된 상태의 리스트에 요소를 삽입할 때마다 원하는 위치에 삽입해야 하는 문제일 때 활용할 수 있을 것이다.
- 여담으로, 리스트로 풀기 위해서 여러 시도를 해보았는데 실패했다. 런타임 에러가 뜨거나 시간초과가 계속 일어나 그냥 힙 자료구조 검색해서 풀었다.

### 코드
```py
import heapq
def solution(scoville, K):
    heapq.heapify(scoville) # heap 구조로 리스트 초기화
    
    answer = 0
    while len(scoville) >= 2: # heappop을 두 번 해줘도 문제가 생기지 않는 길이까지만 시행
        min_1 = heapq.heappop(scoville)
        min_2 = heapq.heappop(scoville)
        if min_1 >= K: # 가장 작은 음식이 K 이상이라면 문제 조건 달성 ==> 탈출
            return answer
        
        answer += 1
        new_food = min_1 + 2*min_2
        heapq.heappush(scoville, new_food)
    
    if scoville[0] >= K:
        return answer
    else:
        return -1
```
---
       
# 피로도
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87946)

### 사용한 개념
- 던전의 개수가 최대 8개 밖에 안되기 때문에, 모든 던전 방문 루트를 dfs로 따질 수 있다.

### 코드
```py
def dfs(k, dungeons, depth, visited):
    global answer
    answer = max(answer, depth)
    for idx in range(len(dungeons)):
        a, b = dungeons[idx]
        if not visited[idx] and k >= a and k >= b:
            visited[idx] = True
            dfs(k-b, dungeons, depth+1, visited)
            visited[idx] = False
        
def solution(k, dungeons):
    global answer
    answer = -1
    visited = [False] * len(dungeons)
    dfs(k, dungeons, 0, visited)
    return answer
```