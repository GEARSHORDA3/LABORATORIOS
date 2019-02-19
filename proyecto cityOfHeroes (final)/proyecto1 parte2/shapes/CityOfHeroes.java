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
    private boolean pruebaOk=true;
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
    private  Hashtable<Integer,Integer> durezasEdificios = new Hashtable<Integer,Integer>();
    private  ArrayList<Rectangle> Vitalidades;
    
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
        pruebaOk=true;
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
             xNumeroColores++;
         };
         Building edificio = new Building(x, width, height, hardness,xNumeroColores) ;
         Builds.add(edificio);
         positionX.add(x);
         int y= edificio.getPositionY();
         infCoordenadas.put(x ,y);
         infCoordenadasAncho.put(x,(edificio.getWidth()));
         durezasEdificios.put(x,hardness);
         if (isVisible==true){
         edificio.makeVisible();
         pruebaOk=true;
         };
        }
       
    }
    
    /**
     * verifica si un edifico se colisiona con otro al dibujarse 
     *
     * @param     xPositionEdi posicion edifico a analizar 
     * @param     anchoEdi ancho edifico a analizar
     * @return    boolean
     */
    private boolean  verifyColisionEdi(int xPositionEdi, int anchoEdi){
        int a;
        for(a=0;a<Builds.size();a++)
        {
          int xPositionBuild=Builds.get(a).getPositionX();
          int xwidthBuild= xPositionBuild+Builds.get(a).getWidth();
          int x2PositionEdi = xPositionEdi+anchoEdi;
          if((xPositionBuild<=xPositionEdi && xPositionEdi<= xwidthBuild) || (xPositionBuild<=x2PositionEdi
          && x2PositionEdi<= xwidthBuild )||(xPositionEdi<=xPositionBuild && xwidthBuild<= x2PositionEdi)){
             pruebaOk=false;
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
                    return;
                }
                else{
                }
                try{
                int x =positionX.get(hidingBuilding-1);
                int y= infCoordenadas.get(x);          
                int edificioHeroeAncho= infCoordenadasAncho.get(x);
                int ediActualPosi=x;
                Heroe heroe= new Heroe(color,hidingBuilding,strength, x,y, edificioHeroeAncho,isVisible,ediActualPosi);
                Heroes.add(heroe);
                pruebaOk=true;
                if (isVisible==true){
                    heroe.makeVisible();
                }
                }
                catch(IndexOutOfBoundsException e){
                    pruebaOk=false;
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "No existe un edificio al cual");                    
                }
        }
        else{
                pruebaOk=false;
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
    private boolean  verifyDeadHero(String Color){
        pruebaOk=true;
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
        else{
             liveHeroes.add(Color);
             return false; 
        }

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
       try{
           Builds.get(position).removeBuilding(Builds.get(position)); 
           int posiXedi= Builds.get(position).getPositionX();
           infCoordenadas.remove(posiXedi);
           infCoordenadasAncho.remove(posiXedi);
           positionX.remove(positionX.indexOf(posiXedi));
           Builds.remove(position); 
           pruebaOk=true;
       }catch (IndexOutOfBoundsException e){
           pruebaOk=false;
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null, "No existe dicho edificio");
        }
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
               pruebaOk=true;
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
        pruebaOk=true;
        return ;
    }

    /**
     * The function of the coordenates y,x for the parabolic
     * 
     * @param String color, int angulo, int velocidad
     * @return void
     */
     public void jump(String color, int angulo, int velocidad, boolean slow){  
     pruebaOk=true;
     int achCanvas= canvas.getWidth();
     int altCanvas= canvas.getHeight();
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
                           posiYHeroe, posiXHeroe,altCanvas,achCanvas, 0.0001,isVisible,infCoordenadas,positionX,durezasEdificios,infCoordenadasAncho);
                       }
                       else{
                           (Heroes.get(i)).Jump(color, angulo, velocidad, altCanvas-posiYHeroe,
                           posiYHeroe, posiXHeroe,altCanvas,achCanvas, 0.01,isVisible,infCoordenadas,positionX,durezasEdificios,infCoordenadasAncho);
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
     pruebaOk=true;
     int achCanvas= canvas.getWidth();
     int altCanvas= canvas.getHeight();
       for(int i=0;i<Heroes.size();i++){
           if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){
               int posiXHeroe= (Heroes.get(i)).getxPosition();
               int posiYHeroe= (Heroes.get(i)).getyPosition();
               int posXoriginal=posiXHeroe;
               int posYoriginal=posiYHeroe;
               int a;
               for(a=0;a<Builds.size();a++){
                   Building edificio =Builds.get(a);
                   int xpositionEdi= (edificio.getPositionX());
                   int anchoEdi= edificio.getWidth()+xpositionEdi;
                   if (xpositionEdi<=posiXHeroe && posiXHeroe<=anchoEdi){
                       (Heroes.get(i)).isSafeJump(posXoriginal,posYoriginal,color, angulo, velocidad, altCanvas-posiYHeroe,
                           posiYHeroe, posiXHeroe,altCanvas,achCanvas, 0.01,isVisible,infCoordenadas,positionX,durezasEdificios,infCoordenadasAncho);
                       return;
                    }
                }
           }
    }  
    }
    
    public void zoom(char signo){      
        if (signo=='+'){
           Vitalidades=Heroes.get(0).listaVitalidad();
           for(int i=0;i<Heroes.size();i++){
               Heroes.get(i).changeSize(10);
               Heroes.get(i).setXYposition(0,-15);
               Builds.get(i).changeSize2(2,2);

           }
           for (int j=0;j<Heroes.get(0).listaVitalidadSize();j++){
               Vitalidades.get(j).changeSize2(2,2);
               Vitalidades.get(j).setXYposition(0,-10);               
           }
        }
        else if (signo=='-'){
           Vitalidades=Heroes.get(0).listaVitalidad();
           for(int i=0;i<Heroes.size();i++){
               Heroes.get(i).changeSize(1/10);
               // Heroes.get(i).setXYposition(0,+15);
               Builds.get(i).changeSize2(1/2,1/2);

           }
           for (int j=0;j<Heroes.get(0).listaVitalidadSize();j++){
               Vitalidades.get(j).changeSize2(1/2,1/2);
               // Vitalidades.get(j).setXYposition(0,10);               
           }
        }        
    }
    /** Evalua si las pruebas estan bien
     * @return el booleano pruebaOk
     */
    public boolean ok(){
        return pruebaOk;
    }
}
