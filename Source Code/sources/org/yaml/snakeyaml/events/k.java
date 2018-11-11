package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event.ID;

/* compiled from: SequenceEndEvent */
public final class k extends b {
    public k(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public boolean a(ID id) {
        return ID.SequenceEnd == id;
    }
}
