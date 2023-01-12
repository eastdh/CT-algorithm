# n^2 배열 자르기
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/87390)

### 사용한 개념
- 문제 조건의 2차원 배열을 만드는 과정은 다음과 같은 과정으로 유추해낼 수 있다.
    * n=5일 때 2차원 배열을 문제 조건에 따라 만들면 다음과 같은 배열이 만들어진다.
    ```
    1 2 3 4 5
    2 2 3 4 5
    3 3 3 4 5
    4 4 4 4 5
    5 5 5 5 5
    ```
    * 위 배열에서 임의의 행을 r, 임의의 열을 c라고 한다면 다음 조건문에 따라서 숫자가 삽입된다는 것을 알 수 있다.
    ```py
    # 0 <= r, c < n
    if c <= r:
        arr[r][c] = r+1
    else:
        arr[r][c] = c+1
    ```
- 다음 코드처럼 문제 조건의 n*n 2차원 배열을 만들어 arr[left:right+1]을 return하는 것은 어렵지 않지만, O(n^2)의 시간이 걸리기 때문에 효율적이지 않다.
    * 코드
    ```py
    def solution(n, left, right):
    arr22 = [[0 for _ in range(n)] for _ in range(n)]
    for r in range(n):
        for c in range(n):
            if c < r:
                arr22[r][c] = r+1
            else:
                arr22[r][c] = c+1
    # for row in arr22:
    #     print(row)
    
    arr1 = []
    for row in arr22:
        arr1 += row
        
    return arr1[left:right+1]
    ```
    * 수행시간
    ```
    테스트 1 〉	통과 (17.10ms, 16.1MB)
    테스트 2 〉	실패 (시간 초과)
    테스트 3 〉	실패 (시간 초과)
    테스트 4 〉	통과 (1.56ms, 10.3MB)
    테스트 5 〉	통과 (0.76ms, 10.3MB)
    테스트 6 〉	통과 (162.80ms, 51MB)
    테스트 7 〉	통과 (139.65ms, 53.1MB)
    테스트 8 〉	통과 (143.32ms, 53.3MB)
    테스트 9 〉	실패 (시간 초과)
    테스트 10 〉	실패 (시간 초과)
    테스트 11 〉	실패 (시간 초과)
    테스트 12 〉	실패 (시간 초과)
    테스트 13 〉	실패 (시간 초과)
    테스트 14 〉	실패 (시간 초과)
    테스트 15 〉	실패 (시간 초과)
    테스트 16 〉	실패 (시간 초과)
    테스트 17 〉	실패 (시간 초과)
    테스트 18 〉	실패 (시간 초과)
    테스트 19 〉	실패 (시간 초과)
    테스트 20 〉	실패 (시간 초과)
    ```
- 따라서 가장 긴 시간이 걸리는 n*n 2차원 배열을 만드는 것을 생략하고, 바로 1차원 배열 arr을 만들어야 한다.
- 이 1차원 배열 arr을 만들 때도 len(arr) = n^2 이기 때문에, arr[left : right+1] 배열을 바로 생성해야한다.
- left ~ right 까지의 index를 n으로 나눈 몫과 나머지를 이용하면 된다.
    * n*n사이즈 2차원 배열을 1행1열부터 0, 1, 2, ... 1행n열을 n-1, 2행1열부터 n, n+1, ...2행n열을 2n-1, ... n행n열을 n^2-1로 번호를 매겼다고 해보면, n=5인 경우 다음과 같은 배열이 만들어진다.
    ```
     0  1  2  3  4 
     5  6  7  8  9
    10 11 12 13 14 
    15 16 17 18 19 
    20 21 22 23 24
    ``` 
    * 이 번호들을 n으로 나눈 몫은 행의 번호, n으로 나눈 나머지는 열의 번호가 되는 것을 알 수 있다.
    * 이 번호들은 위의 2차원 배열을 1차원 배열로 변형하였을 때 각 숫자의 인덱스와 같다.
- 이 조건을 따라 arr[left:right+1]을 생성하는 코드는 다음과 같다.
```py
def solution(n, left, right):
    arrLR = []
    for i in range(left, right+1):
        r = i // n
        c = i % n
        if c <= r:
            arrLR.append(r+1)
        else:
            arrLR.append(c+1)
    
        
    return arrLR
```
---
       
# 프린터
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42587)

### 사용한 개념
- 인쇄 대기열의 길이가 100 이하이므로, 문제 조건대로 priorities가 조작되게끔 구현하였다.
    - 먼저 0 <= L < len(priorities) 인 L에 대해서 priorities[L:]을 하나의 구역 newPri으로 잡는다.
    - 각 newPri 별 최고값의 인덱스를 M이라 할 때, M을 기준으로 newPri = newPri[M:] + newPri[:M]으로 순서를 바꾸어 수정한다. 
    - 각 시행이 끝날 때마다 M은 newPri의 가장 왼쪽으로 이동하고, 이렇게 수정된 newPri를 priorities[:L]뒤에 붙여 priorities 전체를 수정한다.
    - 같은 시행을 각 문서의 index를 표시한 리스트에도 적용하여, 시행이 끝났을 때 어떤 문서가 어디로 이동했는지 알 수 있도록 하였다.
- 이 알고리즘은 최악의 경우 O(n^2)의 수행시간을 가진다. 각 구역의 시작점을 담당하는 L은 0부터 n까지 탐색하고 각 구역의 최대값을 한 번의 반복마다 구하기 때문이다.
    * 이 복잡도로도 답이 나오는 이유는 대기목록의 길이가 100 이하이기 때문이다.
- 코드는 다음과 같다.
    ```py
    def solution(priorities, location):
    idx = list(range(len(priorities)))
    for L in range(len(priorities)):
        new_p = priorities[L:]
        new_i = idx[L:]
        if new_p[0] != max(new_p): # 이 Line을 제거해도 같은 결과값이 나올 것이다.
            M = new_p.index(max(new_p))
            new_p = new_p[M:] + new_p[:M]
            new_i = new_i[M:] + new_i[:M]
            priorities = priorities[:L] + new_p
            idx = idx[:L] + new_i
    return idx.index(location) + 1
    ```