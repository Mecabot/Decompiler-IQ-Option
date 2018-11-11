package com.squareup.picasso;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class StatsSnapshot {
    public final long averageDownloadSize;
    public final long averageOriginalBitmapSize;
    public final long averageTransformedBitmapSize;
    public final long cacheHits;
    public final long cacheMisses;
    public final int downloadCount;
    public final int maxSize;
    public final int originalBitmapCount;
    public final int size;
    public final long timeStamp;
    public final long totalDownloadSize;
    public final long totalOriginalBitmapSize;
    public final long totalTransformedBitmapSize;
    public final int transformedBitmapCount;

    public StatsSnapshot(int i, int i2, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, int i3, int i4, int i5, long j9) {
        this.maxSize = i;
        this.size = i2;
        this.cacheHits = j;
        this.cacheMisses = j2;
        this.totalDownloadSize = j3;
        this.totalOriginalBitmapSize = j4;
        this.totalTransformedBitmapSize = j5;
        this.averageDownloadSize = j6;
        this.averageOriginalBitmapSize = j7;
        this.averageTransformedBitmapSize = j8;
        this.downloadCount = i3;
        this.originalBitmapCount = i4;
        this.transformedBitmapCount = i5;
        this.timeStamp = j9;
    }

    public void dump() {
        Writer stringWriter = new StringWriter();
        dump(new PrintWriter(stringWriter));
        Log.i("Picasso", stringWriter.toString());
    }

    public void dump(PrintWriter printWriter) {
        printWriter.println("===============BEGIN PICASSO STATS ===============");
        printWriter.println("Memory Cache Stats");
        printWriter.print("  Max Cache Size: ");
        printWriter.println(this.maxSize);
        printWriter.print("  Cache Size: ");
        printWriter.println(this.size);
        printWriter.print("  Cache % Full: ");
        printWriter.println((int) Math.ceil((double) ((((float) this.size) / ((float) this.maxSize)) * 100.0f)));
        printWriter.print("  Cache Hits: ");
        printWriter.println(this.cacheHits);
        printWriter.print("  Cache Misses: ");
        printWriter.println(this.cacheMisses);
        printWriter.println("Network Stats");
        printWriter.print("  Download Count: ");
        printWriter.println(this.downloadCount);
        printWriter.print("  Total Download Size: ");
        printWriter.println(this.totalDownloadSize);
        printWriter.print("  Average Download Size: ");
        printWriter.println(this.averageDownloadSize);
        printWriter.println("Bitmap Stats");
        printWriter.print("  Total Bitmaps Decoded: ");
        printWriter.println(this.originalBitmapCount);
        printWriter.print("  Total Bitmap Size: ");
        printWriter.println(this.totalOriginalBitmapSize);
        printWriter.print("  Total Transformed Bitmaps: ");
        printWriter.println(this.transformedBitmapCount);
        printWriter.print("  Total Transformed Bitmap Size: ");
        printWriter.println(this.totalTransformedBitmapSize);
        printWriter.print("  Average Bitmap Size: ");
        printWriter.println(this.averageOriginalBitmapSize);
        printWriter.print("  Average Transformed Bitmap Size: ");
        printWriter.println(this.averageTransformedBitmapSize);
        printWriter.println("===============END PICASSO STATS ===============");
        printWriter.flush();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("StatsSnapshot{maxSize=");
        stringBuilder.append(this.maxSize);
        stringBuilder.append(", size=");
        stringBuilder.append(this.size);
        stringBuilder.append(", cacheHits=");
        stringBuilder.append(this.cacheHits);
        stringBuilder.append(", cacheMisses=");
        stringBuilder.append(this.cacheMisses);
        stringBuilder.append(", downloadCount=");
        stringBuilder.append(this.downloadCount);
        stringBuilder.append(", totalDownloadSize=");
        stringBuilder.append(this.totalDownloadSize);
        stringBuilder.append(", averageDownloadSize=");
        stringBuilder.append(this.averageDownloadSize);
        stringBuilder.append(", totalOriginalBitmapSize=");
        stringBuilder.append(this.totalOriginalBitmapSize);
        stringBuilder.append(", totalTransformedBitmapSize=");
        stringBuilder.append(this.totalTransformedBitmapSize);
        stringBuilder.append(", averageOriginalBitmapSize=");
        stringBuilder.append(this.averageOriginalBitmapSize);
        stringBuilder.append(", averageTransformedBitmapSize=");
        stringBuilder.append(this.averageTransformedBitmapSize);
        stringBuilder.append(", originalBitmapCount=");
        stringBuilder.append(this.originalBitmapCount);
        stringBuilder.append(", transformedBitmapCount=");
        stringBuilder.append(this.transformedBitmapCount);
        stringBuilder.append(", timeStamp=");
        stringBuilder.append(this.timeStamp);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
