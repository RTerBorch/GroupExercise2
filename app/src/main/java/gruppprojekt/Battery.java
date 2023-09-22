package gruppprojekt;

public class Battery {

    private int power;
    private boolean fullCharge;
    Light light;

    private final int maxPower = 1000;

    public Battery(int power) {
        this.power = power;
        this.fullCharge = true;
    }

    public double getPower() {
        return power;
    }

    public void setPower(int powerIn) {
        power = powerIn;
        fullCharge = power >= 1000;
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
        setPower(power -= consumption);
    }

    public void charge(int i) {
        setPower(power += i);
    }

    public boolean isFull() {
        return fullCharge;
    }

    public int getMaxPower(){
        return maxPower;
    }
}
