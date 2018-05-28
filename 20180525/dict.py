# 사전 생성
d = dict()   # empty dict
print(d)

d = dict(one=1, two=2)  # keyword arguments
print(d)

d = dict([('one', 1), ('two', 2)])   # tuple list
print(d)

keys = ('one', 'two', 'three')
values = (1, 2, 3)
d = dict(zip(keys, values))
print(d)

print("# 사전 생성")
d = {'basketball': 5, 'baseball': 9}
print(d, type(d))

# 인덱싱 대신 키로 접근해야 한다.
print("# 인덱싱 대신 키로 접근해야 한다.")
print(d['basketball'])
print(d['baseball'])

# print(d + {'volleyball': 6}) # --> dict class의 + 연산자 오버로딩이 되어있지 않음

# 수정
print("# 수정")
d['volleyball'] = 6
print(d)

# 길이
print("# 길이 len(d)")
print(len(d))

# key 존재 여부
print('# key 존재 여부')
print('hello' in d)
print('baseball' in d)


# 사전의 키는 객체의 값에 따라 해싱해야 하기 때문에 수정이 불가능한 객체여야 한다.
d = {}
print(d)

d[True] = 'true'
d[10] = '10'
d["twenty"] = '20'
d[(1, 2, 3)] = '6'

print(d)

# 사전의 키들을 리스트로 반환
keys = d.keys()
print(keys)
print(type(keys))

for key in keys:
    print('{0}:{1}'.format(key, d[key]))

# 사전의 값들을 리스트로 반환
values = d.values()
print(values)
print(type(values))

# (key, values) 튜플의 리스트를 반환
items = d.items()
print(items)

# 값을 가져오는 메서드
phone = dict()
n = phone.get('둘리')
print(n)

n = phone.get('길동')
print(n)
# 에러
# n = phone['길동']

n = phone.get('길동', '000-0000-0000')
print(n)
print(phone)

n = phone.setdefault('길동', '000-0000-0000')
print(n)
print(phone)

n = phone.pop('둘리')
print(n)
print(phone)

n = phone.popitem()
print(n, type(n))
print(phone)

# 사전 업데이트와 전체 비우기
phone.update({'둘리': '010-1111-1111', '길동': '010-5555-5555'})
print(phone)

phone.clear()
print(phone)

# 사전 순회하기

d = {'c': 3, 'a': 1, 'b': 2}
for key in d:
    print(key, end=' ')

for key in d:
    print(str(key) + ":" + str(d[key]), end=' ')

for key in d:
    print("{0}:{1}".format(key, d[key]), end=' ')

for key in d.keys():
    print("{0}:{1}".format(key, d[key]), end=' ')

for key, value in d.items():
    print("{0}:{1}".format(key, value), end=' ')