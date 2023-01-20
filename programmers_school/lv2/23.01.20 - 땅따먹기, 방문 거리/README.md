# 땅따먹기
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12913)    

### 사용한 개념
- 처음엔 dfs 형식으로 풀려고 하였으나, 런타임 에러가 발생한다.
  * dfs는 재귀를 이용하는 경우가 대부분인데, 파이썬은 재귀 제한이 약 1,000회로 걸려있다.
  * 이 문제의 행의 개수 N은 100,000이하의 자연수이므로, 재귀 제한에 걸린다.
- 따라서 dp형식으로 풀었다. 
  * Top-down 형식으로, 각 칸에 바로 이전 행, 다른 열 중에 최대값을 더하면 된다.
  * 마지막 행의 값들 중 가장 큰 값을 return하면 된다.

### 코드
```py
def solution(land):
    answer = 0
    for row in range(1, len(land)):
        for col in range(4):
            land[row][col] += max(land[row-1][(col+1)%4], land[row-1][(col+2)%4], land[row-1][(col+3)%4])

    return max(land[-1])
```
---
       
# 방문 길이
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/49994)

### 사용한 개념
- 중복 제거를 위해 set를 사용했는데, set의 내용물은 mutable한 것이 있으면 안되므로 tuple로 만들어줘야 한다.
- set에 추가한 '방문한 길'은 ((출발점), (방향))형태로 저장하였는데, 이 방식을 제대로 활용하기 위해선 이를 추가함과 동시에 ((도착점), (반대 방향))도 추가해야한다.
  * set에 저장하는 형식을 frozenset(tuple(출발점), tuple(도착점))으로 한다면, 한번 추가할 때 두 개 씩 추가할 필요 없다.
    - frozenset은 set과 똑같이 동작하지만, set와 다르게 immutable하다는 차이점이 있다.


### 코드
```py
def check(x, y):
    if x>5 or x<-5 or y>5 or y<-5:
        return False
    return True

def solution(dirs):
    answer = set()
    pos = [0, 0]
    for d in dirs:
        x, y = pos
        if d == 'U':
            if check(x, y+1):
                answer.add((tuple(pos), d))
                answer.add((tuple([x, y+1]), 'D'))
                pos[1] += 1
        elif d == 'D':
            if check(x, y-1):
                answer.add((tuple(pos), d))
                answer.add((tuple([x, y-1]), 'U'))
                pos[1] -= 1
        elif d == 'R':
            if check(x+1, y):
                answer.add((tuple(pos), d))
                answer.add((tuple([x+1, y]), 'L'))
                pos[0] += 1
        elif d == 'L':
            if check(x-1, y):
                answer.add((tuple(pos), d))
                answer.add((tuple([x-1, y]), 'R'))
                pos[0] -= 1
        
    return len(answer)//2
```
