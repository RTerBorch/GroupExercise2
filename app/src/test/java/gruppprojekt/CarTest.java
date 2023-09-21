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
        assertNotNull(car.getLight());
    }

    @Test
    void CarTest_LightsOn() {
        car.getLight().frontLightsOn();
        assertTrue(car.getLight().getFrontLightStatus());
    }

    @Test
    void CarTest_LightsOff() {
        car.getLight().frontLightsOff();
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
    void CarTest_BacklightOn() {
        car.getLight().backLightsOn();
        assertEquals(car.getLight().getBackLightStatus(), true);
    }

    @Test
    void CarTest_BacklightOff() {
        car.getLight().backLightsOff();
        assertEquals(car.getLight().getBackLightStatus(), false);
    }

    @Test
    void CarTest_EngineOn() {
        car.startEngine();
        assertTrue(car.getEngine().getEngineStatus());
    }

    @Test
    void CarTest_EngineOff() {
        car.stopEngine();
        assertFalse(car.getEngine().getEngineStatus());
    }

    @Test
    void CarTest_AllLightsOn() {
        car.getLight().allLightsOn();
        assertTrue(car.getLight().getFrontLightStatus());
        assertTrue(car.getLight().getBackLightStatus());
    }

    @Test
    void CarTest_EngineOffAllLightsOff() {
        car.getLight().allLightsOn();
        car.stopEngine();
        assertFalse(car.getLight().getFrontLightStatus());
        assertFalse(car.getLight().getBackLightStatus());
    }

    @Test
    void CarTest_WaringLightsOnEngineOff() {
        car.stopEngine();
        car.getLight().warningLightsOn();
        assertTrue(car.getLight().getWarningLightsStatus());
    }

    @Test
    void CarTest_Accelerate() {
        int initialSpeed = car.getSpeed();
        car.accelerate(1);
        assertTrue(car.getSpeed() > initialSpeed);
    }

    @Test
    void CarTest_InitialSpeed() {
        assertEquals(car.getSpeed(), 0);
    }

    @Test
    void CarTest_SpeedMax180() {
        car.accelerate(200);
        assertEquals(car.getSpeed(), 180);
    }

    @Test
    void CarTest_Brake() {
        car.accelerate(50);
        car.brake(50);
        assertEquals(car.getSpeed(), 0);
    }

    @Test
    void CarTest_BrakeNotNegative() {
        car.brake(50);
        assertEquals(car.getSpeed(), 0);
    }
}
