package cue;

public class ArrayListCueTest extends CueHarness {
    @Override
    public Cue<String> getQueue() {
        return new ArrayListCue<>();
    }
}
