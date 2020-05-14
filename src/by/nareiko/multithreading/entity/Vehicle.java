package by.nareiko.multithreading.entity;

import java.util.Objects;

public class Vehicle extends Thread {
    private double weight;
    private double area;
    private long id;
    private VehicleType type;

    public Vehicle() {}

    public Vehicle(long id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.weight = type.getWeight();
        this.area = type.getArea();
    }

    @Override
    public void run(){
        Ferry ferry = Ferry.getInstance();
        ferry.addVehicle(this);
    }

    public double getWeight() {
        return weight;
    }

    public void setMaxWeight(double weight) {
        this.weight = weight;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.weight, weight) == 0 &&
                Double.compare(vehicle.area, area) == 0 &&
                id == vehicle.id &&
                type == vehicle.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, area, id, type);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getName() + ", ")
                .append("weight= " + weight + ", ")
                .append("area=" + area + ", ")
                .append("id=" + id + ", ")
                .append("type=" + type + ".");
        return builder.toString();
    }
}
