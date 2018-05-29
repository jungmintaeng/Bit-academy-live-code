# LEGB Rules

# 1. Local
# 2. Enclosing Function(내포한 함수)
# 3. Global
# 4. Built in

a = 1   # global


def f():
    # b = 1
    def g():
        b = 100
        print(b)
        print(__name__)
    #  b = 20
    g()


f()

