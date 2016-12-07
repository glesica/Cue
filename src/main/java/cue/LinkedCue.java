package cue;

public class LinkedCue<T> implements Cue<T> {
    QueueNode firstNode;
    QueueNode lastNode;

    @Override
    public void enqueue(T item) {
        QueueNode newNode = new QueueNode(item);
        if (isEmpty()) {
            lastNode = newNode;
            firstNode = lastNode;
            return;
        }
        lastNode.next = newNode;
        lastNode = newNode;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        if (firstNode == lastNode) {
            lastNode = null;
        }
        QueueNode nextNode = firstNode;
        firstNode = firstNode.next;
        return nextNode.item;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    private class QueueNode {
        T item;
        QueueNode next;

        QueueNode(T item) {
            this.item = item;
        }
    }
}
