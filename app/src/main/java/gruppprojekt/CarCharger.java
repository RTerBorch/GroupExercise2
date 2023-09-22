package gruppprojekt;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CarCharger {

    private final ArrayList<Car> carList = new ArrayList<>();
    private final int chargeCapacity = 60;

    public void connect(Car car){
        carList.add(car);
    }

    public void charge(){
        int chargeAmount = chargeCapacity / carList.size();
        if(carList.isEmpty()){
            System.out.println("No cars connected");
        }
        carList.forEach(car -> {
            if(!(car.getBattery().isFull())){
                double amountToCharge = car.getBattery().getMaxPower() - car.getBattery().getPower();
                double amounts = amountToCharge / chargeAmount;
                car.setMessage( (int) Math.ceil(amounts) + " Iterations left");
                car.getBattery().charge(chargeAmount);
            } else {
                System.out.println("Battery fully charged");
            }
        });
    }
}
