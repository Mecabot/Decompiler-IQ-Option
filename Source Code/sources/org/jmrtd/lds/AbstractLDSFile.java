package org.jmrtd.lds;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class AbstractLDSFile implements LDSFile {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = -4908935713109830409L;

    protected abstract void f(OutputStream outputStream);

    protected abstract void q(InputStream inputStream);

    AbstractLDSFile() {
    }

    public byte[] getEncoded() {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            f(byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            LOGGER.log(Level.WARNING, "Exception", e);
            return null;
        }
    }
}
