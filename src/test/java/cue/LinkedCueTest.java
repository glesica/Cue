package cue;

public class LinkedCueTest extends CueHarness {
    @Override
    public Cue<String> getQueue() {
        return new LinkedCue<>();
    }
}
