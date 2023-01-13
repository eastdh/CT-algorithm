# 뉴스 클러스터링 (2018 KAKAO BLIND RECRUITMENT)
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/17677)   
[해설 링크](https://tech.kakao.com/2017/09/27/kakao-blind-recruitment-round-1/ "카카오테크 블로그")   

### 사용한 개념
- 카카오 기출 특유의 장문으로 이루어진 문제 조건이 눈에 띈다.
- 정규식을 사용하여 문자열을 다중집합의 원소로 만들 때 영문자가 아닌 글자가 포함되는지 판별하였다.
    * 이는 .isalpha() 를 사용해도 된다.
- 만약 두 다중집합이 공집합이면 바로 65536을 return 하도록 하였다.
- 합집합의 크기와 교집합의 크기를 담당하는 두 변수 hap, gyo를 만들었고, 이 변수들이 증가하는 조건은 다음과 같다.
    * list1과 list2를 합쳐서 set로 만든다. 이를 통해, 중복되는 원소는 모두 제거된다.
    * list1과 list2 각각에서 set의 각 원소들을 몇 개나 갖고있는지 파악한다. 
    * list1에서의 원소 개수는 x, list2에서의 원소 개수는 y라 할 때, x, y 중 큰 값은 hap에 더하고, 작은 값은 gyo에 더한다.
- 이후 자카드 유사도를 구해 최종 답변으로 return 하였다.
- 코드는 다음과 같다.
```py
import re
def makeList(s):
    list1 = []
    p = re.compile('[a-z]')
    for i in range(len(s)-1):
        if p.match(s[i]) and p.match(s[i+1]):
            list1.append(s[i]+s[i+1])
    return list1

def solution(str1, str2):
    str1, str2 = str1.lower(), str2.lower()
    list1, list2 = makeList(str1), makeList(str2)
    #print(list1, list2)
    if list1==[] and list2==[]:
        return 65536
    
    hap, gyo = 0, 0
    for src in set(list1+list2):
        x = list1.count(src)
        y = list2.count(src)
        hap += max(x, y)
        gyo += min(x, y)
    
    jab = gyo/hap
    
    answer = int(jab*65536)
    return answer
```
---
       
# 전화번호 목록
[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/42577)

### 사용한 개념
- startswith()라는 메소드가 있다는 것을 알게 되었다.
- 처음엔 단순하게 두 개의 for문을 사용해 O(n^2) 의 수행시간을 가지게 만들었다.
- 그러나, 이 [질문의 답변](https://school.programmers.co.kr/questions/39655 "프로그래머스 질문과 답변")을 보고, <b>사전순으로 정렬한 후 n번째 번호가 n+1번째 번호의 접두사인지</b>만 알아내면 된다는 것을 알게 되었다.
    * ["123", "456", "789", "1011", "1213"] 다섯 개의 번호가 있다고 가정하자.
    * 이를 사전순으로 정렬하면 다음과 같을 것이다: ["1011", "1213", "123", "456", "789"]
    * 사전순으로 정렬했기 때문에, 1011과 1213을 비교했을 때 접두사가 아니면 굳이 1011과 123을 비교할 필요가 없다.
    * 따라서 이 문제는 전화번호 리스트를 사전순으로 sort하는 시간인 O(n Log n)의 수행시간으로 해결할 수 있다.
- 코드는 다음과 같다.
```py
def solution(phone_book):
    phone_book.sort()
    for n in range(len(phone_book)-1):
        if phone_book[n+1].startswith(phone_book[n]):
            return False
    return True
        
```