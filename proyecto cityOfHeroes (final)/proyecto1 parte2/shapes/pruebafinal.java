

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
        Canvas canvas = Canvas.getCanvas1();
        cityOfHe1.addBuilding(0, 50, 100, 1);
        canvas.wait(700);
        cityOfHe1.addBuilding(60,300,50, 20);
        canvas.wait(700);
        cityOfHe1.addHeroe("red", 1, 30);
        canvas.wait(700);
        cityOfHe1.isSafejump("red",60,30);
        cityOfHe1.jump("red",60,30,false);
        cityOfHe1.jump("red",60,30,false);
        //cityOfHe1.jump("red",60,30,false);
        //cityOfHe1.jump("red",60,30,false);
    }
}

