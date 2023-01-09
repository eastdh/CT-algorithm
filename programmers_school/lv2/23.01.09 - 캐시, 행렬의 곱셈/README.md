# 캐시 (2017년도 카카오 신입 공채 기출)
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17680)   
[해설 링크](https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/ "카카오 테크 블로그")

### 사용한 개념
- LRU (Least Recently Used) 알고리즘 구현
- LRU의 개념을 알고 있고, cacheSize가 0인 경우를 고려했다면 어렵지 않은 문제였다.
- 두 개의 리스트를 사용해 구현했다.
    * 캐시의 역할을 하는 cache
    * 사용된지 얼마나 됐는지 알 수 있는 used
- 각 시행당 used의 모든 원소를 1씩 증가시킨다.
- cache hit 이라면 (== if c in cache) time을 1 증가시키고, 해당 도시의 used를 0으로 초기화시킨다.
- cache miss 라면 (== if c not in cache) time을 5 증가시키고, used가 가장 높은 도시의 cache 자리에 c를 삽입
- 다른 풀이 방법으로, 하나의 리스트만을 사용한 방법이 있다.
    * 리스트의 왼쪽에 있을 수록 사용된지 오래된 것으로, 오른쪽에 있을 수록 최근에 사용된 것으로 판단
    * cache hit라면 cache에서 해당 도시를 pop하고 cache에 다시 append
    * cache miss라면 cache에서 맨 왼쪽 도시를 pop하고 cache에 새로운 도시를 append

---

# 행렬의 곱셈
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12949)

### 사용한 개념
- 간단한 행렬의 곱셈 구현하기
    * 행렬의 연산을 까먹어서 검색했다.
- 먼저 arr1, arr2 각각의 사이즈를 알아내서 결과물의 사이즈를 미리 만들어냈다. 
    * arr1이 row1 x col1 사이즈, arr2가 row2 x col2 사이즈라면 결과물은 row1 x col2 사이즈이다.
- 그리고 각 칸의 연산을 3개의 for문으로 구현하였다.
```py
result = [[0 for _ in range(col2)] for _ in range(row1)]
for r in range(row1):
    for c in range(col2):
        for i in range(col1):
            result[r][c] += arr1[r][i] * arr2[i][c]
```