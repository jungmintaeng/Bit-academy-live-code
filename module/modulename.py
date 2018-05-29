# 모듈 이름 확인
# 모든 모듈은 모듈의 이름을 저장하고 있는 내장 변수 __name__을 가지고 있다.
import mymath as m

print('modulename.py의 모듈 이름 :', __name__)
print('mymod.py의 모듈 이름 :', m.__name__)

