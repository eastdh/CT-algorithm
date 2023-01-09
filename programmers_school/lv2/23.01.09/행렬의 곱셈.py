def solution(arr1, arr2):
    row1, col1 = len(arr1), len(arr1[0])
    row2, col2 = len(arr2), len(arr2[0])
    result = [[0 for _ in range(col2)] for _ in range(row1)]
    for r in range(row1):
        for c in range(col2):
            for i in range(col1):
                result[r][c] += arr1[r][i] * arr2[i][c]
    
    
    return result