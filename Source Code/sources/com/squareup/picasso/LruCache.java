package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LruCache implements Cache {
    private int evictionCount;
    private int hitCount;
    final LinkedHashMap<String, Bitmap> map;
    private final int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(@NonNull Context context) {
        this(Utils.calculateMemoryCacheSize(context));
    }

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Max size must be positive.");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    public Bitmap get(@NonNull String str) {
        if (str == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            Bitmap bitmap = (Bitmap) this.map.get(str);
            if (bitmap != null) {
                this.hitCount++;
                return bitmap;
            }
            this.missCount++;
            return null;
        }
    }

    public void set(@NonNull String str, @NonNull Bitmap bitmap) {
        if (str == null || bitmap == null) {
            throw new NullPointerException("key == null || bitmap == null");
        }
        int bitmapBytes = Utils.getBitmapBytes(bitmap);
        if (bitmapBytes <= this.maxSize) {
            synchronized (this) {
                this.putCount++;
                this.size += bitmapBytes;
                Bitmap bitmap2 = (Bitmap) this.map.put(str, bitmap);
                if (bitmap2 != null) {
                    this.size -= Utils.getBitmapBytes(bitmap2);
                }
            }
            trimToSize(this.maxSize);
        }
    }

    /* JADX WARNING: Missing block: B:18:0x0071, code:
            throw new java.lang.IllegalStateException(r0.toString());
     */
    private void trimToSize(int r4) {
        /*
        r3 = this;
    L_0x0000:
        monitor-enter(r3);
        r0 = r3.size;	 Catch:{ all -> 0x0072 }
        if (r0 < 0) goto L_0x0053;
    L_0x0005:
        r0 = r3.map;	 Catch:{ all -> 0x0072 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r3.size;	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0053;
    L_0x0012:
        r0 = r3.size;	 Catch:{ all -> 0x0072 }
        if (r0 <= r4) goto L_0x0051;
    L_0x0016:
        r0 = r3.map;	 Catch:{ all -> 0x0072 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0051;
    L_0x001f:
        r0 = r3.map;	 Catch:{ all -> 0x0072 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0072 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0072 }
        r0 = r0.next();	 Catch:{ all -> 0x0072 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0072 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0072 }
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0072 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0072 }
        r0 = (android.graphics.Bitmap) r0;	 Catch:{ all -> 0x0072 }
        r2 = r3.map;	 Catch:{ all -> 0x0072 }
        r2.remove(r1);	 Catch:{ all -> 0x0072 }
        r1 = r3.size;	 Catch:{ all -> 0x0072 }
        r0 = com.squareup.picasso.Utils.getBitmapBytes(r0);	 Catch:{ all -> 0x0072 }
        r1 = r1 - r0;
        r3.size = r1;	 Catch:{ all -> 0x0072 }
        r0 = r3.evictionCount;	 Catch:{ all -> 0x0072 }
        r0 = r0 + 1;
        r3.evictionCount = r0;	 Catch:{ all -> 0x0072 }
        monitor-exit(r3);	 Catch:{ all -> 0x0072 }
        goto L_0x0000;
    L_0x0051:
        monitor-exit(r3);	 Catch:{ all -> 0x0072 }
        return;
    L_0x0053:
        r4 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0072 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0072 }
        r0.<init>();	 Catch:{ all -> 0x0072 }
        r1 = r3.getClass();	 Catch:{ all -> 0x0072 }
        r1 = r1.getName();	 Catch:{ all -> 0x0072 }
        r0.append(r1);	 Catch:{ all -> 0x0072 }
        r1 = ".sizeOf() is reporting inconsistent results!";
        r0.append(r1);	 Catch:{ all -> 0x0072 }
        r0 = r0.toString();	 Catch:{ all -> 0x0072 }
        r4.<init>(r0);	 Catch:{ all -> 0x0072 }
        throw r4;	 Catch:{ all -> 0x0072 }
    L_0x0072:
        r4 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0072 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.LruCache.trimToSize(int):void");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized void clear() {
        evictAll();
    }

    public final synchronized void clearKeyUri(String str) {
        int length = str.length();
        Iterator it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            String str2 = (String) entry.getKey();
            Bitmap bitmap = (Bitmap) entry.getValue();
            int indexOf = str2.indexOf(10);
            if (indexOf == length && str2.substring(0, indexOf).equals(str)) {
                it.remove();
                this.size -= Utils.getBitmapBytes(bitmap);
            }
        }
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }
}
