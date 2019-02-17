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
        public Heroe(String color,int hidingBuilding, int strength, int x, int y, int edificioX, boolean isVisible){
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
         * Verifica si se sale del canvas el heroe o si choca con un edifcio
         * @param x posicion del heroe
         * @param y posicion del heroe
         * @param infCoordenadas diccionario con posiciones (x) y (y) de los edificios
         * @param altoCanvas
         * @param anchoCanvas
         * @return choque booleano 
         */
        private boolean chocoEdificio(double x,double y,int altoCanvas,int anchoCanvas,Hashtable infCoordenadas,String color)
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
            
            
        return false;
    }


    /** Move the heroe in form of parabolic
     * 
     * @param String color, int angulo, int velocidad
     * @return void
     */
     public void Jump(String color, int angulo, int velocidad,int alturaEdi, int posy, int posx, int altoCanvas,int anchoCanvas,double avance,
     boolean isVisible,Hashtable infCoordenadas)
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
            x= Math.abs(vox*t);
            
            if (chocoEdificio(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color)){
               return;
            }
            else if (chocoEdificio(posicionX,y,altoCanvas,anchoCanvas,infCoordenadas,color)){
               return;                
            }
            t+=avance;
            posicionX+=(x/2);
            posicionY=y;
            (ListaVitalidad.get(pos1)).setXYposition(posicionX,posicionY);
            heroe.setXYposition(posicionX,posicionY);
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
    public boolean isSafeJump(String color, int angulo, int velocidad,int alturaEdi, int posy, int posx, int altoCanvas, double avance, double posiXheroe, double posiYheroe, boolean rta)
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
                rta=false;
                return rta;
            }
            else if (y<=-posicionY){
                rta=false;
                return rta;                
            }
            x= Math.abs(vox*t);
            t+=avance;
            posicionX+=(x/2);
            posicionY=y;
            posiXheroe=posicionX;
            posiYheroe=posicionY;
        }
        return true;
    } 
    

}