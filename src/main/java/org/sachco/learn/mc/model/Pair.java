package org.sachco.learn.mc.model;

/**
 * Created by: sachco at date: 18/01/24.
 */
public class Pair<T, T1> {
    private T key;
    private T1 value;

    public Pair(T key, T1 value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public T1 getValue() {
        return value;
    }
}
