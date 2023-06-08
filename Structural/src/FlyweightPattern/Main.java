package FlyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Create and draw circles with different colors
        Shape redCircle = ShapeFactory.getCircle("red");
        redCircle.draw();

        Shape blueCircle = ShapeFactory.getCircle("blue");
        blueCircle.draw();

        Shape greenCircle = ShapeFactory.getCircle("green");
        greenCircle.draw();

        // Reuse the red circle instance
        Shape anotherRedCircle = ShapeFactory.getCircle("red");
        anotherRedCircle.draw();
    }
}


// Flyweight interface
interface Shape {
    void draw();
}

// Concrete flyweight class
class Circle implements Shape {
    private String color;

    public Circle(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("Drawing a " + color + " circle");
    }
}

// Flyweight factory class
class ShapeFactory {
    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        // Check if a circle with the given color exists in the map
        // If it exists, return the shared instance
        if (circleMap.containsKey(color)) {
            return circleMap.get(color);
        } else {
            // If it doesn't exist, create a new circle and add it to the map
            Shape circle = new Circle(color);
            circleMap.put(color, circle);
            return circle;
        }
    }
}

