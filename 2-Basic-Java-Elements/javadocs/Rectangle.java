/**
 * The {@code Rectangle} class represents a rectangle in a 2D coordinate system.
 * It includes methods to calculate the area and perimeter of the rectangle.
 */
public class Rectangle {

    /**
     * The length of the rectangle.
     */
    private double length;

    /**
     * The width of the rectangle.
     */
    private double width;

    /**
     * Constructs a new {@code Rectangle} instance with the specified length and width.
     *
     * @param length The length of the rectangle.
     * @param width  The width of the rectangle.
     */
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Gets the length of the rectangle.
     *
     * @return The length of the rectangle.
     */
    public double getLength() {
        return length;
    }

    /**
     * Sets the length of the rectangle.
     *
     * @param length The new length of the rectangle.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Gets the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle.
     *
     * @param width The new width of the rectangle.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Calculates and returns the area of the rectangle.
     *
     * @return The area of the rectangle.
     */
    public double calculateArea() {
        return length * width;
    }

    /**
     * Calculates and returns the perimeter of the rectangle.
     *
     * @return The perimeter of the rectangle.
     */
    public double calculatePerimeter() {
        return 2 * (length + width);
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.length = 2;
        rectangle.width = 1;
        rectangle.calculateArea();
    }
}