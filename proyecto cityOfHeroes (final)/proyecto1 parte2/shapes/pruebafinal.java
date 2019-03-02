

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class pruebafinal.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class pruebafinal
{
    /**
     * Default constructor for test class pruebafinal
     */
    public pruebafinal()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
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

    @Test
    public void ShouldNotifyDeads() {
        CityOfHeroes ch = new CityOfHeroes(25, 250);
        ch.addBuilding(0, 10, 20, 5);
        assertTrue(ch.ok());
        ch.addBuilding(11, 10, 20, 10);
        assertTrue(ch.ok());
        ch.addHeroe("Blue", 1, 100);
        assertTrue(ch.ok());
        ch.addHeroe("yElLoW", 2, 100);
        assertTrue(ch.ok());
        ch.jump("blue", 200, 45, true);
        assertArrayEquals(ch.deads(), new String[]{"blue"});
    }
    

}

