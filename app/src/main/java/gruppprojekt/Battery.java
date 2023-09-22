package gruppprojekt;

public class Battery {

    private int power;
    Light light;

    public Battery(int power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public void setPower(int powerIn) {
        power = powerIn;
        if(power <= 0){
            light.allLightsOff();
            power = 0;
        }
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public void consumption(int consumption){
        setPower(power+=consumption);
    }
}
