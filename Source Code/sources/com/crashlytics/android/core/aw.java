package com.crashlytics.android.core;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: Utils */
final class aw {
    private static final FilenameFilter wd = new FilenameFilter() {
        public boolean accept(File file, String str) {
            return true;
        }
    };

    static int a(File file, int i, Comparator<File> comparator) {
        return a(file, wd, i, comparator);
    }

    static int a(File file, FilenameFilter filenameFilter, int i, Comparator<File> comparator) {
        File[] listFiles = file.listFiles(filenameFilter);
        int i2 = 0;
        if (listFiles == null) {
            return 0;
        }
        int length = listFiles.length;
        Arrays.sort(listFiles, comparator);
        int length2 = listFiles.length;
        while (i2 < length2) {
            File file2 = listFiles[i2];
            if (length <= i) {
                return length;
            }
            file2.delete();
            length--;
            i2++;
        }
        return length;
    }
}
