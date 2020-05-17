package by.nareiko.multithreading.runner;

import by.nareiko.multithreading.entity.Ferry;
import by.nareiko.multithreading.entity.Pier;
import by.nareiko.multithreading.entity.Vehicle;
import by.nareiko.multithreading.generator.VehicleGenerator;
import by.nareiko.multithreading.starter.VehicleStarter;
import by.nareiko.multithreading.starter.impl.VehicleStarterImpl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        int vehicleCount = 20;
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<List<Vehicle>> future = service.submit(new VehicleGenerator(vehicleCount));
        try {
            List<Vehicle> vehicles = future.get();
            VehicleStarter starter = new VehicleStarterImpl();
            starter.start(vehicles);
            Thread pier = new Thread(new Pier());
            pier.getState();
            pier.start();
            pier.getState();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
