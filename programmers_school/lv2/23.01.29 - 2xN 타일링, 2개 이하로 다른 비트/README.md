# 2xN 타일링
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12900)    

### 사용한 개념
- 유명한 DP 활용 문제이다.
- 자세히 뜯어 보면 [멀리 뛰기](https://school.programmers.co.kr/learn/courses/30/lessons/12914) 문제와 유사하다.
  * 가장 왼쪽 블록을 ㅣ로 시작하냐, =로 시작하냐를 따지는 것과 위 문제의 첫 점프를 1칸 점프하냐, 2칸 점프하냐를 따지는 것은 똑같다.
- 따라서, 멀리 뛰기 문제와 유사하게 dp를 활용하였다.
  * 특이사항으로, n의 최대값이 매우 높아서 그런지 다음과 같이 리스트를 만들어 내용물을 구성하는 것은 시간 초과가 걸린다.
  ```py
  answer = [1, 2]
  for i in range(2, n):
    answer.append(answer[-1] + answer[-2])
  return answer[-1]
  ```

### 코드
```py
def solution(n):
    a, b = 1, 2
    if n==1:
        return 1
    elif n==2:
        return 2
    
    for i in range(2, n):
        a, b = b, a+b
    return b%1000000007
```


---     

# 2개 이하로 다른 비트
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/77885)

### 사용한 개념
- [다음 큰 숫자](https://school.programmers.co.kr/learn/courses/30/lessons/12911)와 비슷한 문제인 것으로 파악해 비슷하게 반복문을 이용해 조건을 만족할 때까지 찾도록 풀었으나, 최악의 경우를 입력 받았을 경우 시간 초과가 걸리는 문제가 발생했다.
- 따라서 이진수로 숫자를 작성해서 쭉 나열해놓고 규칙을 찾아보니, 다음과 같은 규칙이 존재했다.
  * 짝수의 경우, n보다 1 더 큰 숫자가 규칙을 만족했다. 맨 뒷자리의 0만 1로 바뀌면 되기 때문이다.
  * 홀수의 경우, 가장 오른쪽에 있는 0과 그 바로 오른쪽에 있는 1끼리
 서로 자리를 바꾸면 규칙을 만족했다. 
    - 1101 ==>  1110, 1011 ==> 1101, 1111(=01111) ==> 10111
- 따라서, 다음과 같은 로직으로 답변을 찾아냈다.
  * 짝수일 경우, n+1을 return
  * 홀수일 경우, 숫자를 이진수 문자열로 변환한 후 0을 맨 앞에 붙이고 숫자를 거꾸로 뒤집음
    - 0b1111과 같은 수는 0이 존재하지 않고, 맨 앞에 붙은 0은 숫자의 값에 영향을 미치지 않기 때문이다.
  * 그리고 `list.index()`를 사용해 가장 먼저 나오는 0을 찾고, 바로 왼쪽 1과 자리를 바꿈
    - `list.index()` 메소드는 가장 먼저 그 조건을 만족하는 인덱스를 반환하기 때문에, 이를 이용하기 위해 이진수를 거꾸로 뒤집었다.
  * 이후 다시 숫자를 뒤집어 십진수로 변환한 후 return

### 코드
```py
def f_x(n):
    if n%2 == 0:
        return n+1
    bi_n = str(format(n, 'b'))[::-1] + '0'
    idx = bi_n.index('0')
    bi_n = bi_n[:idx-1]+'01'+bi_n[idx+1:]
    
    return int(bi_n[::-1], 2)

def solution(numbers):
    answer = []
    for n in numbers:
        answer.append(f_x(n))
    return answer
```