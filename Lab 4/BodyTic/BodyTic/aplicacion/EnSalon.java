package aplicacion;
import java.awt.Color;
import java.util.Random;

public interface EnSalon{
    public static String[] FORMAS = new String[]{"Persona","Circulo", "Cuadrado"};
    Random r = new Random(1);
    
    /**metodo para los elementos que implemeten su interfaz haciendo que retorne su posicion en x*/
    int getPosicionX();
    
    /**metodo para los elementos que implemeten su interfaz haciendo que retorne su posicion en y*/
    int getPosicionY();
    
    /**color que se  va a pedir para su caracteristica para quienes lo implementen y lo utilizen para informacion*/
    Color getColor();
    
    /**iniciar el movimiento del objeto*/
    void inicie();
    
    /**parar el movimiento del objeto*/
    void pare();
    
    /**iniciar el movimiento del DeportistasAvanzados sobreescribiendolo*/
    default String forma(){
       return FORMAS[1];
    }
    
    
    /**
     * Da un mensaje vacio
     */
    default String mensaje(){
       return "";
    }
    
    /**
     * Decide aleatoriamente la acción a tomar
     */
    default void decida(){
        if (r.nextBoolean()){
            inicie();
        }else{
            pare();
        }
    }
}
