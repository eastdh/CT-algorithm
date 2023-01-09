def solution(people, limit):
    answer = 0
    people.sort(reverse = True)
    L = 0
    R = len(people)-1
    while(L<=R):
        if L == R:
            answer += 1
            break
        if people[L] + people[R] <= limit:
            L += 1
            R -= 1
        else:
            L += 1
        answer += 1
        
    return answer