package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@RequiresApi(24)
@RestrictTo({Scope.LIBRARY_GROUP})
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;

    TypefaceCompatApi24Impl() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0045 A:{Splitter: B:1:0x0001, ExcHandler: java.lang.ClassNotFoundException (r1_2 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:4:0x0045, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0046, code:
            android.util.Log.e(TAG, r1.getClass().getName(), r1);
            r1 = null;
            r2 = r1;
            r4 = r2;
     */
    static {
        /*
        r0 = 0;
        r1 = "android.graphics.FontFamily";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r2 = 0;
        r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r3 = r1.getConstructor(r3);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r4 = "addFontWeightStyle";
        r5 = 5;
        r5 = new java.lang.Class[r5];	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = java.nio.ByteBuffer.class;
        r5[r2] = r6;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r7 = 1;
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = 2;
        r8 = java.util.List.class;
        r5[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = 3;
        r8 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r5[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = 4;
        r8 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r5[r6] = r8;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r4 = r1.getMethod(r4, r5);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r5 = java.lang.reflect.Array.newInstance(r1, r7);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r6 = android.graphics.Typeface.class;
        r8 = "createFromFamiliesWithDefault";
        r7 = new java.lang.Class[r7];	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r5 = r5.getClass();	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r7[r2] = r5;	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r2 = r6.getMethod(r8, r7);	 Catch:{ ClassNotFoundException -> 0x0045, ClassNotFoundException -> 0x0045 }
        r0 = r3;
        goto L_0x0056;
    L_0x0045:
        r1 = move-exception;
        r2 = "TypefaceCompatApi24Impl";
        r3 = r1.getClass();
        r3 = r3.getName();
        android.util.Log.e(r2, r3, r1);
        r1 = r0;
        r2 = r1;
        r4 = r2;
    L_0x0056:
        sFontFamilyCtor = r0;
        sFontFamily = r1;
        sAddFontWeightStyle = r4;
        sCreateFromFamiliesWithDefault = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi24Impl.<clinit>():void");
    }

    public static boolean isUsable() {
        if (sAddFontWeightStyle == null) {
            Log.w(TAG, "Unable to collect necessary private methods.Fallback to legacy implementation.");
        }
        return sAddFontWeightStyle != null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r0_2 'e' java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r0_2 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x000a, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0010, code:
            throw new java.lang.RuntimeException(r0);
     */
    private static java.lang.Object newFamily() {
        /*
        r0 = sFontFamilyCtor;	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        r0 = r0.newInstance(r1);	 Catch:{ IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a, IllegalAccessException -> 0x000a }
        return r0;
    L_0x000a:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r1.<init>(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi24Impl.newFamily():java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x002c A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r3_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x002c, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0032, code:
            throw new java.lang.RuntimeException(r3);
     */
    private static boolean addFontWeightStyle(java.lang.Object r3, java.nio.ByteBuffer r4, int r5, int r6, boolean r7) {
        /*
        r0 = sAddFontWeightStyle;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1 = 5;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r2 = 0;
        r1[r2] = r4;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 1;
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 2;
        r5 = 0;
        r1[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 3;
        r5 = java.lang.Integer.valueOf(r6);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r4 = 4;
        r5 = java.lang.Boolean.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r1[r4] = r5;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r3 = r0.invoke(r3, r1);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r3 = (java.lang.Boolean) r3;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        r3 = r3.booleanValue();	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
        return r3;
    L_0x002c:
        r3 = move-exception;
        r4 = new java.lang.RuntimeException;
        r4.<init>(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi24Impl.addFontWeightStyle(java.lang.Object, java.nio.ByteBuffer, int, int, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0019 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r4_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x0019, code:
            r4 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x001f, code:
            throw new java.lang.RuntimeException(r4);
     */
    private static android.graphics.Typeface createFromFamiliesWithDefault(java.lang.Object r4) {
        /*
        r0 = sFontFamily;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r1 = 1;
        r0 = java.lang.reflect.Array.newInstance(r0, r1);	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r2 = 0;
        java.lang.reflect.Array.set(r0, r2, r4);	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r4 = sCreateFromFamiliesWithDefault;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r3 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r1[r2] = r0;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r4 = r4.invoke(r3, r1);	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        r4 = (android.graphics.Typeface) r4;	 Catch:{ IllegalAccessException -> 0x0019, IllegalAccessException -> 0x0019 }
        return r4;
    L_0x0019:
        r4 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi24Impl.createFromFamiliesWithDefault(java.lang.Object):android.graphics.Typeface");
    }

    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr, int i) {
        Object newFamily = newFamily();
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontInfo fontInfo : fontInfoArr) {
            Uri uri = fontInfo.getUri();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(uri);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.mmap(context, cancellationSignal, uri);
                simpleArrayMap.put(uri, byteBuffer);
            }
            if (!addFontWeightStyle(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic())) {
                return null;
            }
        }
        return Typeface.create(createFromFamiliesWithDefault(newFamily), i);
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        Object newFamily = newFamily();
        for (FontFileResourceEntry fontFileResourceEntry : fontFamilyFilesResourceEntry.getEntries()) {
            ByteBuffer copyToDirectBuffer = TypefaceCompatUtil.copyToDirectBuffer(context, resources, fontFileResourceEntry.getResourceId());
            if (copyToDirectBuffer == null || !addFontWeightStyle(newFamily, copyToDirectBuffer, 0, fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                return null;
            }
        }
        return createFromFamiliesWithDefault(newFamily);
    }
}
