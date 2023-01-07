def solution(arr):
    # 유클리드 호제법, 최대공약수 구하는 방법
    def gcd(x, y):
        while y != 0:
            x, y = y, x%y
        return x
    
    # 최소공배수 == 두 수를 곱한 값 / 두 수의 최대공약수
    def lcm(x, y):
        return x*y/gcd(x, y)
    
    # N개의 최소공배수: 
    # arr에서 두 개의 수 끼리 최소공배수를 구하고 
    # 그 최소공배수랑 다른 수랑 최소공배수를 구하고...
    while(len(arr) > 1):
        arr.append(lcm(arr.pop(), arr.pop()))
    
    return arr[0]