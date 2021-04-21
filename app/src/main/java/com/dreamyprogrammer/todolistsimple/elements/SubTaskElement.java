package com.dreamyprogrammer.todolistsimple.elements;

public class SubTaskElement {
    private String name;
    private boolean сompleted;

    public SubTaskElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isСompleted() {
        return сompleted;
    }

    public void setСompleted(boolean сompleted) {
        this.сompleted = сompleted;
    }
}
