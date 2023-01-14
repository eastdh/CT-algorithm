def solution(numbers, target):
    answer = 0
    def dfs(temp, idx):
        if idx >= len(numbers):
            if temp == target:
                nonlocal answer
                answer += 1
            return
            
        for i in [-1, 1]:
            dfs(temp + i*numbers[idx], idx+1)
    
    dfs(0, 0)
    return answer