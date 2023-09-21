package gruppprojekt;

public class Car {
    Light light;

    Engine engine;

    public Car() {
        this.light = new Light(true, "HALF", true);
        this.engine = new Engine(false);
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public Engine getEngine() {
        return engine;
    }
}
