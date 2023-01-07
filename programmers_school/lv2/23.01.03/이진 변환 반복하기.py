def solution(s):
    times = 0
    zeros = 0
    while(True):
        times += 1
        ones = 0
        for b in s:
            if b == '1':
                ones += 1
            else:
                zeros += 1
        if ones == 1:
            break
        s = str(format(ones, 'b'))
        

    answer = [times, zeros]
    return answer