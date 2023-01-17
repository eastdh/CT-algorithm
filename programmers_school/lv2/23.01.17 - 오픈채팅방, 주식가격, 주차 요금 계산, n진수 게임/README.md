# 오픈채팅방 (2019 KAKAO BLIND RECRUITMENT)
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42888)    

### 사용한 개념
- 카카오 기출은 길고 긴 문제 설명을 뚫고 문제 풀이에 핵심적인 단서를 찾아내는 것이 중요하다.
- 어떠한 예외사항 없이 세 가지 '첫 단어'와 두 가지의 record형태만을 사용하기 때문에, 문제를 잘 읽어보면 어떻게 풀어야 할지 금방 알 수 있다.
- 각 record를 저장하기 위해 log라는 리스트와 uid라는 딕셔너리를 사용했다.
  * log의 경우 기록된 순서가 중요하기 때문에 list로 만들었다.
  * uid의 경우 변하지 않는 유저 아이디(key)에 대한 많은 검색과 닉네임(value) 갱신 및 삽입이 많이 이뤄질 것으로 예상되기 때문에 dictionary로 만들었다.
- 각 record를 처리하면서 log에는 '행동'과 '유저 아이디'를 저장하고, 첫 단어가 'Leave'가 아닐 경우 uid에 닉네임을 삽입하거나 갱신한다.
- 이후 log를 순서대로 탐색하면서 'Enter'와 'Leave'에 맞는 메시지를 result에 삽입한다. 

### 코드
```py
def solution(record):
    log, uid = [], dict()
    for r in record:
        act = r.split()[0]
        user = r.split()[1]
        if act == "Enter" or act == "Change":
            nick = r.split()[2]
            uid[user] = nick
        log.append([act, user])
    
    answer = []
    for l in log:
        act, user = l
        if act == "Enter":
            msg = uid[user]+"님이 들어왔습니다."
        elif act == "Leave":
            msg = uid[user]+"님이 나갔습니다."
        else:
            continue
        answer.append(msg)
    
    return answer
```
---
       
# 주식가격
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42584)

### 사용한 개념
- 문제 설명은 짧지만 이해하기에 쉽지 않았다. 수정하던가 해야하지 않을까...
- 어렵게 생각할 필요 없이, 각 주식 가격에 대해 그 가격보다 떨어지는 타이밍이 언제인지만 찾으면 된다.

### 코드
```py
def solution(prices):
    answer = []
    for p in range(len(prices)):
        for k in range(p+1, len(prices)):
            if prices[k]<prices[p]:
                break            
        answer.append(k-p)
    return answer
```

---

# 주차 요금 계산
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/92341)

### 사용한 개념
- [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888)과 비슷한 문제이다. 
- 문제를 잘 읽고 문제에서 요구하는 그대로 구현하면 된다.
- 각 record에 대해 각 차량이 주차장을 이용한 시간을 저장하는 dictionary를 생성하였다.
  * dictionary의 구조는 다음과 같다.   
  ```{(자동차 번호): [(주차장 이용 시간(분)), (들어온 시간(나갔으면 -1))]}```
- 각 record에 대한 계산이 끝난 후, 출차한 기록이 없는 차에 대해서 문제 조건대로 23시 59분에 나간 것으로 처리한다.
- 자동차 번호를 오름차순으로 정렬하고 이 순서대로 요금 계산을 하기 위해서 새로운 리스트를 만들었다.
- 마지막으로 각 자동차의 주차장 이용 시간을 계산한다.
- 여담으로, 코드의 가독성을 위해서 다음과 같은 형태로 unpack을 진행하는 것은 꽤 큰 도움이 된다.
    ```time, num, act = r.split()```
    ```std_min, std_won, per_min, per_won = fees```
### 코드
```py
import math
def solution(fees, records):
    ### 각 record에 대해 시간 계산 후 dict에 저장
    time_of_num = dict()
    for r in records:
        time, num, act = r.split()
        t_hour, t_min = list(map(int, time.split(':')))
        t_min += t_hour*60
        if num not in time_of_num:
            time_of_num[num] = [0, -1]
        if act == "IN":
            time_of_num[num][1] = t_min
        else:
            time_spent, in_time = time_of_num[num]
            time_of_num[num] = [time_spent+(t_min-in_time), -1]
    #print(time_of_num)
    
    ### 출차 처리가 되지 않은 차에 대해서 문제 조건과 같이 23시 59분에 출차한 것으로 처리
    end_of_day = 23*60 + 59
    for num in time_of_num.keys():
        time_spent, in_time = time_of_num[num]
        if in_time != -1:
            time_of_num[num] = [time_spent+(end_of_day-in_time), -1]
            
    ### 자동차 번호를 오름차순으로 정렬하기 위해서 [(자동차 번호), (주차장 이용 시간)] 형태로 리스트 생성
    time_list = [[x, time_of_num[x][0]] for x in time_of_num.keys()]
    time_list.sort(key = lambda x: x[0])
    #print(time_list)
    
    ### 문제 조건과 같이 요금 계산
    answer = []
    std_min, std_won, per_min, per_won = fees # 가독성을 위해 unpack
    for t in time_list:
        time = t[1]
        if time <= std_min:
            answer.append(std_won)
        else:
            won = std_won + math.ceil((time-std_min)/per_min)*per_won
            answer.append(won)
        
    return answer
```

# n진수 게임 (2018 KAKAO BLIND RECRUITMENT)
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17687)   
[해설 링크](https://tech.kakao.com/2017/11/14/kakao-blind-recruitment-round-3/ "카카오 Tech 블로그")

### 사용한 개념
- [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335)에서 쓰였던 n진수 변환 알고리즘이 또 다시 나왔다. 
  * 이 문제도 카카오 기출이였다.
- 숫자를 n진수로 변환한 문자열을 계속 이어 붙인다.
  * 주의할 점으로, 내가 만든 n진수 변환 알고리즘은 0에 대한 처리를 하지 못하므로 '번호 문자열'을 초기화할 때 0이 들어간 상태로 만들어야 한다.
  * 숫자를 변환할 때 필요한 숫자 개수보다 조금 더 많은 숫자를 변환하고 종료하기 위해서 (구하는 문자의 수) * (참여 인원 수)까지의 숫자를 변환했다.
- n진수 변환 알고리즘에서 2<=n<=16이므로, n진법으로 변환 시 10~15를 A~F로 변환하기 위해서 나머지를 16진법으로 바꾸었다.
- 숫자들을 쭉 이어붙인 문자열을 탐색하면서 index%(참여 인원 수)가 (차례)-1 일 때마다 answer의 맨 뒤에 이어붙인다.
  * 이 때 탈출을 위해 시행마다 answer의 길이를 구하면 수행시간이 길어지기 때문에, length라는 변수를 따로 만들어 answer가 늘어날 때마다 1씩 증가시켰다.
    - len()의 수행시간은 O(n)이지만 정수를 확인하는 수행시간은 O(1)이기 때문이다.

### 코드
```py
def conv_dec2n(num, n):
    result = ''
    while num>0:
        num, i = divmod(num, n)
        result += str(format(i, 'x')).upper() # 10~15의 숫자를 A~F로 변환하기 위함.
    return result[::-1]

        
def solution(n, t, m, p):
    numbers = '0'
    for num in range(t*m):
        numbers += conv_dec2n(num, n)
    #print(numbers)
    
    answer = ''
    length = 0
    for idx in range(len(numbers)):
        if idx%m == p-1:
            answer += numbers[idx]
            length += 1
        if length >= t:
            break
    return answer
```