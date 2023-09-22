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
        if(power <= 50){
            light.allLightsOff();
        }
        if(power <= 0){
            light.warningLightsOff();
        }
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public void consumption(int consumption) {
        setPower(power += consumption);
    }

    public void charge(int i) {
        setPower(power += i);
    }
}
