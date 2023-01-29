def f_x(n):
    if n%2 == 0:
        return n+1
    bi_n = str(format(n, 'b'))[::-1] + '0'
    idx = bi_n.index('0')
    bi_n = bi_n[:idx-1]+'01'+bi_n[idx+1:]
    
    return int(bi_n[::-1], 2)

def solution(numbers):
    answer = []
    for n in numbers:
        answer.append(f_x(n))
    return answer