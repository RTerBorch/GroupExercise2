package gruppprojekt;

public class Car {
    Light light = new Light();

    public boolean getLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }

    public Car(boolean light) {
        this.light = light;
    }
    public Car() {
    }


}
