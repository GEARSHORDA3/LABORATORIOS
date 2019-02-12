import java.awt.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */


 
public class Rectangle{

    private static int height;
    private static int width;
    private int xPosition;
    private int yPosition;
    private String color;
    private boolean isVisible;
    public int change=1;
    public int cambiaMedida=0;
    public int cambiaMedida2=0;
    public final static int AltoInicial=height;
    public final static int AnchoInicial=width;

    /**
     * Create a new rectangle at default position with default color.
     */
    public Rectangle(){
        height = 30;
        width = 120;
        xPosition = 70;
        yPosition = 15;
        color = "magenta";
        isVisible = false;
    }
    
    /**
     * Change the hight of square
     * @param  int a number
     */  
    
    public void changeHeightWidth(int a){
        height=a;
    }
    
    /**
     * Make this rectangle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Make this rectangle invisible. If it was already invisible, do nothing.
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Move the rectangle a few pixels to the right.
     */
    public void moveRight(){
        moveHorizontal(20);
    }

    /**
     * Move the rectangle a few pixels to the left.
     */
    public void moveLeft(){
        moveHorizontal(-20);
    }

    /**
     * Move the rectangle a few pixels up.
     */
    public void moveUp(){
        moveVertical(-20);
    }

    /**
     * Move the rectangle a few pixels down.
     */
    public void moveDown(){
        moveVertical(20);
    }

    /**
     * Move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void moveHorizontal(int distance){
        erase();
        xPosition += distance;
        draw();
    }

    /**
     * Move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void moveVertical(int distance){
        erase();
        yPosition += distance;
        draw();
    }

    /**
     * Slowly move the rectangle horizontally.
     * @param distance the desired distance in pixels
     */
    public void slowMoveHorizontal(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            xPosition += delta;
            draw();
        }
    }

    /**
     * Slowly move the rectangle vertically.
     * @param distance the desired distance in pixels
     */
    public void slowMoveVertical(int distance){
        int delta;

        if(distance < 0) {
            delta = -1;
            distance = -distance;
        } else {
            delta = 1;
        }

        for(int i = 0; i < distance; i++){
            yPosition += delta;
            draw();
        }
    }

    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void changeSize(int newHeight, int newWidth) {
        erase();
        height = newHeight;
        width = newWidth;
        draw();
    }
    
    /**
     * Change the color. 
     * @param color the new color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void changeColor(String newColor){
        color = newColor;
        draw();
    }

    /*
     * Draw the rectangle with current specifications on screen.
     */

    private void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition, width, height));
            canvas.wait(10);
        }
    }

    /*
     * Erase the rectangle on screen.
     */
    private void erase(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
    
    /**
     * blink the square .
     * @param number times to blink the square
     */
    public void blink (int times){
        for (int i=0; i<times;i++){
            Canvas canvas = Canvas.getCanvas();
            makeVisible();
            canvas.wait(700);
            makeInvisible();
            canvas.wait(700);
        }
        
    }
 
    /**
     * Calculate the perimeter of rectangle..
     * @param none
     */
    public void Perimeter(){
        System.out.println((2*height)+(2*width));
    }
    
    /**
     * Turn the square 90 degrees to the right.
     * @param heigth width
     */
    public void turn(){
        if (AltoInicial>AnchoInicial){
            cambiaMedida=height;
            cambiaMedida2=width;
            height=cambiaMedida2;
            width=cambiaMedida;
            if (change==1){
                moveVertical(height/2);
            }   
            if (change==2){
                draw();
            }
            else if (change==3){
                moveHorizontal(-height+(height/2));
            }
            else if (change==4){
                change=0;
                moveHorizontal(width/2);
                moveVertical(-width/2);
            }
            change+=1;
        }
        else{
            cambiaMedida=height;
            cambiaMedida2=width;
            height=cambiaMedida2;
            width=cambiaMedida;
            if (change==1){
                draw();
            }
            if (change==2){
                moveHorizontal(-height/2);
            }
            if (change==3){
                moveHorizontal(width/2);
                moveVertical(-width/2);
            }
            if (change==4){
                change=0;
                moveVertical(height/2);
            }
            change+=1;
        }
    }
}

