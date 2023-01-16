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