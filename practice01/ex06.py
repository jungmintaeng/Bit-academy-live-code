import random
given_list = []
x3_list = []
for i in range(20):
    given_list.append(random.randrange(1, 100))

for i in given_list:
    if i % 3 == 0:
        x3_list.append(i)

print('리스트')
print(given_list)
print("주어진 리스트에서 3의 배수의 개수 =>", len(x3_list))
print("주어진 리스트에서 3의 배수의 합 =>", sum(x3_list))
