# k진수에서 소수 개수 구하기 (2022 KAKAO BLIND RECRUITMENT)
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/92335)    

### 사용한 개념
- 소수 판별 알고리즘과 divmod() 활용의 적절한 콤비네이션이 필요하다.
- 소수 판별 알고리즘 isPrime()의 경우, 효율성을 높이기 위해 2부터 n^(1/2)까지만 탐색하는 것이 중요하다.
  * 36의 약수인 [1, 2, 3, 4, 6, 9, 12, 18, 36]의 경우를 생각해보면, 뒤의 네 개의 숫자(9, 12, 18, 36)는 앞의 다섯 개의 숫자를 구하는 과정에서 구할 수 있다.
  * 1에서 6까지만 탐색해도 모든 약수를 구할 수 있으므로 훨씬 짧은 시간에 약수를 구할 수 있다.
- divmod(n, k)는 튜플의 형태로 (n//k, n%k)를 return한다.
  * 이를 활용한 십진수 n의 k진수 변환 알고리즘은 다음과 같다.
  ```py
  def conv_n_dec_2_k(n, k):
    result = ""
    while n>0:
        n, i = divmod(n, k)
        result += str(i)
        return result[::-1]
  ```
- 문제 조건에서 주어진대로 소수의 개수를 구하는 방법은 다음과 같다.
    1. 주어진 십진수 n을 k진수로 변환한 후, 0을 기준으로 split한다.
    2. split한 각 숫자에 대해서 소수인지 판별한 후 개수를 따진다.

### 코드
```py
def isPrime(n):
    if n == 1:
        return False
    for i in range(2, int(n**(1/2))+1):
        if n%i == 0:
            return False
    return True

def dec2n(n, k):
    result = ""
    while n>0:
        n, i = divmod(n, k)
        result += str(i)
    return result[::-1]

def solution(n, k):    
    arr = dec2n(n, k).split('0')
    arr = [x for x in arr if len(x) != 0]
    arr = list(map(int, arr))
    # print(arr)

    answer = 0
    for i in arr:
        if isPrime(i):
            answer += 1
    return answer
```
---
       
# 압축 (2018 KAKAO BLIND RECRUITMENT)
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17684)

### 사용한 개념
- 반복문에서 사전에 대한 수없이 많은 검색과 삽입이 이뤄질 것으로 예상되기 때문에, 사전을 딕셔너리로 구성하였다.
  * list에 대한 검색은 최악의 경우 O(n) 시간이 소모되지만, dictionary에 대한 검색은 항상 O(1) 시간이 소모되기 때문이다.
- 사전은 '단어'가 key로, '번호'가 value로 구성된다.
- 먼저 아스키 코드를 이용해 [A-Z]를 사전에 삽입하였다.
- 그리고 문제 조건과 같이 반복문을 구성하였다.
  * 과정 2: msg의 가장 첫 부분 부터 한 글자씩 늘려가며 사전에 있는지 탐색한다. 가장 긴 문자열 w를 찾는다.
  * 과정 3: w에 해당하는 사전의 번호를 출력하고 msg에서 w를 삭제한다.
  * 과정 4: 아직 msg가 모두 처리되지 않았다면 바로 다음 글자 c를 포함한 w+c를 사전에 삽입한다.
- 주석 처리한 print문을 출력하면 문제와 같은 형태로 나타난다. 그 중 입력 `TOBEORNOTTOBEORTOBEORNOT`에 대한 출력은 다음과 같다.
  ```
  테스트 2
    입력값 〉	"TOBEORNOTTOBEORTOBEORNOT"
    기댓값 〉	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
    실행 결과 〉	테스트를 통과하였습니다.
    출력 〉	
    T	O	20	27	TO
    O	B	15	28	OB
    B	E	2	29	BE
    E	O	5	30	EO
    O	R	15	31	OR
    R	N	18	32	RN
    N	O	14	33	NO
    O	T	15	34	OT
    T	T	20	35	TT
    TO	B	27	36	TOB
    BE	O	29	37	BEO
    OR	T	31	38	ORT
    TOB	E	36	39	TOBE
    EO	R	30	40	EOR
    RN	O	32	41	RNO
    OT		34
  ```

### 코드
```py
def solution(msg):
    ##### LZW 압축 과정 1. 사전 초기화
    wordDic = dict()
    for i in range(1, 27):
        wordDic[chr(64+i)] = i
    dicNum = 27
    
    answer = []
    while msg:
        ##### LZW 압축 과정 2. 가장 긴 문자열 w 찾기
        R = 1
        while R<=len(msg) and msg[:R+1] in wordDic:
            R += 1
        w = msg[:R]

        ##### LZW 압축 과정 3. w에 해당하는 사전의 색인 번호 출력 및 w 제거
        answer.append(wordDic[w])
        msg = msg[R:]

        ##### LZW 압축 과정 4. 입력에서 처리되지 않은 다음 글자 c가 남아있다면 w+c를 사전에 삽입
        c = ''
        if len(msg) != 0:
            c = msg[0]
            wordDic[w+c] = dicNum
            # print(w, c, wordDic[w], dicNum, w+c, sep='\t')
            dicNum += 1
        # else:
            # print(w, c, wordDic[w], sep='\t')
        
    return answer 
```