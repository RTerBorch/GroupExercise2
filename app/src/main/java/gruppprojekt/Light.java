package gruppprojekt;

public class Light {
    private boolean frontLightStatus;
    private String frontLightMode;
    private boolean backLightStatus;
    private boolean warningLights = false;
    private boolean brakeLight = false;

    Battery battery;


    public Light(boolean frontLightStatus,
                 String lightMode,
                 boolean backLightStatus) {
        this.backLightStatus = backLightStatus;
        this.frontLightStatus = frontLightStatus;
        this.frontLightMode = lightMode;
    }

    public void frontLightsOn() {
        if(battery.getPower() <= 50){
            return;
        }
        frontLightStatus = true;
        battery.consumption(1);
    }

    public void frontLightsOff() {
        frontLightStatus = false;
    }

    public void switchLightMode() {
        if (frontLightMode.equals("HALF")) {
            frontLightMode = "FULL";
        } else {
            frontLightMode = "HALF";
        }
    }

    public boolean getFrontLightStatus() {
        return frontLightStatus;
    }


    public String getFrontLightMode() {
        return frontLightMode;
    }

    public void setFrontLightMode(String frontLightMode) {
        this.frontLightMode = frontLightMode;
    }


    public void backLightsOn() {
        if(battery.getPower() <= 50){
            return;
        }
        backLightStatus = true;
        battery.consumption(1);
    }

    public void backLightsOff() {
        backLightStatus = false;
    }

    public void allLightsOn() {
        backLightsOn();
        frontLightsOn();
        turnOnBrakeLight();
    }
    public void allLightsOff(){
        backLightsOff();
        frontLightsOff();
        turnOffBrakeLight();
    }

    public boolean getBackLightStatus() {
        return backLightStatus;
    }



    public void warningLightsOn() {
        if(battery.getPower() <= 0){
            return;
        }
        battery.consumption(1);
        warningLights = true;
    }
    public void warningLightsOff() {
        warningLights = false;
    }

    public boolean getWarningLightsStatus() {
        return warningLights;
    }

    public boolean getbrakeLightsStatus() {
        return brakeLight;
    }

    public void turnOnBrakeLight( ) {
        if(battery.getPower() <= 50){
            return;
        }
        brakeLight = true;
    }
    public void turnOffBrakeLight( ) {
        brakeLight = false;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }
}
