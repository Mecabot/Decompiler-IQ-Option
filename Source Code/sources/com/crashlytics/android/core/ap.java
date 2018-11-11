package com.crashlytics.android.core;

import android.app.ActivityManager.RunningAppProcessInfo;
import io.fabric.sdk.android.c;
import io.fabric.sdk.android.services.common.IdManager.DeviceIdentifierType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: SessionProtobufHelper */
class ap {
    private static final d vX = d.aS("0");
    private static final d vY = d.aS("Unity");

    public static void a(CodedOutputStream codedOutputStream, String str, String str2, long j) {
        codedOutputStream.a(1, d.aS(str2));
        codedOutputStream.a(2, d.aS(str));
        codedOutputStream.a(3, j);
    }

    public static void a(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, String str5, int i, String str6) {
        d aS = d.aS(str);
        d aS2 = d.aS(str2);
        d aS3 = d.aS(str3);
        d aS4 = d.aS(str4);
        d aS5 = d.aS(str5);
        d aS6 = str6 != null ? d.aS(str6) : null;
        codedOutputStream.p(7, 2);
        codedOutputStream.C(a(aS, aS2, aS3, aS4, aS5, i, aS6));
        codedOutputStream.a(1, aS);
        codedOutputStream.a(2, aS3);
        codedOutputStream.a(3, aS4);
        codedOutputStream.p(5, 2);
        codedOutputStream.C(d(aS2));
        codedOutputStream.a(1, aS2);
        codedOutputStream.a(6, aS5);
        if (aS6 != null) {
            codedOutputStream.a(8, vY);
            codedOutputStream.a(9, aS6);
        }
        codedOutputStream.k(10, i);
    }

    public static void a(CodedOutputStream codedOutputStream, String str, String str2, boolean z) {
        d aS = d.aS(str);
        d aS2 = d.aS(str2);
        codedOutputStream.p(8, 2);
        codedOutputStream.C(a(aS, aS2, z));
        codedOutputStream.k(1, 3);
        codedOutputStream.a(2, aS);
        codedOutputStream.a(3, aS2);
        codedOutputStream.c(4, z);
    }

    public static void a(CodedOutputStream codedOutputStream, int i, String str, int i2, long j, long j2, boolean z, Map<DeviceIdentifierType, String> map, int i3, String str2, String str3) {
        CodedOutputStream codedOutputStream2 = codedOutputStream;
        d bk = bk(str);
        d bk2 = bk(str3);
        d bk3 = bk(str2);
        codedOutputStream2.p(9, 2);
        d dVar = bk3;
        codedOutputStream2.C(a(i, bk, i2, j, j2, z, map, i3, bk3, bk2));
        codedOutputStream2.k(3, i);
        codedOutputStream2.a(4, bk);
        codedOutputStream2.j(5, i2);
        codedOutputStream2.a(6, j);
        codedOutputStream2.a(7, j2);
        codedOutputStream2.c(10, z);
        for (Entry entry : map.entrySet()) {
            codedOutputStream2.p(11, 2);
            codedOutputStream2.C(a((DeviceIdentifierType) entry.getKey(), (String) entry.getValue()));
            codedOutputStream2.k(1, ((DeviceIdentifierType) entry.getKey()).protobufIndex);
            codedOutputStream2.a(2, d.aS((String) entry.getValue()));
        }
        codedOutputStream2.j(12, i3);
        if (dVar != null) {
            codedOutputStream2.a(13, dVar);
        }
        if (bk2 != null) {
            codedOutputStream2.a(14, bk2);
        }
    }

    public static void a(CodedOutputStream codedOutputStream, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        d aS = d.aS(str);
        d bk = bk(str2);
        d bk2 = bk(str3);
        int b = CodedOutputStream.b(1, aS) + 0;
        if (str2 != null) {
            b += CodedOutputStream.b(2, bk);
        }
        if (str3 != null) {
            b += CodedOutputStream.b(3, bk2);
        }
        codedOutputStream.p(6, 2);
        codedOutputStream.C(b);
        codedOutputStream.a(1, aS);
        if (str2 != null) {
            codedOutputStream.a(2, bk);
        }
        if (str3 != null) {
            codedOutputStream.a(3, bk2);
        }
    }

    public static void a(CodedOutputStream codedOutputStream, long j, String str, at atVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, aa aaVar, RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f, int i2, boolean z, long j2, long j3) {
        d dVar;
        CodedOutputStream codedOutputStream2 = codedOutputStream;
        String str4 = str3;
        d aS = d.aS(str2);
        if (str4 == null) {
            dVar = null;
        } else {
            dVar = d.aS(str4.replace("-", ""));
        }
        d dVar2 = dVar;
        d hU = aaVar.hU();
        if (hU == null) {
            c.aUg().d("CrashlyticsCore", "No log data to include with this event.");
        }
        aaVar.hW();
        codedOutputStream2.p(10, 2);
        codedOutputStream2.C(a(j, str, atVar, thread, stackTraceElementArr, threadArr, (List) list, 8, (Map) map, runningAppProcessInfo, i, aS, dVar2, f, i2, z, j2, j3, hU));
        codedOutputStream2.a(1, j);
        codedOutputStream2.a(2, d.aS(str));
        CodedOutputStream codedOutputStream3 = codedOutputStream2;
        d dVar3 = hU;
        a(codedOutputStream3, atVar, thread, stackTraceElementArr, threadArr, list, 8, aS, dVar2, map, runningAppProcessInfo, i);
        a(codedOutputStream3, f, i2, z, i, j2, j3);
        a(codedOutputStream2, dVar3);
    }

    private static void a(CodedOutputStream codedOutputStream, at atVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, d dVar, d dVar2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        codedOutputStream.p(3, 2);
        codedOutputStream.C(a(atVar, thread, stackTraceElementArr, threadArr, (List) list, i, dVar, dVar2, (Map) map, runningAppProcessInfo, i2));
        a(codedOutputStream, atVar, thread, stackTraceElementArr, threadArr, list, i, dVar, dVar2);
        if (!(map == null || map.isEmpty())) {
            a(codedOutputStream, (Map) map);
        }
        if (runningAppProcessInfo != null) {
            codedOutputStream.c(3, runningAppProcessInfo.importance != 100);
        }
        codedOutputStream.j(4, i2);
    }

    private static void a(CodedOutputStream codedOutputStream, at atVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, d dVar, d dVar2) {
        codedOutputStream.p(1, 2);
        codedOutputStream.C(a(atVar, thread, stackTraceElementArr, threadArr, (List) list, i, dVar, dVar2));
        a(codedOutputStream, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            a(codedOutputStream, threadArr[i2], (StackTraceElement[]) list.get(i2), 0, false);
        }
        a(codedOutputStream, atVar, 1, i, 2);
        codedOutputStream.p(3, 2);
        codedOutputStream.C(if());
        codedOutputStream.a(1, vX);
        codedOutputStream.a(2, vX);
        codedOutputStream.a(3, 0);
        codedOutputStream.p(4, 2);
        codedOutputStream.C(a(dVar, dVar2));
        codedOutputStream.a(1, 0);
        codedOutputStream.a(2, 0);
        codedOutputStream.a(3, dVar);
        if (dVar2 != null) {
            codedOutputStream.a(4, dVar2);
        }
    }

    private static void a(CodedOutputStream codedOutputStream, Map<String, String> map) {
        for (Entry entry : map.entrySet()) {
            codedOutputStream.p(2, 2);
            codedOutputStream.C(s((String) entry.getKey(), (String) entry.getValue()));
            codedOutputStream.a(1, d.aS((String) entry.getKey()));
            String str = (String) entry.getValue();
            if (str == null) {
                str = "";
            }
            codedOutputStream.a(2, d.aS(str));
        }
    }

    private static void a(CodedOutputStream codedOutputStream, at atVar, int i, int i2, int i3) {
        codedOutputStream.p(i3, 2);
        codedOutputStream.C(a(atVar, 1, i2));
        codedOutputStream.a(1, d.aS(atVar.className));
        String str = atVar.vZ;
        if (str != null) {
            codedOutputStream.a(3, d.aS(str));
        }
        int i4 = 0;
        for (StackTraceElement a : atVar.wa) {
            a(codedOutputStream, 4, a, true);
        }
        atVar = atVar.wb;
        if (atVar == null) {
            return;
        }
        if (i < i2) {
            a(codedOutputStream, atVar, i + 1, i2, 6);
            return;
        }
        while (atVar != null) {
            atVar = atVar.wb;
            i4++;
        }
        codedOutputStream.j(7, i4);
    }

    private static void a(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        codedOutputStream.p(1, 2);
        codedOutputStream.C(a(thread, stackTraceElementArr, i, z));
        codedOutputStream.a(1, d.aS(thread.getName()));
        codedOutputStream.j(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            a(codedOutputStream, 3, a, z);
        }
    }

    private static void a(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) {
        codedOutputStream.p(i, 2);
        codedOutputStream.C(a(stackTraceElement, z));
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.a(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.a(1, 0);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getClassName());
        stringBuilder.append(".");
        stringBuilder.append(stackTraceElement.getMethodName());
        codedOutputStream.a(2, d.aS(stringBuilder.toString()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.a(3, d.aS(stackTraceElement.getFileName()));
        }
        int i2 = 4;
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.a(4, (long) stackTraceElement.getLineNumber());
        }
        if (!z) {
            i2 = 0;
        }
        codedOutputStream.j(5, i2);
    }

    private static void a(CodedOutputStream codedOutputStream, Float f, int i, boolean z, int i2, long j, long j2) {
        codedOutputStream.p(5, 2);
        codedOutputStream.C(a(f, i, z, i2, j, j2));
        if (f != null) {
            codedOutputStream.a(1, f.floatValue());
        }
        codedOutputStream.l(2, i);
        codedOutputStream.c(3, z);
        codedOutputStream.j(4, i2);
        codedOutputStream.a(5, j);
        codedOutputStream.a(6, j2);
    }

    private static void a(CodedOutputStream codedOutputStream, d dVar) {
        if (dVar != null) {
            codedOutputStream.p(6, 2);
            codedOutputStream.C(e(dVar));
            codedOutputStream.a(1, dVar);
        }
    }

    private static int a(d dVar, d dVar2, d dVar3, d dVar4, d dVar5, int i, d dVar6) {
        int b = ((CodedOutputStream.b(1, dVar) + 0) + CodedOutputStream.b(2, dVar3)) + CodedOutputStream.b(3, dVar4);
        int d = d(dVar2);
        b = (b + ((CodedOutputStream.B(5) + CodedOutputStream.D(d)) + d)) + CodedOutputStream.b(6, dVar5);
        if (dVar6 != null) {
            b = (b + CodedOutputStream.b(8, vY)) + CodedOutputStream.b(9, dVar6);
        }
        return b + CodedOutputStream.n(10, i);
    }

    private static int d(d dVar) {
        return CodedOutputStream.b(1, dVar) + 0;
    }

    private static int a(d dVar, d dVar2, boolean z) {
        return (((CodedOutputStream.n(1, 3) + 0) + CodedOutputStream.b(2, dVar)) + CodedOutputStream.b(3, dVar2)) + CodedOutputStream.d(4, z);
    }

    private static int a(DeviceIdentifierType deviceIdentifierType, String str) {
        return CodedOutputStream.n(1, deviceIdentifierType.protobufIndex) + CodedOutputStream.b(2, d.aS(str));
    }

    private static int a(int i, d dVar, int i2, long j, long j2, boolean z, Map<DeviceIdentifierType, String> map, int i3, d dVar2, d dVar3) {
        int i4;
        int i5 = 0;
        i = CodedOutputStream.n(3, i) + 0;
        if (dVar == null) {
            i4 = 0;
        } else {
            i4 = CodedOutputStream.b(4, dVar);
        }
        i = ((((i + i4) + CodedOutputStream.m(5, i2)) + CodedOutputStream.b(6, j)) + CodedOutputStream.b(7, j2)) + CodedOutputStream.d(10, z);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                i2 = a((DeviceIdentifierType) entry.getKey(), (String) entry.getValue());
                i += (CodedOutputStream.B(11) + CodedOutputStream.D(i2)) + i2;
            }
        }
        i += CodedOutputStream.m(12, i3);
        if (dVar2 == null) {
            i4 = 0;
        } else {
            i4 = CodedOutputStream.b(13, dVar2);
        }
        i += i4;
        if (dVar3 != null) {
            i5 = CodedOutputStream.b(14, dVar3);
        }
        return i + i5;
    }

    private static int a(d dVar, d dVar2) {
        int b = ((CodedOutputStream.b(1, 0) + 0) + CodedOutputStream.b(2, 0)) + CodedOutputStream.b(3, dVar);
        return dVar2 != null ? b + CodedOutputStream.b(4, dVar2) : b;
    }

    private static int a(long j, String str, at atVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2, d dVar, d dVar2, Float f, int i3, boolean z, long j2, long j3, d dVar3) {
        int b = (CodedOutputStream.b(1, j) + 0) + CodedOutputStream.b(2, d.aS(str));
        int a = a(atVar, thread, stackTraceElementArr, threadArr, (List) list, i, dVar, dVar2, (Map) map, runningAppProcessInfo, i2);
        b += (CodedOutputStream.B(3) + CodedOutputStream.D(a)) + a;
        a = a(f, i3, z, i2, j2, j3);
        b += (CodedOutputStream.B(5) + CodedOutputStream.D(a)) + a;
        if (dVar3 == null) {
            return b;
        }
        a = e(dVar3);
        return b + ((CodedOutputStream.B(6) + CodedOutputStream.D(a)) + a);
    }

    private static int a(at atVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, d dVar, d dVar2, Map<String, String> map, RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int a = a(atVar, thread, stackTraceElementArr, threadArr, (List) list, i, dVar, dVar2);
        int B = (CodedOutputStream.B(1) + CodedOutputStream.D(a)) + a;
        boolean z = false;
        B += 0;
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                int s = s((String) entry.getKey(), (String) entry.getValue());
                B += (CodedOutputStream.B(2) + CodedOutputStream.D(s)) + s;
            }
        }
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance != 100) {
                z = true;
            }
            B += CodedOutputStream.d(3, z);
        }
        return B + CodedOutputStream.m(4, i2);
    }

    private static int a(at atVar, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, d dVar, d dVar2) {
        int a = a(thread, stackTraceElementArr, 4, true);
        int B = ((CodedOutputStream.B(1) + CodedOutputStream.D(a)) + a) + 0;
        int length = threadArr.length;
        int i2 = B;
        for (B = 0; B < length; B++) {
            int a2 = a(threadArr[B], (StackTraceElement[]) list.get(B), 0, false);
            i2 += (CodedOutputStream.B(1) + CodedOutputStream.D(a2)) + a2;
        }
        int a3 = a(atVar, 1, i);
        i2 += (CodedOutputStream.B(2) + CodedOutputStream.D(a3)) + a3;
        a3 = if();
        i2 += (CodedOutputStream.B(3) + CodedOutputStream.D(a3)) + a3;
        a3 = a(dVar, dVar2);
        return i2 + ((CodedOutputStream.B(3) + CodedOutputStream.D(a3)) + a3);
    }

    private static int s(String str, String str2) {
        int b = CodedOutputStream.b(1, d.aS(str));
        if (str2 == null) {
            str2 = "";
        }
        return b + CodedOutputStream.b(2, d.aS(str2));
    }

    private static int a(Float f, int i, boolean z, int i2, long j, long j2) {
        int i3 = 0;
        if (f != null) {
            i3 = 0 + CodedOutputStream.b(1, f.floatValue());
        }
        return ((((i3 + CodedOutputStream.o(2, i)) + CodedOutputStream.d(3, z)) + CodedOutputStream.m(4, i2)) + CodedOutputStream.b(5, j)) + CodedOutputStream.b(6, j2);
    }

    private static int e(d dVar) {
        return CodedOutputStream.b(1, dVar);
    }

    private static int a(at atVar, int i, int i2) {
        int i3 = 0;
        int b = CodedOutputStream.b(1, d.aS(atVar.className)) + 0;
        String str = atVar.vZ;
        if (str != null) {
            b += CodedOutputStream.b(3, d.aS(str));
        }
        int i4 = b;
        for (StackTraceElement a : atVar.wa) {
            int a2 = a(a, true);
            i4 += (CodedOutputStream.B(4) + CodedOutputStream.D(a2)) + a2;
        }
        atVar = atVar.wb;
        if (atVar == null) {
            return i4;
        }
        if (i < i2) {
            int a3 = a(atVar, i + 1, i2);
            return i4 + ((CodedOutputStream.B(6) + CodedOutputStream.D(a3)) + a3);
        }
        while (atVar != null) {
            atVar = atVar.wb;
            i3++;
        }
        return i4 + CodedOutputStream.m(7, i3);
    }

    private static int if() {
        return ((CodedOutputStream.b(1, vX) + 0) + CodedOutputStream.b(2, vX)) + CodedOutputStream.b(3, 0);
    }

    private static int a(StackTraceElement stackTraceElement, boolean z) {
        int b;
        int i = 0;
        if (stackTraceElement.isNativeMethod()) {
            b = CodedOutputStream.b(1, (long) Math.max(stackTraceElement.getLineNumber(), 0)) + 0;
        } else {
            b = CodedOutputStream.b(1, 0) + 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(stackTraceElement.getClassName());
        stringBuilder.append(".");
        stringBuilder.append(stackTraceElement.getMethodName());
        b += CodedOutputStream.b(2, d.aS(stringBuilder.toString()));
        if (stackTraceElement.getFileName() != null) {
            b += CodedOutputStream.b(3, d.aS(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            b += CodedOutputStream.b(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i = 2;
        }
        return b + CodedOutputStream.m(5, i);
    }

    private static int a(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int b = CodedOutputStream.b(1, d.aS(thread.getName())) + CodedOutputStream.m(2, i);
        for (StackTraceElement a : stackTraceElementArr) {
            int a2 = a(a, z);
            b += (CodedOutputStream.B(3) + CodedOutputStream.D(a2)) + a2;
        }
        return b;
    }

    private static d bk(String str) {
        return str == null ? null : d.aS(str);
    }
}
