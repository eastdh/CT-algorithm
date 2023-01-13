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