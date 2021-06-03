package rank6kyu._sortableShapes;

public class Shape implements Comparable<Shape>{

    public static void main(String[] args) {
        System.out.println(1222);
    }

    protected double area;

    void setArea(double area) {
        this.area = area;
    }

    @Override
    public int compareTo(Shape o) {
        return Double.compare(area, o.area);
    }


    public class Triangle extends Shape  {
        public Triangle(double side, double height) {
            setArea(0.5 * side * height);
        }
    }

    public class CustomShape extends Shape  {
        public CustomShape(double area) {
            setArea(area);
        }
    }

    public class Rectangle extends Shape  {
        public Rectangle(double side, double base) {
            setArea(side * base);
        }
    }

    public class Circle extends Shape  {
        Circle(double radius) {
            setArea(Math.PI * radius * radius);
        }
    }

    public class Square extends Shape  {
        Square(double side) {
            setArea(side * side);
        }
    }
}