package cue;

import java.util.ArrayList;

public class ArrayListCue<T> implements Cue<T> {
    ArrayList<T> list = new ArrayList<>();

    @Override
    public void enqueue(T item) {
        list.add(item);
    }

    @Override
    public T dequeue() {
        if (list.isEmpty()) {
            throw new EmptyQueueException();
        }
        return list.remove(0);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
