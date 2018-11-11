package com.iqoption.chat;

import android.os.Environment;
import io.reactivex.o;
import io.reactivex.p;
import io.reactivex.r;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.text.Regex;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, aXE = {"Lcom/iqoption/chat/StorageRepository;", "", "()V", "IMG_FILTER", "Ljava/io/FileFilter;", "IMG_REX_EX", "Lkotlin/text/Regex;", "collect", "", "Ljava/io/File;", "dir", "filter", "getImageFiles", "Lio/reactivex/Single;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: StorageRepository.kt */
public final class e {
    private static final Regex aCN = new Regex(".+\\.(jpg|JPG|JPEG|png|PNG)");
    private static final FileFilter aCO = a.aCQ;
    public static final e aCP = new e();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, aXE = {"<anonymous>", "", "it", "Ljava/io/File;", "kotlin.jvm.PlatformType", "accept"})
    /* compiled from: StorageRepository.kt */
    static final class a implements FileFilter {
        public static final a aCQ = new a();

        a() {
        }

        public final boolean accept(File file) {
            h.d(file, "it");
            String name = file.getName();
            h.d(name, "it.name");
            return e.aCN.matches(name);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012 \u0010\u0002\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0005 \u0006*\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0007"}, aXE = {"<anonymous>", "", "it", "Lio/reactivex/SingleEmitter;", "", "Ljava/io/File;", "kotlin.jvm.PlatformType", "subscribe"})
    /* compiled from: StorageRepository.kt */
    static final class b<T> implements r<T> {
        public static final b aCR = new b();

        @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
        /* compiled from: Comparisons.kt */
        public static final class a<T> implements Comparator<T> {
            public final int compare(T t, T t2) {
                return b.c(Long.valueOf(((File) t2).lastModified()), Long.valueOf(((File) t).lastModified()));
            }
        }

        b() {
        }

        public final void a(p<List<File>> pVar) {
            h.e(pVar, "it");
            if (com.iqoption.core.ext.a.go("android.permission.READ_EXTERNAL_STORAGE")) {
                e eVar = e.aCP;
                File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
                h.d(externalStoragePublicDirectory, "getExternalStoragePublicDirectory(DIRECTORY_DCIM)");
                List a = eVar.a(externalStoragePublicDirectory, e.aCO);
                e eVar2 = e.aCP;
                File externalStoragePublicDirectory2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                h.d(externalStoragePublicDirectory2, "getExternalStoragePublic…ctory(DIRECTORY_PICTURES)");
                List a2 = eVar2.a(externalStoragePublicDirectory2, e.aCO);
                e eVar3 = e.aCP;
                File externalStoragePublicDirectory3 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                h.d(externalStoragePublicDirectory3, "getExternalStoragePublic…tory(DIRECTORY_DOWNLOADS)");
                pVar.onSuccess(u.a((Iterable) u.b((Collection) u.b((Collection) a, (Iterable) a2), (Iterable) eVar3.a(externalStoragePublicDirectory3, e.aCO)), (Comparator) new a()));
                return;
            }
            pVar.onError(new SecurityException("Requires android.permission.READ_EXTERNAL_STORAGE permission"));
        }
    }

    private e() {
    }

    public final o<List<File>> Ow() {
        o<List<File>> a = o.a((r) b.aCR);
        h.d(a, "Single.create({\n        …\n            }\n        })");
        return a;
    }

    private final List<File> a(File file, FileFilter fileFilter) {
        List<File> arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                h.d(file2, "file");
                if (file2.isDirectory() && !file2.isHidden()) {
                    arrayList.addAll(aCP.a(file2, fileFilter));
                } else if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }
}
