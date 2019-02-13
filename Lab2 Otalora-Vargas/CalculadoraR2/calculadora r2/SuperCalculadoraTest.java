import java.util.Stack;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SuperCalculadoraTest
{
    private SuperCalculadora cal;
    private Stack<Velocidad> operandos;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        cal = new SuperCalculadora();
        operandos = new Stack<Velocidad>();
    }

    @Test
    public void deberiaAdicionar(){
        cal.adicione(10, 45);
        operandos.add(new Velocidad(10, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
        cal.adicione(-10, 45);
        operandos.add(new Velocidad(10, new Angulo(225, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
        cal.adicione(10, -45);
        operandos.add(new Velocidad(10, new Angulo(315, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
    }
    
    @Test
    public void deberiaEliminar(){
        cal.adicione(10, 45);
        operandos.add(new Velocidad(10, new Angulo(45, Angulo.GRADOS)));
        cal.adicione(-10, 45);
        operandos.add(new Velocidad(10, new Angulo(225, Angulo.GRADOS)));
        cal.adicione(10, -45);
        operandos.add(new Velocidad(10, new Angulo(315, Angulo.GRADOS)));
        cal.elimine();
        operandos.pop();
        assertEquals(cal.consulte(), operandos.peek().toString());
        cal.elimine();
        operandos.pop();
        assertEquals(cal.consulte(), operandos.peek().toString());
    }
    
    @Test
    public void deberiaDuplicar(){
        cal.adicione(10, 45);
        operandos.add(new Velocidad(10, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
        cal.duplique();
        operandos.add(new Velocidad(10, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
        cal.duplique();
        operandos.add(new Velocidad(10, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
    }
    
    @Test
    public void deberiaOperar(){
        cal.adicione(10, 45);
        operandos.add(new Velocidad(10, new Angulo(45, Angulo.GRADOS)));
        cal.adicione(-10, 45);
        operandos.add(new Velocidad(10, new Angulo(225, Angulo.GRADOS)));
        cal.adicione(10, -45);
        operandos.add(new Velocidad(10, new Angulo(315, Angulo.GRADOS)));
        cal.calcule('+');
        Velocidad temp = operandos.peek();
        operandos.pop();
        temp.sume(operandos.peek());
        operandos.add(temp);
        assertEquals(cal.consulte(), operandos.peek().toString());
        cal.calcule('-');
        Velocidad temp2 = operandos.peek();
        operandos.pop();
        temp.reste(operandos.peek());
        operandos.add(temp2);
        assertEquals(cal.consulte(), operandos.peek().toString());
        cal.calcule('*');
        Velocidad temp3 = operandos.peek();
        operandos.pop();
        temp.escalar(5);
        operandos.add(temp3);
        assertEquals(cal.consulte(), operandos.peek().toString());
        cal.calcule('x');
        Velocidad temp4 = operandos.peek();
        operandos.pop();
        temp.vectorial(operandos.peek());;
        operandos.add(temp4);
        assertEquals(cal.consulte(), operandos.peek().toString());
    }
    
    @Test
    public void deberiaConsultar(){
        cal.adicione(10, 45);        
        assertEquals("longitud=10.0 grados=45.0", cal.consulte());
        cal.adicione(-10, 45);
        assertEquals("longitud=-10.0 grados=45.0", cal.consulte());
        // cal.adicione(10, -45);
        // assertEquals("longitud=10.0 grados=315.0", cal.consulte());
    }
    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}