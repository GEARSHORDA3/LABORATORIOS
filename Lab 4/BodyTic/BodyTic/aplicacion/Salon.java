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
        private int conta;
        public static Salon demeSalon() {
            if (salon==null){
                salon=new Salon();
            }
            return salon;
        }
        
        public static void nuevoSalon() {
            salon=new Salon();
        }   
        
        public static void cambieSalon(Salon d) {
            salon=d;
        }       
    
            private Salon() {
            elementos= new ArrayList<EnSalon>();
        }

        public EnSalon deme(int n){
            EnSalon h=null;
            if (1<=n && n<=elementos.size()){
                h=elementos.get(n-1);
            }    
            return h; 
        }
    
    
        public void adicione(EnSalon e){
            elementos.add(e);
        }
    
        public int numeroEnSalon(){
            return elementos.size();
        }
    

        public void entrada(){  
            // Deportista edward = new Deportista(salon,"edward",200,50);
            // Deportista bella = new Deportista(salon, "bella",150,50);
            Deportista neo = new SuperDeportista(salon,"neo",300,150);
            Deportista trinity = new SuperDeportista(salon, "trinity",250,150);            
        }  
    
        public void salida(){
            elementos.clear();
        }

       public void inicio(){
           if (conta<2){
               elementos.add(elementos.get(0));
               elementos.add(elementos.get(1));
               elementos.get(0).inicie();
               elementos.get(1).inicie();
           }
           else{
               parada();
           }
       }    

       public void parada(){                     
           elementos.get(0).pare();
           elementos.get(1).pare();    
       }    

       public void decision(){
            elementos.get(0).decida();
            elementos.get(1).decida();
       }       
    
}
