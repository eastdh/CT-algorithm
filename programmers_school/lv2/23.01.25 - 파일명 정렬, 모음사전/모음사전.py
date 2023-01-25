def make_word(length, before):
    global dictionary
    if len(before) == length:
        dictionary.add(before)
        return
    moeum = ['A', 'E', 'I', 'O', 'U']
    for m in moeum:
        make_word(length, before+m)
    
    
def solution(word):
    global dictionary
    dictionary = set()
    for L in range(1, 6):
        make_word(L, "")
    dict_list = sorted(list(dictionary))
    print(len(dict_list))
    return dict_list.index(word)+1