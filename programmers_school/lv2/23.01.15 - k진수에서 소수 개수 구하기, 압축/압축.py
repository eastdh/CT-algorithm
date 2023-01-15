def solution(msg):
    wordDic = dict()
    for i in range(1, 27):
        wordDic[chr(64+i)] = i
    dicNum = 27
    
    answer = []
    while msg:
        R = 1
        while R<=len(msg) and msg[:R+1] in wordDic:
            R += 1
        w = msg[:R]
        answer.append(wordDic[w])
        msg = msg[R:]
        c = ''
        if len(msg) != 0:
            c = msg[0]
            wordDic[w+c] = dicNum
            # print(w, c, wordDic[w], dicNum, w+c, sep='\t')
            dicNum += 1
        # else:
        #     print(w, c, wordDic[w], sep='\t')
        
    return answer