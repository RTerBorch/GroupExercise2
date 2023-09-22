package gruppprojekt;

public class Car {
    Light light;
    Engine engine;

    private final Battery battery;
    private int speed = 0;
    private boolean isReverse = false;

    public Car() {
        this.battery = new Battery(1000);
        this.light = new Light( false,
                                    "HALF",
                                false);
        this.engine = new Engine(false);
        light.setBattery(battery);
        battery.setLight(light);

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
        return speed;
    }

    public void accelerate(int i) {
        if (i > 0) {
            getLight().turnOffBrakeLight();
        }
        if(battery.getPower() <= 0){
            return;
        }
        if (!isReverse) {
            speed += i;
            if (speed > 180) {
                speed = 180;
            }
        } else {
            speed -= i;
            if (speed < -180) {
                speed = -180;
            }
        }
        battery.consumption(-10);
    }

    public void brake(int i) {
        if (!isReverse) {
            speed -= i;
            if (speed < 0) {
                speed = 0;
            }
        }else {
            speed += i;
            if (speed > 0) {
                speed = 0;
            }
        }
        if (i > 0) {
            getLight().turnOnBrakeLight();
        } else {
            getLight().turnOffBrakeLight();
        }
    }

    public boolean getReverseStatus() {
        return isReverse;
    }

    public void driveMode() {
        isReverse = false;
    }

    public void reverseMode() {
        isReverse = true;
    }

    public Battery getBattery() {
        return battery;
    }
}
