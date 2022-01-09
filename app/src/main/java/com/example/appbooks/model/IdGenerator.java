package com.example.appbooks.model;

import java.io.Serializable;

class IdGenerator implements Serializable {
    private static IdGenerator instance = new IdGenerator();
    private int nextId;

    private IdGenerator () {
    }

    public static int nextId() {
        return instance.nextId++;
    }

    // readResolve method to preserve singleton property
    private Object readResolve() {
        return instance;
    }
}