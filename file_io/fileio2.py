# 다양한 파일 입출력 함수
f = open('text.txt', 'r', encoding='utf-8')
text = f.read()
print(text)
text = f.read()
print("--", text, "--", sep='')  # 또읽으면 빈거나옴

# position 단위는 byte
pos = f.tell()  # 현재 파일에서 커서 위치를 출력
print(pos)

# position 이동
f.seek(16)  # 0번부터 가능. 인자를 아무것도 안주면 0으로 이동
print(f.read())

f.close()

#
line_num = 1
f = open('fileio2.py', 'r', encoding='utf-8')
while True:
    data = f.readline()
    if data is '':
        break
    print('{0} {1}'.format(str(line_num), data), end='')
    line_num += 1
f.close()

f = open('fileio2.py', 'r', encoding='utf-8')
fdata = f.readlines()
print(fdata)
f.close()

for line in fdata:
    print(line, end='')

# with ~ as 구문을 활용한 자동 자원 정리 --> 명시적으로 close를 호출하지 않아도 된다.
with open('fileio.py', 'r', encoding='utf-8') as f:
    print(f.readlines())





