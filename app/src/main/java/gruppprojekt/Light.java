package gruppprojekt;

public class Light {
    private boolean lightStatus;
    private String lightMode;

    public Light(boolean lightStatus, String lightMode) {
        lightStatus = lightStatus;
        this.lightMode = lightMode;
    }

    public void turnOnLights() {
        lightStatus = true;
    }

    public void turnOffLights() {
        lightStatus = false;
    }

    public void switchLightMode() {
        if (lightMode.equals("HALF")) {
            lightMode = "FULL";
        } else {
            lightMode = "HALF";
        }
    }

    public boolean getLightStatus() {
        return lightStatus;
    }


    public String getLightMode() {
        return lightMode;
    }

    public void setLightMode(String lightMode) {
        this.lightMode = lightMode;
    }


}
