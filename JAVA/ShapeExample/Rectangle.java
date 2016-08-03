/**
 *  Rectangle class
 *  Developer: Luis Regus
 *  Class: Introduction to Java
 *  Date: 06/22/2016
 *  Description: This class inherits from the shape class and represents a rectangle object
 */

public class Rectangle extends Shape {
    private double length;
    private double width;

	/**
     *  Secondary constructor
     *  Sets the color, length and width of the rectangle
     *
     *  @param color the color of the rectangle
     *  @param length the length of the rectangle
	 *	@param width the length of the rectangle
     */
    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

	/**
     *  Returns the area of the rectangle
     *  length * width
     *
     *  @return the area of the rectangle defined by the previous formula
     */
    public double area() {
        Double area = this.length * this.width;
        return area;    
    }

	/**
     *  Returns a description of the rectangle
     *  Includes color, length, width and area
     *
     *  @return a string with the description of the rectangle
     */
    public String toString() {
        return super.getColor() + " Rectangle with length of " + Double.toString(this.length) + " and width of " + Double.toString(this.width) + " and area of " + Double.toString(this.area());
    }
}
