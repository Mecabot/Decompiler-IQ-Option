package com.jumio.persistence;

import android.content.Context;
import android.support.annotation.Nullable;
import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Persistor {
    private static final Set<Class> WRAPPER_TYPES = new HashSet(Arrays.asList(new Class[]{Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Void.class}));
    private PersistenceTarget mDataLayer;

    public Persistor(Context context, Class cls) {
        this.mDataLayer = new SqliteSink(context, checkAnnotated(cls));
    }

    public Persistor(Context context, String str) {
        this.mDataLayer = new SqliteSink(context, str);
    }

    public Persistor(PersistenceTarget persistenceTarget) {
        this.mDataLayer = persistenceTarget;
    }

    public static String getPersistenceName(Class<?> cls) {
        return checkAnnotated(cls);
    }

    static String checkAnnotated(Class cls) {
        Annotation annotation = cls.getAnnotation(PersistWith.class);
        if (isWrapperType(cls)) {
            return cls.getName();
        }
        if (annotation != null && (annotation instanceof PersistWith)) {
            return ((PersistWith) annotation).value();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Class ");
        stringBuilder.append(cls.getName());
        stringBuilder.append(" must be annotated with PersistWith!");
        throw new PersistenceException(stringBuilder.toString());
    }

    public static boolean isWrapperType(Class cls) {
        return WRAPPER_TYPES.contains(cls);
    }

    public <T extends Serializable> long storeAsBlob(T t) {
        checkAnnotated(t.getClass());
        return this.mDataLayer.storeBlob(serialize(t));
    }

    public <T extends Serializable> T restoreFromBlob() {
        byte[] readBlob = this.mDataLayer.readBlob();
        if (readBlob == null) {
            return null;
        }
        return deserialize(readBlob);
    }

    public boolean delete() {
        return this.mDataLayer.delete();
    }

    @Nullable
    private <T extends Serializable> byte[] serialize(T t) {
        try {
            Closeable byteArrayOutputStream = new ByteArrayOutputStream();
            Closeable objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(t);
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.flush();
            IOUtils.closeQuietly(byteArrayOutputStream);
            IOUtils.closeQuietly(objectOutputStream);
            return toByteArray;
        } catch (Throwable e) {
            Log.w("Persistor", "error in serialize()", e);
            throw new IOException(e);
        }
    }

    @Nullable
    private <T extends Serializable> T deserialize(byte[] bArr) {
        Closeable byteArrayInputStream = new ByteArrayInputStream(bArr);
        Closeable objectInputStream = new ObjectInputStream(byteArrayInputStream);
        try {
            Serializable serializable = (Serializable) objectInputStream.readObject();
            IOUtils.closeQuietly(objectInputStream);
            IOUtils.closeQuietly(byteArrayInputStream);
            return serializable;
        } catch (Throwable e) {
            throw new IOException(e);
        } catch (Throwable th) {
            IOUtils.closeQuietly(objectInputStream);
            IOUtils.closeQuietly(byteArrayInputStream);
        }
    }
}
