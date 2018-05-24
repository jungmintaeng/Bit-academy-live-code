# 리스트 생성
l = []
l = [1, 2, {'name': "정민", 'age': 5}]

# indexing
l = [1, 2, 'python']
print(l[-2], l[-1], l[0], l[1], l[2])
print(l[1:3])
print(l * 2)
print(l + [3, 4, 5])
print(len(l))
print(2 in l)

del l[0]
print(l)

# 리스트는 변경 가능(Mutable)한 자료형이다.
a = ['apple', 'banana', 10, 20]
a[2] = a[2] + 90
print(a)

# 슬라이스를 통한 치환
a = [1, 12, 123, 1234]

a[0:2] = [10, 20]
print(a)

a[0:2] = [10]
print(a)

a[1:2] = [20]
print(a)

a[2:3] = [30]
print(a)

# 슬라이스를 통한 삭제
a = [1, 12, 123, 1234]
a[1:2] = []
print(a)
a[0:] = []
print(a)

# 슬라이스를 통한 삽입
a = [1, 12, 123, 1234]

a[1:1] = ['a']
print(a)

a[5:] = [12345]
print(a)

a[:0] = [-12, -1, 0]
print(a)

# 리스트의 메서드
a = [1, 2, 3]
print(a)
a.append(5)  # a 의 뒤에 5를 삽입한다.
print(a)
a.insert(3, 4)  # 0번부터 시작. 리스트의 4번째 인덱스에 4를 삽입한다.
print(a)
print(a.count(2))  # 리스트 내에 2라는 요소의 숫자를 센다
a.reverse()  # a의 순서를 뒤집는다.
print(a)
a.sort()  # a를 정렬한다.
print(a)
a.remove(3)
print(a)
a.extend([6, 7, 8])
print(a)

# 리스트의 정렬
# 1) list 메소드 이용
l = [1, 5, 3, 9, 8, 4, 2]
l.sort()
print(l)
l.sort(reverse=True)
print(l)

l = [10, 2, 22, 9, 8, 33, 4, 11]
l.sort(key=str)
print(l)
l.sort(key=int)
print(l)

# 2) 내장 함수 이용
l2 = sorted(l, reverse=True)
print(l2)


def f(i):
    return i % 10


l2 = sorted(l, key=f, reverse=False)    # 1의 자리수로 정렬
print(l2)
