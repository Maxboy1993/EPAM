package by.nareiko.multithreading.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Pier implements Runnable {
    static Logger logger = LogManager.getLogger();
    Ferry ferry;

    public Pier( ) {

    }

    @Override
    public void run() {
        Thread.currentThread().getState();
        ferry = Ferry.getInstance();
    while (true){
        Thread.currentThread().setName("Unloader");
        try {
          Vehicle vehicle =  ferry.getVehicleFromFerry();
            logger.info("Vehicle " + Optional.of(vehicle) + " is unloaded");
//            System.out.println("Vehicle " + Optional.of(vehicle) + " is unloaded");
            //Time to load the goods
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
}
