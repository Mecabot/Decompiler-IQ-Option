package io.fabric.sdk.android.services.b;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.common.o;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: QueueFileEventStorage */
public class h implements c {
    private final Context context;
    private final File eoj;
    private final String eok;
    private o eol = new o(this.vJ);
    private File eom;
    private final File vJ;

    public h(Context context, File file, String str, String str2) {
        this.context = context;
        this.eoj = file;
        this.eok = str2;
        this.vJ = new File(this.eoj, str);
        aVo();
    }

    private void aVo() {
        this.eom = new File(this.eoj, this.eok);
        if (!this.eom.exists()) {
            this.eom.mkdirs();
        }
    }

    public void aa(byte[] bArr) {
        this.eol.aa(bArr);
    }

    public int aVk() {
        return this.eol.aUP();
    }

    public void lI(String str) {
        this.eol.close();
        a(this.vJ, new File(this.eom, str));
        this.eol = new o(this.vJ);
    }

    private void a(File file, File file2) {
        Closeable fileInputStream;
        Throwable th;
        Closeable closeable = null;
        try {
            Closeable y;
            fileInputStream = new FileInputStream(file);
            try {
                y = y(file2);
            } catch (Throwable th2) {
                th = th2;
                CommonUtils.a(fileInputStream, "Failed to close file input stream");
                CommonUtils.a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
            try {
                CommonUtils.a((InputStream) fileInputStream, (OutputStream) y, new byte[1024]);
                CommonUtils.a(fileInputStream, "Failed to close file input stream");
                CommonUtils.a(y, "Failed to close output stream");
                file.delete();
            } catch (Throwable th3) {
                Throwable th4 = th3;
                closeable = y;
                th = th4;
                CommonUtils.a(fileInputStream, "Failed to close file input stream");
                CommonUtils.a(closeable, "Failed to close output stream");
                file.delete();
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            CommonUtils.a(fileInputStream, "Failed to close file input stream");
            CommonUtils.a(closeable, "Failed to close output stream");
            file.delete();
            throw th;
        }
    }

    public OutputStream y(File file) {
        return new FileOutputStream(file);
    }

    public List<File> iZ(int i) {
        List<File> arrayList = new ArrayList();
        for (Object add : this.eom.listFiles()) {
            arrayList.add(add);
            if (arrayList.size() >= i) {
                break;
            }
        }
        return arrayList;
    }

    public void bO(List<File> list) {
        for (File file : list) {
            CommonUtils.H(this.context, String.format("deleting sent analytics file %s", new Object[]{file.getName()}));
            file.delete();
        }
    }

    public List<File> aVm() {
        return Arrays.asList(this.eom.listFiles());
    }

    public void aVn() {
        try {
            this.eol.close();
        } catch (IOException unused) {
            this.vJ.delete();
        }
    }

    public boolean aVl() {
        return this.eol.isEmpty();
    }

    public boolean aY(int i, int i2) {
        return this.eol.aW(i, i2);
    }
}
