def solution(s):
    s = s[2:-2].split("},{")
    s.sort(key = len)
    new_s = []
    for k in s:
        new_s.append(set(map(int, k.split(','))))
    #print(new_s)
    
    temp = set()
    answer = []
    for i in new_s:
        answer += list(set.difference(i, temp))
        temp.update(i)
        
    return answer