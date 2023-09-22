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
                 boolean backLightStatus,
                 Battery battery) {
        this.backLightStatus = backLightStatus;
        this.frontLightStatus = frontLightStatus;
        this.frontLightMode = lightMode;
        this.battery = battery;
    }

    public void frontLightsOn() {
        frontLightStatus = true;
        battery.setPower(-0.1);
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
        backLightStatus = true;
        battery.setPower(-0.1);
    }

    public void backLightsOff() {
        backLightStatus = false;
    }

    public void allLightsOn() {
        backLightsOn();
        frontLightsOn();
    }
    public void allLightsOff(){
        backLightsOff();
        frontLightsOff();
    }

    public boolean getBackLightStatus() {
        return backLightStatus;
    }



    public void warningLightsOn() {
        battery.setPower(-0.1);
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
        brakeLight = true;
    }
    public void turnOffBrakeLight( ) {
        brakeLight = false;
    }
}
