package com.jumio.dv.c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.support.annotation.Nullable;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import java.io.File;

/* compiled from: DvLogUtils */
public class a extends LogUtils {
    public static void a() {
        LogUtils.init();
    }

    public static void a(Bitmap bitmap, String str, CompressFormat compressFormat, int i, @Nullable String str2) {
        File subFolder = LogUtils.getSubFolder(str);
        StringBuilder stringBuilder = new StringBuilder();
        if (str2 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append("_");
            stringBuilder2.append("scaled");
            str2 = stringBuilder2.toString();
        } else {
            str2 = "scaled";
        }
        stringBuilder.append(str2);
        stringBuilder.append(".");
        stringBuilder.append(compressFormat.name().toLowerCase());
        str2 = stringBuilder.toString();
        if (subFolder != null) {
            Log.image(bitmap, subFolder, str2, compressFormat, i);
        }
    }
}
