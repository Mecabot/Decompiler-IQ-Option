package com.jumio.core.network.multipart;

import android.content.Context;
import android.util.Pair;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.utils.IOUtils;
import com.jumio.core.mvp.model.Subscriber;
import com.jumio.core.network.ApiCall;
import com.jumio.core.network.ApiCall.DynamicProvider;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class MultipartApiCall<T> extends ApiCall<T> {
    private static final int TIMEOUT = 90000;
    private final String boundary;
    private final String lineEnd = "\r\n";
    private final String partEnd;
    private final String partHeader;
    private List<Pair<String[], Object>> parts;
    private final String twoHyphens = "--";

    protected abstract void prepareData();

    public MultipartApiCall(Context context, DynamicProvider dynamicProvider, Subscriber<T> subscriber) {
        super(context, dynamicProvider, subscriber);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+++Android_JMSDK_mobile_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("+++");
        this.boundary = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(this.boundary);
        stringBuilder.append("\r\n");
        this.partHeader = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(this.boundary);
        stringBuilder.append("--");
        stringBuilder.append("\r\n");
        this.partEnd = stringBuilder.toString();
    }

    public MultipartApiCall(Context context, DynamicProvider dynamicProvider) {
        super(context, dynamicProvider);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("+++Android_JMSDK_mobile_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("+++");
        this.boundary = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(this.boundary);
        stringBuilder.append("\r\n");
        this.partHeader = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append("--");
        stringBuilder.append(this.boundary);
        stringBuilder.append("--");
        stringBuilder.append("\r\n");
        this.partEnd = stringBuilder.toString();
        this.ioTimeout = TIMEOUT;
    }

    protected String getBoundary() {
        return this.boundary;
    }

    protected int prepareRequest() {
        this.parts = new ArrayList();
        prepareData();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Pair pair : this.parts) {
            i += this.partHeader.length();
            stringBuilder.append(this.partHeader);
            int i2 = i;
            for (String str : (String[]) pair.first) {
                i2 = (i2 + str.length()) + "\r\n".length();
                stringBuilder.append(str);
                stringBuilder.append("\r\n");
            }
            i2 += "\r\n".length();
            stringBuilder.append("\r\n");
            if (pair.second instanceof InputStream) {
                try {
                    i2 += ((InputStream) pair.second).available();
                    stringBuilder.append("<InputStream>");
                } catch (IOException unused) {
                    i2 += 0;
                }
            } else if (pair.second instanceof File) {
                i2 = (int) (((long) i2) + ((File) pair.second).length());
                stringBuilder.append("<File>");
            } else if (pair.second instanceof String) {
                i2 += ((String) pair.second).length();
                stringBuilder.append((String) pair.second);
            } else if (pair.second instanceof byte[]) {
                i2 += ((byte[]) pair.second).length;
                stringBuilder.append("<byte[]>");
            }
            i = "\r\n".length() + i2;
            stringBuilder.append("\r\n");
        }
        i += this.partEnd.length();
        stringBuilder.append(this.partEnd);
        LogUtils.logServerRequest(getClass().getSimpleName(), stringBuilder.toString());
        return i;
    }

    protected void addPart(String[] strArr, Object obj) {
        this.parts.add(new Pair(strArr, obj));
    }

    protected void fillRequest(OutputStream outputStream) {
        for (Pair pair : this.parts) {
            outputStream.write(this.partHeader.getBytes("UTF-8"));
            for (String bytes : (String[]) pair.first) {
                outputStream.write(bytes.getBytes("UTF-8"));
                outputStream.write("\r\n".getBytes("UTF-8"));
            }
            outputStream.write("\r\n".getBytes("UTF-8"));
            if (pair.second instanceof InputStream) {
                IOUtils.copy((InputStream) pair.second, outputStream);
                IOUtils.closeQuietly((InputStream) pair.second);
            } else if (pair.second instanceof File) {
                Closeable fileInputStream = new FileInputStream((File) pair.second);
                IOUtils.copy(fileInputStream, outputStream);
                IOUtils.closeQuietly(fileInputStream);
            } else if (pair.second instanceof String) {
                outputStream.write(((String) pair.second).getBytes("UTF-8"));
            } else if (pair.second instanceof byte[]) {
                outputStream.write((byte[]) pair.second);
            }
            outputStream.write("\r\n".getBytes("UTF-8"));
        }
        outputStream.write(this.partEnd.getBytes("UTF-8"));
    }
}
