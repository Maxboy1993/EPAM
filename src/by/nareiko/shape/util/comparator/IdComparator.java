package by.nareiko.shape.util.comparator;

import by.nareiko.shape.entity.Triangle;

import java.util.Comparator;

public class IdComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        return (int)(o1.getId() - o2.getId());
    }
}
