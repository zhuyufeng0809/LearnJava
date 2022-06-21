package LearnBasic;

public class AnonymousClass {
    public static void main(String[] args) {
        AnonymousDemo1 an1 = new AnonymousDemo1();
        an1.createClass();

        AnonymousDemo2 an2 = new AnonymousDemo2();
        an2.createClass();

        AnonymousDemo3 an3 = new AnonymousDemo3();
        an3.createClass();
    }
}

class Polygon1 {
    public void display() {
        System.out.println("在 Polygon 类内部");
    }
}

class AnonymousDemo1 {
    public void createClass() {
        // 创建的匿名类继承了 Polygon 类
        Polygon1 p1 = new Polygon1() {
            @Override
            public void display() {
                System.out.println("在匿名类内部");
            }
        };
        p1.display();
    }
}

interface Polygon2 {
    public void display();
}

class AnonymousDemo2 {
    public void createClass() {
        // 匿名类实现一个接口
        Polygon2 p1 = new Polygon2() {
            public void display() {
                System.out.println("在匿名类内部");
            }
        };
        p1.display();
    }
}

abstract class AbClass {
    public abstract void fuck();
}

class AnonymousDemo3 {
    public void createClass() {
        // 匿名类实现一个抽象类
        AbClass abClass = new AbClass() {
            @Override
            public void fuck() {
                System.out.println("fuck you");
            }
        };
    }
}