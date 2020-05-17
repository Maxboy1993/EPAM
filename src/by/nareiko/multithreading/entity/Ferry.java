package by.nareiko.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Ferry implements Runnable{
    private static Ferry ferry;
    public static final int FERRY_AREA_CAPACITY = 30;
    public static final int FERRY_WEIGHT_CAPACITY = 30;
    private int vehiclesOnFerryCount;
    private int vehiclesInQueueCount;
    private Queue<Vehicle> loadedVehicles = new ArrayDeque<>();
    private Queue<Vehicle> waitingVehicles = new ArrayDeque<>();
    private static Lock lock = new ReentrantLock(true);
    private Condition condition = lock.newCondition();

    private static final Logger logger = LogManager.getLogger();

    private Ferry() {
    }

    public static Ferry getInstance() {
        if (ferry == null) {
            try {
                lock.lock();
                    if (ferry == null) {
                        ferry = new Ferry();
                    }
            }finally {
                lock.unlock();
            }
        }
        return ferry;
    }

    @Override
    public void run() {
        Thread.currentThread().getState();
        while (waitingVehicles.size()>0){
          Vehicle vehicle =  waitingVehicles.poll();
          loadedVehicles.add(vehicle);
            }
        }



    public void addVehicle(Vehicle vehicle) {
        try {
            lock.lock();
        double weight = 0;
        double area = 0;
        for (Vehicle element : loadedVehicles
        ) {
            weight += element.getWeight();
            area += element.getArea();
        }
        double fullWeight = weight + vehicle.getWeight();
        double fullArea = area + vehicle.getArea();

            if (fullWeight <= FERRY_WEIGHT_CAPACITY && fullArea <= FERRY_AREA_CAPACITY) {
                loadedVehicles.add(vehicle);
                vehiclesOnFerryCount++;
                logger.info("Vehicle " + vehicle.getId() + " is added on ferry.");
//                System.out.println("Vehicle " + vehicle.getId() + " is added on ferry.");
            } else {
                waitingVehicles.add(vehicle);
                vehiclesInQueueCount++;
                logger.info("Vehicle " + vehicle.getId() + " is added to queue.");
//                System.out.println("Vehicle " + vehicle.getId() + " is added to queue.");
            }
        }finally {
            lock.unlock();
        }
    }

    public  Vehicle getVehicleFromFerry() {
        try{
            lock.lock();
        if (vehiclesOnFerryCount > 0) {
            Thread.currentThread().getState();
            condition.signalAll();
            Thread.currentThread().getState();
                    vehiclesOnFerryCount--;
                    logger.info("The ship is taken from the Ferry: " + Thread.currentThread().getName());
//            System.out.println("The ship is taken from the Ferry: " + Thread.currentThread().getName());
                    Vehicle vehicle = loadedVehicles.poll();
                    return vehicle;
        }else {
            logger.info("There are no vehicles on the Ferry: " + Thread.currentThread().getName());
//            System.out.println("There are no vehicles on the Ferry: " + Thread.currentThread().getName());
            condition.await();
            Thread.currentThread().getState();
        }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }

    public  Vehicle getVehicleFromQueue(int id) {
        try{
            lock.lock();
            if (vehiclesInQueueCount > 0) {
                Thread.currentThread().getState();
                condition.signalAll();
                Thread.currentThread().getState();
                for (Vehicle element : waitingVehicles
                ) {
                    if (id == element.getId()) {
                        vehiclesInQueueCount--;
                        logger.info("The ship is taken from the Queue: " + Thread.currentThread().getName());
//                        System.out.println("The ship is taken from the Queue: " + Thread.currentThread().getName());
                        waitingVehicles.remove(element);
                        return null;
                    }
                }
            }else {
                logger.info("There are no vehicles in the Queue: " + Thread.currentThread().getName());
//                System.out.println("There are no vehicles in the Queue: " + Thread.currentThread().getName());
                condition.await();
                Thread.currentThread().getState();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return null;
    }
}
