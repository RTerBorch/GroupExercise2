package gruppprojekt;

public class Engine {
    private boolean engineStatus;

    public Engine(boolean engineStatus) {
        this.engineStatus = engineStatus;
    }

    public boolean getEngineStatus() {
        return engineStatus;
    }

    public void stopEngine() {
        engineStatus = false;
    }

    public void startEngine() {
        engineStatus = true;
    }
}
