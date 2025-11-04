abstract class Shape {
    abstract void draw();
}
class Circle extends Shape{
    void draw(){
        System.out.println("Нарисовали круг");
    }
}
class Rectangle extends Shape{
    void draw(){
        System.out.println("Нарисовали прямоугольник");
    }
}