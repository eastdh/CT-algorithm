import math
def solution(fees, records):
    time_of_num = dict()
    for r in records:
        time, num, act = r.split()
        t_hour, t_min = list(map(int, time.split(':')))
        t_min += t_hour*60
        if num not in time_of_num:
            time_of_num[num] = [0, -1]
        if act == "IN":
            time_of_num[num][1] = t_min
        else:
            time_spent, in_time = time_of_num[num]
            time_of_num[num] = [time_spent+(t_min-in_time), -1]
    #print(time_of_num)
    
    end_of_day = 23*60 + 59
    for num in time_of_num.keys():
        time_spent, in_time = time_of_num[num]
        if in_time != -1:
            time_of_num[num] = [time_spent+(end_of_day-in_time), -1]
            
    time_list = [[x, time_of_num[x][0]] for x in time_of_num.keys()]
    time_list.sort(key = lambda x: x[0])
    #print(time_list)
    
    answer = []
    std_min, std_won, per_min, per_won = fees
    for t in time_list:
        time = t[1]
        if time <= std_min:
            answer.append(std_won)
        else:
            won = std_won + math.ceil((time-std_min)/per_min)*per_won
            answer.append(won)
        
    return answer