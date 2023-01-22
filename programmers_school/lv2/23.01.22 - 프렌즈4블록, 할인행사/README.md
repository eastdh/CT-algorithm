# 프렌즈4블록 (2018 KAKAO BLIND RECRUITMENT)
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17679)    
[해설 링크](https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/ "카카오 테크 블로그")   

### 사용한 개념
- 구현 자체는 쉽지만, 모든 조건을 따지기가 쉽지 않은 문제였다.
- 문제 조건에 나온대로, 모든 동작을 그대로 구현했다.
- boom, downable, down 세 가지의 메소드를 만들었다.
  * boom 메소드의 경우, 해당 블록을 포함하는 2x2 블록이 제거 대상이면 True를 return한다.
  * downable 메소드의 경우, 아래 쪽에 빈 칸이 존재해 위에 있는 블록이 떨어져야한다면 True를 return한다.
  * down 메소드의 경우, 위에 있는 블록이 떨어지는 동작을 구현했다.
- 처음엔 downable 메소드 없이 제출하였는데 이 때는 테스트 케이스 10번에서 실패가 나왔다. 
- 이를 해결하기 위해 `질문하기`에서 찾아보니, 테스트 케이스 10은 문제 조건대로 **블록이 모두 떨어진 후에 다음 제거가 진행**되어야 성공이 뜬다.
  * downable 메소드 없이 그냥 down만 한 번 진행할 경우, 내가 짠 대로라면 한 줄씩만 맨 아래로 떨어진다.
  * 그 후, 완전히 떨어지지 않은 상태에서 다음 제거가 진행돼 원래라면 지워져야 할 블록이 지워지지 않게된다.
- 끝까지 집중력을 놓치지 않고 반례를 찾아가며 코드를 고쳐야 하는 구현 문제였다.


### 코드
```py
# 해당 블록과 우, 하, 우하측에 있는 블록이 모두 같은지 확인
def boom(board, x, y):
    if board[x][y] != '' and board[x][y] == board[x][y + 1] == board[x + 1][y] == board[x + 1][y + 1]:
        return True
    return False


# down이 완벽하게 끝까지 진행되도록 확인. 이 메소드가 없으면, 한 번에 한 줄씩만 down 됨.
def downable(board):
    for row in range(1, len(board))[::-1]:
        for col in range(len(board[0])):
            if board[row][col] == '' and board[row - 1][col] != '':
                return True
    return False


# 빈 칸이 생겼을 때 빈 칸을 윗 블록으로 메꾸기 위한 메소드.
def down(board):
    changed = False
    while downable(board):
        for row in range(1, len(board)):
            for col in range(len(board[0])):
                if board[row][col] == '' and board[row - 1][col] != '':
                    board[row][col], board[row - 1][col] = board[row - 1][col], board[row][col]
                    changed = True
    return board, changed


# 디버깅을 위한 print 메소드
def print_board(board):
    for row in board:
        for c in row:
            if c == '':
                print('-', end="")
            print(c, end="")
        print()
    print()
    print()


def solution(m, n, board):
    answer = 0
    board = list(map(list, board))

    while True:
        boomed = [[False for _ in range(n)] for _ in range(m)] # boomed가 True라면, 그 블록은 제거 대상.
        
        for x in range(m - 1): # 제거 대상인 블록을 모두 체크
            for y in range(n - 1):
                if boom(board, x, y):
                    boomed[x][y] = True
                    boomed[x + 1][y] = True
                    boomed[x][y + 1] = True
                    boomed[x + 1][y + 1] = True
        # print_board(board)
        
        for x in range(m): # 제거 대상인 블록을 모두 제거
            for y in range(n):
                if boomed[x][y]:
                    board[x][y] = ''
                    answer += 1
        # print_board(board)

        board, changed = down(board) # 블록이 지워진 후에 위에 있는 블록이 아래로 떨어짐
        # print_board(board)
        # print("+" * 10)
        
        if not changed: # changed: 블록 제거가 일어나 블록이 떨어졌다면 True
            break # 블록이 떨어지지 않았다면 더이상 while문을 진행할 필요 없으니 break
        
    return answer


# for test_case 10, expected 86
print(solution(10, 10, ["DDABBAABBA",
                        "AAAAAABBBA",
                        "DDACCBBBAA",
                        "DDABBBBBAA",
                        "AAABBABBBA",
                        "CCADDAABBB",
                        "CCADDAABBB",
                        "BBACCABBBA",
                        "BBAAABBBAA",
                        "DDABBBBAAA"]))  

```
---
       
# 할인 행사
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131127)

### 사용한 개념
- 간단한 deque 활용 및 zip 사용을 실습할 수 있는 문제였다.
- 어렵지 않은 문제이고, deque와 zip 사용법만 알면 풀 수 있는 문제이므로 자세한 풀이는 아래 코드로 대신하고자 한다.
- deque 활용 없이 투포인터 만으로도 풀 수 있는 문제이다.
  * queue를 따로 만들지 않고 discount에서 왼쪽, 오른쪽 인덱스를 만들어서 왼쪽 인덱스를 한 칸 옮기는 것을 popleft, 오른쪽 인덱스를 한 칸 옮기는 것을 append로 치고 동작하게 하면 된다.

### 코드
```py
from collections import deque
def solution(want, number, discount):
    answer = 0
    goal = dict(zip(want, number)) # goal = {want[i]:number[i], ...}
    shop = {x:0 for x in want} # shop의 key는 want에 있는 요소들로만 구성
    que = deque(discount[0:10]) # 최초 queue는 discount의 첫 10개 원소
    for s in shop: # 최초 dictionary 구성을 위해 queue의 원소 개수를 셈
        shop[s] = que.count(s)
    if shop == goal:
        answer += 1

    # 11번째 원소부터는 popleft와 append를 이용한다.
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
```
