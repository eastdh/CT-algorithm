# 멀리 뛰기
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12914)

### 사용한 개념
- dp 문제
- a를 1칸 뛰기, b를 2칸 뛰기라고 했을 때 n=6 까지의 뛰는 방법들을 나열하면 다음과 같다.
    * n = 1 ==> 1
        - a
    * n = 2 ==> 2
        - aa
        - b
    * n = 3 ==> 3
        - aaa
        - ab
        - ba
    * n = 4 ==> 5
        - aaaa
        - aab
        - aba
        - baa
        - bb
    * n = 5 ==> 8
        - aaaaa
        - aaab
        - aaba
        - abaa
        - abb
        - baaa
        - bab
        - bba
    * n = 6 ==> 13
        - aaaaaa
        - aaaab
        - aaaba
        - aabaa
        - aabb
        - abaaa
        - abab
        - abba
        - baaaa
        - baab
        - baba
        - bbaa
        - bbb
- 위 나열에서 n == n-1 + n-2 라는 것을 알 수 있다.
- 그 이유는 다음과 같다.
    * n개의 칸이 있을 때 첫 점프가 한 칸이라면, 남은 칸 개수는 n-1개이다. 즉, 남은 칸을 뛰는 방법은 n-1개의 칸을 뛰는 방법과 동일하다.
    * 첫 점프가 두 칸이라면, 남은 칸 개수는 n-2개이다. 즉, 남은 칸을 뛰는 방법은 n-2개의 칸을 뛰는 방법과 동일하다.
    * 점프는 한 칸 또는 두 칸이기 때문에 (n개의 칸을 뛰는 방법) = (n-1방법) + (n-2방법) 이다.
- 만약 점프를 세 칸까지 할 수 있다면 n == n-1 + n-2 + n-3 일 것이다.

--- 

# H-Index
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42747)

### 사용한 개념
- h = max(citations)를 이용해 최초 h 값을 잡는다.
- h를 1씩 감소시키면서 인용된 횟수가 h 이상인 논문의 개수가 h개 이상이 될 때 h를 return하도록 했다.
```py
def solution(citations):
    h = max(citations)
    count = 1
    while count<h:
        count = 0
        h -= 1
        for c in citations:
            if c>=h:
                count += 1
    return h
```
- 그러나 이 방법은 다음과 같이 시행시간이 길게 나오고 citations를 자주 탐색하는 등 효율성이 낮아 다르게 풀어보았다.
```
테스트 1 〉	통과 (161.48ms, 10.1MB)
테스트 2 〉	통과 (303.42ms, 10.1MB)
테스트 3 〉	통과 (339.69ms, 10.1MB)
테스트 4 〉	통과 (233.65ms, 10.3MB)
테스트 5 〉	통과 (270.78ms, 9.97MB)
테스트 6 〉	통과 (273.86ms, 10.1MB)
테스트 7 〉	통과 (118.60ms, 10.2MB)
테스트 8 〉	통과 (18.64ms, 10.3MB)
테스트 9 〉	통과 (73.87ms, 10.2MB)
테스트 10 〉	통과 (173.51ms, 10.1MB)
테스트 11 〉	통과 (290.98ms, 10MB)
테스트 12 〉	통과 (53.88ms, 10.1MB)
테스트 13 〉	통과 (326.88ms, 10.2MB)
테스트 14 〉	통과 (348.34ms, 10.4MB)
테스트 15 〉	통과 (287.37ms, 10.2MB)
테스트 16 〉	통과 (0.00ms, 10MB)
```

- citations를 역순으로 정렬하였다.
- 이후 citations의 인덱스 i 와 citations[i]를 비교해서 i가 citations[i]보다 커지면 i를 return 하도록 했다.
    * 문제의 예시인 [2, 0, 6, 1, 5]를 생각해보자
    * sort ==> [6, 5, 2, 1, 0]
    * c[0] == 6, c[1] == 5, c[2] == 2, c[3] == 1, ...
- 인덱스 i는 `c[i]보다 인용 횟수가 크거나 같은 논문의 개수`를 의미한다.
- i가 답이 되는 이유는, H-index는 '인용된 횟수'가 아니라 '인용 횟수가 h 이상인 *논문의 개수*'이기 때문이다.
- 이 상태에서 제출하면, `테스트 9`에서 실패처리 된다. 이는 다음과 같은 반례가 존재하기 때문이다. 
    * [9, 9, 9], return=3
- 이 반례를 해결하기 위해서, 만약 i를 돌며 탐색하는 동안 어떤 i 도 return 되지 않았다면 len(citations)를 return한다.
- 이 방법은 citations를 한 번만 탐색하기 때문에 높은 효율성을 보인다.