package org.jmrtd.lds.icao;

import java.io.InputStream;
import org.jmrtd.lds.DisplayedImageDataGroup;

public class DG5File extends DisplayedImageDataGroup {
    private static final long serialVersionUID = 923840683207218244L;

    public DG5File(InputStream inputStream) {
        super(101, inputStream);
    }
}
