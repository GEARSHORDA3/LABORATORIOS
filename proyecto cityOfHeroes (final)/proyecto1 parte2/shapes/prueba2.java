

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
public class prueba2
{
    /**
     * Default constructor for test class pruebafinal
     */
    public prueba2()
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
    public void CityHeores2()
    {
        CityOfHeroes cityOfHe2 = new CityOfHeroes(500, 500);
        cityOfHe2.makeVisible();
        Canvas canvas = Canvas.getCanvas1();
        cityOfHe2.addBuilding(0, 50, 100, 1);
        canvas.wait(1000);
        //cityOfHe2.addBuilding(60, 300, 30, 1);
        canvas.wait(1000);
        cityOfHe2.addHeroe("red", 1, 30);
        //canvas.wait(1000);
        //cityOfHe2.isSafeJump("red",60,30);
        cityOfHe2.jump("red",5,28,false);
        //cityOfHe2.jump("red",60,30,false);
    }
}
