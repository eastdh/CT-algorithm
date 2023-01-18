# 연속 부분 수열 합의 개수
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/131701)    

### 사용한 개념
- 중복되는 값을 제외한 합의 가짓수이기 때문에, set를 활용하였다.
  * 만약 list를 이용한다면, 합을 구할 때마다 list에 그 값이 있는지 탐색해야하기 때문에 효율적이지 않다.
- 연속된 수의 최대 길이는 len(elements)이기 때문에, 이 값을 따로 저장해놓고 elements를 두배로 늘려 사용하였다.

### 코드
```py
def solution(elements):
    length = len(elements)
    elements += elements
    answer = set()
    for L in range(length):
        for R in range(1, length):
            answer.add(sum(elements[L:L+R]))
            
    #print(answer)
    return len(answer)+1 # 위 알고리즘은 길이가 len(elements)인 수열의 합은 구하지 못하기 때문에 1을 더한다.
```
---
       
# 스킬트리
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/49993)

### 사용한 개념
- 먼저 skill을 역순으로 뒤집었다.
  * 후순위에 위치한 스킬이 존재하는지부터 확인하기 위함이다.
- 그리고 각 스킬트리에 대해서 확인을 진행하였다.
- 확인을 할 때는, 현재 검증하는 스킬이 '없어도 되는지' 여부를 확인하도록 하였다.
  * 만약 해당 스킬이 스킬트리에 없는데 후순위에 위치한 스킬이라 없어도 된다면(ok == True), 아무 동작 없이 넘긴다.
  * 만약 해당 스킬이 스킽트리에 없는데 그 스킬보다 후순위에 있는 스킬이 존재해서 해당 스킬이 꼭 있어야 한다면(ok == False), False를 return한다.
  * 만약 해당 스킬이 스킬트리에 존재한다면, 그 스킬보다 선순위에 있는 스킬들은 꼭 존재해야하므로 ok를 False로 바꾼다.
- 이 알고리즘은 입출력 예시 중에 하나인 skill=="CBD", tree=="AECB"일 때 다음과 같이 동작한다.
  * skill을 역순으로 뒤집어 "DBC"로 바꾼다.
  * D부터 확인해서, D는 tree에 없지만 ok==True이기 때문에 가능한 스킬트리이다. 
  * B를 확인해서, B는 tree에 존재하기 때문에 ok를 False로 바꾸고 tree를 B이전까지 자른다.
    - 즉, B 다음으로 검증할 스킬들은 tree에 꼭 존재해야 한다.
  * A를 확인해서, A는 B이전까지 자른 tree에 존재하기 때문에 A이전까지 tree를 자른다.
  * "DBC"를 모두 검증할 때까지 False를 return하지 않았으므로 True를 return한다.


### 코드
```py
def check(skill, tree):
    ok = True
    for s in skill:
        if s in tree:
            tree = tree[:tree.index(s)]
            ok = False
        elif ok:
            continue
        else:
            return False
    return True

def solution(skill, skill_trees):
    answer = 0
    skill = skill[::-1]
    for tree in skill_trees:
        if check(skill, tree):
            answer += 1
                
    return answer
```
