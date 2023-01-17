def conv_dec2n(num, n):
    result = ''
    while num>0:
        num, i = divmod(num, n)
        result += str(format(i, 'x')).upper()
    return result[::-1]

        
def solution(n, t, m, p):
    numbers = '0'
    for num in range(t*m):
        numbers += conv_dec2n(num, n)
    #print(numbers)
    
    answer = ''
    length = 0
    for idx in range(len(numbers)):
        if idx%m == p-1:
            answer += numbers[idx]
            length += 1
        if length >= t:
            break
    return answer