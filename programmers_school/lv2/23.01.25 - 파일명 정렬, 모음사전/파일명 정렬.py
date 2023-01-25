def solution(files):
    new_files = []
    for f in files:
        head, number, tail = "", "", ""
        numON = False
        tailON = False
        for c in f:
            if not numON: # if HEAD is not over
                if not c.isdigit(): # if c is HEAD
                    head += c
                else: # if c is NUMBER
                    numON = True
                    number += c
            else: # if HEAD is over
                if not tailON: # if NUMBER is not over
                    if c.isdigit(): # if c is NUMBER
                        number += c
                    else: # if c is a head of TAIL
                        tailON = True
                        tail += c
                else: # if NUMBER is over (== if c is TAIL)
                    tail += c
        new_files.append([head, number, tail])
    # print(new_files)
    
    files_dict = dict()
    for n in new_files:
        if n[0].lower() not in files_dict:
            files_dict[n[0].lower()] = [n]
        else:
            files_dict[n[0].lower()].append(n)
    key_list = sorted(files_dict.keys()) # sort with HEAD
    answer = []
    for k in key_list:
        files_dict[k].sort(key = lambda x: int(x[1])) # sort with NUMBER
        for item in files_dict[k]:
            answer.append("".join(item))
    # print(files_dict)            
    
    return answer