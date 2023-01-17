def solution(record):
    log, uid = [], dict()
    for r in record:
        act = r.split()[0]
        user = r.split()[1]
        if act == "Enter" or act == "Change":
            nick = r.split()[2]
            uid[user] = nick
        log.append([act, user])
    
    answer = []
    for l in log:
        act, user = l
        if act == "Enter":
            msg = uid[user]+"님이 들어왔습니다."
        elif act == "Leave":
            msg = uid[user]+"님이 나갔습니다."
        else:
            continue
        answer.append(msg)
    
    return answer