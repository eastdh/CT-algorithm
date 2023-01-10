def solution(clothes):
    categories = dict()
    for c in clothes:
        if c[1] in categories:
            categories[c[1]] += 1
        else:
            categories[c[1]] = 2 
            # '안 입기'와 '아이템 1' 두 가지를 동시에 추가하기 위해 2로 초기화한다.
    codi = 1
    for n in categories.values():
        codi *= n
    
    return codi - 1