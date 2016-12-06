package cue;

public class LinkedCue<T> implements Cue<T> {
    QueueNode<T> firstNode;
    QueueNode<T> lastNode;

    @Override
    public void enqueue(T item) {
        QueueNode<T> newNode = new QueueNode<>(item);
        if (lastNode == null) {
            lastNode = newNode;
            firstNode = lastNode;
            return;
        }
        newNode.prev = lastNode;
        lastNode.next = newNode;
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        if (firstNode == null) {
            throw new EmptyQueueException();
        }
        QueueNode<T> nextNode = firstNode;
        firstNode = nextNode.next;
        if (lastNode == nextNode) {
            lastNode = null;
        }
        return nextNode.item;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    private class QueueNode<T> {
        T item;
        QueueNode<T> next;
        QueueNode<T> prev;

        QueueNode(T item) {
            this.item = item;
        }
    }
}
