# 객체의 대소 비교하는 연산
print(1 > 3)
print(2 < 4)

print(4 <= 5)
print(5 >= 4)

print(6 == 9)
print(6 != 9)

# 복합 관계식 지원
a = 6
print(0 < a and a < 10)
print(0 < a < 10)

# 수치형 이외의 다른 타입의 객체
print("abcd" > "abd")
print((1, 2, 4) < (1, 3, 1))
print([1, 3, 2] > [1, 2, 0])

# 동질성 비교 : ==, 동일성 : is
a = 10
b = 20
c = a
print(a == b)
print(a == c)
print(a is c)

# 비어있으면 뒤에 출력하장
print([] or 'logical')
print('' or 'operator')
print(None and 1)
print(None or '')
print(a if b < a else b)

s = "Hello World"
s = ""
s and print(s)
