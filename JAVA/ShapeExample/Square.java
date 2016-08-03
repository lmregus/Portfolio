/**
 *  Square class
 *  Developer: Luis Regus
 *  Class: Introduction to Java
 *  Date: 06/22/2016
 *  Description: This class inherits from the shape class and represents a square object
 */

public class Square extends Shape {
    private double length;

	/**
     *  Secondary constructor
     *  Sets the color and length of the square
     *
     *  @param color the color of the square
     *  @param length the length of the square
     */
    public Square(String color, double length) {
        super(color);
        this.length = length;
    }

	/**
     *  Returns the area of the square
     *  length^2
     *
     *  @return the area of the square defined by the previous formula
     */
    public double area() {
        Double area = this.length * this.length;
        return area;
    }

	/**
     *  Returns a description of the square
     *  Includes color, length and area
     *
     *  @return a string with the description of the square
     */
	public String toString() {
        return super.getColor() + " Square with length of " + Double.toString(this.length) + " and area of " + Double.toString(this.area());
    }
}
