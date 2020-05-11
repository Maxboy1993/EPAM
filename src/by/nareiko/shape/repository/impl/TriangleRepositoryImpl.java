package by.nareiko.shape.repository.impl;

import by.nareiko.shape.entity.Triangle;
import by.nareiko.shape.repository.TriangleRepository;
import by.nareiko.shape.repository.TriangleSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepositoryImpl implements TriangleRepository {
    private static TriangleRepositoryImpl instanse;
    private List<Triangle> triangles = new ArrayList<>();

    private TriangleRepositoryImpl(){}

    public static TriangleRepositoryImpl getTriangleRepositoryImpl(){
        if (instanse == null){
            instanse = new TriangleRepositoryImpl();
        }
        return instanse;
    }

    @Override
    public boolean add(Triangle triangle) {
        return triangles.add(triangle);

    }

    @Override
    public boolean addAll(List<Triangle> triangleList) {
        return triangles.addAll(triangleList);
    }

    @Override
    public Triangle get(int index) {
        return triangles.get(index);
    }

    @Override
    public int size() {
        return triangles.size();
    }

    @Override
    public boolean remove(Triangle triangle) {
        return triangles.remove(triangle);

    }

    @Override
    public void sort(Comparator<? super Triangle> comparator) {
        triangles.sort(comparator);
    }

    @Override
    public List<Triangle> query(TriangleSpecification specification) {
        List<Triangle> triangleList = triangles.stream().filter(specification).collect(Collectors.toList());
        return triangleList;
    }
}
