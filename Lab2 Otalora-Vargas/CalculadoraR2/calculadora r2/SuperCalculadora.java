import java.util.Stack;

/** 
 * Representa una calculadora de velocidades
 * @author ESCUELA 2018-01
 */
   

// No olvide documentar los métodos
public class SuperCalculadora{

    private Stack<Velocidad > operandos;
    // Consultar en el API Java la clase Stack
    
    public SuperCalculadora(){
        operandos= new Stack<Velocidad>();
    }
    
    public void adicione(int longitud, int grados){
        operandos.push(new Velocidad(longitud,new Angulo(grados,1)));
    }
    
    public void elimine(){
        if (operandos.empty()){
            System.out.println("El STACK esta vacio");
        }
        else{
            operandos.pop();
        }
    }
    
    public void duplique(){
        if (operandos.empty()){
            System.out.println("El STACK esta vacio");
        }
        else{
            operandos.push(operandos.peek());
        }
    }
    
    //Los caracteres de las operaciones posibles son: +, -, x (producto vectorial),h (velocidad horizontal), v (velocidad vertical)
    public void calcule(char operacion){
        Velocidad vel1= operandos.peek();
        operandos.pop();
        switch (operacion){
            case '+': vel1.sume(operandos.peek());
                      operandos.push(vel1);
                      break;
            case '-': vel1.reste(operandos.peek());
                      operandos.push(vel1);
                      break;
            case 'x': vel1.vectorial(operandos.peek());
                      operandos.push(vel1);
                      break;       
        }
    }
  
    //Los caracteres de las operaciones posibles son: * (producto escalar), t velocidad después de un tiempo
    public void calcule(char operacion, int parametro){
        Velocidad vel2= operandos.peek();
        operandos.pop();
        switch (operacion){
            case '*': vel2.escalar(parametro);
                      operandos.push(vel2);
                      break;
            case 't': operandos.push(operandos.pop());
                      break;
        }        
    }
    
    /** Muestra el ultimo elemento del STACK
     *  @return String del ultimo elemento del STACK
     */
    public String consulte(){
        return operandos.peek().toString();
    }
    
    public boolean ok(){
        return false;
    }
}
    



