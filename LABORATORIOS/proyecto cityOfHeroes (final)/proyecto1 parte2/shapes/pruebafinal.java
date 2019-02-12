

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
        CityOfHeroes cityOfHe1 = new CityOfHeroes(600, 600);
        cityOfHe1.makeVisible();
        cityOfHe1.addBuilding(0, 60, 100, 1);
        cityOfHe1.addBuilding(100, 100, 400, 1);
        cityOfHe1.addBuilding(300, 150, 480, 1);
        cityOfHe1.addHeroe("red", 3, 1);
        cityOfHe1.addHeroe("black", 2, 1);
        cityOfHe1.addHeroe("grey", 1, 1);
        cityOfHe1.jump("red", 60, 40, false);
        cityOfHe1.jump("black", 60, 40, false);
        cityOfHe1.addHeroe("pink", 2, 1);
        cityOfHe1.removeBuilding(3);
        cityOfHe1.removeHeroe("pink");
        cityOfHe1.makeInvisible();
    }
}

