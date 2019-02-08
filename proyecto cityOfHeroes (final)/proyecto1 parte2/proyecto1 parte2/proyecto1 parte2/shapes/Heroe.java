 



import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Collections;
import java.awt.Toolkit; 
import java.util.ArrayList;
import java.util.ArrayList;
/**
 * Write a description of class Heroe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Heroe
{
    // instance variables - replace the example below with your own
    private int strength;
    private Circle heroe;
    private int hidingBuilding;
    private ArrayList<Building>Builds;
    private double posicionY;
    private double posicionX;
    private int h;
    private double vox=0;
    private double voy=0;    
    private double vo;   
    private double y;
    private double PosiXParaHero;
    private double PosiYParaHero;
    private double x;
    private double t=0;
    // private static Heroe heroeSingleton;
    
    /**
     * Add a Heore
     *
     * @param  color,hidingBuilding,strength
     * @return void
     */
    public Heroe(String color,int hidingBuilding, int strength, int x, int y, int edificioX){
        this.strength=strength;
        this.hidingBuilding=hidingBuilding;
        heroe= new Circle ();
        heroe.changeColor(color);
        heroe.setXYposition(x+((edificioX/2)-8),y-19);
       
        
    }
    

    /**
     * Remove a heroe
     *
     * @param     Object Building
     * @return    void
     */
    public void removeHeroe(Object Building)
    {
         heroe.makeInvisible();  
    }
    
    /**
     * get color heroe
     *
     * @param  Object Building
     * @return color
     */
    public String getHeroeColor(Object Building)
    {
        return heroe.getColor();
    }
    
    /** Move the heroe in form of parabolic
     * 
     * @param String color, int angulo, int velocidad
     * @return void
     */
     public void Jump(String color, int angulo, int velocidad,int alturaEdi, int posy, int posx, int altoCanvas, double avance,boolean isVisible)
    {        
        h=alturaEdi;
        vo=velocidad/4;
        voy= vo*Math.sin(-angulo);
        vox= vo*Math.cos(angulo);
        angulo*=Math.PI;
        angulo/=180;
        heroe.setXYposition(posicionX,posicionY);
        posicionY=posy;
        posicionX=posx;
        h=h/3; 
        while (y>-posicionY){
            t+=avance;
            y=((posicionY)-(voy*t) + (4.9*(t*t)));
            if (y>=altoCanvas-15){
               Toolkit.getDefaultToolkit().beep();
               JOptionPane.showMessageDialog(null, "El heroe de color " +color +" ha muerto");                
               return;
            }
            else if (y<=-posicionY){
               Toolkit.getDefaultToolkit().beep();
               JOptionPane.showMessageDialog(null, "El heroe de color " +color +" ha muerto");
                   return;                
            }
            x= Math.abs(vox*t);
            t+=avance;
            posicionX+=(x/2);
            posicionY=y;
            heroe.setXYposition(posicionX,posicionY);
            if (isVisible==true){
                heroe.makeVisible();
            };
        } 
         
    }
    public int getxPosition(){
        return heroe.getPositionX();
    }
    
    public int getyPosition(){
        return heroe.getPositionY();
    }    
    
    public void setXYposition(double x, double y){
        heroe.setPositionX(x);
        heroe.setPositionY(y);
    }  
    
    public void makeVisible(){
        heroe.makeVisible();
    }
    
    public void makeInvisible(){
        heroe.makeInvisible();
    }
    
    

}