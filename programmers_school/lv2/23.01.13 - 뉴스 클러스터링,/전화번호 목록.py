def solution(phone_book):
    phone_book.sort()
    for n in range(len(phone_book)-1):
        if phone_book[n+1].startswith(phone_book[n]):
            return False
    return True
        