package by.nareiko.multuthreading.generator;

import by.nareiko.multuthreading.entity.Ferry;
import by.nareiko.multuthreading.entity.Vehicle;
import by.nareiko.multuthreading.entity.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class VehicleGenerator implements Callable<List<Vehicle>> {
    private int vehicleCount;
    Vehicle vehicle;
    VehicleType vehicleType;

    public VehicleGenerator(int vehicleCount) {
        this.vehicleCount = vehicleCount;
    }

    @Override
    public List<Vehicle> call() throws Exception {
        List<Vehicle> vehicles = new ArrayList<>();
        int count = 0;
        double weight = 0;
        double area = 0;
        while (count < vehicleCount
                && weight <= Ferry.FERRY_AREA_CAPACITY
                && area <= Ferry.FERRY_WEIGHT_CAPACITY){
            Thread.currentThread().setName(" Generator ship");
            vehicleType = getRandomType();
            vehicle = new Vehicle(count+1, vehicleType);
            vehicles.add(vehicle);
            count++;
            weight += vehicle.getWeight();
            area += vehicle.getArea();
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return vehicles;
    }

    private VehicleType getRandomType(){
        Random random = new Random();
        return VehicleType.values()[random.nextInt(VehicleType.values().length)];
    }



}
