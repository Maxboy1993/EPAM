package by.nareiko.shape.observer;

import java.util.List;

public interface TriangleObserverable {
    void attach(List<TriangleObserver> observerList);
    void detach(TriangleObserver observer);
    void notifyObserver();
}
