menu = input('메뉴: ')
price_dict = {'오뎅': 300, '순대': 400, '만두': 500}
if menu in price_dict:
    price = price_dict[menu]
else:
    price = 0
print('가격: {0}'.format(price))