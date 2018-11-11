package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event.ID;

/* compiled from: StreamStartEvent */
public final class n extends Event {
    public n(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public boolean a(ID id) {
        return ID.StreamStart == id;
    }
}
