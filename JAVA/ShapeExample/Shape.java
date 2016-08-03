/**
 *  Shape class
 *  Developer: Luis Regus
 *  Class Introduction to Java
 *  Date: 06/22/2016
 *  Description: Base class for shapes like triangles, rectangles etc 
 *    
 */

public class Shape {
    private String color;

    /**
     *  Secondary constructor
     *  Sets the color of the shape
     *
     *  @param color string defining the shape's color
     */
    public Shape(String color) {
        this.color = color;
    }

    /**
     *  Gets the color of the shape
     *
     *  @return the color of the shape as a string
     */
    public String getColor() {
        return this.color;
    }

    /**
     *  Base area method
     *
     *  @return 0 for the base shape
     */
    public double area() {
        return 0.0;
    }

    /**
     *  Base toString method
     *
     *  @return a string specifying that the object has a generic shape
     */
    public String toString() {
        return "generic shape";
    }
}
