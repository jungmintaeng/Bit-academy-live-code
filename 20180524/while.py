count = 1
while count < 11:
    print(count, end=' ')
    count += 1
else:
    print('')

# 1 ~ 10까지 합
s, i = 0, 1
while i <= 10:
    s += i
    i += 1
print('합: {0}'.format(s))

# break, continue, else
i = 0
while i < 10:
    i += 1
    if i < 5:
        continue
    print(i, end=' ')
    
    if i > 10:
        break
else:
    print('break 안탐')
    

# 무한루프
i = 0
while True:
    print("무한루프")
    i += 1
    if i > 100:
        break
