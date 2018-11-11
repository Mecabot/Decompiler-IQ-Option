package org.yaml.snakeyaml.events;

import org.yaml.snakeyaml.DumperOptions.FlowStyle;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event.ID;

/* compiled from: SequenceStartEvent */
public final class l extends c {
    public l(String str, String str2, boolean z, Mark mark, Mark mark2, FlowStyle flowStyle) {
        super(str, str2, z, mark, mark2, flowStyle);
    }

    public boolean a(ID id) {
        return ID.SequenceStart == id;
    }
}
