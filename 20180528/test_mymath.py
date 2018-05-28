# mymath module test
import sys

# 절대 경로
sys.path.append(r'C:\cafe24\PythonPractice\python_modules')
# 상대 경로
# sys.path.append('../../python_modules')

import mymath

print(mymath.pi)
print(mymath.add(10, 20))
print(mymath.area_circle(10))
