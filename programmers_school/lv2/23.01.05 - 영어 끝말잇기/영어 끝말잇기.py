def solution(n, words):
    wordList = []
    count = 0
    preWord = words[0][0]
    
    for w in words:
        print(count)
        if w in wordList or w[0] != preWord[-1]:
            num = count%n + 1
            time = count//n + 1
            return [num, time]
        wordList.append(w)
        preWord = w
        count += 1
        
    return [0, 0]