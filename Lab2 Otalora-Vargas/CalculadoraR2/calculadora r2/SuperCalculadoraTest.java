
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
        cal.adicione(20, 90);
        operandos.add(new Velocidad(20, new Angulo(90, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
        assertTrue(cal.ok());
        cal.adicione(-40, 30);
        operandos.add(new Velocidad(-40, new Angulo(30, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
        assertTrue(cal.ok());
        cal.adicione(50, 45);
        operandos.add(new Velocidad(50, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), operandos.peek().toString());
        assertTrue(cal.ok());
    }
    
    @Test
    public void deberiaEliminar(){
        cal.adicione(20, 90);
        assertTrue(cal.ok());
        operandos.add(new Velocidad(20, new Angulo(90, Angulo.GRADOS)));
        cal.adicione(-40, 30);
        assertTrue(cal.ok());
        operandos.add(new Velocidad(-40, new Angulo(30, Angulo.GRADOS)));
        cal.adicione(50, 45);
        assertTrue(cal.ok());
        operandos.add(new Velocidad(50, new Angulo(45, Angulo.GRADOS)));
        cal.elimine();
        assertTrue(cal.ok());
        operandos.pop();
        String a = String.valueOf(cal.muestraStack());
        String b= String.valueOf(operandos);
        boolean aaa = a.equals(b);
        assertTrue(aaa);
    }
    
    @Test
    public void deberiaDuplicar(){
        cal.adicione(10, 45);
        assertTrue(cal.ok());
        cal.adicione(20, 90);
        assertTrue(cal.ok());
        cal.duplique();
        assertEquals(cal.consulteNumFinal(), cal.consulte().toString());
        

        cal.adicione(30, 45);
        assertTrue(cal.ok());
        operandos.add(new Velocidad(30, new Angulo(45, Angulo.GRADOS)));
        cal.duplique();
        assertEquals(cal.consulteNumFinal(), operandos.get(0).toString());
        
    }
    
    @Test
    public void deberiaCalcular(){
        cal.adicione(10, 45);
        operandos.add(new Velocidad(10, new Angulo(45, Angulo.GRADOS)));
        cal.adicione(-10, 45);
        operandos.add(new Velocidad(10, new Angulo(225, Angulo.GRADOS)));
        cal.adicione(10, -45);
        operandos.add(new Velocidad(10, new Angulo(315, Angulo.GRADOS)));
        cal.calcule('+');
        
        Velocidad temp = operandos.peek();
        temp=operandos.peek();
        System.out.println(temp);
        System.out.println(cal.consulte()+"  aaaaa");
        
        
        operandos.pop();
        temp.sume(operandos.peek());
        operandos.add(temp);
        System.out.println(temp);
        System.out.println(operandos.peek());
        System.out.println(cal.consulte());
        assertEquals(cal.consulte(), operandos.peek().toString());
        
        // cal.calcule('x');
        // Velocidad temp4 = operandos.peek();
        // operandos.pop();
        // temp.vectorial(operandos.peek());
        // operandos.add(temp4);
        // assertEquals(cal.consulte(), operandos.peek().toString());        
        

        // cal.calcule('-');
        // Velocidad temp2 = operandos.peek();
        // operandos.pop();
        // temp.reste(operandos.peek());
        // operandos.add(temp2);
        // assertEquals(cal.consulte(), operandos.peek().toString());
        

        // cal.calcule('*');
        // Velocidad temp3 = operandos.peek();
        // operandos.pop();
        // temp.escalar(5);
        // operandos.add(temp3);
        // assertEquals(cal.consulte(), operandos.peek().toString());
        
        

    }
    
    @Test
    public void deberiaConsultar(){
        cal.adicione(50, 95);
        assertTrue(cal.ok());
        assertEquals("longitud=50.0 grados=95.0", cal.consulte());
        cal.adicione(-50, 0);
        assertTrue(cal.ok());
        assertEquals("longitud=-50.0 grados=0.0", cal.consulte());
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