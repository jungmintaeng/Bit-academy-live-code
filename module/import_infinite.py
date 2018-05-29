import sys
import mod_a
print("import infinitely")
print('코드 상으로는 mod_a <--> mod_b 간 무한 import가 일어날 것 같지만 실제로는 그렇지 않다.')

# import 된 모듈 열거
for key in sys.modules.keys():
    print(key)

# mod_a, mod_b 둘 다 import 된 것을 확인할 수 있다.
