def makeUpper(s, idx):
    if ord(s[idx]) >= 97 and ord(s[idx]) <= 122:
        return chr(ord(s[idx]) - 32)
    else:
        return s[idx]

def makeLower(s, idx):
    if ord(s[idx]) >= 65 and ord(s[idx]) <= 90:
        return chr(ord(s[idx]) + 32)
    else:
        return s[idx]

def isNextUpper(s, idx):
    return s[idx] == " " and s[idx+1] != " "

def isNextLower(s, idx):
    return s[idx] != " " and s[idx+1] != " "

def solution(s):
    newLine = ""
    newLine += makeUpper(s, 0)
        
    for idx in range(len(s)-1):
        if isNextUpper(s, idx):
            newLine += makeUpper(s, idx+1)
        elif isNextLower(s, idx):
            newLine += makeLower(s, idx+1)
        else:
            newLine += s[idx+1]
        
        
    answer = newLine
    return answer