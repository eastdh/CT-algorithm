# 파일명 정렬 (2018 KAKAO BLIND RECRUITMENT)
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17686)    
[해설 링크](https://tech.kakao.com/2017/11/14/kakao-blind-recruitment-round-3/ "카카오 테크 블로그")   

### 사용한 개념
- 좀 더 'sexy'하고 깔끔한 풀이는 인터넷을 찾아보면 정규식을 이용한 + 좀 더 'pythonic'한 풀이가 있으니, 그 풀이를 찾아보는 것이 훨씬 좋을 것 같다.
  * 해당 문제의 `질문하기` 게시판에도 파이썬 풀이의 전문을 올려 놓은 사람들이 있다.
- 따라서 접근했던 방법 (및 아쉬웠던 점)을 여기에 작성하고, 상세한 로직은 주석으로 대신할까 한다.
  * 영어로 작성한 주석은 문제를 풀면서 작성한 주석이고, 한글로 작성한 주석이 설명을 위한 주석이다.
  * 한글 주석 없는 코드는 ```Github에서 확인하기```
- 먼저, 이 문제는 '인터넷 검색 찬스 불가능'이라는 제약 조건이 존재한다.
  * 대부분의 코딩테스트의 경우 인터넷 검색 찬스는 허용하는 곳이 많은 것으로 알고있다.
  * 3차에 해당하는 이 문제의 경우도 [해설 링크](https://tech.kakao.com/2017/11/14/kakao-blind-recruitment-round-3/ "카카오 테크 블로그")에 따르면 1차/2차 코딩테스트는 검색 가능인 반면 3차는 검색 불가능이다.
- 따라서, 이 문제를 빠르게 풀기 위해서는 정규식(regex) 사용이나 안정 정렬(stable sort)에 대한 사전 지식이 충분히 존재해야한다.
- 나의 경우는 이 문제를 풀면서 다음과 같은 특이사항이 있었다.
  * HEAD / NUMBER / TAIL로 분리할 때 정규식을 사용하면 더 간결하게 분리될 것이라고 생각하며 아쉬웠다.
  * 문제는 풀렸지만 안정 정렬에 대해서는 전혀 고려하지 않고 풀었다. 운이 좋게도 파이썬의 `list.sort()`메소드는 안정 정렬에 해당하는 정렬이였다.
- 그리고 이러한 특이사항을 포함해 문제를 푼 방식에 대해서는 다음과 같은 자기 반성이 있겠다.
  * 파일명을 분해할 때 굉장히 복잡한 for, if 문을 사용하였다. 이러한 풀이는 가독성이 좋지 않아 나중에 다시 봤을 때 로직을 따라가기 어렵다. 최악의 경우 시험 중간에 로직을 놓치게 되면 다시 짜는 것이 빠를 정도이다. 
    - 모든 조건문에 대해 주석을 따로 달아야 할 정도로 복잡하다는 것은 긍정적인 습관은 분명히 아니라고 생각한다.
  * 정규식은 현재의 나의 굉장히 짧은 식견으로써는 계륵같은 존재이다. 이걸 외워 말어... (외우는 것이 분명히 도움되긴 한다)
  * HEAD, NUMBER로 sort 할 때 나는 HEAD 따로 정렬하고 NUMBER 따로 정렬했는데, sort() 메소드는 여러 개의 key를 지정해 sort() 한 줄로도 같은 결과물을 내놓을 수 있다는 것을 나중에야 알았다.

### 코드
```py
def solution(files):
    new_files = []
    for f in files: # 전처리
        head, number, tail = "", "", ""
        numON = False
        tailON = False
        for c in f:
            if not numON: # if HEAD is not over
                if not c.isdigit(): # if c is HEAD
                    head += c # 문제 조건에 따라, 숫자가 나오기 전의 문자들을 전부 HEAD로 처리한다.
                else: # if c is NUMBER
                    numON = True # 숫자가 나오기 시작했으므로 HEAD를 종료하고,
                    number += c # 해당 문자부터는 NUMBER로 처리한다.
            else: # if HEAD is over
                if not tailON: # if NUMBER is not over
                    if c.isdigit(): # if c is NUMBER
                        number += c # 문제 조건에 따라, 문자가 나오기 전의 숫자들을 전부 NUMBER로 처리한다.
                    else: # if c is a head of TAIL
                        tailON = True # 문자가 나오기 시작했으므로 NUMBER를 종료하고,
                        tail += c # 해당 문자부터 TAIL로 처리한다.
                else: # if NUMBER is over (== if c is TAIL)
                    tail += c # NUMBER가 종료됐다면 그 뒤로는 모두 TAIL로 처리한다.
        new_files.append([head, number, tail])
    # print(new_files)
    
    files_dict = dict()
    for n in new_files: # HEAD 기준의 정렬을 위해 딕셔너리를 이용해 같은 HEAD끼리 모은다
        if n[0].lower() not in files_dict:
            files_dict[n[0].lower()] = [n]
        else:
            files_dict[n[0].lower()].append(n)
    key_list = sorted(files_dict.keys()) # sort with HEAD
    answer = []
    for k in key_list:
        files_dict[k].sort(key = lambda x: int(x[1])) # sort with NUMBER
        for item in files_dict[k]:
            answer.append("".join(item))
    # print(files_dict)            
    
    return answer
```
---
       
# 모음 사전
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/84512)

### 사용한 개념
- 사전에 있는 단어들의 길이 제한이 5자 밖에 되지 않으므로, 재귀 깊이가 5밖에 되지 않는다. 
- 사용 가능한 알파벳의 수도 5이므로 사전의 모든 단어를 만들어내도 그렇게 오랜 시간이 걸리지 않을 것을 예측할 수 있다.
- 모든 테스트 케이스의 실행시간은 항상 상수시간이 걸릴 것 또한 알아낼 수 있다.
  * 무엇을 입력하든 사전의 길이가 바뀌지 않기 때문이다.
- 따라서, 이 문제는 dfs와 sort를 이용해도 된다.
- 먼저 dfs를 이용해서 모든 단어를 만든다. 
  * 중복 제거를 위해서 set를 활용했으나 단어 길이별로 따로 dfs를 따로 실행하고 단어를 만들어내는 과정에서도 같은 결과값은 만들어지지 않기 때문에 중복은 생기지 않을 것이다.
- 그리고 사전을 list로 만들어서 sort한 후, index를 return한다.
- 최소 시간은 입력이 "A"일 때이고, 최대 시간은 입력이 "UUUUU"일 때이다. 
  * 이는 `list.index()`메소드가 리스트의 맨 앞에서부터 원하는 값을 찾을 때까지 탐색하기 때문이다.
- `질문하기`에 수학적인 방법으로 푼 정답들이 몇 개 있는데 이를 참고하여 'dfs처럼 보이지만 복잡한 조건으로 인해 더 짧은 시간에 풀어야 하는 문제들'에 활용하자.
  * 재귀 함수를 이용하는 풀이들은 최악의 입력에 재귀 제한 에러를 일으킬 수 있기 때문에 문제 조건을 잘 살펴야한다.
  * '수학적인 규칙을 찾아낸 풀이'들은 대부분 알고리즘 수행 시간이 O(1)로 최악의 입력에도 수행 시간이 변하지 않기 때문에 굉장히 경쟁력있는 알고리즘을 만들어 낼 수 있다.

### 코드
```py
def make_word(length, before):
    global dictionary
    if len(before) == length:
        dictionary.add(before)
        return
    moeum = ['A', 'E', 'I', 'O', 'U']
    for m in moeum:
        make_word(length, before+m)
    
    
def solution(word):
    global dictionary
    dictionary = set()
    for L in range(1, 6):
        make_word(L, "")
    dict_list = sorted(list(dictionary))
    print(len(dict_list))
    return dict_list.index(word)+1
```
