package gruppprojekt;

import java.util.ArrayList;
import java.util.HashMap;

public class CarCharger {

    private final ArrayList<Car> carList = new ArrayList<>();
    private final int kiloWatt = 60;
    private final int costPerKW = 2;

    HashMap<Car, Integer> cost = new HashMap<>();

    public void connect(Car car){
        carList.add(car);
        //cost.put(car, 0);
    }

    public void charge() {
        carList.removeIf(car -> car.getBattery().isFull());

        if (carList.isEmpty()) {
            System.out.println("No cars connected");
            return;
        }

        int maxChargeAmountPerCar = kiloWatt / carList.size();

        carList.forEach(car -> {
            double remainingPowerNeeded = car.getBattery().getMaxPower() - car.getBattery().getPower();

            int actualChargeAmount = (int) Math.min(remainingPowerNeeded, maxChargeAmountPerCar);

            car.getBattery().charge(actualChargeAmount);

            int currentCost = cost.getOrDefault(car, 0);
            cost.put(car, currentCost + actualChargeAmount * costPerKW);

            double remainingIterations = (car.getBattery().getMaxPower() - car.getBattery().getPower()) / maxChargeAmountPerCar;

            car.setMessage(car.getBattery().isFull()
                    ? "Fully charged, Cost: " + cost.get(car)
                    : (int) Math.ceil(remainingIterations) + " Iterations left");
        });
    }

}
