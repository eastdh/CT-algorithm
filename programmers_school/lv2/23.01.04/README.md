# 카펫
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42842)

### 사용한 개념
- 전체 카펫 넓이 = 갈색 + 노란색
- 노란색의 너비와 높이를 w, h라고 할 때, 전체 카펫의 너비와 높이는 w+2, h+2임
- 따라서, h를 1부터 int(sqrt(yellow))까지 탐색해서 yellow를 h로 나눈 나머지가 0일 때의 몫인 w를 구함
    * 높이는 항상 너비와 같거나 작기 때문에 h의 최댓값은 int(sqrt(yellow))임
- 각 탐색마다 (h+2) * (w+2) = carpet이라면 [w+2, h+2]를 return함
   

---  
   
   
# 짝지어 제거하기
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12973)

### 사용한 개념
- [올바른 괄호](https://school.programmers.co.kr/learn/courses/30/lessons/12909)문제와 비슷하게 풀기 위해서 stack을 이용함
- 먼저 s의 길이가 홀수라면 짝지어 제거되지 않기 때문에 불가능(0)을 return 
    * 테스트 케이스에는 길이가 홀수인 문자열은 존재하지 않는 것 같지만 분명한 불가능 조건이기 때문에 추가하였음
- 문자열 s를 한 글자씩 탐색하면서, 다음과 같이 동작함
    * 만약 스택의 마지막 글자가 현재 탐색하는 글자 c와 같지 않다면, c를 스택에 push
    *  스택의 마지막 글자가 c와 같다면 스택의 마지막 글자를 pop
- 예를 들어 s=baabaa일 때, 동작은 다음과 같음
    * b: push b >> stack = b
    * a: push a >> stack = ba
    * a: pop >> stack = b
    * b: pop >> stack = /
    * a: push a >> stack = a
    * a: pop >> stack = /

- 위와 같이 하지 않고 s를 탐색하며 짝지어 제거하면서 s를 편집한다면, 다음과 같은 문제가 발생함
    * s = baabcc의 경우, 가장 먼저 aa를 제거
    * s = b  bcc => b 사이의 빈 공간을 메꾸기 위해서 b를 s[1]에, c를 s[2]에, c를 s[3]에 이동시켜야 함
    * 문자열 s의 길이가 길어질 경우 시간이 오래 걸림