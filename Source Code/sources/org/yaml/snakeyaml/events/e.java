package org.yaml.snakeyaml.events;

import java.util.Map;
import org.yaml.snakeyaml.DumperOptions.Version;
import org.yaml.snakeyaml.error.Mark;
import org.yaml.snakeyaml.events.Event.ID;

/* compiled from: DocumentStartEvent */
public final class e extends Event {
    private final Map<String, String> aYH;
    private final Version fhr;
    private final boolean fii;

    public e(Mark mark, Mark mark2, boolean z, Version version, Map<String, String> map) {
        super(mark, mark2);
        this.fii = z;
        this.fhr = version;
        this.aYH = map;
    }

    public boolean a(ID id) {
        return ID.DocumentStart == id;
    }
}
