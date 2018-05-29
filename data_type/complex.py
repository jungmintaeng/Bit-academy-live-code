# 복소수는 실수부 + 하수부
# 하수부는 j 또는 J를 숫자 뒤에 붙힌다
a = 4 + 5j
print(type(a))
print(isinstance(a, complex))

# 복소수는 연산이 가능하며 실수부와 하수부 값만 따로 참조할 수도 있다.
b = 7 - 2j
print(a+b)
print(b.real, b.imag)

# complex() 함수
p = 2.5
q = 3
print(complex(p, q))