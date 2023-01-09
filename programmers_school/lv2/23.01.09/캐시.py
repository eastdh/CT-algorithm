def solution(cacheSize, cities):
    if cacheSize == 0:
        return 5*len(cities)
    cache = []
    used = []
    time = 0
    for c in cities:
        c = c.lower()
        used = list(map(lambda x: x+1, used))
        if c in cache: # cache hit
            time += 1
            idx = cache.index(c)
            used[idx] = 0
        else: # cache miss
            time += 5
            if len(cache) < cacheSize:
                cache.append(c)
                used.append(0)
            else:
                idx = used.index(max(used))
                cache[idx] = c
                used[idx] = 0
        #print(c, ':', cache, used)
        
    
    return time