# import를 사용하지 않고 코드에서 동적으로 import가 가능하다
m = __import__('mymath')

print(m.pi)
print(m.add(10, 20))
print(m.area_circle(10))

