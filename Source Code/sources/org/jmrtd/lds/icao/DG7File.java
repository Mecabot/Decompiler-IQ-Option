package org.jmrtd.lds.icao;

import java.io.InputStream;
import org.jmrtd.lds.DisplayedImageDataGroup;

public class DG7File extends DisplayedImageDataGroup {
    private static final long serialVersionUID = 7189545112850471359L;

    public DG7File(InputStream inputStream) {
        super(103, inputStream);
    }
}
