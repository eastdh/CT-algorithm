# 올바른 괄호
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12909)

### 사용한 개념
- 기본적인 스택 문제  
   

---  
   
   
# 이진 변환 반복하기
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/70129)

### 사용한 개념
- format(n, 'b')
    * 출력 형태: 10111 (앞에 0b가 붙지 않는 이진수 형태)
- 문제를 단순화하면 x = (old_x의 1의 개수를 이진수로 표현한 형태)
- 각 변환마다 times += 1, zeros += old_x의 0의 개수

---  
   
   
# 숫자의 표현
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12924)

### 사용한 개념
- 투포인터 사용: L, R
    * L과 R의 초기값: L = 1, R = L+1
    * L부터 R까지 더한 값이 n이 될 때까지 R을 1 증가
    * L부터 R까지 더한 값이 n보다 커지면 L을 1 증가
- 효율성을 증가시키기 위해
    * 연속한 자연수의 개수가 2개일 때 그 이상의 시행은 의미 없다.
        - 2개가 되는 경우는 무조건 n//2 + (n//2)+1 의 경우이기 때문이다.
        - 15의 경우: 7+8 = 15, 25의 경우: 12+13 = 25
    * 따라서, L이 n//2보다 큰 경우는 따지지 않아도 된다.
    * 이 때 L==R==n 인 경우는 따져지지 않기 때문에 최종 결과에 1을 더한다.