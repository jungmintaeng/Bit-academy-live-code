# 파일 입출력

# 파일 입출력 모드
# r:읽기모드 w:쓰기모드 a:이어쓰기 +:읽기,쓰기모드 t:텍스트모드 b:바이너리모드
# default 는 읽기모드

# text 모드가 default : w로 쓰면 wt로 되어있는거야
f = open("text.txt", 'w', encoding='utf-8')
write_size = f.write('안녕하세요\n정민입니다.')
print(write_size)
f.close()

# binary mode
f = open("btext.txt", 'wb')
write_size = f.write(bytes('안녕하세요\n정민입니다.', encoding='utf-8'))
print(write_size)
f.close()

# read test
f = open("btext.txt", 'r', encoding='utf-8')
print(f.read())
f.close()

# copy binary file
f = open('naeun.jpg', 'rb')
byte_data = f.read()
f.close()
f = open('copynaeun.jpg', 'wb')
f.write(byte_data)
f.close()




