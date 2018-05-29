# help 함수

help(print)


def plus(a, b):
    return a + b


plus.__doc__ = """
    Returns the sum of two parameters.
    :param a : 1st parameter
    :param b : 2nd parameter
    :return sum
"""
help(plus)


print(plus.__doc__)
print(plus.__name__)
