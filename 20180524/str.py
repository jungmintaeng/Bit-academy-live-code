s = ''
str1 = 'hello world'
str2 = "hello world"
print(type(s), type(str1), type(str2))
print(isinstance(str2, str))

str3 = """ABCDEFG
abcdef
가나다라마
123456789"""
print(str3)

# 기본적으로  시퀀스형이므로 시퀀스의 연산(인덱싱, 슬라이싱, 연결(+), 반복(*), len(), in, not in) 등의 연산이 가능하다.

str1 = "First String"
str2 = "Second String"

print(str1 + str2)
print(str1 * 3)
print(str1[2])
print(str2[2:5])
print(len(str2))

# 문자열 객체의 내용은 변경 할수 없는 변경 불가(Immutable) 자료형이다.
# str1[0] = 'f'

# 문자열 객체와 정수형 객체는 + 연산을 할 수 없다.
name = "길동"
age = 40
# print("name: " + name + ", age:" + age)

# 문자열 서식(Formatting)을 사용하여 좀더 다양하게 표현할 수 있다.
# 위 문제의 해결법 -->
print("name: " + name + ", age: " + str(age))
print("name: " + name + ",age: " + format(age, "d"))
print("name: " + format(name, "s") + ",age: " + format(age, "d"))

# 튜플을 이용한 문자열 포매팅
f = 'name: %s, age: %d'
print(f % ('둘리', 20))
print(f % ('또치', 10))
print(f % ('도우넛', 30))

# 딕셔너리를 이용한 포매팅
f = 'name: %(name)s, age: %(age)d'
print(f)
print(f % {'name': '둘리', 'age': 20})
print(f % {'name': '또치', 'age': 10})
print(f % {'name': '도우넛', 'age': 30})

# 문자열 메서드

# 대소문자 관련 메소드
s = 'i like Python'
print(s.upper())
print(s.lower())
print(s.swapcase())
print(s.capitalize())
print(s.title())

# 검색 관련 메소드
s = 'I Like Python. I Like Java Also'
print(s.count('Like'))

print(s.find('Like'))
print(s.find('Like', 5))
print(s.find('JS'))
print(s.rfind('Like'))

# print(s.index('JS'))
print(s.rindex('Like'))  # 오른쪽에서부터의 인덱스
print(s.startswith('I Like'))  # 문자열 s가 해당 문자열로부터 시작하는지
print(s.startswith('Like', 2))  # 문자열 s의 2번인덱스부터 해당 문자로 시작하는지
print(s.endswith('Also'))  # 문자열 s가 문자열로부터 시작하는지
print(s.endswith('Java', 0, 26))  # 문자열 s의 0번부터 26번 인덱스까지가 Java 라는 글자로 끝나는지

# 편집과 치환
s = '          spam and ham            '
print(s.strip())  # 문자열 공백 뺴기
print(s.rstrip())  # 문자열 오른쪽 공백 빼기
print(s.lstrip())  # 문자열 왼쪽 공백 빼기

s = '<><abc><><defg><><>'
print(s.strip('<>'))  # 문자열 양쪽에 있는 <와 >를 전부 제거한다.

s = 'Hello Java'
print(s.replace('Java', 'Python'))

# 정렬 메서드
s = 'king and queen'
print(s.center(60))  # 60 길이의 문자열을 만들어 원래 문자열을 가운데로 정렬한다.
print(s.center(60, '-'))  # 문자열을 가운데로 정렬할 때 양쪽 빈 부분을 특정 문자로 채운다.
print(s.ljust(60, '-'))  # 왼쪽 정렬 후 특정 문자열로 빈 부분을 채움
print(s.rjust(60, '-'))  # 오른쪽 정렬 후 특정 문자열로 빈 부분을 채움

# 분리와 결합 메서드
s = 'Spam and Ham'
t = s.split()
print(t)

t = s.split(' and ')
print(t)

s2 = ':'.join(t)
print(s2)

s3 = 'one:two:three:four:five'
print(s3.split(':', 2))  # 왼쪽부터 두개만 쪼갬 (두 단어 외에 다른 문자열은 여전히 붙어 있음)
print(s3.rsplit(':', 2))  # 오른쪽부터 두개만 쪼갬

lines = '''1st line
2nd line
3rd line
4th line
'''
print(lines.split('\n'))  # 빈 문자열도 나눔
print(lines.splitlines())  # 빈 문자열은 뺴고 나눔

# 판별 메서드

print('1234'.isdigit())
print('abcd'.isalpha())

print('1234'.isalpha())  # 알파벳인지
print('abcd'.isdigit())  # 숫자인지

print('abcd'.islower())  # 소문자인지
print('ABCD'.isupper())  # 대문자인지

print('\n\n'.isspace())  # 공백이 있는지 판별 함수
print('    '.isspace())
print(''.isspace())  # 빈 문자열은 공백이 아니다.

print('20'.zfill(5))  # 길이가 5인 문자열을 만들어 나머지는 0로 채움 ( 숫자 )
print('1234'.zfill(5))

# 포매팅 매서드
f = 'name: {}, age: {}'
print(f)
print(f.format("둘리", 10))

print('name: {0}, age: {1}'.format('둘리', 10))
print('name: {1}, age: {0}'.format(30, '마이콜'))

print('{:3}의 제곱근은 {:.5}입니다.'.format(2, 2 ** 0.5))   # 자리수 포매팅. 3자리 ..2로 나옴 .5 는 소수점 4자리까지
print('{1:03}의 제곱근은 {0:.5}입니다.'.format(2 ** 0.5, 2))

f = "name: {name}, age: {age}"
print(f.format_map({'name': '도우넛', 'age': 10}))
