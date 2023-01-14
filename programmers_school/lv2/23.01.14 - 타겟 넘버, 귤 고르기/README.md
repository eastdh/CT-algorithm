# 타겟 넘버
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/43165)    

### 사용한 개념
- 간단한 dfs 활용 문제이다.
    - 이 문제처럼 모든 경우의 수를 탐색할 때는 dfs를 활용하는 것이 좋다.
- dfs와 같은 재귀함수를 이용하는 문제는 `탈출 조건`을 잘 짜야한다.
    - 이 문제의 경우, numbers에 있는 모든 숫자에 대한 연산이 끝났을 때 탈출한다.
    - 탈출할 때, target이 나올 수 있으면 (방법의 수) += 1을 시행한다.
- 코드는 다음과 같다.
```py
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
```
---
       
# 귤 고르기
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/138476)

### 사용한 개념
- 딕셔너리를 이용하여 {(종류) : (개수)} 형태로 딕셔너리에 담기게 하였다.
- 이후, 딕셔너리의 value들을 역순으로 sort하고, 귤의 총 개수가 k가 넘을 때까지 (종류의 수) += 1 을 시행하였다.
- 코드는 다음과 같다.
```py
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
        
```