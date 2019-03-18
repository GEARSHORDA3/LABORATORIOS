package shapes;
import java.awt.*;
import java.awt.geom.*;

/**
 * A circle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0.  (15 July 2000) 
 */

public class Circle extends Figure{

    public static double PI=3.1416;
    //public String color;
    /**
     * Create a new circle at default position with default color.
     */
    public Circle(){
        diameter = 15;
        xPosition = 0;
        yPosition = 0;
        color = "blue";
        isVisible = false;
    }
    
    public void setXYposition2(double x, double y){
        xPosition=(int) x;
        yPosition=(int) y;
    }    
    
    public int getPositionX(){
        return xPosition;
    }
    
    public int getPositionY(){
        return yPosition;
    }
    //
    public void setPositionX(double a){
        xPosition+=a;
    }
    
    public void setPositionY(double b){
        yPosition+=b;
    }    
    /**
     * Change the size.
     * @param newDiameter the new size (in pixels). Size must be >=0.
     */
    public void changeSize(int newDiameter){
        erase();
        diameter += newDiameter;
        draw();
    }
    /*
     * Draw the circle with current specifications on screen.
     */
    protected void draw(){
        if(isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, 
                new Ellipse2D.Double(xPosition, yPosition, 
                diameter, diameter));
            canvas.wait(10);
        }
    }
}