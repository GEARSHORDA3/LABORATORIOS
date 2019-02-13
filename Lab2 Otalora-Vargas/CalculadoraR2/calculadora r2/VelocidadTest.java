
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VelocidadTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VelocidadTest
{

    private Velocidad Velocidad1, Velocidad2, Velocidad3, Velocidad4, Velocidad5;
    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        Velocidad1 = new Velocidad(5, new Angulo(45, Angulo.GRADOS));
        Velocidad2 = new Velocidad(10, new Angulo(0, Angulo.GRADOS));
        Velocidad3 = new Velocidad(15, new Angulo(90, Angulo.GRADOS));
        Velocidad4 = new Velocidad(20, new Angulo(-90, Angulo.GRADOS));
        Velocidad5 = new Velocidad(20, new Angulo(-45, Angulo.GRADOS));
    }

    
    @Test
    public void deberiaCrearBienLosVelocidades(){
        assertTrue (Velocidad1.equals(Velocidad1));
        assertTrue (Velocidad1.equals(new Velocidad(5, new Angulo(45, Angulo.GRADOS))));
        assertFalse ((new Velocidad(10, new Angulo(0, Angulo.GRADOS))).equals((new Velocidad(10, new Angulo(0, Angulo.GRADOS)))));
        assertFalse(Velocidad1.equals(Velocidad2));
    }
    
    @Test
    public void deberiaDarLasCoordenadasEnX(){
        assertEquals(10.0, Velocidad2.componenteH(), Velocidad.MAXERROR);
        assertEquals(0, Velocidad3.componenteH(), Velocidad.MAXERROR);
        assertEquals(0, Velocidad4.componenteH(), Velocidad.MAXERROR);
        assertEquals(3.5355339059327378, Velocidad1.componenteH(), Velocidad.MAXERROR);
        assertEquals(14.142135623730955, Velocidad5.componenteH(), Velocidad.MAXERROR);
    }
    
    @Test
    public void deberiaDarLasCoordenadasEnY(){
        assertEquals(0, Velocidad2.componenteV(), Velocidad.MAXERROR);
        assertEquals(15, Velocidad3.componenteV(), Velocidad.MAXERROR);
        assertEquals(-20, Velocidad4.componenteV(), Velocidad.MAXERROR);
        assertEquals(3.5355339059327378, Velocidad1.componenteV(), Velocidad.MAXERROR);
        assertEquals(-14.142135623730955, Velocidad5.componenteV(), Velocidad.MAXERROR);
    }
    
    @Test 
    public void deberiaDevolverElAngulo(){
        assertEquals(Velocidad1.angulo(),new Angulo(45, Angulo.GRADOS));
        assertEquals(Velocidad2.angulo(),new Angulo(0, Angulo.GRADOS));
        assertEquals(Velocidad3.angulo(),new Angulo(90, Angulo.GRADOS));
        assertEquals(Velocidad4.angulo(),new Angulo(-90, Angulo.GRADOS));
        assertEquals(Velocidad5.angulo(),new Angulo(-45, Angulo.GRADOS));
    }
    
    @Test
    public void deberiaDevolverLaLongitud(){
        assertEquals(5, Velocidad1.longitud(), Velocidad.MAXERROR);
        assertEquals(10, Velocidad2.longitud(), Velocidad.MAXERROR);
        assertEquals(15, Velocidad3.longitud(), Velocidad.MAXERROR);
        assertEquals(20, Velocidad4.longitud(), Velocidad.MAXERROR);
        assertEquals(20, Velocidad5.longitud(), Velocidad.MAXERROR);
    }
    
    // @Test
    // public void deberiaDecirLaDistancia(){
        // assertEquals(35, Velocidad3.distancia(Velocidad4), Velocidad.MAXERROR);
        // assertEquals(20.615528128088304, Velocidad1.distancia(Velocidad5), Velocidad.MAXERROR);
        // assertEquals(20.615528128088304, Velocidad5.distancia(Velocidad1), Velocidad.MAXERROR);
    // }
    

    @Test
    public void deberiaMultiplicarEscalar(){
        Velocidad Velocidad21 = new Velocidad(10, new Angulo(0, Angulo.GRADOS));
        Velocidad21.escalar(4);
        assertEquals(40, Velocidad21.componenteH(), Velocidad.MAXERROR);
        assertEquals(0, Velocidad21.componenteV(), Velocidad.MAXERROR);
        Velocidad Velocidad23 = new Velocidad(10, new Angulo(45, Angulo.GRADOS));
        Velocidad23.escalar(3);
        assertEquals(21.213203435596427, Velocidad23.componenteH(), Velocidad.MAXERROR);
        assertEquals(21.213203435596427, Velocidad23.componenteV(), Velocidad.MAXERROR);
    }
    
    // @Test
    // public void deberiaRotar(){

    // }
    
    // @Test
    // public void deberiaSumar(){

    // }
    
    @Test
    public void deberiaRestar(){
        Velocidad Velocidad12 = new Velocidad(5, new Angulo(0, Angulo.GRADOS));
        Velocidad Velocidad21 = new Velocidad(10, new Angulo(0, Angulo.GRADOS));
        Velocidad Velocidad31 = new Velocidad(15, new Angulo(0, Angulo.GRADOS));
        Velocidad31.reste(Velocidad21);
        assertEquals(Velocidad12.longitud(),Velocidad31.longitud(),1);
        assertEquals(Velocidad12.angulo(),Velocidad31.angulo());
        Velocidad21.reste(Velocidad12);
        assertEquals(Velocidad12.longitud(),Velocidad21.longitud(),1);
        assertEquals(Velocidad12.angulo(),Velocidad21.angulo());
    }
    
    // @Test
    // public void deberiaMultiplicarVelocidades(){
        // Velocidad Velocidad12 = new Velocidad(5, new Angulo(0, Angulo.GRADOS));
        // Velocidad Velocidad21 = new Velocidad(88.38834764831844, new Angulo(0, Angulo.GRADOS));
        // Velocidad Velocidad31 = new Velocidad(15, new Angulo(45, Angulo.GRADOS));
        // Velocidad Velocidad41 = new Velocidad(1125, new Angulo(45, Angulo.GRADOS));
        // Velocidad12.multiplique(Velocidad1);
        // assertEquals(Velocidad21, Velocidad12);
        // Velocidad31.multiplique(Velocidad1);
        // assertEquals(Velocidad41, Velocidad31);
    // }
    
    @Test
    public void deberiaConvertirloString(){
        assertEquals("r=5.0 grados=45.0", Velocidad1.toString());
        assertEquals("r=10.0 grados=0.0", Velocidad2.toString());
        assertEquals("r=15.0 grados=90.0", Velocidad3.toString());
        assertEquals("r=20.0 grados=270.0", Velocidad4.toString());
        assertEquals("r=20.0 grados=315.0", Velocidad5.toString());
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