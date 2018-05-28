# 튜플 생성
t = ()  # 공튜플
t = (1,)  # 항목이 하나일 때에는 반드시 뒤에 콤마를 붙여주어야 한다.
t = (1)  # --> Integer자나

t = (1, 2, 3)
print(type(t))

#
# 시퀀스형 지원 연산
#

# 인덱싱
print(t[-3], t[-2], t[-1], t[0], t[1], t[2])

# 길이
print(len(t))

# 확인
print(5 in t)

# 튜플은 변경 불가능이다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
t = ('apple', 'banana', 10, 20)
# t[2] = 90

# 튜플을 이용해서 좌우변에 여러개의 값을 치환(대입)할 수 있다.
x, y, z = 10, 20, 30
print(x, y, z)

# 튜플을 잉룡해서 값을 바꾸는 작업
x, y = 10, 20
print(x, y)
x, y = y, x
print(x, y)

# 튜플은 객체 함수가 많지 않다. : immutable 이기 때문에
t = (20, 30, 10, 20)
print(t.index(20))
print(t.count(20))

# 변환
t = (1, 2, 3)
tset = set(t)
print(tset, type(tset))

tlist = list(t)
print(tlist, type(tlist))

t = tuple(tlist)  # 다시 튜플로 변환 가능하다.
print(t, type(t))

