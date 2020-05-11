package by.nareiko.multuthreading.starter.impl;

import by.nareiko.multuthreading.entity.Vehicle;
import by.nareiko.multuthreading.starter.VehicleStarter;

import java.util.List;

public class VehicleStarterImpl implements VehicleStarter {
    @Override
    public void start(List<Vehicle> vehicles) {
        for (Vehicle element : vehicles
             ) {
            Thread thread = new Thread(element);
            thread.start();
        }
    }
}
