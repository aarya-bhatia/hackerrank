package com.aarya.trees;

public interface BSTMap<E extends Comparable<E>> {
    void add(E val);

    BSTNode<E> remove(E val);

    void update(E val, E nextVal);

    void read();
}
