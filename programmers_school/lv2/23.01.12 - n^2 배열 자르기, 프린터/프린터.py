def solution(priorities, location):
    idx = list(range(len(priorities)))
    for L in range(len(priorities)):
        new_p = priorities[L:]
        new_i = idx[L:]
        if new_p[0] != max(new_p):
            M = new_p.index(max(new_p))
            new_p = new_p[M:] + new_p[:M]
            new_i = new_i[M:] + new_i[:M]
            priorities = priorities[:L] + new_p
            idx = idx[:L] + new_i
    return idx.index(location) + 1