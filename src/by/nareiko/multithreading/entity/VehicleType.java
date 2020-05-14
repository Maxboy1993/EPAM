package by.nareiko.multithreading.entity;

public enum  VehicleType {
    TRUCK(5, 5), PASSENGER(1, 1);

    private double weight;
    private double area;

     VehicleType(double weight, double area) {
        this.weight = weight;
        this.area = area;
    }

    public double getWeight() {
        return weight;
    }

    public double getArea() {
        return area;
    }
}
