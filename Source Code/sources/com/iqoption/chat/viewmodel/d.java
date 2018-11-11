package com.iqoption.chat.viewmodel;

import com.iqoption.app.IQApp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a1\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r\"\u00020\u000eH\u0002¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, aXE = {"DATE_FORMATTER", "Ljava/text/SimpleDateFormat;", "ONE_GB", "", "ONE_KB", "ONE_MB", "ONE_TB", "getString", "", "kotlin.jvm.PlatformType", "resId", "", "args", "", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: FilePickerViewModel.kt */
public final class d {
    private static final SimpleDateFormat aKx = new SimpleDateFormat("dd MMM HH:mm", Locale.US);

    private static final String getString(int i, Object... objArr) {
        return IQApp.Dk().getString(i, Arrays.copyOf(objArr, objArr.length));
    }
}
