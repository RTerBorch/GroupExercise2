package gruppprojekt;

public class Car {
    Light light;

    public Car() {
        this.light = new Light(true, "HALF");
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }
}
