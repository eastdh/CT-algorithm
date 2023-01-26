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