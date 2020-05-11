package by.nareiko.ih.composite;

import by.nareiko.ih.composite.impl.Type;

import java.util.List;

public interface Component {

    void add(Component component);
    void remove(Component component);
    Type getType();
    Component getComponent(int index);
    List<Component> getComponents();
}
