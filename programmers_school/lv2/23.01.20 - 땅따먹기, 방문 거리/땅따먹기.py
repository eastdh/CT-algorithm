def solution(land):
    answer = 0
    for row in range(1, len(land)):
        for col in range(4):
            land[row][col] += max(land[row-1][(col+1)%4], land[row-1][(col+2)%4], land[row-1][(col+3)%4])

    return max(land[-1])