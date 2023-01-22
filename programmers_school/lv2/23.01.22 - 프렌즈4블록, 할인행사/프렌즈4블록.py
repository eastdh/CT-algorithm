def boom(board, x, y):
    if board[x][y] != '' and board[x][y] == board[x][y + 1] == board[x + 1][y] == board[x + 1][y + 1]:
        return True
    return False


def downable(board):
    for row in range(1, len(board))[::-1]:
        for col in range(len(board[0])):
            if board[row][col] == '' and board[row - 1][col] != '':
                return True
    return False


def down(board):
    changed = False
    while downable(board):
        for row in range(1, len(board)):
            for col in range(len(board[0])):
                if board[row][col] == '' and board[row - 1][col] != '':
                    board[row][col], board[row - 1][col] = board[row - 1][col], board[row][col]
                    changed = True
    return board, changed


def print_board(board):
    for row in board:
        for c in row:
            if c == '':
                print('-', end="")
            print(c, end="")
        print()
    print()
    print()


def solution(m, n, board):
    answer = 0
    board = list(map(list, board))

    while True:
        boomed = [[False for _ in range(n)] for _ in range(m)]
        for x in range(m - 1):
            for y in range(n - 1):
                if boom(board, x, y):
                    boomed[x][y] = True
                    boomed[x + 1][y] = True
                    boomed[x][y + 1] = True
                    boomed[x + 1][y + 1] = True
        # print_board(board)
        for x in range(m):
            for y in range(n):
                if boomed[x][y]:
                    board[x][y] = ''
                    answer += 1
        # print_board(board)
        board, changed = down(board)
        # print_board(board)
        # print("+" * 10)
        if changed:
            continue
        break
    return answer


print(solution(10, 10, ["DDABBAABBA",
                        "AAAAAABBBA",
                        "DDACCBBBAA",
                        "DDABBBBBAA",
                        "AAABBABBBA",
                        "CCADDAABBB",
                        "CCADDAABBB",
                        "BBACCABBBA",
                        "BBAAABBBAA",
                        "DDABBBBAAA"]))  # for test_case 10, expected 86
