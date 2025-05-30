h, m = input().split()
h = int(h)
m = int(m)

if m-45<0: 
    m += 15
    if h == 0: h=23
    else: h -= 1
else: m -= 45

print(h, m)