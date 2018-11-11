package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event.ID;

/* compiled from: MappingEndEvent */
public final class g extends b {
    public g(Mark mark, Mark mark2) {
        super(mark, mark2);
    }

    public boolean a(ID id) {
        return ID.MappingEnd == id;
    }
}
