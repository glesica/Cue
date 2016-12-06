package cue;

public interface Cue<T> {
    void enqueue(T item);

    T dequeue();

    boolean isEmpty();
}
