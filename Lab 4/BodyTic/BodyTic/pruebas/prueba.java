package pruebas;
import aplicacion.*;
import presentacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;
/**
 * The test class CityOfHeroesTest02.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class prueba
 {
    @Test
    public void deberiaSerbirMetodos() {
        Salon salon = Salon.demeSalon();
        salon.entrada();
        salon.inicio();
        salon.parada();
        salon.decision();
        salon. salida();
    }
    
    @Test
    public void deberiaCrearLosDeportistas(){
      Salon salon = Salon.demeSalon();
      Deportista edward = new Deportista(salon,"edward",250,50,0);
      Deportista bella = new Deportista(salon, "bella",200,50,0);
      DeportistasAvanzados neo = new DeportistasAvanzados(salon,"neo",250,150);
      DeportistasAvanzados trinity = new DeportistasAvanzados(salon, "trinity",200,150);
      DeportistasHabladores han = new DeportistasHabladores(salon,"han",200,250);
      DeportistasHabladores leila = new DeportistasHabladores(salon,"leila",300,250);
      DeportistaSalsero David = new  DeportistaSalsero(salon,"David",420,150); 
      DeportistaSalsero Andres = new  DeportistaSalsero(salon,"Andres",20,150);
    }
    
    @Test
    public void deberiaFuncionarCaracteristicasDeportistaAvanzado(){
      Salon salon = Salon.demeSalon();
      DeportistasAvanzados neo = new DeportistasAvanzados(salon,"neo",250,150);
      DeportistasAvanzados trinity = new DeportistasAvanzados(salon, "trinity",200,150);
      Deportista bella = new Deportista(salon, "bella",200,50,0);
      assertTrue(Color.ORANGE.equals(neo.getColor()));
      assertEquals(Color.ORANGE,trinity.getColor());
      trinity.inicie();
      bella.inicie();
      assertTrue(trinity.getPosicionX()<bella.getPosicionX());
      assertTrue(trinity.PASO>bella.PASO);
    }
    
    @Test
    public void deberiaFuncionarCaracteristicasDeportistaHabladores
    (){
      Salon salon = Salon.demeSalon();
      DeportistasHabladores han = new DeportistasHabladores(salon,"han",200,250);
      DeportistasHabladores leila = new DeportistasHabladores(salon,"leila",300,250);
      han.inicie();
      leila.inicie();
      han.pare();
      leila.pare();
      assertEquals("¿Hola como has estado? leila",leila.getPalabras());
      assertEquals("¿Hola como has estado? han",han.getPalabras());
      han.inicie();
      leila.inicie();
      assertEquals("Soyleila",leila.getPalabras());
      assertEquals("Soyhan",han.getPalabras());
    }
    
    @Test
    public void deberiaFuncionarCaracteristicasBola
    (){
      Salon salon = Salon.demeSalon();
      Bola bol = new Bola(salon,40,10);
      Bola bol2 = new Bola(salon,480,410);
      bol.inicie();
      bol2.inicie();
      assertFalse(bol.getColor()==Color.BLACK);
      assertFalse(bol.getColor()==Color.BLACK);
      bol.pare();
      bol2.pare();
      assertTrue(bol.getColor()==Color.BLACK);
      assertTrue(bol.getColor()==Color.BLACK);
    }
}

