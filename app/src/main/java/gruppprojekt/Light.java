package gruppprojekt;

public class Light {
    private boolean frontLightStatus;
    private String frontLightMode;

    private boolean backLightStatus;

    public Light(boolean lightStatus, String lightMode, boolean backLightStatus) {
        this.backLightStatus = backLightStatus;
        lightStatus = lightStatus;
        this.frontLightMode = lightMode;
    }

    public void turnOnLights() {
        frontLightStatus = true;
    }

    public void turnOffLights() {
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

    public boolean backLightStatus() {
        return backLightStatus;
    }
}
