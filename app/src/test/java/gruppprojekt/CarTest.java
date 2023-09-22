package gruppprojekt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    Car car;
    CarCharger carCharger;

    @BeforeEach
    public void setupCar() {
        this.car = new Car();
        this.carCharger = new CarCharger();
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
    @Test
    void CarTest_DriveMode(){
        car.driveMode();
       assertFalse(car.getReverseStatus());

    }
    @Test
    void CarTest_ReverseMode(){
        car.reverseMode();
        assertTrue(car.getReverseStatus());
    }

    @Test
    void CarTest_BrakeLightsOn(){
        car.brake(5);
        assertTrue(car.getLight().getbrakeLightsStatus());
    }
    @Test
    void CarTest_BrakeLightsOff(){
        car.brake(5);
        car.brake(0);
        assertFalse(car.getLight().getbrakeLightsStatus());
    }
    @Test
    void CarTest_ReverseBrake(){

        car.reverseMode();
        car.accelerate(90);
        car.brake(100);
        assertEquals(car.getSpeed(), 0);

    }

    @Test
    void CarTest_BatteryExists(){
        assertEquals(car.getBattery().getPower(), 1000);
    }

    @Test
    void CarTest_BatteryDrainDrive(){
        car.accelerate(20);
        assertNotEquals(car.getBattery().getPower(), 1000);
    }

    @Test
    void CarTest_BatteryDrainLights(){
        car.getLight().allLightsOn();
        assertNotEquals(car.getBattery().getPower(), 1000);
        assertEquals(car.getBattery().getPower(), 998);
    }

    @Test
    void CarTest_BatteryEmptyNoAccelerate(){
        car.accelerate(100);
        int startSpeed = car.getSpeed();
        car.getBattery().setPower(0);
        car.accelerate(20);
        assertEquals(startSpeed, car.getSpeed());
    }

    @Test
    void CarTest_BatteryConsumptionAllLightsOff(){
        assertEquals(car.getBattery().getPower(), 1000);
        car.getLight().allLightsOn();
        car.getBattery().consumption(-998);
        assertEquals(car.getBattery().getPower(), 0);
        assertFalse(car.getLight().getBackLightStatus());
        assertFalse(car.getLight().getbrakeLightsStatus());
        assertFalse(car.getLight().getFrontLightStatus());
        assertFalse(car.getLight().getWarningLightsStatus());
    }


    @Test
    void CarTest_BatteryEmptyAllLightsAreOff(){
        car.getBattery().setPower(0);
        car.getLight().allLightsOn();
        assertFalse(car.getLight().getBackLightStatus());
        assertFalse(car.getLight().getbrakeLightsStatus());
        assertFalse(car.getLight().getFrontLightStatus());
        assertFalse(car.getLight().getWarningLightsStatus());
    }

    @Test
    void CarTest_BatteryEmptyWorkingHazards(){
        car.getBattery().consumption(-950);
        car.getLight().allLightsOn();
        assertEquals(car.getBattery().getPower(), 50);
        car.getLight().warningLightsOn();
        assertFalse(car.getLight().getBackLightStatus());
        assertFalse(car.getLight().getbrakeLightsStatus());
        assertFalse(car.getLight().getFrontLightStatus());
        assertTrue(car.getLight().getWarningLightsStatus());
        car.getLight().warningLightsOff();
        car.getLight().warningLightsOn();
        assertTrue(car.getLight().getWarningLightsStatus());
        assertEquals(car.getBattery().getPower(), 48);
    }

    @Test
    void CarTest_BatteryCharge(){
        car.getBattery().consumption(-950);
        assertEquals(car.getBattery().getPower(), 50);
        car.getBattery().charge(50);
        assertEquals(car.getBattery().getPower(), 100);
    }

    @Test
    void CarTest_ChargeCar(){
        car.getBattery().consumption(-950);
        assertEquals(car.getBattery().getPower(), 50);
        carCharger.connect(car);
        carCharger.charge();
        assertEquals(car.getBattery().getPower(), 110);
    }

    @Test
    void CarTest_ChargeTwoCars(){
        car.getBattery().consumption(-950);
        Car car2 = new Car();
        car2.getBattery().consumption(-850);
        carCharger.connect(car);
        carCharger.connect(car2);
        carCharger.charge();
        assertEquals(car.getBattery().getPower(), 80);
        assertEquals(car2.getBattery().getPower(), 180);
    }

    @Test
    void CarTest_ChargeThreeCars(){
        car.getBattery().consumption(-950);
        Car car2 = new Car();
        car2.getBattery().consumption(-850);
        Car car3 = new Car();
        car3.getBattery().consumption(-850);
        carCharger.connect(car);
        carCharger.connect(car2);
        carCharger.connect(car3);
        carCharger.charge();
        assertEquals(car.getBattery().getPower(), 70);
        assertEquals(car2.getBattery().getPower(), 170);
        assertEquals(car3.getBattery().getPower(), 170);
    }

    @Test
    void CarTest_CarChargerWithoutCars(){
        carCharger.charge();
    }



}
