# packing은 tuple로만 가능
t = (10, 20, 30, 'python')
print(t, type(t))

# unpacking --> 튜플을 변수에 할당하기!!!!!!!!!!!!
a, b, c, d = t
print(a, b, c, d)

# a, b, c = t  # packing되어있는 객체가 더 많은 경우 오류
# print(a, b, c)

# unpacking extension *를 붙이면 packing되어 있는 객체가 더 많은 경우 나머지 객체를 모두 list로 할당한다.
t = (1, 2, 3, 4, 5)
a, *b = t
print(a, b, type(b))

a, b, *c = t
print(a, b, c, type(c))

a, *b, c = t
print(a, b, c, type(b))

*a, b = t
print(a, b, type(a))

# *a, *b = t
# print(a, b, type(a), type(b))
