package gruppprojekt;

import java.util.ArrayList;

public class CarCharger {

    private final ArrayList<Car> carList = new ArrayList<>();
    private final int chargeCapacity = 60;

    public void connect(Car car){
        carList.add(car);
    }

    public void charge(){
        if(carList.isEmpty()){
            System.out.println("No cars connected");
        }
        carList.forEach(car ->
                car.getBattery()
                        .charge(chargeCapacity/carList.size()));
    }
}