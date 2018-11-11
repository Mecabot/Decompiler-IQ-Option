package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

@RequiresApi(26)
@RestrictTo({Scope.LIBRARY_GROUP})
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG = "TypefaceCompatApi26Impl";
    private static final Method sAbortCreation;
    private static final Method sAddFontFromAssetManager;
    private static final Method sAddFontFromBuffer;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;
    private static final Method sFreeze;

    /* JADX WARNING: Removed duplicated region for block: B:4:0x008c A:{Splitter: B:1:0x0001, ExcHandler: java.lang.ClassNotFoundException (r1_2 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:4:0x008c, code:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x008d, code:
            r2 = TAG;
            r3 = new java.lang.StringBuilder();
            r3.append("Unable to collect necessary methods for class ");
            r3.append(r1.getClass().getName());
            android.util.Log.e(r2, r3.toString(), r1);
            r1 = null;
            r2 = r1;
            r4 = r2;
            r5 = r4;
            r6 = r5;
            r10 = r6;
     */
    static {
        /*
        r0 = 0;
        r1 = "android.graphics.FontFamily";
        r1 = java.lang.Class.forName(r1);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r2 = 0;
        r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r3 = r1.getConstructor(r3);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r4 = "addFontFromAssetManager";
        r5 = 8;
        r5 = new java.lang.Class[r5];	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = android.content.res.AssetManager.class;
        r5[r2] = r6;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = java.lang.String.class;
        r7 = 1;
        r5[r7] = r6;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r8 = 2;
        r5[r8] = r6;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = java.lang.Boolean.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r9 = 3;
        r5[r9] = r6;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r10 = 4;
        r5[r10] = r6;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r11 = 5;
        r5[r11] = r6;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = 6;
        r12 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r5[r6] = r12;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = 7;
        r12 = android.graphics.fonts.FontVariationAxis[].class;
        r5[r6] = r12;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r4 = r1.getMethod(r4, r5);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r5 = "addFontFromBuffer";
        r6 = new java.lang.Class[r11];	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r11 = java.nio.ByteBuffer.class;
        r6[r2] = r11;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r11 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6[r7] = r11;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r11 = android.graphics.fonts.FontVariationAxis[].class;
        r6[r8] = r11;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r11 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6[r9] = r11;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r11 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6[r10] = r11;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r5 = r1.getMethod(r5, r6);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = "freeze";
        r10 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r6 = r1.getMethod(r6, r10);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r10 = "abortCreation";
        r11 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r10 = r1.getMethod(r10, r11);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r11 = java.lang.reflect.Array.newInstance(r1, r7);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r12 = android.graphics.Typeface.class;
        r13 = "createFromFamiliesWithDefault";
        r9 = new java.lang.Class[r9];	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r11 = r11.getClass();	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r9[r2] = r11;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r2 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r9[r7] = r2;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r2 = java.lang.Integer.TYPE;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r9[r8] = r2;	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r2 = r12.getDeclaredMethod(r13, r9);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r2.setAccessible(r7);	 Catch:{ ClassNotFoundException -> 0x008c, ClassNotFoundException -> 0x008c }
        r0 = r3;
        goto L_0x00b1;
    L_0x008c:
        r1 = move-exception;
        r2 = "TypefaceCompatApi26Impl";
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "Unable to collect necessary methods for class ";
        r3.append(r4);
        r4 = r1.getClass();
        r4 = r4.getName();
        r3.append(r4);
        r3 = r3.toString();
        android.util.Log.e(r2, r3, r1);
        r1 = r0;
        r2 = r1;
        r4 = r2;
        r5 = r4;
        r6 = r5;
        r10 = r6;
    L_0x00b1:
        sFontFamilyCtor = r0;
        sFontFamily = r1;
        sAddFontFromAssetManager = r4;
        sAddFontFromBuffer = r5;
        sFreeze = r6;
        sAbortCreation = r10;
        sCreateFromFamiliesWithDefault = r2;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.<clinit>():void");
    }

    private static boolean isFontFamilyPrivateAPIAvailable() {
        if (sAddFontFromAssetManager == null) {
            Log.w(TAG, "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return sAddFontFromAssetManager != null;
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.newFamily():java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0042 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r3_12 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x0042, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0048, code:
            throw new java.lang.RuntimeException(r3);
     */
    private static boolean addFontFromAssetManager(android.content.Context r3, java.lang.Object r4, java.lang.String r5, int r6, int r7, int r8) {
        /*
        r0 = sAddFontFromAssetManager;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r1 = 8;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = r3.getAssets();	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r2 = 0;
        r1[r2] = r3;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = 1;
        r1[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = 2;
        r5 = java.lang.Integer.valueOf(r2);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r1[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = 3;
        r5 = java.lang.Boolean.valueOf(r2);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r1[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = 4;
        r5 = java.lang.Integer.valueOf(r6);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r1[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = 5;
        r5 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r1[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = 6;
        r5 = java.lang.Integer.valueOf(r8);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r1[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = 7;
        r5 = 0;
        r1[r3] = r5;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = r0.invoke(r4, r1);	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = (java.lang.Boolean) r3;	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        r3 = r3.booleanValue();	 Catch:{ IllegalAccessException -> 0x0042, IllegalAccessException -> 0x0042 }
        return r3;
    L_0x0042:
        r3 = move-exception;
        r4 = new java.lang.RuntimeException;
        r4.<init>(r3);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.addFontFromAssetManager(android.content.Context, java.lang.Object, java.lang.String, int, int, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x002c A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r3_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x002c, code:
            r3 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0032, code:
            throw new java.lang.RuntimeException(r3);
     */
    private static boolean addFontFromBuffer(java.lang.Object r3, java.nio.ByteBuffer r4, int r5, int r6, int r7) {
        /*
        r0 = sAddFontFromBuffer;	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
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
        r5 = java.lang.Integer.valueOf(r7);	 Catch:{ IllegalAccessException -> 0x002c, IllegalAccessException -> 0x002c }
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
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.addFontFromBuffer(java.lang.Object, java.nio.ByteBuffer, int, int, int):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0028 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r5_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x0028, code:
            r5 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x002e, code:
            throw new java.lang.RuntimeException(r5);
     */
    private static android.graphics.Typeface createFromFamiliesWithDefault(java.lang.Object r5) {
        /*
        r0 = sFontFamily;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r1 = 1;
        r0 = java.lang.reflect.Array.newInstance(r0, r1);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r2 = 0;
        java.lang.reflect.Array.set(r0, r2, r5);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r5 = sCreateFromFamiliesWithDefault;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r3 = 0;
        r4 = 3;
        r4 = new java.lang.Object[r4];	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r4[r2] = r0;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r0 = -1;
        r2 = java.lang.Integer.valueOf(r0);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r4[r1] = r2;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r1 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r4[r1] = r0;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r5 = r5.invoke(r3, r4);	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        r5 = (android.graphics.Typeface) r5;	 Catch:{ IllegalAccessException -> 0x0028, IllegalAccessException -> 0x0028 }
        return r5;
    L_0x0028:
        r5 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.createFromFamiliesWithDefault(java.lang.Object):android.graphics.Typeface");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r2_4 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x0010, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x0016, code:
            throw new java.lang.RuntimeException(r2);
     */
    private static boolean freeze(java.lang.Object r2) {
        /*
        r0 = sFreeze;	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        r2 = r0.invoke(r2, r1);	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        r2 = (java.lang.Boolean) r2;	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        r2 = r2.booleanValue();	 Catch:{ IllegalAccessException -> 0x0010, IllegalAccessException -> 0x0010 }
        return r2;
    L_0x0010:
        r2 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.freeze(java.lang.Object):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0009 A:{Splitter: B:0:0x0000, ExcHandler: java.lang.IllegalAccessException (r2_1 'e' java.lang.Throwable)} */
    /* JADX WARNING: Missing block: B:3:0x0009, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:5:0x000f, code:
            throw new java.lang.RuntimeException(r2);
     */
    private static void abortCreation(java.lang.Object r2) {
        /*
        r0 = sAbortCreation;	 Catch:{ IllegalAccessException -> 0x0009, IllegalAccessException -> 0x0009 }
        r1 = 0;
        r1 = new java.lang.Object[r1];	 Catch:{ IllegalAccessException -> 0x0009, IllegalAccessException -> 0x0009 }
        r0.invoke(r2, r1);	 Catch:{ IllegalAccessException -> 0x0009, IllegalAccessException -> 0x0009 }
        return;
    L_0x0009:
        r2 = move-exception;
        r0 = new java.lang.RuntimeException;
        r0.<init>(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.TypefaceCompatApi26Impl.abortCreation(java.lang.Object):void");
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i);
        }
        Object newFamily = newFamily();
        FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        i = entries.length;
        int i2 = 0;
        while (i2 < i) {
            FontFileResourceEntry fontFileResourceEntry = entries[i2];
            if (addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), 0, fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) {
                i2++;
            } else {
                abortCreation(newFamily);
                return null;
            }
        }
        if (freeze(newFamily)) {
            return createFromFamiliesWithDefault(newFamily);
        }
        return null;
    }

    public Typeface createFromFontInfo(Context context, @Nullable CancellationSignal cancellationSignal, @NonNull FontInfo[] fontInfoArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        Throwable th2;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (isFontFamilyPrivateAPIAvailable()) {
            Map prepareFontData = FontsContractCompat.prepareFontData(context, fontInfoArr, cancellationSignal);
            Object newFamily = newFamily();
            Object obj = null;
            for (FontInfo fontInfo : fontInfoArr) {
                ByteBuffer byteBuffer = (ByteBuffer) prepareFontData.get(fontInfo.getUri());
                if (byteBuffer != null) {
                    if (addFontFromBuffer(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic())) {
                        obj = 1;
                    } else {
                        abortCreation(newFamily);
                        return null;
                    }
                }
            }
            if (obj == null) {
                abortCreation(newFamily);
                return null;
            } else if (freeze(newFamily)) {
                return Typeface.create(createFromFamiliesWithDefault(newFamily), i);
            } else {
                return null;
            }
        }
        FontInfo findBestInfo = findBestInfo(fontInfoArr, i);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.getUri(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                Typeface build = new Builder(openFileDescriptor.getFileDescriptor()).setWeight(findBestInfo.getWeight()).setItalic(findBestInfo.isItalic()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
        } catch (IOException unused) {
            return null;
        }
        if (openFileDescriptor != null) {
            if (th22 != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th4) {
                    th22.addSuppressed(th4);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th;
        throw th;
    }

    @Nullable
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i, str, i2);
        }
        Object newFamily = newFamily();
        if (!addFontFromAssetManager(context, newFamily, str, 0, -1, -1)) {
            abortCreation(newFamily);
            return null;
        } else if (freeze(newFamily)) {
            return createFromFamiliesWithDefault(newFamily);
        } else {
            return null;
        }
    }
}
