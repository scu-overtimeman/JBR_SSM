package com.jbr.backend.entity;

public class Position {

    String name;
    int count;

    public Position(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
