package by.nareiko.ih.composite.impl;

import by.nareiko.ih.composite.Component;


import java.util.List;
import java.util.Objects;

public class Leaf implements Component {
    private String content;
    private Type type;

    public Leaf(String content, Type type){
        this.content = content;
        this.type = type;
    }

    @Override
    public void add(Component component) {
        throw  new UnsupportedOperationException("Cannot add component to leaf!");
    }

    @Override
    public void remove(Component component) {
        throw  new UnsupportedOperationException("Cannot remove component from leaf!");
    }

    @Override
    public Component getComponent(int index) {
        return this;
    }

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public List<Component> getComponents(){
        throw new UnsupportedOperationException("Cannot be returned components");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaf leaf = (Leaf) o;
        return content.equals(((Leaf) o).content) &&
                this.type == ((Leaf) o).type;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result += prime*result + type.hashCode();
        result += prime*result + content.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
