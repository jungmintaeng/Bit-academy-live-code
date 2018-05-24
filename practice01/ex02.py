# ex2
user_input = input('수를 입력하세요 : ')
if not user_input.isdigit():
    print('정수가 아닙니다.')
elif int(user_input) % 2 != 0:
    print('홀수')
else:
    print('짝수')
