package by.nareiko.shape.repository.impl;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.repository.TriangleSpecification;

public class TriangleSpecificationByX1 implements TriangleSpecification {
    private double x1;

    public TriangleSpecificationByX1(double x1) {
        this.x1 = x1;
    }

    @Override
    public boolean test(Triangle triangle) {
        return x1 == triangle.getPoint1().getX();
    }
}
