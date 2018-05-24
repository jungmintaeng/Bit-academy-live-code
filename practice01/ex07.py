money = int(input('금액 : '))
money_list = [50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1]

for m in money_list:
    print(str(m) + '원 : ' + str(money // m) + "개")
    money = money % m
