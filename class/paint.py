from point import Point


def main():
    bound_instance_method()
    test_unbound_class_method()


def bound_instance_method():
    p = Point()
    p.set_x(10)
    p.set_y(10)
    print(p.get_x(), p.get_y(), sep=',')


def test_unbound_class_method():
    p = Point()
    Point.set_x(p, 20)
    Point.set_y(p, 20)
    print(Point.get_x(p), Point.get_y(p), sep=',')


if __name__ == '__main__':
    main()

