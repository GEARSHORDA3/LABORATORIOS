

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
            posiActEdiX=ediActualPosi;
            this.isVisible=isVisible;
            ListaVitalidad= new ArrayList<Rectangle>();
            ListaHeroes= new ArrayList<Circle>();
            ColoresHeroes= new ArrayList<String>();
            this.strength=strength;
            this.hidingBuilding=hidingBuilding;
            heroe= new Circle ();
            heroe.changeColor(color);
            heroe.setXYposition(x+((edificioX)-12),y-15);
            vitalidad = new Rectangle();
            vidasHeores.add(vitalidad);
            vitalidad.changeSize(7,30);
            vitalidad.setXposition(x+(edificioX-8)-7);
            vitalidad.setYposition(y-11-12);
            if (isVisible==true){
                vitalidad.makeVisible();
            }            
            ListaVitalidad.add(vitalidad);
            ListaHeroes.add(heroe);
            ColoresHeroes.add(color);
        }
        
        /**
         * Hacer visible el heroe
         *
         */
        public void makeVisible(){
            isVisible = true;
            draw();
        }
        
        public ArrayList listaVitalidad(){
            return ListaVitalidad;
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
        public boolean estaHeroDead(){
            return  heroeMuerto;
        }
        
        
        /**
         * Instrucciones para quitar una heroe al estar muerto
         *
         * @param  color Color del heroe
         */
        private void BorraHeroe(String color)
        {
           Toolkit.getDefaultToolkit().beep();
           JOptionPane.showMessageDialog(null, "El heroe de color " +color +" ha muerto");  
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
                if (x>=i  && (posiActEdiX!=i && posiActEdiX<=((int)infCoordenadasAncho.get(i)+i) ) && 
                ((int)infCoordenadas.get(i) <= y && y<=altoCanvas )){
                    
                    if((strength-(int)durezasEdificios.get(i))<=0){
                        return true; 
                    }
                    else{
                       strength-= (int)durezasEdificios.get(i);
                       return false;
                    }
                }
                else if((i!=posiActEdiX) &&( x>i && x<=i+(int)infCoordenadasAncho.get(i)) && (y>=(int)infCoordenadas.get(i)-20 && y<=(int)infCoordenadas.get(i)-13)){
                    posiActEdiX=i;
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
                if (y>=altoCanvas-15){
                   BorraHeroe(color);
                   return true;
                }
                else if (y<=0){
                   BorraHeroe(color);
                   return true;                
                }
                else if (x<=0){
                   BorraHeroe(color);
                   return true;                
                }
                else if (x>=anchoCanvas){
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
         * @param String color, int angulo, int velocidad
         * @return void
         */
         public void Jump(String color, int angulo, int velocidad,int alturaEdi, int posy, int posx, int altoCanvas,int anchoCanvas,double avance,
         boolean isVisible,Hashtable infCoordenadas,ArrayList posicionesX,Hashtable durezasEdificios,Hashtable infCoordenadasAncho)
        {   
            //
            int pos1=ColoresHeroes.indexOf(color);
            //
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
                if (chocoEdificio(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)){
                   return;
                }
                x= Math.abs(vox*t);
                t+=avance;
                posicionX+=(x/2);
                posicionY=y;
                (ListaVitalidad.get(pos1)).setXYposition(posicionX,posicionY);
                heroe.setXYposition(posicionX,posicionY);
                
                if(varibleBool){
                    (ListaVitalidad.get(pos1)).setXYposition(posicionX,posicionY);
                    heroe.setXYposition(posicionX,posicionY);
                    heroe.setXYposition(posiActEdiX+(((int)infCoordenadasAncho.get(posiActEdiX))-12),y-15);
                    varibleBool=false;
                    return; 
                }
                if (isVisible==true){
                    heroe.makeVisible();
                    ListaVitalidad.get(pos1).makeVisible();
                };
            }    
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
    
        /** Move the heroe in form of parabolic
         * 
         * @param String color, int angulo, int velocidad
         * @return boolean
         */
         public boolean isSafeJump(int posXoriginal,int posYoriginal,String color, int angulo, int velocidad,int alturaEdi, int posy, int posx, int altoCanvas,int anchoCanvas,double avance,
         boolean isVisible,Hashtable infCoordenadas,ArrayList posicionesX,Hashtable durezasEdificios,Hashtable infCoordenadasAncho)
        {   
            //
            int pos1=ColoresHeroes.indexOf(color);
            //
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
                if (chocoEdificio(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)){
                   posicionX=posXoriginal;
                   posicionY=posYoriginal;
                   heroe.setXYposition(posicionX,posicionY); 
                   Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null, "true");                    
                   return true;
                }
                if (!chocoEdificio(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color,posicionesX,durezasEdificios,infCoordenadasAncho)){
                   posicionX=posXoriginal;
                   posicionY=posYoriginal;                    
                   heroe.setXYposition(posicionX,posicionY);
                   Toolkit.getDefaultToolkit().beep();
                   JOptionPane.showMessageDialog(null, "false");
                   return false;
                }                
                x= Math.abs(vox*t);
                t+=avance;
                posicionX+=(x/2);
                posicionY=y;
                (ListaVitalidad.get(pos1)).setXYposition(posicionX,posicionY);
                heroe.setXYposition(posicionX,posicionY);
                if(varibleBool){
                    (ListaVitalidad.get(pos1)).setXYposition(posicionX,posicionY);
                    heroe.setXYposition(posicionX,posicionY);
                    heroe.setXYposition(posiActEdiX+(((int)infCoordenadasAncho.get(posiActEdiX))-12),y-15);
                    varibleBool=false;
                    posicionX=posXoriginal;
                    posicionY=posYoriginal;                        
                    heroe.setXYposition(posicionX,posicionY);
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(null, "true"); 
                    return true; 
                }
                if (isVisible==true){
                    //heroe.makeVisible();
                    ListaVitalidad.get(pos1).makeVisible();
                };
            }  
            posicionX=posXoriginal;
            posicionY=posYoriginal;                        
            heroe.setXYposition(posicionX,posicionY);
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "false");
            return false;
        } 
    

}