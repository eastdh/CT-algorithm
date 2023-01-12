def solution(n, left, right):
    arrLR = []
    for i in range(left, right+1):
        r = i // n
        c = i % n
        if c <= r:
            arrLR.append(r+1)
        else:
            arrLR.append(c+1)
    
        
    return arrLR