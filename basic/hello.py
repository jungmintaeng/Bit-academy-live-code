import keyword

print("Hello World")

# 변수 이름은 문자, 숫자, _으로 구성해야 한다.
friend = 1
a = 10
my_name = "신정민"
myName = "신정민"
_yourName = "둘리"
member1 = "도우너"

# 예약어는 변수 이름으로 사용할 수 없다.

# friend$ = 1
# a! = 10
# @myName = "신정민"
# 1abc = 10
# def = 10

# 예약어 알아보기
print(keyword.kwlist)
print(len(keyword.kwlist))

# 한글 변수도 사용 가능하다.
가격1 = 2000
print(가격1-200)