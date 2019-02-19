import java.util.ArrayList;
import java.util.Random;
import java.util.*;
/**
 * Crear un edificio en la ciudad
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Building
{
    private static final String colores[]={"red","yellow","blue","black","brown","magenta","green","grey","fucsia"};
    private int numero=0;
    private int nColores;
    private static int hardness;
    private Rectangle cuadrado;
    
    
    /**
     * Constructor for objects of class Building
     */
    public Building(int x, int width, int height, int hardness,int numero){
                        

                        Canvas canvas = Canvas.getCanvas1();
                        this.hardness=hardness;
                        ArrayList<Rectangle> Builder= new ArrayList<Rectangle>();
                        cuadrado = new Rectangle();
                        cuadrado.changeSize(height,width);                        
                        cuadrado.setxPosition(x);
                        cuadrado.setyPosition((canvas.getHeight()-cuadrado.getHeight()));
                        cuadrado.changeColor(colores[numero]);
                        
    
                    
    }
    
    /**
     * Remove a Building
     *
     * @param     Object Building
     * @return    void
     */
    public void removeBuilding(Object Building)
    {
       cuadrado.makeInvisible(); 
    }
    
    /**
     * Return the position Y
     */
    public int  getPositionY (){
        return cuadrado.getyPosition();
    }
    
    public void changeSize2(int ancho, int alto){
        cuadrado.changeSize2(ancho,alto);
    }
    
    /**
     * Return the position X
     */
    public int  getPositionX (){
        return cuadrado.getxPosition();
    }
    
    /**
     * Return the width
     */
    public int getWidth(){
        return cuadrado.getWidth();
    }
    
    /**
     * Return color edificio
     */
    public String getColor(){
        return cuadrado.getColor();
    }
    
    /**
     * Make this circle visible. If it was already visible, do nothing.
     */
    public void makeVisible(){
        cuadrado.makeVisible();
    }
    
    /**
     * Make this circle Invisible. If it was already Invisible, do nothing.
     */
    public void makeInvisible(){
        cuadrado.makeInvisible();
    }

}