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
    private ArrayList<Integer>listaPlan;
    private boolean message=true;
    int PosicionColor=-2;
    private int edificioJumpPlan;
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
        pruebaOk=true;
        draw();
    }
    

    /**
     * darw the heroe.
     */    
    private void draw() {
        if(isVisible) {
           int i; 
           for(i=0;i<Heroes.size();i++){
               if (Heroes.get(i).deads()){
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
           pruebaOk=true;
    }      
    } 
    
    /**
     * Hacer invisible la ciudad 
     *
     * 
     */
    public void makeInvisible(){
        erase();
        pruebaOk=true;
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
           pruebaOk=true;     
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
             pruebaOk=true;
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
             mostrarMensaje("El edificio queda sobrepuesto en el edificio "+Builds.get(a).getColor());
             return true; 
            }
        }
        pruebaOk=true;
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
                    pruebaOk=true;
                    return;
                }
                else{
                }
                try{
                Collections.sort(positionX);
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
                    mostrarMensaje("No existe un edificio al cual");                  
                }
        }
        else{
                pruebaOk=false;
                Toolkit.getDefaultToolkit().beep();
                mostrarMensaje("No existe un edificio al cual"); 
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
            mostrarMensaje("El hereoe de color "+Color+" esta muerto o ya ha sido creado"); 
            pruebaOk=true;
            return true;
        }
        else if(liveHeroes.contains(Color)){
            Toolkit.getDefaultToolkit().beep();
            mostrarMensaje("El hereoe de color "+Color+" ya existe o esta muerto");
            pruebaOk=true;
            return true;
        }
        else{
             liveHeroes.add(Color);
             pruebaOk=true;
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
           Collections.sort(positionX);
           int buscador=positionX.get(position);
           int i; 
           for(i=0;i<Builds.size();i++){
             if (Builds.get(i).getPositionX()==buscador){
                int posiXedi= Builds.get(i).getPositionX();
                infCoordenadas.remove(posiXedi);
                infCoordenadasAncho.remove(posiXedi);
                positionX.remove(positionX.indexOf(posiXedi)); 
                pruebaOk=true;
                Builds.get(i).removeBuilding(Builds.get(i));
                Builds.remove(i);
                }
           }
       }catch (IndexOutOfBoundsException e){
           pruebaOk=false;
           Toolkit.getDefaultToolkit().beep();
           mostrarMensaje("No existe dicho edificio");
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
    public ArrayList<String> deads()
    {
        pruebaOk=true;
        return DeadsHeroes ;
    }
    
    
    /**
     * Modificar un edifico en altura tras el choque de un heroe al sobrevivir 
     * @param  edificoModificadoX posicion en x del edifico
     * @param  posicion y del edificio para su nueva altura
     */
    private void modiAltuEdiChoqueHeroe(int edificoModificadoX,int nuevaAlturaEdiY)
    {
       try{
           int i; 
           for(i=0;i<Builds.size();i++){
             if (Builds.get(i).getPositionX()==edificoModificadoX){
                 Builds.get(i).changeHightEdi(nuevaAlturaEdiY);
                 Builds.get(i).makeVisible();
                }
           }
       }catch (IndexOutOfBoundsException e){
           pruebaOk=false;
           Toolkit.getDefaultToolkit().beep();
           mostrarMensaje("No existe dicho edificio para modificar");
        }
    }

    /**
     * The function of the coordenates y,x for the parabolic
     * 
     * @param String color, int angulo, int velocidad
     * @return void
     */
     public void jump(String color, int angulo, int velocidad, boolean slow){  
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
                           posiYHeroe, posiXHeroe,altCanvas,achCanvas, 0.001,isVisible,infCoordenadas,positionX,durezasEdificios,infCoordenadasAncho);
                           if(Heroes.get(i).getVeriHeroNoMuerto()){
                               infCoordenadas.put(Heroes.get(i).getPosiActEdiX(),((int) Heroes.get(i).getPositionY())+7);
                               Heroes.get(i).changeVeriHeroNoMuerto();
                               int edificoModificadoX=Heroes.get(i).getposiEdiModificado();
                               int nuevaAlturaEdiY=Heroes.get(i).getNuevaAlturaEdificio();
                               modiAltuEdiChoqueHeroe(edificoModificadoX,nuevaAlturaEdiY);
                               this.asignarEdiDañado(Heroes.get(i).getXEdiDañado());
                               this.addDeads(Heroes.get(i).deads(),Heroes.get(i));
                               pruebaOk=true;
                            }
                            else{
                                this.asignarEdiDañado(Heroes.get(i).getXEdiDañado());
                                this.addDeads(Heroes.get(i).deads(),Heroes.get(i));
                                pruebaOk=true;
                            }
                           
                       }
                       else{
  
                           (Heroes.get(i)).Jump(color, angulo, velocidad, altCanvas-posiYHeroe,
                           posiYHeroe, posiXHeroe,altCanvas,achCanvas, 0.01,isVisible,infCoordenadas,positionX,durezasEdificios,infCoordenadasAncho);
                           if(Heroes.get(i).getVeriHeroNoMuerto()){
                               infCoordenadas.put(Heroes.get(i).getPosiActEdiX(),((int) Heroes.get(i).getPositionY())+7);
                               Heroes.get(i).changeVeriHeroNoMuerto();
                               int edificoModificadoX=Heroes.get(i).getposiEdiModificado();
                               int nuevaAlturaEdiY=Heroes.get(i).getNuevaAlturaEdificio();
                               modiAltuEdiChoqueHeroe(edificoModificadoX,nuevaAlturaEdiY);
                               this.asignarEdiDañado(Heroes.get(i).getXEdiDañado());
                               this.addDeads(Heroes.get(i).deads(),Heroes.get(i));
                               pruebaOk=true;
                            }
                            else{
                                this.asignarEdiDañado(Heroes.get(i).getXEdiDañado());
                                this.addDeads(Heroes.get(i).deads(),Heroes.get(i));
                                pruebaOk=true;
                            }
                        }
                       return;
                    }
                }
           }
           pruebaOk=false;
    }       
       
    }
    
    /**
     * Analiza si el salto es seguro para el heroe
     * 
     * @param String color
     * @param String int angulo
     * @param String int velocidad
     */
    public boolean isSafejump(String color, int angulo, int velocidad){  
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
                       boolean n=(Heroes.get(i)).isSafeJump(posXoriginal,posYoriginal,color, angulo, velocidad, altCanvas-posiYHeroe,
                       posiYHeroe, posiXHeroe,altCanvas,achCanvas, 0.01,isVisible,infCoordenadas,positionX,durezasEdificios,infCoordenadasAncho, message);
                       pruebaOk=true;
                       return n;
                    }
                }
           }
    }  
    return false;
    }
    

    public boolean isSafeJump2(String color, int angulo, int velocidad){  
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
                       ArrayList<Integer>listaCarcatEdi= findBuilding(edificioJumpPlan);
                       Hashtable<Integer,Integer> durezasEdificios2 = new Hashtable<Integer,Integer>();
                       Hashtable<Integer,Integer> infCoordenadas2 = new Hashtable<Integer,Integer>();
                       Hashtable<Integer,Integer> infCoordenadasAncho2 = new Hashtable<Integer,Integer>();
                       ArrayList<Integer>positionX2= new ArrayList<Integer>();
                       durezasEdificios2.put(listaCarcatEdi.get(0),listaCarcatEdi.get(3));
                       infCoordenadas2.put(listaCarcatEdi.get(0),listaCarcatEdi.get(1));
                       infCoordenadasAncho2.put(listaCarcatEdi.get(0),listaCarcatEdi.get(2));
                       positionX2.add(listaCarcatEdi.get(0));
                       boolean b= (Heroes.get(i)).isSafeJump2(color, angulo, velocidad, altCanvas-posiYHeroe,
                       posiYHeroe, posiXHeroe,altCanvas,achCanvas, 0.01,isVisible,infCoordenadas2 ,positionX2,durezasEdificios2,infCoordenadasAncho2, posXoriginal,posYoriginal);
                       return b;
                    }
                }
           }
           pruebaOk=false;
     }   return false;
     }

    public ArrayList jumpPlan(String heroe, int building){
        edificioJumpPlan=building;
        listaPlan = new ArrayList<Integer>();
        notShowMessage();
        
        for (int angulo=1; angulo<90;angulo++){
            for (int velocidad=1; velocidad<90;velocidad++){
                if (isSafeJump2(heroe,angulo,velocidad)){
                    listaPlan.add(angulo);
                    listaPlan.add(velocidad);                    
                }
            }
        }
        showMessage();
        System.out.println(listaPlan);
        return listaPlan;
    }
    
    /**
     * buscar solo el edifico por su poscicsion visualmente especialmente diseñado para isSafeJump2
     *
     * @param  position posicion edifico
     * @return listaCarcatEdi lista de laposicion en x, su altura, su ancho, su dureza
     */
    private ArrayList findBuilding(int position)
    {
       ArrayList<Integer>listaCarcatEdi= new ArrayList<Integer>();
       position-=1; 
       try{
           Collections.sort(positionX);
           int buscador=positionX.get(position);
           int i; 
           for(i=0;i<Builds.size();i++){
             if (Builds.get(i).getPositionX()==buscador){
                int posiXEdi= Builds.get(i).getPositionX();
                int alturaEdi = Builds.get(i).getPositionY();
                int anchoEdi= Builds.get(i).getWidth();
                int durezaEdi=Builds.get(i).gethardness();
                listaCarcatEdi.add(posiXEdi);
                listaCarcatEdi.add(alturaEdi);
                listaCarcatEdi.add(anchoEdi);
                listaCarcatEdi.add(durezaEdi);
                return listaCarcatEdi;
                }
           }
       }catch (IndexOutOfBoundsException e){
           pruebaOk=false;
           Toolkit.getDefaultToolkit().beep();
           mostrarMensaje("No existe dicho edificio");
        }
       return listaCarcatEdi;
    }

    private void showMessage(){
        message= true;
    }
    
    private void notShowMessage(){
        message= false;
    }
    
    public void zoom(char signo){      
        Canvas canvas = Canvas.getCanvas1();
        canvas.zoom(signo);
        pruebaOk=true;
    }
    
    /**
         * reutilizar codigo para crear mensaje
         * @param  string cadena a representar
         */
        private void mostrarMensaje(String string)
        {
           Toolkit.getDefaultToolkit().beep();
           JOptionPane p = new JOptionPane(string);
           JFrame frame= new JFrame();
           frame.setContentPane(p);
           frame.setVisible(true);
           frame.pack();
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           try{ 
               Thread.sleep(2000);
            } catch (InterruptedException e){
            }
           frame.setVisible(false);
        }
        
    /** Evalua si las pruebas estan bien
     * @return el booleano pruebaOk
     */
    public boolean ok(){
        return pruebaOk;
    }
    
    /**
     * Terminar todo el programa
     */
    public void finish()
    {
        System.exit(1);
    }
    
    /**
     * asigna un heroe a la lista deads si el valor o indicador que entra como parametro es true
     * @param bool booleano con true o false
     * @param hereoe objecto de la clase heroe
     */
    private void addDeads(boolean indicador,Heroe heroe)
    {
        if (indicador){
           this.removeHeroe(heroe.getColor());
           DeadsHeroes.add(heroe.getHeroeColor(heroe));
        }
    }
    
    /**
     * asignar al objeto building correspondiente si esta dañado con un numero diferente a -1000000.
     * @param  x  cordenada x del edifico
     */
    private void asignarEdiDañado(int x)
    {
        if (x!=-1000000){
            int buscador1=x;
            int i; 
            for(i=0;i<Builds.size();i++){
             if (Builds.get(i).getPositionX()==buscador1){
                Builds.get(i).setDañadoEdifcioTrue();
                }
           }
            
        }
    }

    /**
         * Retorna la vida del heroe
         * @param  color de heroe
         * @return vida es la vida actual del heroe
         */
        public int strength(String color1)
        
        {
        try
        {
          int i; 
           for(i=0;i<Heroes.size();i++)
           {
               if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color1)){
                   return Heroes.get(i).getStrength();
            }
          } 
            }catch(IndexOutOfBoundsException e)
            {
                mostrarMensaje("No existe dicho heroe");
            } 
        return -1000000;
      }
    
        /**
         * Indicar si un edificio esta dañado
         * @param  position posicion del edificio
         * @return boolean si es true es que esta dañado, si retorna false es que no esta dañado
         */
        public boolean isDamaged(int position)
        {
           Collections.sort(positionX);
           int buscador=positionX.get(position-1);
           int i; 
           for(i=0;i<Builds.size();i++){
             if (Builds.get(i).getPositionX()==buscador && Builds.get(i).getDañadoEdifcio()==true){
                return true;
                }
            } 
           return false;
    }

}
