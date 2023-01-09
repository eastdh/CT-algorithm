def solution(brown, yellow):
    carpet = brown + yellow
    for h in range(1, int(yellow**(1/2)) + 1):
        if yellow % h == 0:
            w = yellow / h
            height = h + 2
            width = w + 2
            if height * width == carpet:
                break
            
        
    answer = [width, height]
    return answer