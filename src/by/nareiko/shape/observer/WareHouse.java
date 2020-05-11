package by.nareiko.shape.observer;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {
    private Map<Long, Double> perimetersMap = new HashMap<>();
    private Map<Long, Double> areasMap = new HashMap<>();

    private static WareHouse instance;

    private WareHouse(){}

    public static WareHouse getInstance(){
        if (instance == null){
            instance = new WareHouse();
        }
        return instance;
    }

    public void putPerimeter(long id, double perimeter){
        perimetersMap.put(id, perimeter);
    }

    public double getPerimeter(long id){
        return perimetersMap.get(id);
    }

    public void putArea(long id, double area){
        areasMap.put(id, area);
    }

    public double getAre(long id){
        return areasMap.get(id);
    }

}
