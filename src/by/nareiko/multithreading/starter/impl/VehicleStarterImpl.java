package by.nareiko.multithreading.starter.impl;

import by.nareiko.multithreading.entity.Vehicle;
import by.nareiko.multithreading.starter.VehicleStarter;

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
