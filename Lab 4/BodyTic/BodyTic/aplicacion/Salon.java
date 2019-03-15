package aplicacion;
import java.util.*;


/**
 * @author ECI 2014
 * Salon de la aplicación egiptologos
 */
/**
 * @author ECI
 *
 */
public class Salon{
        public static final int MAXIMO = 500;
        private static Salon salon = null;
        private ArrayList<EnSalon> elementos;
        private int conta=0;
        public static Salon demeSalon() {
            if (salon==null){
                salon=new Salon();
            }
            return salon;
        }
        
        /**crear un nuevo salon*/
        public static void nuevoSalon() {
            salon=new Salon();
        }   
        
        /**cambiar entre salones*/
        public static void cambieSalon(Salon d) {
            salon=d;
        }       
        
        /**crear una lista de todos los salones que existan*/
        public Salon() {
            elementos= new ArrayList<EnSalon>();
        }
        
        /**buscar un salon sino es nulo*/
        public EnSalon deme(int n){
            EnSalon h=null;
            if (1<=n && n<=elementos.size()){
                h=elementos.get(n-1);
            }    
            return h; 
        }
    
        /**adicionar salones a la lista elementos*/
        public void adicione(EnSalon e){
            elementos.add(e);
        }
    
        /**retornar la cantidad de salones existentes con un entero*/
        public int numeroEnSalon(){
            return elementos.size();
        }
    
        /**crear todos los objetos de los salones*/
        public void entrada(){  
            PistaDeBaile Bass = new PistaDeBaile(salon,20,-20);
            Bola bol = new Bola(salon,40,10);
            Bola bol2 = new Bola(salon,480,410);
            elementos.add(bol);
            elementos.add(bol2);
            elementos.add(Bass);
            Deportista edward = new Deportista(salon,"edward",250,50,0);
            Deportista bella = new Deportista(salon, "bella",200,50,0);
            DeportistasAvanzados neo = new DeportistasAvanzados(salon,"neo",250,150);
            DeportistasAvanzados trinity = new DeportistasAvanzados(salon, "trinity",200,150);
            DeportistasHabladores han = new DeportistasHabladores(salon,"han",200,250);
            DeportistasHabladores leila = new DeportistasHabladores(salon,"leila",300,250);
            DeportistaSalsero David = new  DeportistaSalsero(salon,"David",420,150); 
            DeportistaSalsero Andres = new  DeportistaSalsero(salon,"Andres",20,150); 
        }  
        
        /**quitar todos los elemntos existentes de los salones*/
        public void salida(){
            elementos.clear();
        }
        
        /**poner en moviminto todos los elemntos de todos los salones*/
       public void inicio(){              
           for (int i=0; i<elementos.size(); i++){
               elementos.get(i).inicie();}             
       }    
       
       /**parar el movimiento que esten realizando los objetos de elementos*/
       public void parada(){
           for (int i=0; i<elementos.size(); i++){
               if (i!=2 || i!=3){
                   elementos.get(i).pare();
               }
           }           
           if (conta % 3==0 && elementos.size()>3){
               elementos.get(2).pare();
               elementos.get(3).pare();                  
           }
           conta+=1;
       }    
       
       /**poner en moviminto todos los elemntos de todos los salones*/
       public void decision(){
           for (int i=0; i<elementos.size(); i++){
               elementos.get(i).decida();
           }
       }       
    
}
