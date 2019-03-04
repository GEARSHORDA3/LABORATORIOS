

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
        cityOfHe2.addBuilding(0, 10, 10, 5);
        cityOfHe2.addBuilding(11, 10, 200, 10);
        cityOfHe2.addBuilding(200, 10, 200, 10);
        cityOfHe2.addHeroe("Blue", 1, 100);
        cityOfHe2.jump("Blue");
        //assertFalse(cityOfHe2.isSafeJump("blue", 200, 20));
}
}
