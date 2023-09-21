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
        car.getLight().turnOnLights();
        assertTrue(car.getLight().getLightStatus());
    }

    @Test
    void CarTest_LightsOff() {
        car.getLight().turnOffLights();
        assertFalse(car.getLight().getLightStatus());
    }

    @Test
    void CarTest_LightModeDefault() {
        assertEquals(car.getLight().getLightMode(), "HALF");
    }

    @Test
    void CarTest_LightModeFull() {
        car.getLight().switchLightMode();
        assertEquals(car.getLight().getLightMode(), "FULL");
    }

    @Test
    void CarTest_LightModeHalf() {
        car.getLight().switchLightMode();
        car.getLight().switchLightMode();
        assertEquals(car.getLight().getLightMode(), "HALF");
    }


}
