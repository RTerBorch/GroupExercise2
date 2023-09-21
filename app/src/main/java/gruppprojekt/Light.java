package gruppprojekt;

public class Light {
    private boolean frontLightStatus;
    private String frontLightMode;



    private boolean backLightStatus;
    private boolean warningLights = false;
    private boolean brakeLight = false;

    public Light(boolean frontLightStatus, String lightMode, boolean backLightStatus) {
        this.backLightStatus = backLightStatus;
        this.frontLightStatus = frontLightStatus;
        this.frontLightMode = lightMode;
    }

    public void frontLightsOn() {
        frontLightStatus = true;
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
    }

    public void backLightsOff() {
        backLightStatus = false;
    }

    public boolean getBackLightStatus() {
        return backLightStatus;
    }

    public void allLightsOn() {
        backLightsOn();
        frontLightsOn();
    }
    public void allLightsOff(){
        backLightsOff();
        frontLightsOff();
    }

    public void warningLightsOn() {
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
