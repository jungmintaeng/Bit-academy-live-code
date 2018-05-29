# set 생성
s = {1, 2, 3}
print(s, type(s))

# 기본연산
print(len(s))
print(2 in s)
print(2 not in s)

# list의 중복되는 항목을 제거할 때 유용
l2 = [1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3]
l2 = list(set(l2))
print(l2)

# 메서드
s.add(4)
s.add(1)
s.discard(2)
s.remove(3)
s.update({2, 3})
s.clear()

# 수학의 집합연산
s1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
s2 = {10, 20, 30}

s3 = s1.union(s2)
print(s3)

s4 = s1.intersection(s2)
print(s4)

s4 = s1.difference(s2)
print(s4)

s5 = s1.symmetric_difference(s2)
print(s5)

print(s1.issuperset(s4))
print(s5.issuperset(s1))
print(s2.issubset(s3))
