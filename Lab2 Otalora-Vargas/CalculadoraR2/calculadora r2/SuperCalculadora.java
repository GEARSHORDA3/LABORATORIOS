import java.util.Stack;
import java.util.ArrayList;
import java.util.*;
/** 
 * Representa una calculadora de velocidades
 * @author ESCUELA 2018-01
 */
   

// No olvide documentar los métodos
public class SuperCalculadora{

    private Stack<Velocidad > operandos;
    // Consultar en el API Java la clase Stack
    private boolean pruebaOk=true;
    public SuperCalculadora(){
        operandos= new Stack<Velocidad>();
    }
    
    /** Adiciona la velocidad a el Stack operandos
     * @param longitud,grados la longitud el vector y el angulo con respecto al eje x
     */
    public void adicione(int longitud, int grados){
        operandos.push(new Velocidad(longitud,new Angulo(grados,1)));
        pruebaOk=true;
    }
    
    public Stack muestraStack(){
        return operandos;
    }
    
    /** Elimina la ultima velocidad del Stack
     * 
     */
    public void elimine(){
        if (operandos.empty()){
            System.out.println("El STACK esta vacio");
            pruebaOk=false;
        }
        else{
            operandos.pop();
            pruebaOk=true;
        }
    }
    
    /** Duplica el primer elemento agregandolo al final
     * 
     */
    public void duplique(){
        if (operandos.empty()){
            System.out.println("El STACK esta vacio");
            pruebaOk=false;
        }
        else{
            operandos.push(operandos.peek());
            pruebaOk=true;
        }
    }
    
    //Los caracteres de las operaciones posibles son: +, -, x (producto vectorial),h (velocidad horizontal), v (velocidad vertical)
    /** calcula suma/resta/producto vectorial entre 2 vectores
     * @param operacion es la operacion
     */
    public void calcule(char operacion){
        Velocidad vel1= operandos.peek();
        operandos.remove(0);
        if (operandos.size()==0){
            pruebaOk=false;
        }
        else if(operacion=='+'){
            vel1.sume(operandos.peek());
            operandos.add(vel1);
            pruebaOk=true;
        }
        else if(operacion=='-'){
             vel1.reste(operandos.peek());
             operandos.push(vel1);
             pruebaOk=true;
        }
        else if(operacion=='x'){
            vel1.vectorial(operandos.peek());
            operandos.push(vel1);
            pruebaOk=true;
        }
        else{
            System.out.println("operador invalido");
            pruebaOk=false;
        }
    }
  
    //Los caracteres de las operaciones posibles son: * (producto escalar), t velocidad después de un tiempo
    /** calcula producto escalar de un vector
     * @param operacion,parametro la operacion * y el numero indicado
     */
    public void calcule1(char operacion, int parametro){
        Velocidad vel2= operandos.peek();
        
        if(operacion=='*'){
            vel2.escalar(parametro);
            operandos.push(vel2);
            pruebaOk=true;
        }
        else{
            System.out.println("operador invalido");
            pruebaOk=false;
        }
    }
    
    /** Muestra el primer elemento del STACK
     *  @return String del primer elemento del STACK
     */
    public String consulte(){
        pruebaOk=true;
        return operandos.peek().toString();
    }
    
    /** Muestra el ultimo elemento del STACK
     *  @return String del ultimo elemento del STACK
     */
    public String consulteNumFinal(){
        pruebaOk=true;
        return operandos.get(operandos.size()-1).toString();
    }
    
    /** Evalua si las pruebas estan bien
     * @return el booleano pruebaOk
     */
    public boolean ok(){
        return pruebaOk;
    }
}
    



