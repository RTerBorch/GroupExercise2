package gruppprojekt;

public class Car {
    Light light;

    Engine engine;

    private int speed = 0;

    public Car() {
        this.light = new Light(false, "HALF", false);
        this.engine = new Engine(false);
    }

    public void stopEngine() {
        engine.setEngineStatus(false);
        light.frontLightsOff();
        light.backLightsOff();
    }

    public void startEngine() {
        engine.setEngineStatus(true);
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

    public int getSpeed() {
        return  speed;
    }

    public void accelerate(int i) {
        speed += i;
        if (speed > 180){
            speed = 180;
        }
    }

    public void brake(int i) {
        speed -= i;
        if (speed < 0){
            speed = 0;
        }
    }
}
