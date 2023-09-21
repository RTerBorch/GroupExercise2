package gruppprojekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    Car car;

    @BeforeEach
    public void setupCar() {
        this.car = new Car();
    }

    @Test
    void carTest_valid() {
        assertNotNull(car);
    }

    @Test
    void carTest_lightsExists() {
      //  car.setLight(true);
        assertNotNull(car.getLight());
    }

    @Test
    void CarTest_LightsOn() {
        car.setLight(true);
        assertTrue(car.getLight());
    }

    @Test
    void CarTest_LightsOff() {
        car.setLight(false);
        assertFalse(car.getLight());
    }

    @Test
    void CarTest_HasLightModeHalf(){
       assertEquals(car.getLightMode(),"HALF");

        {

        }
    }





}
