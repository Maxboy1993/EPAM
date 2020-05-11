package by.nareiko.shape.repository.impl;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.repository.TriangleSpecification;

public class TriangleSpecificationById implements TriangleSpecification {
    private long id;

    public TriangleSpecificationById(long id) {
        this.id = id;
    }

    @Override
    public boolean test(Triangle triangle) {
        return id == triangle.getId();
    }
}
