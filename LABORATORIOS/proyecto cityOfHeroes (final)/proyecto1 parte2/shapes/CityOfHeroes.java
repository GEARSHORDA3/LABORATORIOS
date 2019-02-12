import java.util.ArrayList;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.List;
import java.util.Collections;
import java.awt.Toolkit; 
import java.util.ArrayList;
import java.util.ArrayList;
/**
* Es la ciudad de los heroes donde se tiene unos edificos y herores que interactuan entre si mediante un salto
* 
* @author David Andres Vargas Leon y David Otalora
* @version (02/08/2019)
*/
public class CityOfHeroes
{
    private  int heightNew;
    private  int wightNew; 
    public   int width1;
    private  int height1;
    private  ArrayList<Building>Builds;
    private  ArrayList<Heroe>Heroes;
    private  Canvas canvas;
    private  Rectangle ciudadBlack;
    private  Hashtable<Integer,Integer> infCoordenadas = new Hashtable<Integer,Integer>();
    private  ArrayList<Integer>positionX = new ArrayList<Integer>();
    private  Hashtable<Integer,Integer> infCoordenadasAncho = new Hashtable<Integer,Integer>();
    private  int xNumeroColores=-1;
    private  static final String colores[]={"red","yellow","blue","black","brown","magenta","green","grey","fucsia"};
    private  boolean isVisible=false;
    private  ArrayList<String>DeadsHeroes= new ArrayList<String>();
    private  ArrayList<String>liveHeroes= new ArrayList<String>();
    
    
    /**
     * constructor
     *
     * @param  widthNew  ancho cuidad
     * @param   heightNewalto ciudad
     * 
     */
    public CityOfHeroes(int widthNew, int heightNew) {
        Builds= new ArrayList<Building>();
        Heroes = new  ArrayList<Heroe>();
        width1=widthNew;
        height1=heightNew;
        canvas = Canvas.getCanvas(widthNew,heightNew);
    }
    
    /**
     * Hace visible todo lo presente en la ciudad 
     *
     * 
     */   
    public void makeVisible(){
        isVisible = true;
        draw();
    }
    
    /**
     * Dibuja heroes y ciudad presentes en la ciudad 
     *
     * 
     */
    /**
     * darw the heroe.
     */    
    private void draw() {
        if(isVisible) {
           int i; 
           for(i=0;i<Heroes.size();i++){
               if (Heroes.get(i).estaHeroDead()){
                   removeHeroe(Heroes.get(i).getHeroeColor2(Heroes.get(i)));
                }
               else{    
               Heroes.get(i).makeVisible();
               Heroes.get(i).PonerBarraVida(); 
               }
           }
           int a;
           for(a=0;a<Builds.size();a++){
               Builds.get(a).makeVisible();
                }
    }
    } 
    
    /**
     * Hacer invisible la ciudad 
     *
     * 
     */
    public void makeInvisible(){
        erase();
        isVisible = false;
    }
    
    /**
     * Borra o hace invisible cada elemento de la ciudad, como heroes y edificos
     * 
     */
    private void erase(){
        if(isVisible) {
           int i; 
           for(i=0;i<Heroes.size();i++){
               Heroes.get(i).makeInvisible();
               Heroes.get(i).removeBarraVida(); 
                }
           int a;
           for(a=0;a<Builds.size();a++){
               Builds.get(a).makeInvisible();
                } 
        }
    }
    
    
    /**
     * Añadir un edificio a la ciudad con unas caracteristicas
     *
     * @param  x  posicion edifico en x
     * @param  width  ancho edifico
     * @param  height  alto edifico
     * @param  hardness  duresa edifico
     * 
     */
    public void addBuilding(int x, int width, int height, int hardness)
    {
       if (verifyColisionEdi(x,width)){
        }
       else{
         if (xNumeroColores==colores.length-1){
                            xNumeroColores=0;
                        }
                        else{
                            xNumeroColores++;};
         Building edificio = new Building(x, width, height, hardness,xNumeroColores) ;
         Builds.add(edificio);
         positionX.add(x);
         int y= edificio.getPositionY();
         infCoordenadas.put(x ,y);
         infCoordenadasAncho.put(x,(edificio.getWidth()));
         if (isVisible==true){
         edificio.makeVisible();};   
        }
       
    }
    
    /**
     * verifica si un edifico se colisiona con otro al dibujarse 
     *
     * @param     xPositionEdi posicion edifico a analizar 
     * @param     anchoEdi ancho edifico a analizar
     * @return    boolean
     */
    public boolean  verifyColisionEdi(int xPositionEdi, int anchoEdi){
        int a;
        for(a=0;a<Builds.size();a++)
        {
          int xPositionBuild=Builds.get(a).getPositionX();
          int xwidthBuild= xPositionBuild+Builds.get(a).getWidth();
          int x2PositionEdi = xPositionEdi+anchoEdi;
          if((xPositionBuild<=xPositionEdi && xPositionEdi<= xwidthBuild) || (xPositionBuild<=x2PositionEdi
          && x2PositionEdi<= xwidthBuild )||(xPositionEdi<=xPositionBuild && xwidthBuild<= x2PositionEdi)){
             Toolkit.getDefaultToolkit().beep();
             JOptionPane.showMessageDialog(null, "El edificio queda sobrepuesto en el edificio "+Builds.get(a).getColor());
             return true; 
            }
        } 
        return false; 
    }
   
    /**
     * Añadir un heroe a la ciudad
     *
     * @param  color
     * @param  hidingBuilding
     * @param  strength
     */
    public void addHeroe(String color,int hidingBuilding, int strength){
        
        if(Builds.size()!=0){
                if (verifyDeadHero(color)){
                }
                else{
                }
                int x =positionX.get(hidingBuilding-1);
                int y= infCoordenadas.get(x);          
                int edificioHeroe= infCoordenadasAncho.get(x);
                Heroe heroe= new Heroe(color,hidingBuilding,strength, x,y, edificioHeroe,isVisible);
                Heroes.add(heroe);
                if (isVisible==true){
                    heroe.makeVisible();
                };
        }
        else{
            
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, "No existe un edificio al cual");
            
        }
    }
    
    /**
     * Verifica si un heroe esta muerto
     *
     * @param     Color
     * @return    boolean
     */
    public boolean  verifyDeadHero(String Color){
        
        if (DeadsHeroes.contains(Color)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El hereoe de color "+Color+" esta muerto o ya ha sido creado");
            return true;
        }
        else if(liveHeroes.contains(Color)){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El hereoe de color "+Color+" ya existe o esta muerto");
            return true;
        }
        liveHeroes.add(Color);
        return false; 
    }
    
    /**
     * Remove a Building
     *
     * @param     int position
     * @return    void
     */
    public void removeBuilding(int position)
    {
       position-=1; 
       Builds.get(position).removeBuilding(Builds.get(position)); 
       int posiXedi= Builds.get(position).getPositionX();
       infCoordenadas.remove(posiXedi);
       infCoordenadasAncho.remove(posiXedi);
       positionX.remove(positionX.indexOf(posiXedi));
       Builds.remove(position); 
    }
    
    /**
     * Remove a Heroe
     *
     * @param     int position
     * @return    void
     */
    public void removeHeroe(String color)
    {
       int i; 
       for(i=0;i<Heroes.size();i++){
           if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){
               if (Heroes.get(i).getStrength() <= 0){
                   DeadsHeroes.add(Heroes.get(i).getHeroeColor(Heroes.get(i)));
                }
               
               Heroes.get(i).removeBarraVida();
               Heroes.get(i).removeHeroe(Heroes.get(i));
               Heroes.remove(i);
               return;
               
            }

    }
    }
    
    
    /**
     * Mostrar los heroes muertos 
     *
     * @return    lista DeadsHeroes
     */
    public void deads()
    {
        System.out.println(DeadsHeroes);
        return ;
    }

    
    /**
     * The function of the coordenates y,x for the parabolic
     * 
     * @param String color, int angulo, int velocidad
     * @return void
     */
     public void jump(String color, int angulo, int velocidad, boolean slow){  
     int altCanvas= canvas.getWidth();
       for(int i=0;i<Heroes.size();i++){
           if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){
               int posiXHeroe= (Heroes.get(i)).getxPosition();
               int posiYHeroe= (Heroes.get(i)).getyPosition();
               int a;
               for(a=0;a<Builds.size();a++){
                   Building edificio =Builds.get(a);
                   int xpositionEdi= (edificio.getPositionX());
                   int anchoEdi= edificio.getWidth()+xpositionEdi;
                   if (xpositionEdi<=posiXHeroe && posiXHeroe<=anchoEdi){
                       if (slow){
                           (Heroes.get(i)).Jump(color, angulo, velocidad, altCanvas-posiYHeroe,
                           posiYHeroe, posiXHeroe,altCanvas, 0.0001,isVisible);
                       }
                       else{
                           (Heroes.get(i)).Jump(color, angulo, velocidad, altCanvas-posiYHeroe,
                           posiYHeroe, posiXHeroe,altCanvas, 0.01,isVisible);
                        }
                       return;
                    }
                }
           }
    }       
       
}
    
    /**
     * Analiza si el salto es seguro para el heroe
     * 
     * @param String color
     * @param String int angulo
     * @param String int velocidad
     */
    public void isSafejump(String color, int angulo, int velocidad){  
     int altCanvas= canvas.getWidth();
       for(int i=0;i<Heroes.size();i++){
           if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){
               int posiXHeroe= (Heroes.get(i)).getxPosition();
               int posiYHeroe= (Heroes.get(i)).getyPosition();
               int a;
               for(a=0;a<Builds.size();a++){
                   Building edificio =Builds.get(a);
                   int xpositionEdi= (edificio.getPositionX());
                   int anchoEdi= edificio.getWidth()+xpositionEdi;
                   if (xpositionEdi<=posiXHeroe && posiXHeroe<=anchoEdi){
                       (Heroes.get(i)).isSafeJump(color, angulo, velocidad, altCanvas-posiYHeroe,
                       posiYHeroe, posiXHeroe,altCanvas, 0.01,posiXHeroe,posiYHeroe,false);
                       return;
                    }
                }
           }
    }  
    }
    
}
