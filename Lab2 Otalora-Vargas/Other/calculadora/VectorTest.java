

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VectorTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VectorTest
{

    private Vector vector1, vector2, vector3, vector4, vector5;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        vector1 = new Vector(5, new Angulo(45, Angulo.GRADOS));
        vector2 = new Vector(10, new Angulo(0, Angulo.GRADOS));
        vector3 = new Vector(15, new Angulo(90, Angulo.GRADOS));
        vector4 = new Vector(20, new Angulo(-90, Angulo.GRADOS));
        vector5 = new Vector(20, new Angulo(-45, Angulo.GRADOS));
    }

    
    @Test
    public void deberiaCrearBienLosVectores(){
        assertTrue (vector1.equals(vector1));
        assertTrue (vector1.equals(new Vector(5, new Angulo(45, Angulo.GRADOS))));
        assertTrue ((new Vector(10, new Angulo(0, Angulo.GRADOS))).equals((new Vector(10, new Angulo(0, Angulo.GRADOS)))));
        assertFalse(vector1.equals(vector2));
    }
    
    @Test
    public void deberiaDarLasCoordenadasEnX(){
        assertEquals(10.0, vector2.coordenadaX(), Vector.MAXERROR);
        assertEquals(0, vector3.coordenadaX(), Vector.MAXERROR);
        assertEquals(0, vector4.coordenadaX(), Vector.MAXERROR);
        assertEquals(3.5355339059327378, vector1.coordenadaX(), Vector.MAXERROR);
        assertEquals(14.142135623730955, vector5.coordenadaX(), Vector.MAXERROR);
    }
    
    @Test
    public void deberiaDarLasCoordenadasEnY(){
        assertEquals(0, vector2.coordenadaY(), Vector.MAXERROR);
        assertEquals(15, vector3.coordenadaY(), Vector.MAXERROR);
        assertEquals(-20, vector4.coordenadaY(), Vector.MAXERROR);
        assertEquals(3.5355339059327378, vector1.coordenadaY(), Vector.MAXERROR);
        assertEquals(-14.142135623730955, vector5.coordenadaY(), Vector.MAXERROR);
    }
    
    @Test 
    public void deberiaDevolverElAngulo(){
        assertEquals(vector1.angulo(),new Angulo(45, Angulo.GRADOS));
        assertEquals(vector2.angulo(),new Angulo(0, Angulo.GRADOS));
        assertEquals(vector3.angulo(),new Angulo(90, Angulo.GRADOS));
        assertEquals(vector4.angulo(),new Angulo(-90, Angulo.GRADOS));
        assertEquals(vector5.angulo(),new Angulo(-45, Angulo.GRADOS));
    }
    
    @Test
    public void deberiaDevolverLaLongitud(){
        assertEquals(5, vector1.longitud(), Vector.MAXERROR);
        assertEquals(10, vector2.longitud(), Vector.MAXERROR);
        assertEquals(15, vector3.longitud(), Vector.MAXERROR);
        assertEquals(20, vector4.longitud(), Vector.MAXERROR);
        assertEquals(20, vector5.longitud(), Vector.MAXERROR);
    }
    
    @Test
    public void deberiaDecirLaDistancia(){
        assertEquals(35, vector3.distancia(vector4), Vector.MAXERROR);
        assertEquals(20.615528128088304, vector1.distancia(vector5), Vector.MAXERROR);
        assertEquals(20.615528128088304, vector5.distancia(vector1), Vector.MAXERROR);
    }
    
    @Test
    public void deberiaTrasladar(){
        Vector vector21 = new Vector(10, new Angulo(0, Angulo.GRADOS));
        vector21.traslade(vector1.coordenadaX(), vector1.coordenadaY());
        assertEquals(vector1, vector21);
        vector21.traslade(vector2.coordenadaX(), vector2.coordenadaY());
        assertEquals(vector2, vector21);
        vector21.traslade(vector3.coordenadaX(), vector3.coordenadaY());
        assertEquals(vector3, vector21);
    }
    
    @Test
    public void deberiaMultiplicarEscalar(){
        Vector vector21 = new Vector(10, new Angulo(0, Angulo.GRADOS));
        vector21.productoEscalar(2);
        assertEquals(20, vector21.coordenadaX(), Vector.MAXERROR);
        assertEquals(0, vector21.coordenadaY(), Vector.MAXERROR);
        Vector vector22 = new Vector(10, new Angulo(90, Angulo.GRADOS));
        vector22.productoEscalar(1.5);
        assertEquals(0, vector22.coordenadaX(), Vector.MAXERROR);
        assertEquals(15, vector22.coordenadaY(), Vector.MAXERROR);
        Vector vector23 = new Vector(10, new Angulo(45, Angulo.GRADOS));
        vector23.productoEscalar(3);
        assertEquals(21.213203435596427, vector23.coordenadaX(), Vector.MAXERROR);
        assertEquals(21.213203435596427, vector23.coordenadaY(), Vector.MAXERROR);
    }
    
    @Test
    public void deberiaRotar(){
        Vector vector21 = new Vector(10, new Angulo(0, Angulo.GRADOS));
        Vector vector22 = new Vector(10, new Angulo(0, Angulo.GRADOS));
        vector22.rote(new Angulo(360, Angulo.GRADOS));
        assertEquals(vector21, vector22);
        Vector vector23 = new Vector(10, new Angulo(90, Angulo.GRADOS));
        Vector vector24 = new Vector(10, new Angulo(45, Angulo.GRADOS));
        vector24.rote(new Angulo(45, Angulo.GRADOS));
        assertEquals(vector23, vector24);
        Vector vector25 = new Vector(10, new Angulo(10, Angulo.GRADOS));
        Vector vector26 = new Vector(10, new Angulo(350, Angulo.GRADOS));
        vector26.rote(new Angulo(20, Angulo.GRADOS));
        assertEquals(vector25, vector26);
    }
    
    @Test
    public void deberiaSumar(){
        Vector vector12 = new Vector(5, new Angulo(0, Angulo.GRADOS));
        Vector vector21 = new Vector(10, new Angulo(0, Angulo.GRADOS));
        Vector vector31 = new Vector(15, new Angulo(0, Angulo.GRADOS));
        vector12.sume(vector21);
        assertEquals(vector12, vector31);
        vector12.sume(vector3);
        Vector vectorTemp = new Vector(15, new Angulo(0, Angulo.GRADOS));
        vectorTemp.traslade(15, 15);
        assertEquals(vector12, vectorTemp);
    }
    
    @Test
    public void deberiaRestar(){
        Vector vector12 = new Vector(5, new Angulo(0, Angulo.GRADOS));
        Vector vector21 = new Vector(10, new Angulo(0, Angulo.GRADOS));
        Vector vector31 = new Vector(15, new Angulo(0, Angulo.GRADOS));
        vector31.reste(vector21);
        assertEquals(vector12, vector31);
        vector21.reste(vector12);
        assertEquals(vector12, vector21);
    }
    
    @Test
    public void deberiaMultiplicarVectores(){
        Vector vector12 = new Vector(5, new Angulo(0, Angulo.GRADOS));
        Vector vector21 = new Vector(88.38834764831844, new Angulo(0, Angulo.GRADOS));
        Vector vector31 = new Vector(15, new Angulo(45, Angulo.GRADOS));
        Vector vector41 = new Vector(1125, new Angulo(45, Angulo.GRADOS));
        vector12.multiplique(vector1);
        assertEquals(vector21, vector12);
        vector31.multiplique(vector1);
        assertEquals(vector41, vector31);
    }
    
    @Test
    public void deberiaConvertirloString(){
        assertEquals("r=5.0 grados=45.0", vector1.toString());
        assertEquals("r=10.0 grados=0.0", vector2.toString());
        assertEquals("r=15.0 grados=90.0", vector3.toString());
        assertEquals("r=20.0 grados=270.0", vector4.toString());
        assertEquals("r=20.0 grados=315.0", vector5.toString());
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
