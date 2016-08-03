/**
 *  Circle class
 *  Developer: Luis Regus
 *  Class: Introduction to java
 *  Date: 06/22/2016
 *  Description: This class inherits from the shape class and represent a circle object
 */

public class Circle extends Shape {
    private double radius;

    /**
     *  Secondary constructor
     *  Sets the color and radius of the circle
     *
     *  @param color the color of the circle
     *  @param radius the radius of the circle
     */
    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    /**
     *  Returns the area of the circle
     *  PI * (radius^2)
     *
     *  @return area the area of the circle defined by the previous formula
     */
    public double area() {
        Double area = Math.PI * Math.pow(this.radius, 2);
        return area;
    }

    /**
     *  Returns a description of the circle
     *  Includes color, radius and area
     *
     *  @return a string with the description of the circle
     */
    public String toString() {
        return super.getColor() + " Circle with radius of " + Double.toString(this.radius) + " and area of " + String.format("%.5f",this.area());
    }
}
