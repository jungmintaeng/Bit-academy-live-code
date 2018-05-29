# 클래스 정의 테스트


class MyString:
    pass


s = MyString()  # 생성자 부르듯이 인스턴스 생성
print(type(s))
print(MyString.__bases__)  # 부모 클래스들 출력

s2 = str()
print(type(s2))
print(str.__bases__)
