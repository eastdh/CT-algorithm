def isPrime(n):
    if n == 1:
        return False
    for i in range(2, int(n**(1/2))+1):
        if n%i == 0:
            return False
    return True

def dec2n(n, k):
    result = ""
    while n>0:
        n, i = divmod(n, k)
        result += str(i)
    return result[::-1]

def solution(n, k):    
    arr = dec2n(n, k).split('0')
    arr = [x for x in arr if len(x) != 0]
    arr = list(map(int, arr))
    # print(arr)

    answer = 0
    for i in arr:
        if isPrime(i):
            answer += 1
    return answer