

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
    public void CityHeores()
    {
        CityOfHeroes cityOfHe1 = new CityOfHeroes(500, 500);
        cityOfHe1.makeVisible();
        cityOfHe1.addBuilding(0, 50, 100, 1);
        cityOfHe1.addBuilding(80, 200, 50, 100);
        cityOfHe1.addHeroe("red", 1, 1);
        cityOfHe1.jump("red",60,30,false);
        //cityOfHe1.addHeroe("black", 2, 1);
        // cityOfHe1.addHeroe("grey", 1, 1);
        // cityOfHe1.jump("red", 60, 40, false);
        // cityOfHe1.jump("black", 60, 40, false);
        // cityOfHe1.addHeroe("pink", 2, 1);
        // cityOfHe1.removeBuilding(3);
        // cityOfHe1.removeHeroe("pink");
        // cityOfHe1.makeInvisible();
    }
}

