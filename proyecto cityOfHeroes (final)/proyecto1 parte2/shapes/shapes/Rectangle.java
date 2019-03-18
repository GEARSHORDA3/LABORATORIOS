package shapes;
import java.awt.*;

/**
 * A rectangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes (Modified)
 * @version 1.0  (15 July 2000)()
 */


 
public class Rectangle extends Figure{


    /**
     * Create a new rectangle at default position with default color.
     */
    public Rectangle(){
        height = 30;
        width = 40;
        xPosition = 0;
        yPosition = 0;
        color = "magenta";
        isVisible = false;
    }
    
    public void setXposition(int a){
        xPosition+=a;
    }
    
    public void setYposition(int b){
        yPosition+=b;
    }
    
    public void changeSize2(int newHeight, int newWidth) {
        erase();
        height += newHeight;
        width += newWidth;
        draw();
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
    /*
     * Draw the rectangle with current specifications on screen.
     */

    protected void draw() {
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color,
                new java.awt.Rectangle(xPosition, yPosition, width, height));
            canvas.wait(10);
        }
    }
    
    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }
    
    public int getxPosition(){
        return xPosition;
    }
    
    public int getyPosition(){
        return yPosition;
    }
    
    public void setxPosition(int xPosition2){
        xPosition+=xPosition2;
    }
    
    public void setyPosition(int yPosition2){
        yPosition+=yPosition2;
    }
    
    public void setNewYPosition(int yPosition2){
        yPosition=yPosition2;
    }
    
    public void setWidth(int width2){
        width+=width2;
    }
    
    public void setHeight(int height2){
        height+=height2;
    }
    
    /**
     * Change the size to the new size
     * @param newHeight the new height in pixels. newHeight must be >=0.
     * @param newWidht the new width in pixels. newWidth must be >=0.
     */
    public void onlyChangeSize(int newHeight, int newWidth) {
        height += newHeight;
        width  += newWidth;
    }
}

