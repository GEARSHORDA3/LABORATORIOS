

    import javax.swing.ImageIcon;
    import javax.swing.JFrame;
    import javax.swing.JOptionPane;
    import java.util.List;
    import java.util.Collections;
    import java.awt.Toolkit; 
    import java.util.ArrayList;
    import java.util.ArrayList;
    import java.util.*;
    /**
     * Es el heroe que actua en la ciudad con el poder de volar 
     *
     */
    public class Heroe
    {
        private int strength;
        private Circle heroe;
        private int hidingBuilding;
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
        private ArrayList<Circle>ListaHeroes;
        private ArrayList<Rectangle>ListaVitalidad;
        private ArrayList<String> ColoresHeroes;
        private  boolean isVisible;
        private Rectangle vitalidad;
        private  ArrayList<Rectangle>vidasHeores= new ArrayList<Rectangle>();
        private boolean heroeMuerto=false;
        private boolean varibleBool=false;
        private int posiActEdiX;
        private int edificioHeroeAncho;
        private int strengthIsSafeJump;
        private boolean modoIsJumpNoSeguro=true;
        private boolean sobreviveHeroeEdi=false;
        private int strenghtt2;
        private boolean modoIsJumpOn=false;
        private int nuevaAlturaEdificio;
        private int posiEdiModificado=-1;
        private boolean veriHeroNoMuerto=false;
        private int anchoVitalidad=30;
        private ArrayList<Integer>listaPlan;
        private boolean encimaEdificio=false;
        private int numeroEdificio;
        private int EdificiosDañado= -1000000;
        private boolean hereoEnEdiRoto = false;
        /**
         * Constructor Heore
         *
         * @param  color
         * @param  hidingBuilding
         * @param  strength
         * @param  x
         * @param  y
         * @param  edificioX
         * @param  isVisible
         */
        public Heroe(String color,int hidingBuilding, int strength, int x, int y, int edificioX, boolean isVisible,int ediActualPosi){
            strenghtt2=strength;
            edificioHeroeAncho=edificioX;
            posiActEdiX=ediActualPosi;
            this.isVisible=isVisible;
            ListaVitalidad= new ArrayList<Rectangle>();
            ListaHeroes= new ArrayList<Circle>();
            ColoresHeroes= new ArrayList<String>();
            strengthIsSafeJump=strength;
            this.strength=strength;
            this.hidingBuilding=hidingBuilding;
            heroe= new Circle ();
            heroe.changeColor(color);
            heroe.setXYposition(x+((edificioX)-8),y-15);
            vitalidad = new Rectangle();
            vidasHeores.add(vitalidad);
            vitalidad.changeSize(7,anchoVitalidad);
            vitalidad.setXposition(x+(edificioX-8)-7);
            vitalidad.setYposition(y-11-12);
            ListaVitalidad.add(vitalidad);
            
            if (isVisible==true){
                vitalidad.makeVisible();
            }            

            ListaHeroes.add(heroe);
            ColoresHeroes.add(color);
        }
        
        /**
         * obtener la posicion del edifcio actual en el que se encuentra el heroe
         * @return posiActEdiX
         */
        public int getPosiActEdiX()
        {
            return posiActEdiX;
        }

        /**
             * Hacer visible el heroe
             *
             */
            public void makeVisible(){
                isVisible = true;
                draw();
            }
        
        public int getHidingBuilding()
        {
            return hidingBuilding;
        }

        public ArrayList listaVitalidad(){
                return ListaVitalidad;
            }
        
        /**
         * retornar nueva altura modificado por choque de heroe
         * @return  nuevaAlturaEdificio
         */
        public int getNuevaAlturaEdificio()
        {
            return nuevaAlturaEdificio;
        }
        
        /**
         * retornar la posiscion del edificio a modificar en altura
         * @return  posiEdiModificado
         */
        public int getposiEdiModificado()
        {
            return posiEdiModificado;
        }


        public int listaVitalidadSize(){
                    return ListaVitalidad.size();
            }
        
        /**
         * Remover la barra de vida del heroe
         *
         */
        public void removeBarraVida(){
            int i; 
               for(i=0;i<vidasHeores.size();i++){
                   vidasHeores.get(i).makeInvisible();
                      
                    }
        }
        
        /**
         * Hacer visible la barra de vida del heroe
         */
        public void PonerBarraVida(){
            int i; 
               for(i=0;i<vidasHeores.size();i++){
                   vidasHeores.get(i).makeVisible();
                      
                    }
        }
        
        public int getPositionY()
        {
         return heroe.getPositionY();
         }
         
        public int getPositionX()
        {
         return heroe.getPositionX();
         }
        
         public void setHeroeMuerto()
         {
         heroeMuerto=true;
         }
         
        
        /**
         * Retornar el objeto vitalidad del heroe
         *
         * @return    vitalidad
         */
        public Object getVida(){
            return vitalidad;
        }
        
        /**
         * Hacer visibles tantos hereos junto con sus lineas de vida
         *
         */
        private void draw() {
            if(isVisible) {
               int i; 
               for(i=0;i<ListaVitalidad.size();i++){
                   ListaVitalidad.get(i).makeVisible();
               }
               int a;
               for(a=0;a<ListaHeroes.size();a++){
                   ListaHeroes.get(a).makeVisible();
               }           
            }
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
        
        /**
         * get color heroe
         * @return color
         */
        public String getColor()
        {
            return heroe.getColor();
        }
        
        /**
         * cambiar estado de veriHeroNoMuerto=false
         */
        public void changeVeriHeroNoMuerto()
        {
            veriHeroNoMuerto=false;
        }
        
        /**
         * consultar el valor boolean de la varibale veriHeroNoMuerto
         */
        public boolean getVeriHeroNoMuerto()
        {
            return veriHeroNoMuerto;
        }
        
        /**
         * get color heroe
         *
         * @param  Object Building
         * @return color
         */
        public String getHeroeColor2(Object Heroe)
        {
            return heroe.getColor();
        }
        
        /** Mostrar estado del heroe respecto a su existencia
         * 
         * @return heroeMuerto
         */
        public boolean deads(){
            return  heroeMuerto;
        }


        /**
         * reutilizar codigo para crear mensaje
         * @param  string cadena a representar
         */
        public void mostrarMensaje(String string)
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

        /**
                 * Instrucciones para quitar una heroe al estar muerto
                 *
                 * @param  color Color del heroe
                 */
        private void BorraHeroe(String color)
        {
           String mensaje = "El heroe de color " +color +" ha muerto";
           mostrarMensaje(mensaje);
           vidasHeores.remove(0);
           heroeMuerto=true;
           vitalidad.makeInvisible();
           makeInvisible();
           strength=0; 
        }
        
        /**
         * Busca respecto a la posicion en x del heroe a que numero en x de edifico es mayor para mirar si se estrella
         *
         * @param  posicionesX  lista de las pocisiones iniciales (x) de los edificios
         * @param  infocordenadas diccionario (x) y (y) de edificios
         * @param  x posicion x heroe
         * @param  y posicion y heroe
         * @return boolean
         */
        private boolean verificaChoqueXEdificio(Hashtable infCoordenadas,double x,double y,ArrayList posicionesX,int altoCanvas,
        Hashtable durezasEdificios, Hashtable infCoordenadasAncho)
        {
            ArrayList<Integer>posicionesX2 = posicionesX;
            for(Integer i : posicionesX2){
                if (x>=i  && (posiActEdiX!=i && x<=((int)infCoordenadasAncho.get(i)+i)) && 
                ((int)infCoordenadas.get(i) <= y && y<=altoCanvas )){
                    if((strength-(int)durezasEdificios.get(i))<=0){
                        EdificiosDañado=i;
                        this.setHeroeMuerto();
                        return true; 
                    }
                    else {
                       EdificiosDañado=i;
                       if (!modoIsJumpOn){
                           strength-= (int)durezasEdificios.get(i);
                           vitalidad.changeSize(7,anchoVitalidad-5);
                           strenghtt2=strength;
                           posiActEdiX=i;
                           hidingBuilding=posicionesX2.indexOf(i);
                           sobreviveHeroeEdi=true;
                           hereoEnEdiRoto=true;
                           posiEdiModificado=posiActEdiX;
                           return false;
                        }
                       else{
                           hereoEnEdiRoto=true;
                           posiActEdiX=i;
                           sobreviveHeroeEdi=true;
                           return false;
                        }
                       
                    }
                }
                else if((i!=posiActEdiX) &&( x>i && x<=i+(int)infCoordenadasAncho.get(i)) && (y>=(int)infCoordenadas.get(i)-20 && y<=(int)infCoordenadas.get(i)-13))
                {
                    posiActEdiX=i;
                    hidingBuilding=posicionesX2.indexOf(i);
                    varibleBool=true;
                    return true;   
                }
            
           }
           return false; 
        }

            /**
            * Verifica si se sale del canvas el heroe o si choca con un edifcio
            * @param x posicion del heroe
            * @param y posicion del heroe
            * @param infCoordenadas diccionario con posiciones (x) y (y) de los edificios
            * @param altoCanvas
            * @param anchoCanvas
            * @return choque booleano 
            */
            private boolean chocoEdificio(double x,double y,int altoCanvas,int anchoCanvas,Hashtable infCoordenadas,
            String color,ArrayList posicionesX,Hashtable durezasEdificios,Hashtable infCoordenadasAncho)
            {
                if (y<=0){
                   this.setHeroeMuerto();
                   BorraHeroe(color);
                   return true;                    
                }
                else if (y>=altoCanvas-15){
                   this.setHeroeMuerto();
                   BorraHeroe(color);
                   return true;
                }
                else if (x<=0){
                   this.setHeroeMuerto();
                   BorraHeroe(color);
                   return true;                
                }
                else if (x>=anchoCanvas){
                   this.setHeroeMuerto();
                   BorraHeroe(color);
                   return true;                
                }
                else if (verificaChoqueXEdificio(infCoordenadas,x,y,posicionesX,altoCanvas,durezasEdificios,infCoordenadasAncho)){
                    if(varibleBool){
                        return false; 
                    }
                    else if(!varibleBool){
                        BorraHeroe(color);
                        return true; 
                    }
                    return true; 
                }
                return false; 
            }

        


    /** Move the heroe in form of parabolic
         * 
         * @param String color 
         * @param int angulo
         * @param int velocidad
         * @param int alturaEdi
         * @param int posy
         * @param int posx
         * @param int altoCanvas
         * @param int anchoCanvas
         * @param double avance
         * @param boolean isVisible
         * @param Hashtable infCoordenadas
         * @param ArrayList posicionesX
         * @param Hashtable durezasEdificios
         * @param Hashtable infCoordenadasAncho
         * @return void
         */
         public void Jump(String color, int angulo, int velocidad,int alturaEdi, int posy, int posx, int altoCanvas,int anchoCanvas,double avance,
         boolean isVisible,Hashtable infCoordenadas,ArrayList posicionesX,Hashtable durezasEdificios,Hashtable infCoordenadasAncho)
        {
            Canvas canvas = Canvas.getCanvas1();
            sobreviveHeroeEdi=false;
            y=0;
            int angulo2=angulo;
            if(angulo2>90){
                Math.abs(angulo-=100);
                angulo*=-1;
                velocidad*=-1;
            }
            
            if( modoIsJumpNoSeguro && !hereoEnEdiRoto){  
            t=0;
            int pos1=ColoresHeroes.indexOf(color);
            h=alturaEdi;
            vo=velocidad/4;
            if (velocidad>angulo){
                voy= 2*(vo*Math.sin(-angulo));
                vox= vo*Math.cos(angulo);
            }
            else{
                voy= 2*(vo*Math.sin(-angulo))/2;
                vox= 2*(vo*Math.cos(angulo)); 
            }            
            angulo*=Math.PI;
            angulo/=180;
            heroe.setXYposition(posicionX,posicionY);
            posicionY=posy;
            posicionX=posx;
            h=h/3; 
            boolean lento=false;
            if (avance==0.001){
                avance=0.01;
                lento=true;
            }
            while (y>-altoCanvas){
                t+=avance;
                y=((posicionY)-(voy*t) + (4.9*(t*t)));
                if (lento){ 
                   canvas.wait(70);
                }
                if (chocoEdificio(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)){
                    return;
                }
                
                else if (!chocoEdificio(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)
                &&sobreviveHeroeEdi==true){
                   heroe.setXYposition(posiActEdiX+(((int)infCoordenadasAncho.get(posiActEdiX))-12),y+2);
                   (ListaVitalidad.get(pos1)).setXYposition(heroe.getPositionX()-6,heroe.getPositionY()-7);
                   varibleBool=false;
                   nuevaAlturaEdificio=heroe.getPositionY()+15;
                   veriHeroNoMuerto=true;
                   infCoordenadas.put(posiActEdiX,(int) heroe.getPositionY()+7);
                   if (isVisible==true){
                    heroe.makeVisible();
                    ListaVitalidad.get(pos1).makeVisible();
                   }
                   return;
                }
                if (angulo2<89){
                    x=Math.abs(vox*t);
                }
                else if(angulo2>=90){
                    x=-(vox*t);
                }
                t+=avance;
                posicionX+=(x/2);
                posicionY=y;  
                (ListaVitalidad.get(pos1)).setXYposition(posicionX,posicionY);
                heroe.setXYposition(posicionX,posicionY);
                 if(varibleBool){
                    heroe.setXYposition(posiActEdiX+(((int)infCoordenadasAncho.get(posiActEdiX))-12),y+2);
                    (ListaVitalidad.get(pos1)).setXYposition(heroe.getPositionX()-6,heroe.getPositionY()-7);
                    varibleBool=false;
                    if (isVisible==true){
                    heroe.makeVisible();
                    ListaVitalidad.get(pos1).makeVisible();
                   }
                    return; 
                }
                if (isVisible==true){
                    heroe.makeVisible();
                    ListaVitalidad.get(pos1).makeVisible();
                };
            }
        }
        else if(modoIsJumpNoSeguro && hereoEnEdiRoto){ 
            hereoEnEdiRoto=false; 
            this.Jump(color, angulo,velocidad,alturaEdi, posy,posx, altoCanvas, anchoCanvas,avance,isVisible,infCoordenadas, posicionesX,durezasEdificios,infCoordenadasAncho);
        }
        }
        
        public ArrayList ColoresHeroes(){
            return ColoresHeroes;
        }
        
        public int numeroEdificio(){
            return numeroEdificio;
        }
        /**
         * obtener posicion x de heroe
         *
         * @return xheroe
         */
        public int getxPosition(){
            return heroe.getPositionX();
        }
    
        /**
         *  obtener posicion y de heroe
         *
         * @return yheroe
         */
        public int getyPosition(){
            return heroe.getPositionY();
        }    
    
        /**
         * cambiar la posicion del heroe respecto al canvas
         *
         * @param  x Double
         * @param  y Double
         */
        public void setXYposition(double x, double y){
            heroe.setPositionX(x);
            heroe.setPositionY(y);
        }  

        public void setXYposition2(double x, double y){
            heroe.setXYposition2(x,y);
        }  
    
        public void changeSize(int valor){
            heroe.changeSize(valor);
        }
        
        /** Hacer visible el heroe
         * 
         */
        public void makeVisible1(){
            heroe.makeVisible();
        }
    
        /** hacer visible el heroe
         * 
         */
        public void makeInvisible(){
            heroe.makeInvisible();
        }
    
        /** Obtener la dureza del heroe
         * 
         * @return strength
         */
        public int getStrength(){
            return strength ;
        }
        
        /**
        * Verifica si se sale del canvas el heroe o si choca con un edifcio
        * @param x posicion del heroe
        * @param y posicion del heroe
        * @param infCoordenadas diccionario con posiciones (x) y (y) de los edificios
        * @param altoCanvas
        * @param anchoCanvas
        * @return choque booleano 
        */
            private boolean chocoEdificio2(double x,double y,int altoCanvas,int anchoCanvas,Hashtable infCoordenadas,
            String color,ArrayList posicionesX,Hashtable durezasEdificios,Hashtable infCoordenadasAncho)
            {
                if (y>=altoCanvas-15){
                   varibleBool=false;
                   return false;
                }
                else if (y<=0){
                   encimaEdificio=true;
                   numeroEdificio=posiActEdiX;
                   varibleBool=false;
                   return false;                
                }
                else if (x<=0){
                   varibleBool=false;
                   return false;                
                }
                else if (x>=anchoCanvas){
                   varibleBool=false;
                   return false;                
                }
                else if (verificaChoqueXEdificio2(infCoordenadas,x,y,posicionesX,altoCanvas,durezasEdificios,infCoordenadasAncho)){
                        return true; 
                }
                return false;  
            }
            
        /**
         * Busca respecto a la posicion en x del heroe a que numero en x de edifico es mayor para mirar si se estrella
         *
         * @param  posicionesX  lista de las pocisiones iniciales (x) de los edificios
         * @param  infocordenadas diccionario (x) y (y) de edificios
         * @param  x posicion x heroe
         * @param  y posicion y heroe
         * @return boolean
         */
        private boolean verificaChoqueXEdificio2(Hashtable infCoordenadas,double x,double y,ArrayList posicionesX,int altoCanvas,
        Hashtable durezasEdificios, Hashtable infCoordenadasAncho)
        {
           ArrayList<Integer>posicionesX2 = posicionesX;
            for(Integer i : posicionesX2){
                if (x>=i  && (posiActEdiX!=i && x<=((int)infCoordenadasAncho.get(i)+i) ) && 
                ((int)infCoordenadas.get(i) <= y && y<=altoCanvas )){
                    if((strength-(int)durezasEdificios.get(i))<=0){
                        return false; 
                    }
                    else{
                       strength-= (int)durezasEdificios.get(i);
                       
                       varibleBool=true;
                       return true;
                    }
                }
                else if((i!=posiActEdiX) &&( x>i && x<=i+(int)infCoordenadasAncho.get(i)) && (y>=(int)infCoordenadas.get(i)-20 && y<=(int)infCoordenadas.get(i)-13))
                {
                    posiActEdiX=i;
                    varibleBool=true;
                    return true;   
                }
           }
           varibleBool=true;
           return false; 
        }
        
        /** Move the heroe in form of parabolic
         * 
         * @param String color, int angulo, int velocidad
         * @return boolean
         */
         public boolean isSafeJump(int posXoriginal,int posYoriginal,String color, int angulo, int velocidad,int alturaEdi, int posy, int posx,
         int altoCanvas,int anchoCanvas,double avance,boolean isVisible,Hashtable infCoordenadas,ArrayList posicionesX,Hashtable durezasEdificios,
         Hashtable infCoordenadasAncho, boolean message)
        {  
            int pos1=ColoresHeroes.indexOf(color);
            t=0;
            avance=0.01;
            h=alturaEdi;
            vo=velocidad/4;
            if(angulo>90){
                angulo*=-1;
                velocidad*=-1;
            }            
            if (velocidad>angulo){
                voy= 2*(vo*Math.sin(-angulo));
                vox= vo*Math.cos(angulo);
            }
            else{
                voy= 2*(vo*Math.sin(-angulo))/2;
                vox= 2*(vo*Math.cos(angulo)); 
            }               
            voy= vo*Math.sin(-angulo);
            vox= vo*Math.cos(angulo);
            angulo*=Math.PI;
            angulo/=180;
            heroe.setXYposition(posicionX,posicionY);
            posicionY=posy;
            posicionX=posx;
            h=h/3; 
            while (y>-altoCanvas){
                t+=avance;
                y=((posicionY)-(voy*t) + (4.9*(t*t)));
                if (chocoEdificio2(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)
                && varibleBool==true){
                   if (message){
                       Toolkit.getDefaultToolkit().beep();
                       this.mostrarMensaje("true");
                   }
                   this.Jump(color,angulo,velocidad,alturaEdi,posy,posx,altoCanvas,anchoCanvas,avance,
                   isVisible,infCoordenadas,posicionesX,durezasEdificios,infCoordenadasAncho);
                   strength=strenghtt2;
                   heroe.setXYposition(posXoriginal,posYoriginal);
                   y=0.0;
                   varibleBool=false;
                   return true;
                }
                else if(!chocoEdificio2(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)
                && varibleBool==false){
                    modoIsJumpOn=true;
                    if (message){
                        this.mostrarMensaje("false");
                    }
                    modoIsJumpNoSeguro=false;
                    strength=strenghtt2;
                    this.Jump(color,angulo,velocidad,alturaEdi,posy,posx,altoCanvas,anchoCanvas,avance,
                    isVisible,infCoordenadas,posicionesX,durezasEdificios,infCoordenadasAncho);
                    strength=strenghtt2;
                    varibleBool=true;
                    heroe.setXYposition(posXoriginal,posYoriginal);
                    y=0.0;
                    varibleBool=false;
                    modoIsJumpNoSeguro=true;
                    modoIsJumpOn=false;
                    return false;
                }
                if (angulo<89){
                    x=Math.abs(vox*t);
                }
                else{
                    x=(vox*t);
                }
                t+=avance;
                if (angulo!=80){
                    posicionX+=(x/2);
                }
                else{
                    posicionX+=x;
                }
                posicionY=y;
                heroe.setXYposition(posicionX,posicionY);
            }
            return false; 
        } 
        
        /**
         * retorna el edificios dañado por un heroe
         * @param  x cordena en x del edificio
         */
        public int getXEdiDañado()
        {
            int a = EdificiosDañado;
            EdificiosDañado= -1000000;
            return a;
            
        }

        private boolean chocoEdificio3(double x,double y,int altoCanvas,int anchoCanvas,Hashtable infCoordenadas,
            String color,ArrayList posicionesX,Hashtable durezasEdificios,Hashtable infCoordenadasAncho)
            {
                if (y<=0){
                   return true;                    
                }                
                else if (y>=altoCanvas-15){
                   return false;
                }
                else if (x<=0){
                   return true;                
                }
                else if (x>=anchoCanvas){
                   return true;                
                }
                else if (verificaChoqueXEdificio(infCoordenadas,x,y,posicionesX,altoCanvas,durezasEdificios,infCoordenadasAncho)){
                    if(varibleBool){
                        return false; 
                    }
                    else if(!varibleBool){
                        return true; 
                    }
                    return true; 
                }
                return false; 
            }        
        
        
        
        

        
        
        
        
        
        public boolean isSafeJump2(String color, int angulo, int velocidad,int alturaEdi, int posy, int posx, int altoCanvas,int anchoCanvas,double avance,
         boolean isVisible,Hashtable infCoordenadas,ArrayList posicionesX,Hashtable durezasEdificios,Hashtable infCoordenadasAncho,int posiXoriginal, int posiYoriginal)
        {
            Canvas canvas = Canvas.getCanvas1(); 
            t=0;
            y=0;
            if(angulo>90){
                angulo*=-1;
                velocidad*=-1;
            }
            int pos1=ColoresHeroes.indexOf(color);
            h=alturaEdi;
            vo=velocidad/4;
            if (velocidad>angulo){
                voy= 2*(vo*Math.sin(-angulo));
                vox= vo*Math.cos(angulo);
            }
            else{
                voy= 2*(vo*Math.sin(-angulo))/2;
                vox= 2*(vo*Math.cos(angulo)); 
            }            
            angulo*=Math.PI;
            angulo/=180;
            heroe.setXYposition(posicionX,posicionY);
            posicionY=posy;
            posicionX=posx;
            h=h/3; 
            boolean lento=false;
            while (y<altoCanvas){
                t+=avance;
                y=((posicionY)-(voy*t) + (4.9*(t*t)));
                if (chocoEdificio3(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)){
                   heroe.setXYposition(posiXoriginal,posiYoriginal);
                   return true;
                }
                if (!chocoEdificio3(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)
                &&sobreviveHeroeEdi==true){
                   varibleBool=false;
                   heroe.setXYposition(posiXoriginal,posiYoriginal);
                   return true;
                }
                if (angulo<89){
                    x=Math.abs(vox*t);
                }
                else{
                    x=(vox*t);
                }
                t+=avance;
                posicionX+=(x/2);
                posicionY=y;  
                heroe.setXYposition(posicionX,posicionY);
                if(varibleBool){
                    varibleBool=false;
                }
            }
        heroe.setXYposition(posiXoriginal,posiYoriginal);
        return false;
        }        
        
        public ArrayList getXYPositionHeroe(String Heroe){
            ArrayList<Integer>listaPositions= new ArrayList<Integer>();
            int a =heroe.getPositionX();
            int b =heroe.getPositionY();
            listaPositions.add(a);
            listaPositions.add(b);
            return listaPositions;
        }
        
}