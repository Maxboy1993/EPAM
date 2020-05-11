package by.nareiko.shape.repository.impl;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.repository.TriangleSpecification;

public class TriangleSpecificationByY1 implements TriangleSpecification {
    private double y1;

    public TriangleSpecificationByY1(double y1) {
        this.y1 = y1;
    }

    @Override
    public boolean test(Triangle triangle) {
        return y1 == triangle.getPoint1().getY();
    }
}
