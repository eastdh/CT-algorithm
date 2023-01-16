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