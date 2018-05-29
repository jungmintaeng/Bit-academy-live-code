# if ~ else

a = 10
if a > 5:
    print('big')
else:
    print('small')

# if ~ else 에서 block을 비워두고 싶은 경우
# ex ) if(a>10){  ~~~    }else{ 비워두고 싶을 때 }
if a > 5:
    print('big')
else:
    pass

# if ~ elif ~ else
n = 10
if n > 0:
    print('양수')
elif n < 0:
    print('음수')
else:
    print('0')

# elif 여러개 사용도 가능하다
order = 'spam'
if order == 'spam':
    price = 100
elif order == 'egg':
    price = 500
elif order == 'spagetti':
    price = 2000

print(price)

# Condition Expression (tenary operator, 삼항 연산자)
# in java...
# a > 5 ? 'big' : 'small'
# in python...
a = 3
b = 1 if a > 5 else 0
print(b)