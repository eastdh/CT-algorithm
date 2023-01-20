def check(x, y):
    if x>5 or x<-5 or y>5 or y<-5:
        return False
    return True

def solution(dirs):
    answer = set()
    pos = [0, 0]
    for d in dirs:
        x, y = pos
        if d == 'U':
            if check(x, y+1):
                answer.add((tuple(pos), d))
                answer.add((tuple([x, y+1]), 'D'))
                pos[1] += 1
        elif d == 'D':
            if check(x, y-1):
                answer.add((tuple(pos), d))
                answer.add((tuple([x, y-1]), 'U'))
                pos[1] -= 1
        elif d == 'R':
            if check(x+1, y):
                answer.add((tuple(pos), d))
                answer.add((tuple([x+1, y]), 'L'))
                pos[0] += 1
        elif d == 'L':
            if check(x-1, y):
                answer.add((tuple(pos), d))
                answer.add((tuple([x-1, y]), 'R'))
                pos[0] -= 1
        
    return len(answer)//2