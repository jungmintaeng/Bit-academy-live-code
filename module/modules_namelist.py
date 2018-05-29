# 한 번이라도 import한 모듈은 dict 타입인 sys.modules 변수에 저장되어 있다.

import mod_a
import mod_b
import mymod
import mymod2
import sys

for key in sys.modules.keys():
    print(key)
