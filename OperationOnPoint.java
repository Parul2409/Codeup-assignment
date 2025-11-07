import java.util.*;
class coordinate{
    int x;
    int y;
    coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Base{
    private int x;
    private int y;
    // default constructor
    Base(){
        x = 0;
        y = 0;
    }
    // To initialize the value of x and y.
    Base(int x, int y){
        this.x = x;
        this.y = y;
    }
    // find the distance between self and other point.
    double distance(int x, int y){
        return Math.sqrt(((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y)));
    }

    coordinate translate(int x, int y){
        return new coordinate((x + this.x), (y + this.y));
    }
}

class Shape extends Base{
    double area(double pi, int radius){
        return (pi * radius * radius);
    }
    double area(int side){
        return (side * side);
    }
}

class Circle extends Shape{
    double area;
    Circle(double pi, int radius){
        this.area = area(pi, radius);
    }
}

class Sqare extends Shape{
    double area;
    Sqare(int side){
        this.area = area(side);
    }
}

public class OperationOnPoint{
    public static void main(String args[]){
        Base point = new Base(0, 0);
        double dist = point.distance(3, 4);
        System.out.println("distance btw points : " + dist);
        coordinate translate = point.translate(3,4);
        System.out.println("Translated coordinate is : " + translate.x +", " + translate.y);
        Circle obj = new Circle(3.1415, 5);
        System.out.printf("Area of circle is : %.2f%n", obj.area);
        Sqare obj1 = new Sqare(2);
        System.out.println("Area of circle is : " + obj1.area);
    }
} 