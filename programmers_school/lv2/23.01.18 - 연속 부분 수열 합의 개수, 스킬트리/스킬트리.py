def check(skill, tree):
    ok = True
    for s in skill:
        if s in tree:
            tree = tree[:tree.index(s)]
            ok = False
        elif ok:
            continue
        else:
            return False
    return True

def solution(skill, skill_trees):
    answer = 0
    skill = skill[::-1]
    for tree in skill_trees:
        if check(skill, tree):
            answer += 1
                
    return answer