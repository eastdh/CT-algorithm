def solution(s):
    s = s.lower() # 문자열 전체를 소문자화
    answer = s[0].upper() # 첫 문자를 대문자로 삽입
    for idx in range(1, len(s)):
        c = s[idx]
        if s[idx-1] == " ": # 바로 이전 문자가 " "(공백)이면 대문자화
            c = c.upper()
        answer += c
    return answer