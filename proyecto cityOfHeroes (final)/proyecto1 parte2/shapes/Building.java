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
    private int hardness;
    private Rectangle cuadrado;
    private int height;
    private int width;
    private boolean dañadoEdifcio=false;
    /**
     * Constructor for objects of class Building
     */
    public Building(int x, int width, int height, int hardness,int numero){
                        Canvas canvas = Canvas.getCanvas1();
                        this.height=height;
                        this.width=width;
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
     * cambia altura de edificio 
     * param posiYHeroe posicion en (y) donde se queda el heroe al sobrevivir a un choque con un edificio
     */
    public void changeHightEdi(int posiYHeroe)
    {
        Canvas canvas = Canvas.getCanvas1();
        int altura = canvas.getHeight()-posiYHeroe;
        cuadrado.changeSize(altura,width);
        cuadrado.setNewYPosition((canvas.getHeight()-cuadrado.getHeight()));
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
     * change hight building
     */
    public int  setPositionY (){
        return cuadrado.getyPosition();
    }
    
    /**
     * Return the width
     */
    public int getWidth(){
        return cuadrado.getWidth();
    }
    
    /**
     * Return the width
     */
    public int getHeight(){
        return cuadrado.getHeight();
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
    
    /**
     * asignar a la variable dañadoEdifcio true como indicador de que ha sido golpeado por un heroe
     */
    public void setDañadoEdifcioTrue(){
        dañadoEdifcio=true;
    }
    
    /**
     * Obtener la dureza del edifico
     */
    public int getHardness()
    {
        return hardness;
    }

    /**
     * retornar la varibale dañadoEdifcio para saber si esta dañado un edifico
     * @return dañadoEdifcio variable que indica si el heroe esta dañado o no 
     */
    public boolean getDañadoEdifcio(){
        return dañadoEdifcio;
    }
}