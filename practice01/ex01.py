# ex1
user_input = input('수를 입력하세요 : ')
if not user_input.isdigit():
    print('정수가 아닙니다.')
elif int(user_input) % 3 == 0:
    print('3의 배수입니다.')
else:
    print('3의 배수가 아닙니다.')

