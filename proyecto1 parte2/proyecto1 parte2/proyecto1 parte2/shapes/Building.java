import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Building here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Building
{
    private static final String colores[]={"red","yellow","blue","black","brown","magenta","green","grey","fucsia"};
    private int numero;
    private int nColores=8;
    private static int hardness;
    private Rectangle cuadrado;
    /**
     * Constructor for objects of class Building
     */
    public Building(int x, int width, int height, int hardness){
                        Canvas canvas = Canvas.getCanvas1();
                        this.hardness=hardness;
                        numero = (int) (Math.random() * nColores) + 1;
                        ArrayList<Rectangle> Builder= new ArrayList<Rectangle>();
                        cuadrado = new Rectangle();
                        cuadrado.changeSize(height,width);                        
                        cuadrado.setxPosition(x);
                        cuadrado.setyPosition((canvas.getHeight()-cuadrado.getHeight()));
                        cuadrado.changeColor(colores[numero]);
                        cuadrado.makeVisible(); 
                    
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
    
    public int  getPositionY (){
        return cuadrado.getyPosition();
    }
    
    public int  getPositionX (){
        return cuadrado.getxPosition();
    }
    
    public int getWidth(){
        return cuadrado.getWidth();
    }
    
    
    

}