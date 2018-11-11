package org.jmrtd.lds.icao;

import java.io.InputStream;
import org.jmrtd.lds.DisplayedImageDataGroup;

public class DG6File extends DisplayedImageDataGroup {
    private static final long serialVersionUID = -583717105472408528L;

    public DG6File(InputStream inputStream) {
        super(102, inputStream);
    }
}
