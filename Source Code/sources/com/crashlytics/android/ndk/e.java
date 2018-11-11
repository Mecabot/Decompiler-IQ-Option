package com.crashlytics.android.ndk;

import io.fabric.sdk.android.services.c.a;
import io.fabric.sdk.android.services.common.q;
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/* compiled from: NdkCrashFilesManager */
class e implements b {
    private static final FileFilter wm = new FileFilter() {
        public boolean accept(File file) {
            return file.isDirectory();
        }
    };
    private final a sc;

    public e(a aVar) {
        this.sc = aVar;
    }

    private File ij() {
        return new File(this.sc.getFilesDir(), "native");
    }

    public File ih() {
        File ij = ij();
        if (!ij.isDirectory() && !ij.mkdir()) {
            return null;
        }
        File file = new File(ij, Long.toString(new q().aUE()));
        if (!file.mkdir()) {
            file = null;
        }
        return file;
    }

    private static TreeSet<File> m(File file) {
        if (file == null || !file.isDirectory()) {
            return new TreeSet();
        }
        File[] listFiles = file.listFiles(wm);
        TreeSet<File> treeSet = new TreeSet(new Comparator<File>() {
            public int compare(File file, File file2) {
                return file2.getName().compareTo(file.getName());
            }
        });
        treeSet.addAll(Arrays.asList(listFiles));
        return treeSet;
    }

    public TreeSet<File> ii() {
        return m(ij());
    }
}
