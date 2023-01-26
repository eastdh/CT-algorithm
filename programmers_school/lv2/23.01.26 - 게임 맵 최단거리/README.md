# 게임 맵 최단거리
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/1844)    

### 사용한 개념
- 이 문제는 DFS, BFS 둘 다 사용하여 구현할 수 있는 문제이다.
- DFS로 풀어도 답은 나오는데, 효율성이 낮게 나온다.
  - DFS는 모든 분기점에서 더 이상 움직이지 못할 때까지 이동해보고 다시 분기점으로 돌아오기 때문이다.
- 하지만, 문제 조건을 살펴보면 n, m은 100 이하의 자연수이므로, DFS로 풀면 안된다.
  - 최악의 입력으로 100x100의 장애물 없는 맵을 생각해 볼 수 있다. 
    - 이 경우 모든 칸을 방문했다가 분기점으로 돌아오는 동작을 수 없이 많이 수행해야 한다.
    - 재귀를 이용해 문제를 풀었다면, 재귀 깊이는 별도의 설정 없이는 1,000인데 이 경우엔 가장 깊은 재귀는 10,000회이다.
- 따라서 BFS로 문제를 풀어야한다. DFS 코드를 주석을 통해 대강 살펴보고 넘어가자.
### 코드 (DFS 사용, 재귀 제한 및 실행 시간 초과)
```py
def can_go(x, y, n, m): # 가고자 하는 다음 칸이 맵을 넘어가지 않는지 확인
    return x>=0 and y>=0 and x<n and y<m

def dfs(x, y, step, visited, maps):
    global answer
    n, m = len(maps), len(maps[0])
    if x == n-1 and y == m-1:
        answer = min(answer, step)
        return
        
    #     R, D, L, U
    dx = [0, 1, 0, -1] # horizonal move
    dy = [1, 0, -1, 0] # vertical move
    
    for d in range(4):
        new_x = x + dx[d]
        new_y = y + dy[d]
        if can_go(new_x, new_y, n, m) and maps[new_x][new_y] == 1 and not visited[new_x][new_y]:
            visited[new_x][new_y] = True
            dfs(new_x, new_y, step+1, visited, maps)
            visited[new_x][new_y] = False
    
def solution(maps):
    n, m = len(maps), len(maps[0])
    global answer
    answer = n*m+10
    visited = [[False for _ in range(m)] for _ in range(n)]
    dfs(0, 0, 1, visited, maps)
    if answer == n*m+10:
        answer = -1
    return answer
```
        
실행 결과
```
채점을 시작합니다.
정확성  테스트
테스트 1 〉	통과 (0.11ms, 10.3MB)
테스트 2 〉	통과 (0.04ms, 10.2MB)
테스트 3 〉	통과 (0.12ms, 10.2MB)
테스트 4 〉	통과 (0.06ms, 10.1MB)
테스트 5 〉	통과 (0.10ms, 10.2MB)
테스트 6 〉	통과 (0.80ms, 10.1MB)
테스트 7 〉	통과 (3.97ms, 10MB)
테스트 8 〉	통과 (0.10ms, 10.2MB)
테스트 9 〉	통과 (1.92ms, 10.1MB)
테스트 10 〉	통과 (4.98ms, 10MB)
테스트 11 〉	통과 (0.24ms, 10.1MB)
테스트 12 〉	통과 (0.10ms, 10.3MB)
테스트 13 〉	통과 (0.78ms, 10.2MB)
테스트 14 〉	통과 (0.17ms, 10.3MB)
테스트 15 〉	통과 (0.48ms, 10.1MB)
테스트 16 〉	통과 (0.04ms, 10.3MB)
테스트 17 〉	통과 (3.00ms, 10.2MB)
테스트 18 〉	통과 (0.02ms, 10.2MB)
테스트 19 〉	통과 (0.01ms, 10.4MB)
테스트 20 〉	통과 (0.01ms, 10.1MB)
테스트 21 〉	통과 (0.02ms, 10.1MB)
효율성  테스트
테스트 1 〉	실패 (런타임 에러)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 69.9
효율성: 0.0
합계: 69.9 / 100.0
```

     
- 이번엔 BFS를 활용한 풀이를 살펴보자.
- BFS는 너비우선탐색으로, 각 노드에 연결된 모든 노드를 방문한 뒤 그 노드들에 연결된 다음 노드들을 방문한다.
  - 시작점에서 가장 먼 노드를 방문하고 다시 시작점으로 돌아오는 DFS와 달리, BFS에서는 시작점에서 가장 먼 노드는 가장 마지막에 방문한다.
  - BFS를 이용해 길을 탐색할때는 같은 이동 거리를 소모해 갈 수 있는 길은 모두 동시에 방문한다. 
- BFS를 활용할때는 deque를 이용하는 것이 좋다.
- 시작점부터 queue에 넣고, queue가 없어지거나 목표 지점에 방문할 때까지 다음 동작을 반복한다.
  - popleft()로 한 지점 x를 꺼내고, x와 연결된, 방문하지 않은 길을 모두 queue에 넣는다.
  - queue에 넣은 방문하지 않은 길에는 x에 적혀있는 값에 1을 더한 값을 적는다.
- DFS와 다르게 목표 지점에 도달한 순간 이동 거리를 return해도 최소 이동 거리를 보장한다.
  - BFS는 같은 이동 거리를 가진 지점까지 모두 동시에 이동하기 때문에, 그 보다 짧은 이동 거리를 가진 지점들은 이미 모두 방문했기 때문이다.

### 코드 (BFS 활용)
```py
from collections import deque

def can_go(x, y, n, m):
    return x>=0 and y>=0 and x<n and y<m

def bfs(maps):
    n, m = len(maps), len(maps[0])
    #     R, D, L, U
    dx = [0, 1, 0, -1] # horizonal move
    dy = [1, 0, -1, 0] # vertical move
    que = deque()
    que.append([0, 0])
    while que:
        x, y = que.popleft()
        for d in range(4):
            new_x = x + dx[d]
            new_y = y + dy[d]
            if can_go(new_x, new_y, n, m) and maps[new_x][new_y] == 1:
                que.append([new_x, new_y])
                maps[new_x][new_y] += maps[x][y]
                if new_x == n-1 and new_y == m-1:
                    return maps[new_x][new_y]
    return -1
    
def solution(maps):
    answer = bfs(maps)
    return answer
```

### BFS, DFS 길찾기 시뮬레이션 영상
[유튜브 링크](https://youtu.be/GC-nBgi9r0U)       
<iframe width="560" height="315" src="https://www.youtube.com/embed/GC-nBgi9r0U" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>