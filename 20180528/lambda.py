# lambda 함수


def blahblah(x):
    return x * 2


for i in range(10):
    print('{0}:{1}'.format(i, blahblah(i)), end=' ')
else:
    print()

for i in range(10):
    print('{0}:{1}'.format(i, (lambda x: x * 2)(i)), end=' ')
else:
    print()


strings = ['foo', 'card', 'bar', 'abab', 'aaaa', 'abab', 'foo']
# 가지고 있는 'a'의 갯수로 정렬
strings.sort(key=lambda s: s.count('a'))
print(strings)

# 길이 순으로 정렬
strings.sort(key=lambda s: len(s))
print(strings)

