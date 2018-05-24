# 산술 연산자 우선순위

# 1. +, -  (단항 연산자)        <-
# 2. **                         <-
# 3. *, /, %, //                ->
# 4. +, -  (더하기, 빼기)       ->

# 사칙연산
print(2 * 3)
print(2 + 3)
print(2 - 3)

print(2 / 3)
print(2 / 3.0)
print(2.0 / 3)
print(2.0 / 3.0)

# // : 몫 연산자, ** : 지수 연산자, % : 나머지 연산
print(2 // 3)
print(2 ** 3)
print(2 % 3)

# divmod() 함수
print(divmod(2, 3))
print(2 + 3 * 4)
print(-2 + 3 * 4)

print(4 / 2 * 2)

# 결합 순서 주의
print(2 ** 3 ** 4)
print((2 ** 3) ** 4)

