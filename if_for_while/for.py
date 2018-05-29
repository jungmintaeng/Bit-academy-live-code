# for 반복문
a = ['cat', 'cow', 'tiger']

# for문에서의 else는 break가 아닌 정상적으로 반복문을 탈출하였을 때 실행되는 블록이다.
for animal in a:
    print(animal)
else:
    print("끗")

for i in range(10):
    if i == 5:
        break
    print(i)
else:
    print("정상 종료")

# 복합 자료형을 사용하는 for 문
l = [('둘리', 10), ('마이콜', 16), ('도우너', 12)]
for data in l:
    print('이름 : %s, 나이 : %d' % data)

for name, age in l:
    print('이름 :', name, '/ 나이 :', age)

for name, age in l:
    print('이름 : {0}, 나이 : {1}'.format(name, age))

l = [{'name': '둘리', 'age': 10}, {'name': '고길동', 'age': 43}, {'name': '마이콜', 'age': 16}]
for data in l:
    print('이름:%(name)s, 나이:%(age)d' % data)

# 1 ~ 10 합 구하기
s = 0
for i in range(1, 11):
    s += i
print(s)

# break
for i in range(10):
    if i > 5:
        break
    print(i, end=' ')
else:
    print('')

# continue
for i in range(10):
    if i <= 5:
        continue
    print(i, end=' ')

# 구구단
for i in range(1, 10):
    for j in range(1, 10):
        print(str(i) + " x " + str(j) + " = " + str(i*j))
    print('')

# 삼각형
for i in range(0, 10):
    for j in range(0, i+1):
        print('*', end='')
    print('')

# 역삼각형
for i in range(9, 0, -1):
    for j in range(i, 0, -1):
        print('*', end='')
    print('')

# 삼각형 별해 - 중첩 for문 안쓰고
# 1) 삼각형
print('과제 삼각형')
for i in range(1, 10):
    print('*' * i)
# 2) 역삼각형
print('과제 역삼각형')
for i in range(9, 0, -1):
    print('*' * i)
# 3) 이등변 삼각형
print('이등변 삼각형')
for i in range(1, 11, 2):
    print(('*' * i).center(10))
# 4) 역 이등변 삼각형
print('역 이등변 삼각형')
for i in range(9, 0, -2):
    print(('*' * i).center(10))
