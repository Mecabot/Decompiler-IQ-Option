package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event.ID;

/* compiled from: StreamEndEvent */
public final class m extends Event {
    public m(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public boolean a(ID id) {
        return ID.StreamEnd == id;
    }
}
