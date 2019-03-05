
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityOfHeroesTest02.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CityOfHeroesTest02 {
    
    @Test
    public void segunARNoDeberiaSaltar() {
        CityOfHeroes cityOfHe1 = new CityOfHeroes(1000, 1000);
        cityOfHe1.addBuilding(100, 100, 100, 100);
        cityOfHe1.addBuilding(201, 100, 100, 100);
        cityOfHe1.addBuilding(800, 100, 100, 100);
        cityOfHe1.addBuilding(500, 100, 500, 67);
        cityOfHe1.addHeroe("black", 1, 100);
        cityOfHe1.jump("black");
        assertTrue(cityOfHe1.ok());
    }

    @Test
    public void segunARdeberiaSaltar() {
        CityOfHeroes cityOfHe1 = new CityOfHeroes(1000, 1000);
        cityOfHe1.addBuilding(100, 100, 100, 100);
        cityOfHe1.addBuilding(201, 100, 100, 100);
        cityOfHe1.addBuilding(800, 100, 100, 100);
        cityOfHe1.addBuilding(500, 100, 500, 67);
        cityOfHe1.addHeroe("black", 1, 100);
        cityOfHe1.jump("black");
        assertTrue(cityOfHe1.ok());
    }

    @Test
    public void segunARNoDeberiaSerUnSaltoSeguro() {
        CityOfHeroes cityOfHe1 = new CityOfHeroes(1000, 1000);
        cityOfHe1.addBuilding(100, 100, 100, 100);
        cityOfHe1.addBuilding(201, 100, 999, 100);
        cityOfHe1.addHeroe("black", 1, 100);
        assertFalse(cityOfHe1.isSafeJump("black", 2));
    }

    @Test
    public void segunARDeberiaSerUnSaltoSeguro() {
        CityOfHeroes cityOfHe1 = new CityOfHeroes(1000, 1000);
        cityOfHe1.addBuilding(100, 100, 100, 100);
        cityOfHe1.addBuilding(201, 100, 500, 100);
        cityOfHe1.addHeroe("black", 1, 100);
        assertTrue(cityOfHe1.isSafeJump("black", 2));
    }

    @Test
    public void segunJMDeberiaHacerZoom() {
        CityOfHeroes coh = new CityOfHeroes(700, 700);
        coh.addBuilding(100, 100, 100, 100);
        assertTrue(coh.ok());
        coh.addBuilding(220, 100, 200, 1);
        assertTrue(coh.ok());
        coh.addBuilding(400, 100, 300, 100);
        assertTrue(coh.ok());
        coh.addBuilding(501, 100, 500, 67);
        assertTrue(coh.ok());
        coh.addHeroe("yellow", 1, 100);
        assertTrue(coh.ok());
        coh.addHeroe("red", 3, 50);
        assertTrue(coh.ok());
        coh.zoom('+');
        assertTrue(coh.ok());
        coh.zoom('-');
        assertTrue(coh.ok());
    }

    @Test
    public void segunJMNoDeberiaHacerZoom() {
        CityOfHeroes coh = new CityOfHeroes(700, 700);
        coh.addBuilding(100, 100, 100, 1000);
        assertTrue(coh.ok());
        coh.addBuilding(220, 100, 200, 1);
        assertTrue(coh.ok());
        coh.addBuilding(501, 100, 500, 67);
        assertTrue(coh.ok());
        coh.addHeroe("yellow", 1, 100);
        assertTrue(coh.ok());
        coh.addHeroe("red",2,50);
        assertTrue(coh.ok());
        coh.zoom('*');
        assertFalse(coh.ok());
    }
    
    @Test
    public void segunJMDeberiaSaltoOptimo() {
        CityOfHeroes cityOfHe1 = new CityOfHeroes(600, 600);
        cityOfHe1.addBuilding(0, 100, 300, 100);
        cityOfHe1.addBuilding(301, 50, 50, 100);
        cityOfHe1.addHeroe("red", 1, 100);
        cityOfHe1.addBuilding(200, 100, 300, 100);
        cityOfHe1.jump("red");
        assertTrue(cityOfHe1.ok());
    }
    
    @Test
    public void segunJMNoDeberiaSaltoOptimo() {
        CityOfHeroes cityOfHe1 = new CityOfHeroes(600, 600);
        cityOfHe1.addBuilding(0, 100, 300, 100);
        cityOfHe1.addHeroe("red", 1, 100);
        cityOfHe1.jump("red");
        assertFalse(cityOfHe1.ok());
    }

    @Test
    public void shouldDoUndo() {
        CityOfHeroes ch = new CityOfHeroes(100, 250);
        ch.addBuilding(0, 10, 20, 5);
        assertTrue(ch.ok());
        ch.addBuilding(11, 10, 20, 10);
        assertTrue(ch.ok());
        
        ch.addHeroe("Blue", 1, 100);
        assertTrue(ch.ok());
        ch.addHeroe("yElLoW", 2, 50);
        assertTrue(ch.ok());
        ch.undo();
        ch.addHeroe("yElLoW", 2, 50);
        assertTrue(ch.ok());
    }
    
    @Test
    public void shouldDoRedo() {
        CityOfHeroes ch = new CityOfHeroes(100, 250);
        ch.addBuilding(0, 10, 20, 5);
        assertTrue(ch.ok());
        ch.addBuilding(11, 10, 20, 10);
        assertTrue(ch.ok());
        
        ch.addHeroe("Blue", 1, 100);
        assertTrue(ch.ok());
        ch.addHeroe("yElLoW", 2, 50);
        assertTrue(ch.ok());
        ch.undo();
        assertTrue(ch.ok());
        ch.redo();
        assertTrue(ch.ok());
        ch.addHeroe("yElLoW", 2, 50);
        assertFalse(ch.ok());
    }
    
    @Test
    public void shouldConsultCity() {
        CityOfHeroes ch = new CityOfHeroes(100, 250);
        ch.addBuilding(0, 10, 20, 5);
        assertTrue(ch.ok());
        ch.addBuilding(11, 10, 20, 10);
        assertTrue(ch.ok());
        
        ch.addHeroe("Blue", 1, 100);
        assertTrue(ch.ok());
        ch.addHeroe("yElLoW", 2, 100);
        assertTrue(ch.ok());
        
        Integer[][] city = ch.city();
        assertArrayEquals(city[0], new Integer[]{0, 10, 20, 5, 11, 10, 20, 10});
        assertArrayEquals(city[1], new Integer[]{1, 100, 2, 100});
    }
}
