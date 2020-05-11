package by.nareiko.multuthreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;


public class Ferry {
    private static Ferry ferry;
    public static final int FERRY_AREA_CAPACITY = 30;
    public static final int FERRY_WEIGHT_CAPACITY = 30;
    private int vehiclesOnFerryCount;
    private int vehiclesInQueueCount;
    private Queue<Vehicle> loadedVehicles = new ArrayDeque<>();
    private Queue<Vehicle> waitingVehicles = new ArrayDeque<>();

    private static Logger logger = LogManager.getLogger();

    private Ferry() {
    }

    public static Ferry getInstance() {
        if (ferry == null) {
            synchronized (Ferry.class) {
                if (ferry == null) {
                    ferry = new Ferry();
                }
            }
        }
        return ferry;
    }

    public synchronized void addVehicle(Vehicle vehicle) {
        double weight = 0;
        double area = 0;
        for (Vehicle element : loadedVehicles
        ) {
            weight += element.getWeight();
            area += element.getArea();
        }
        double fullWeight = weight + vehicle.getWeight();
        double fullArea = area + vehicle.getArea();
        try {
            if (fullWeight <= FERRY_WEIGHT_CAPACITY && fullArea <= FERRY_AREA_CAPACITY) {
                notifyAll();
                loadedVehicles.add(vehicle);
                vehiclesOnFerryCount++;
                logger.info("Vehicle " + vehicle.getId() + " is added on ferry.");
            } else {
                waitingVehicles.add(vehicle);
                vehiclesInQueueCount++;
                wait();
                logger.info("Vehicle " + vehicle.getId() + " is added to queue.");

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Optional<Vehicle> getVehicle(int id) {
        try{
        if (vehiclesOnFerryCount > 0) {
            notifyAll();
            for (Vehicle element : loadedVehicles
            ) {
                if (id == element.getId()) {
                    vehiclesOnFerryCount--;
                    logger.info("The ship is taken from the Ferry: " + Thread.currentThread().getName());
                    loadedVehicles.remove(element);
                    return Optional.of(element);
                }
            }
        }else {
            wait();
        }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
