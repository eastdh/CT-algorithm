def solution(elements):
    length = len(elements)
    elements += elements
    answer = set()
    for L in range(length):
        for R in range(1, length):
            answer.add(sum(elements[L:L+R]))
            
    #print(answer)
    return len(answer)+1