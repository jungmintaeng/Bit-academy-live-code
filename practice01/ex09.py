def reverse(s):
    result = ''
    for i in range(len(s) - 1, -1, -1):
        result += s[i]
    return result


s = input('입력 > ')
print('결과 >', reverse(s))