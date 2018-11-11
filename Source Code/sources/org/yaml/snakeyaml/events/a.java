package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event.ID;

/* compiled from: AliasEvent */
public final class a extends i {
    public a(String str, Mark mark, Mark mark2) {
        super(str, mark, mark2);
    }

    public boolean a(ID id) {
        return ID.Alias == id;
    }
}
