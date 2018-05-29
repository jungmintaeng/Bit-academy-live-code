import sys
# print() 연습
print(1)  # 객체 넣어주면 출력한다!
print('hello', 'world')

# 여러 인자를 통한 출력
x = 0.2
s = "hello"

print(x)
print(s)
print(x, s)
print(x, s, sep=",")
print(str(x) + "," + "s")
# sep parameter 대신에 + 연산을 통해 잇는 방법이 있지만 + 연산의 left operand가 연산자 오버로딩이 되어 있어야 한다.
# 위는 str 객체의 + 연산이 오버로딩 되어있기 때문에 가능한 것.

# sep, end 키워드 파라미터 지정
print(x, s, sep=',', end='')

# 기본적인 print() 호출은
print(sep=' ', end='\n')
# 이다.

# file parameter 지정
print('Hello World', file=sys.stdout)   # 콘솔
print('Hello ERROR', file=sys.stderr)   # 콘솔 에러


f = open('hello.txt', 'w')
f.write('Hello World')
f.close()

# 참고
sys.stdout.write('Hello world Sysout')

