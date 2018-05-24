a = 1.2
print(type(a))
print(isinstance(a, float))
print(a.is_integer())

# 객체 함수 is_integer()는 실수 타입 객체의 값이 정수인지 판별한다. 타입 판별함수가 아니다.
b = 2.0
print(type(b))
print(isinstance(b, float))
print(isinstance(b, int))
print(b.is_integer())

# 다른 언어처럼 소수점이나 e, E 로 지수 표현이 가능하다
b = 3e3
c = -0.2e-4
print(a, b, c)
print(type(c))
