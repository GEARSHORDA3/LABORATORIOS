import java.util.Stack;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest
{
    private Calculadora cal;
    private Stack<Vector> vectores;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){
        cal = new Calculadora();
        vectores = new Stack<Vector>();
    }

    @Test
    public void deberiaAdicionar(){
        cal.adicione(10, 45);
        vectores.add(new Vector(10, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), vectores.peek().toString());
        cal.adicione(-10, 45);
        vectores.add(new Vector(10, new Angulo(225, Angulo.GRADOS)));
        assertEquals(cal.consulte(), vectores.peek().toString());
        cal.adicione(10, -45);
        vectores.add(new Vector(10, new Angulo(315, Angulo.GRADOS)));
        assertEquals(cal.consulte(), vectores.peek().toString());
    }
    
    @Test
    public void deberiaEliminar(){
        cal.adicione(10, 45);
        vectores.add(new Vector(10, new Angulo(45, Angulo.GRADOS)));
        cal.adicione(-10, 45);
        vectores.add(new Vector(10, new Angulo(225, Angulo.GRADOS)));
        cal.adicione(10, -45);
        vectores.add(new Vector(10, new Angulo(315, Angulo.GRADOS)));
        cal.elimine();
        vectores.pop();
        assertEquals(cal.consulte(), vectores.peek().toString());
        cal.elimine();
        vectores.pop();
        assertEquals(cal.consulte(), vectores.peek().toString());
    }
    
    @Test
    public void deberiaDuplicar(){
        cal.adicione(10, 45);
        vectores.add(new Vector(10, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), vectores.peek().toString());
        cal.duplique();
        vectores.add(new Vector(10, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), vectores.peek().toString());
        cal.duplique();
        vectores.add(new Vector(10, new Angulo(45, Angulo.GRADOS)));
        assertEquals(cal.consulte(), vectores.peek().toString());
    }
    
    @Test
    public void deberiaOperar(){
        cal.adicione(10, 45);
        vectores.add(new Vector(10, new Angulo(45, Angulo.GRADOS)));
        cal.adicione(-10, 45);
        vectores.add(new Vector(10, new Angulo(225, Angulo.GRADOS)));
        cal.adicione(10, -45);
        vectores.add(new Vector(10, new Angulo(315, Angulo.GRADOS)));
        cal.opere('+');
        Vector temp = vectores.peek();
        vectores.pop();
        temp.sume(vectores.peek());
        vectores.add(temp);
        assertEquals(cal.consulte(), vectores.peek().toString());
        cal.opere('-');
        Vector temp2 = vectores.peek();
        vectores.pop();
        temp.reste(vectores.peek());
        vectores.add(temp2);
        assertEquals(cal.consulte(), vectores.peek().toString());
        cal.opere('*');
        Vector temp3 = vectores.peek();
        vectores.pop();
        temp.productoEscalar(5.0);
        vectores.add(temp3);
        assertEquals(cal.consulte(), vectores.peek().toString());
        cal.opere('x');
        Vector temp4 = vectores.peek();
        vectores.pop();
        temp.multiplique(vectores.peek());;
        vectores.add(temp4);
        assertEquals(cal.consulte(), vectores.peek().toString());
    }
    
    @Test
    public void deberiaConsultar(){
        cal.adicione(10, 45);
        assertEquals("r=10.0 grados=45.0", cal.consulte());
        cal.adicione(-10, 45);
        assertEquals("r=10.0 grados=225.0", cal.consulte());
        cal.adicione(10, -45);
        assertEquals("r=10.0 grados=315.0", cal.consulte());
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
