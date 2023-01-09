def solution(n):
    bi = str(format(n, 'b'))
    bi_cnt = 0
    for i in bi:
        if i == '1':
            bi_cnt += 1
    
    while(True):
        n += 1
        new_bi = str(format(n, 'b'))
        new_cnt = 0
        for k in new_bi:
            if k == '1':
                new_cnt += 1
        
        if new_cnt == bi_cnt:
            break
        
    answer = n
    return answer