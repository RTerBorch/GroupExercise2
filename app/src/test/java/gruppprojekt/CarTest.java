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
        assertTrue(car.getLight().getFrontLightStatus());
    }

    @Test
    void CarTest_LightsOff() {
        car.getLight().turnOffLights();
        assertFalse(car.getLight().getFrontLightStatus());
    }

    @Test
    void CarTest_LightModeDefault() {
        assertEquals(car.getLight().getFrontLightMode(), "HALF");
    }

    @Test
    void CarTest_LightModeFull() {
        car.getLight().switchLightMode();
        assertEquals(car.getLight().getFrontLightMode(), "FULL");
    }

    @Test
    void CarTest_LightModeHalf() {
        car.getLight().switchLightMode();
        car.getLight().switchLightMode();
        assertEquals(car.getLight().getFrontLightMode(), "HALF");
    }

    @Test
    void CarTest_BacklightOn(){
        car.getLight().backLightsOn();
        assertEquals(car.getLight().backLightStatus(), true);
    }

    @Test
    void CarTest_BacklightOff(){
        car.getLight().backLightsOff();
        assertEquals(car.getLight().backLightStatus(), false);
    }
}
