package cue;

public class EmptyQueueException extends RuntimeException {
    public EmptyQueueException() {
        super("The queue was empty.");
    }
}
