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
    private ArrayList<Integer> infoEdificios = new ArrayList<Integer>();
    private ArrayList<Integer> infoHeroes = new ArrayList<Integer>();
    private Stack<Object>methods= new Stack<Object>();
    private Stack<Object>parameters=new Stack<Object>();
    private boolean modoRedoOn=false;
    private ArrayList<Integer>listaPlan2;
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
        setPruebOk(true);
    }
    
    /**
     * Realizar la ultima accion inversamente a lo que se hizo 
     * @param  y  a sample parameter for a method
     */
    public void redo()
    {
        if(methods.isEmpty()){
            mostrarMensaje("No se ha realizado ninguna accion");
            setPruebOk(false);
            return;
        }
        String method = String.valueOf(methods.pop());
        if(method.equals("addBuilding")){
            int x = (int)parameters.pop();
            removeBuilding(x);
            setPruebOk(true);
            return;
        }
        else if(method.equals("addHeroe")){
            modoRedoOn=true;
            String x = (String)parameters.pop();
            removeHeroe(x);
            setPruebOk(true);
            modoRedoOn=false;
            return;
        }
        else if((method.equals("removeBuilding"))){
            ArrayList<Integer> temp = (ArrayList<Integer>)parameters.pop();
            addBuilding((int)temp.get(0),(int)temp.get(1),(int)temp.get(2),(int)temp.get(3));
            setPruebOk(true);
            return;
        }
        else if((method.equals("removeHeroe"))){
            modoRedoOn=true;
            ArrayList<Object> temp = (ArrayList)parameters.pop();
            addHeroe((String)temp.get(0),(int)temp.get(1),(int)temp.get(2));
            pruebaOk = true;
            modoRedoOn=false;
            return;
        }
        else if((method.equals("zoom"))){
            modoRedoOn=true;
            String operador = (String)parameters.pop();
            if (operador =="+"){
                zoom('-');
            }
            else{
                zoom('+');
            }
            pruebaOk = true;
            modoRedoOn=false;
            return;
        }
        else if((method.equals("makeInvisible"))){
            modoRedoOn=true;
            Integer operador = (Integer)parameters.pop();
            makeVisible();
            pruebaOk = true;
            modoRedoOn=false;
            return;
        }
        else if((method.equals("makeVisible"))){
            modoRedoOn=true;
            Integer operador = (Integer)parameters.pop();
            makeInvisible();
            pruebaOk = true;
            modoRedoOn=false;
            return;
        }
        else if((method.equals("jump"))){
            int building = (int)parameters.pop(); 
            jump((String)parameters.pop(),building);
            // Falta reparar edificios
            setPruebOk(true);
            return;
        }
        else if((method.equals("jump2"))){
            ArrayList<Object> temp;
            int building = (int)parameters.pop();
            temp=(ArrayList)parameters.pop();
            jump((String)temp.get(1),building);
           setPruebOk(true);
           return;
        }
        else if((method.equals("jump3"))){
            int building = (int)parameters.pop(); 
            jump((String)parameters.pop(),building);
            // Falta reparar edificios
            setPruebOk(true);
            return;
        }
        else{
            mostrarMensaje("El ultimo metodo no se puede rehacer");
            setPruebOk(false);
            return;
        }
    }

    /**
     * Hace visible todo lo presente en la ciudad 
     *
     * 
     */   
    public void makeVisible(){
        isVisible = true;
        setPruebOk(true);
        draw();
    }
    
    /**
     * La consulta city debe retornar un vector con dos vectores. El primero con la información de los edificios [x,ancho, alto, dureza] ordenado
     * por posición en x. El segundo con la información de los heroes [edificio, fortaleza] ordenado por el número de edificio.
     * @return vector
     */
    public Integer[][] city()
    {
        Integer[][] array = new Integer[2][];
        Integer[] infEdificios = new Integer[infoEdificios.size()];
        infEdificios = infoEdificios.toArray(infEdificios);
        array[0]= infEdificios;
        Integer[] infHeroes= new Integer[infoHeroes.size()];
        infHeroes = infoHeroes.toArray(infHeroes);
        array[1]= infHeroes;
        return array;
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
           setPruebOk(true);
    }      
    } 
    
    /**
     * Hacer invisible la ciudad 
     *
     * 
     */
    public void makeInvisible(){
        erase();
        setPruebOk(true);
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
           setPruebOk(true);     
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
       if (verifyColisionEdi(x,width)){}
       else{
         if (xNumeroColores==colores.length-1){
             xNumeroColores=0;
             setPruebOk(true);
         }
         else{
             xNumeroColores++;
         };
         infoEdificios.add(x);
         infoEdificios.add(width);
         infoEdificios.add(height);
         infoEdificios.add(hardness);
         Building edificio = new Building(x, width, height, hardness,xNumeroColores) ;
         Builds.add(edificio);
         positionX.add(x);
         int y= edificio.getPositionY();
         infCoordenadas.put(x ,y);
         infCoordenadasAncho.put(x,(edificio.getWidth()));
         durezasEdificios.put(x,hardness);
         parameters.push(positionX.indexOf(x)+1);
         if (isVisible==true){
         edificio.makeVisible();
         }
         setPruebOk(true);
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
        Canvas canvas = Canvas.getCanvas1();
        int achCanvas= canvas.getWidth();
        int altCanvas= canvas.getHeight();
        for(a=0;a<Builds.size();a++)
        {
          int xPositionBuild=Builds.get(a).getPositionX();
          int xwidthBuild= xPositionBuild+Builds.get(a).getWidth();
          int x2PositionEdi = xPositionEdi+anchoEdi;
          if((xPositionBuild<=xPositionEdi && xPositionEdi<= xwidthBuild) || (xPositionBuild<=x2PositionEdi
          && x2PositionEdi<= xwidthBuild )||(xPositionEdi<=xPositionBuild && xwidthBuild<= x2PositionEdi) || xPositionEdi>=achCanvas
          || xPositionEdi+anchoEdi>=achCanvas){
             setPruebOk(false);
             Toolkit.getDefaultToolkit().beep();
             mostrarMensaje("El edificio queda sobrepuesto en el edificio "+Builds.get(a).getColor());
             return true; 
            }
        }
        setPruebOk(true);
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
        color = color.toLowerCase();
        if(Builds.size()!=0){
            if (verifyDeadHero(color) && !modoRedoOn){
                setPruebOk(true);
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
                // if (color!="brown"){
                    Heroes.add(heroe);
                // }
                setPruebOk(true);
                // if (color!="brown"){                
                    infoHeroes.add(hidingBuilding);
                    infoHeroes.add(strength);
                    methods.push("addHeroe");
                    parameters.push(color);
            // }
            if (isVisible==true){
                heroe.makeVisible();
            }
            }
            catch(IndexOutOfBoundsException e){
                setPruebOk(false);
                Toolkit.getDefaultToolkit().beep();
                mostrarMensaje("No existe un edificio al cual");                  
            }
        }
        else{
            setPruebOk(false);
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
        setPruebOk(true);
        if (DeadsHeroes.contains(Color)){
            Toolkit.getDefaultToolkit().beep();
            mostrarMensaje("El hereoe de color "+Color+" esta muerto o ya ha sido creado"); 
            setPruebOk(true);
            return true;
        }
        else if(liveHeroes.contains(Color)){
            Toolkit.getDefaultToolkit().beep();
            mostrarMensaje("El hereoe de color "+Color+" ya existe o esta muerto");
            setPruebOk(true);
            return true;
        }
        else{
             liveHeroes.add(Color);
             setPruebOk(true);
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
                ArrayList<Integer> lista=new ArrayList<Integer>();
                lista.add(Builds.get(i).getPositionX());
                lista.add(infCoordenadasAncho.get(Builds.get(i).getPositionX()));
                lista.add(Builds.get(i).getHeight());
                lista.add(Builds.get(i).getHardness());
                parameters.push(lista);
                int posiXedi= Builds.get(i).getPositionX();
                infCoordenadas.remove(posiXedi);
                infCoordenadasAncho.remove(posiXedi);
                positionX.remove(positionX.indexOf(posiXedi)); 
                setPruebOk(true);
                Builds.get(i).removeBuilding(Builds.get(i));
                Builds.remove(i);
                }
           }
       }catch (IndexOutOfBoundsException e){
           setPruebOk(false);
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
               ArrayList<Object> lista=new ArrayList<Object>();
               lista.add(color);
               lista.add(Heroes.get(i).getHidingBuilding());
               lista.add(Heroes.get(i).getStrength());
               methods.push("removeHeroe");
               parameters.push(lista);
               Heroes.get(i).removeBarraVida();
               Heroes.get(i).removeHeroe(Heroes.get(i));
               Heroes.remove(i);
               setPruebOk(true);
               return;
            }

    }
    setPruebOk(false);
    }

    /**
     * Mostrar los heroes muertos 
     *
     * @return    lista DeadsHeroes
     */
    public String[] deads()
    {
        setPruebOk(true);
        String[] stockArr = new String[DeadsHeroes.size()];
        stockArr = DeadsHeroes.toArray(stockArr);
        return stockArr ;
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
           setPruebOk(false);
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
       color = color.toLowerCase();
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
                               setPruebOk(true);
                               return;
                            }
                            else{
                                this.asignarEdiDañado(Heroes.get(i).getXEdiDañado());
                                this.addDeads(Heroes.get(i).deads(),Heroes.get(i));
                                setPruebOk(true);
                                return;
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
                               setPruebOk(true);
                               return;
                            }
                            else{
                                this.asignarEdiDañado(Heroes.get(i).getXEdiDañado());
                                this.addDeads(Heroes.get(i).deads(),Heroes.get(i));
                                setPruebOk(true);
                                return;
                            }
                        }
                    }
                }
           }
           setPruebOk(false);
           
    }         
    }
    
    /**
     * Analiza si el salto es seguro para el heroe
     * 
     * @param String color
     * @param String int angulo
     * @param String int velocidad
     */
    public boolean isSafeJump(String color, int angulo, int velocidad){  
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
                       setPruebOk(true);
                       return n;
                    }
                }
           }
    }
    setPruebOk(true);
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
           setPruebOk(false);
     }   return false;
     }

     /** 
      * 
      */
    public ArrayList jumpPlan(String heroe, int building){
        String colorOriginal=heroe;
        
        edificioJumpPlan=building;
        listaPlan = new ArrayList<Integer>();
        listaPlan2 = new ArrayList<Integer>();
        notShowMessage();
        for (int angulo=5; angulo<6;angulo++){
            for (int velocidad=1; velocidad<90;velocidad++){
                if (isSafeJump2(heroe,angulo,velocidad)){
                    listaPlan.add(angulo);
                    listaPlan.add(velocidad);                    
                }
            }
        }
        
        for (int angulo=60; angulo<61;angulo++){
            for (int velocidad=1; velocidad<90;velocidad++){
                if (isSafeJump2(heroe,angulo,velocidad)){
                    listaPlan2.add(angulo);
                    listaPlan2.add(velocidad);                    
                }
            }
        }
        
        showMessage();
        System.out.println(listaPlan);
        return listaPlan;
    }

    public ArrayList getXYPositionHeroe(String color){
        ArrayList<Integer> listaposition = new ArrayList<Integer>();
        for(int i=0;i<Heroes.size();i++){
            if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){        
                listaposition=Heroes.get(i).getXYPositionHeroe( Heroes.get(i).getHeroeColor(Heroes.get(i)) );
            }
        }
        return listaposition;
    }
    
    public void setXYposition2(String color,double x, double y){
        for(int i=0;i<Heroes.size();i++){
            if (Heroes.get(i).getHeroeColor(Heroes.get(i)).equals(color)){
                Heroes.get(i).setXYposition2(x,y);
                removeHeroe("brown");
                Heroes.get(i).makeVisible();
            }
        }
    }
    public void jump (String heroe, int building){
        addHeroe("brown",building,0);
        ArrayList<Integer> a = new ArrayList<Integer>();
        a= getXYPositionHeroe("brown");
        setXYposition2(heroe,a.get(0), a.get(1));
        a= getXYPositionHeroe(heroe);
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
                int durezaEdi=Builds.get(i).getHardness();
                listaCarcatEdi.add(posiXEdi);
                listaCarcatEdi.add(alturaEdi);
                listaCarcatEdi.add(anchoEdi);
                listaCarcatEdi.add(durezaEdi);
                return listaCarcatEdi;
                }
           }
       }catch (IndexOutOfBoundsException e){
           setPruebOk(false);
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
        setPruebOk(true);
    }
    

    public void setPruebOk(boolean estado)
    {
        pruebaOk=estado;
        return;
    }

    /**
     * reutilizar codigo para crear mensaje
     * @param  string cadena a representar
     */
    private void mostrarMensaje(String string)
    {
       if (isVisible==true){
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
        System.exit(0);
    }
    
    /**
     * asigna un heroe a la lista deads si el valor o indicador que entra como parametro es true y lo remueve de la lista de heroes
     * @param bool booleano con true o false
     * @param hereoe objecto de la clase heroe
     */
    private void addDeads(boolean indicador,Heroe heroe)
    {
        if (indicador){
           DeadsHeroes.add(heroe.getHeroeColor(heroe));
           this.removeHeroe(heroe.getColor());
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
