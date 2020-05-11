package by.nareiko.shape.repository;

import by.nareiko.shape.entity.Triangle;

import java.util.Comparator;
import java.util.List;

public interface TriangleRepository {
    boolean add(Triangle triangle);
    boolean addAll(List<Triangle> triangleList);
    Triangle get(int index);
    int size();
    boolean remove(Triangle triangle);
    void sort(Comparator<? super Triangle> comparator);
    List<Triangle> query(TriangleSpecification specification);
}
