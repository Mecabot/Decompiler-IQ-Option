package com.jumio.nv.liveness.eyetracking.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.view.WindowManager;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.jumio.analytics.JumioAnalytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.enums.NVLivenessResult;
import com.jumio.nv.liveness.extraction.LivenessClient;
import com.jumio.nv.liveness.extraction.LivenessClient.LivenessHandler;
import com.jumio.nv.liveness.extraction.LivenessDataModel;
import com.jumio.nv.models.ServerSettingsModel;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.umoove.all.e;
import com.umoove.all.f;
import com.umoove.all.g;
import com.umoove.all.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: EyeTrackingClient */
public class a extends LivenessClient implements h {
    private int a;
    private float b;
    private float c;
    private float d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private g i;
    private int j;
    private int k;
    private int l;
    private int m;
    private ArrayList<com.jumio.nv.liveness.extraction.a> n;
    private ArrayList<com.jumio.nv.liveness.extraction.a> o;
    private ArrayList<ArrayList<com.jumio.nv.liveness.extraction.a>> p;
    private final Object q;
    private final Object r;
    private StringBuilder s;
    private StringBuilder t;
    private WindowManager u;

    /*  JADX ERROR: NullPointerException in pass: BlockFinish
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.fixSplitterBlock(BlockFinish.java:45)
        	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:29)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.util.ArrayList.forEach(ArrayList.java:1257)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.ProcessClass.process(ProcessClass.java:32)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:293)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
        */
    private float c() {
        /*
        r31 = this;
        r1 = r31;
        r2 = r1.q;
        monitor-enter(r2);
        r3 = new java.util.ArrayList;	 Catch:{ all -> 0x04d0 }
        r4 = r1.n;	 Catch:{ all -> 0x04d0 }
        r3.<init>(r4);	 Catch:{ all -> 0x04d0 }
        monitor-exit(r2);	 Catch:{ all -> 0x04d0 }
        r2 = new com.jumio.nv.liveness.eyetracking.a.a$2;
        r2.<init>();
        java.util.Collections.sort(r3, r2);
        r2 = r3.size();
        r4 = (double) r2;
        r6 = 4587366580439587226; // 0x3fa999999999999a float:-1.5881868E-23 double:0.05;
        r4 = r4 * r6;
        r4 = java.lang.Math.floor(r4);
        r2 = (int) r4;
        r2 = r3.get(r2);
        r2 = (com.jumio.nv.liveness.extraction.a) r2;
        r2 = r2.a();
        r4 = r3.size();
        r4 = (double) r4;
        r8 = 4606732058837280358; // 0x3fee666666666666 float:2.720083E23 double:0.95;
        r4 = r4 * r8;
        r4 = java.lang.Math.floor(r4);
        r4 = (int) r4;
        r4 = r3.get(r4);
        r4 = (com.jumio.nv.liveness.extraction.a) r4;
        r4 = r4.a();
        r5 = new com.jumio.nv.liveness.eyetracking.a.a$3;
        r5.<init>();
        java.util.Collections.sort(r3, r5);
        r5 = r3.size();
        r10 = (double) r5;
        r10 = r10 * r6;
        r5 = java.lang.Math.floor(r10);
        r5 = (int) r5;
        r5 = r3.get(r5);
        r5 = (com.jumio.nv.liveness.extraction.a) r5;
        r5 = r5.b();
        r6 = r3.size();
        r6 = (double) r6;
        r6 = r6 * r8;
        r6 = java.lang.Math.floor(r6);
        r6 = (int) r6;
        r3 = r3.get(r6);
        r3 = (com.jumio.nv.liveness.extraction.a) r3;
        r3 = r3.b();
        r4 = r4 - r2;
        r4 = java.lang.Math.abs(r4);
        r3 = r3 - r5;
        r3 = java.lang.Math.abs(r3);
        r6 = new java.util.ArrayList;
        r7 = r1.p;
        r6.<init>(r7);
        r7 = r6.iterator();
    L_0x0094:
        r8 = r7.hasNext();
        r9 = 0;
        if (r8 == 0) goto L_0x00ec;
    L_0x009b:
        r8 = r7.next();
        r8 = (java.util.ArrayList) r8;
        r8 = r8.iterator();
    L_0x00a5:
        r10 = r8.hasNext();
        if (r10 == 0) goto L_0x0094;
    L_0x00ab:
        r10 = r8.next();
        r10 = (com.jumio.nv.liveness.extraction.a) r10;
        r11 = r10.a();
        r12 = r10.b();
        r13 = java.lang.Math.abs(r2);
        r11 = r11 + r13;
        r11 = r11 / r4;
        r10.h = r11;
        r11 = java.lang.Math.abs(r5);
        r12 = r12 + r11;
        r12 = r12 / r3;
        r10.i = r12;
        r11 = r10.h;
        r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1));
        if (r11 >= 0) goto L_0x00d1;
    L_0x00cf:
        r10.h = r9;
    L_0x00d1:
        r11 = r10.h;
        r12 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1));
        if (r11 <= 0) goto L_0x00db;
    L_0x00d9:
        r10.h = r12;
    L_0x00db:
        r11 = r10.i;
        r11 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1));
        if (r11 >= 0) goto L_0x00e3;
    L_0x00e1:
        r10.i = r9;
    L_0x00e3:
        r11 = r10.i;
        r11 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1));
        if (r11 <= 0) goto L_0x00a5;
    L_0x00e9:
        r10.i = r12;
        goto L_0x00a5;
    L_0x00ec:
        r2 = new java.util.ArrayList;
        r2.<init>();
        r3 = r6.size();
        r4 = 0;
        if (r3 <= 0) goto L_0x00fb;
    L_0x00f8:
        r6.remove(r4);
    L_0x00fb:
        r3 = r6.iterator();
    L_0x00ff:
        r5 = r3.hasNext();
        r6 = 10;
        if (r5 == 0) goto L_0x016c;
    L_0x0107:
        r5 = r3.next();
        r5 = (java.util.ArrayList) r5;
        r7 = r5.size();
        if (r7 <= 0) goto L_0x00ff;
    L_0x0113:
        r7 = r5.size();
        if (r7 <= r6) goto L_0x0122;
    L_0x0119:
        r7 = 0;
    L_0x011a:
        if (r7 >= r6) goto L_0x0122;
    L_0x011c:
        r5.remove(r4);
        r7 = r7 + 1;
        goto L_0x011a;
    L_0x0122:
        r6 = r5.iterator();
        r7 = 0;
        r8 = 0;
    L_0x0128:
        r10 = r6.hasNext();
        if (r10 == 0) goto L_0x013b;
    L_0x012e:
        r10 = r6.next();
        r10 = (com.jumio.nv.liveness.extraction.a) r10;
        r11 = r10.h;
        r7 = r7 + r11;
        r10 = r10.i;
        r8 = r8 + r10;
        goto L_0x0128;
    L_0x013b:
        r6 = r5.size();
        r6 = (float) r6;
        r7 = r7 / r6;
        r6 = r5.size();
        r6 = (float) r6;
        r8 = r8 / r6;
        r6 = new android.util.Pair;
        r10 = new android.graphics.PointF;
        r11 = r5.get(r4);
        r11 = (com.jumio.nv.liveness.extraction.a) r11;
        r11 = r11.a;
        r11 = (float) r11;
        r5 = r5.get(r4);
        r5 = (com.jumio.nv.liveness.extraction.a) r5;
        r5 = r5.b;
        r5 = (float) r5;
        r10.<init>(r11, r5);
        r5 = new android.graphics.PointF;
        r5.<init>(r7, r8);
        r6.<init>(r10, r5);
        r2.add(r6);
        goto L_0x00ff;
    L_0x016c:
        r5 = 1;
        r7 = 0;
        r8 = 0;
        r10 = 0;
        r11 = 0;
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
    L_0x0175:
        r9 = r2.size();
        if (r5 >= r9) goto L_0x023e;
    L_0x017b:
        r9 = r2.get(r5);
        r9 = (android.util.Pair) r9;
        r9 = r9.first;
        r9 = (android.graphics.PointF) r9;
        r9 = r9.x;
        r3 = r5 + -1;
        r18 = r2.get(r3);
        r4 = r18;
        r4 = (android.util.Pair) r4;
        r4 = r4.first;
        r4 = (android.graphics.PointF) r4;
        r4 = r4.x;
        r4 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r4 == 0) goto L_0x01bc;
    L_0x019b:
        r4 = r2.get(r5);
        r4 = (android.util.Pair) r4;
        r4 = r4.second;
        r4 = (android.graphics.PointF) r4;
        r4 = r4.x;
        r9 = r2.get(r3);
        r9 = (android.util.Pair) r9;
        r9 = r9.second;
        r9 = (android.graphics.PointF) r9;
        r9 = r9.x;
        r4 = r4 - r9;
        r4 = java.lang.Math.abs(r4);
        r10 = r10 + r4;
        r11 = r11 + 1;
        goto L_0x01dc;
    L_0x01bc:
        r4 = r2.get(r5);
        r4 = (android.util.Pair) r4;
        r4 = r4.second;
        r4 = (android.graphics.PointF) r4;
        r4 = r4.x;
        r9 = r2.get(r3);
        r9 = (android.util.Pair) r9;
        r9 = r9.second;
        r9 = (android.graphics.PointF) r9;
        r9 = r9.x;
        r4 = r4 - r9;
        r4 = java.lang.Math.abs(r4);
        r7 = r7 + r4;
        r8 = r8 + 1;
    L_0x01dc:
        r4 = r2.get(r5);
        r4 = (android.util.Pair) r4;
        r4 = r4.first;
        r4 = (android.graphics.PointF) r4;
        r4 = r4.y;
        r9 = r2.get(r3);
        r9 = (android.util.Pair) r9;
        r9 = r9.first;
        r9 = (android.graphics.PointF) r9;
        r9 = r9.y;
        r4 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1));
        if (r4 == 0) goto L_0x0219;
    L_0x01f8:
        r4 = r2.get(r5);
        r4 = (android.util.Pair) r4;
        r4 = r4.second;
        r4 = (android.graphics.PointF) r4;
        r4 = r4.y;
        r3 = r2.get(r3);
        r3 = (android.util.Pair) r3;
        r3 = r3.second;
        r3 = (android.graphics.PointF) r3;
        r3 = r3.y;
        r4 = r4 - r3;
        r3 = java.lang.Math.abs(r4);
        r14 = r14 + r3;
        r15 = r15 + 1;
        goto L_0x0239;
    L_0x0219:
        r4 = r2.get(r5);
        r4 = (android.util.Pair) r4;
        r4 = r4.second;
        r4 = (android.graphics.PointF) r4;
        r4 = r4.y;
        r3 = r2.get(r3);
        r3 = (android.util.Pair) r3;
        r3 = r3.second;
        r3 = (android.graphics.PointF) r3;
        r3 = r3.y;
        r4 = r4 - r3;
        r3 = java.lang.Math.abs(r4);
        r12 = r12 + r3;
        r13 = r13 + 1;
    L_0x0239:
        r5 = r5 + 1;
        r4 = 0;
        goto L_0x0175;
    L_0x023e:
        r3 = (float) r8;
        r9 = r7 / r3;
        if (r8 != 0) goto L_0x0244;
    L_0x0243:
        r9 = 0;
    L_0x0244:
        r3 = (float) r11;
        r10 = r10 / r3;
        if (r11 != 0) goto L_0x0249;
    L_0x0248:
        r9 = 0;
    L_0x0249:
        r3 = (float) r13;
        r3 = r12 / r3;
        if (r13 != 0) goto L_0x024f;
    L_0x024e:
        r3 = 0;
    L_0x024f:
        r4 = (float) r15;
        r14 = r14 / r4;
        if (r15 != 0) goto L_0x0254;
    L_0x0253:
        r3 = 0;
    L_0x0254:
        r4 = r9 + r10;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r4 = r4 / r5;
        r7 = r3 + r14;
        r7 = r7 / r5;
        r8 = 1;
        r11 = 0;
        r12 = 0;
        r13 = 0;
    L_0x0260:
        r15 = r2.size();
        r16 = 6;
        r18 = 5;
        r20 = 4;
        r21 = 3;
        r22 = 2;
        if (r8 >= r15) goto L_0x0474;
    L_0x0270:
        r15 = "FALSE";
        r23 = "FALSE";
        r24 = r2.get(r8);
        r5 = r24;
        r5 = (android.util.Pair) r5;
        r5 = r5.first;
        r5 = (android.graphics.PointF) r5;
        r5 = r5.x;
        r5 = (int) r5;
        r6 = r8 + -1;
        r24 = r2.get(r6);
        r25 = r15;
        r15 = r24;
        r15 = (android.util.Pair) r15;
        r15 = r15.first;
        r15 = (android.graphics.PointF) r15;
        r15 = r15.x;
        r15 = (int) r15;
        if (r5 == r15) goto L_0x02e7;
    L_0x0298:
        if (r5 >= r15) goto L_0x02bf;
    L_0x029a:
        r24 = r2.get(r8);
        r26 = r14;
        r14 = r24;
        r14 = (android.util.Pair) r14;
        r14 = r14.second;
        r14 = (android.graphics.PointF) r14;
        r14 = r14.x;
        r24 = r2.get(r6);
        r27 = r10;
        r10 = r24;
        r10 = (android.util.Pair) r10;
        r10 = r10.second;
        r10 = (android.graphics.PointF) r10;
        r10 = r10.x;
        r10 = (r14 > r10 ? 1 : (r14 == r10 ? 0 : -1));
        if (r10 < 0) goto L_0x02e1;
    L_0x02be:
        goto L_0x02c3;
    L_0x02bf:
        r27 = r10;
        r26 = r14;
    L_0x02c3:
        if (r5 <= r15) goto L_0x02e4;
    L_0x02c5:
        r10 = r2.get(r8);
        r10 = (android.util.Pair) r10;
        r10 = r10.second;
        r10 = (android.graphics.PointF) r10;
        r10 = r10.x;
        r14 = r2.get(r6);
        r14 = (android.util.Pair) r14;
        r14 = r14.second;
        r14 = (android.graphics.PointF) r14;
        r14 = r14.x;
        r10 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1));
        if (r10 <= 0) goto L_0x02e4;
    L_0x02e1:
        r10 = "TRUE";
        goto L_0x02ed;
    L_0x02e4:
        r10 = r25;
        goto L_0x02ed;
    L_0x02e7:
        r27 = r10;
        r26 = r14;
        r10 = "";
    L_0x02ed:
        r14 = r2.get(r8);
        r14 = (android.util.Pair) r14;
        r14 = r14.first;
        r14 = (android.graphics.PointF) r14;
        r14 = r14.y;
        r14 = (int) r14;
        r24 = r2.get(r6);
        r28 = r3;
        r3 = r24;
        r3 = (android.util.Pair) r3;
        r3 = r3.first;
        r3 = (android.graphics.PointF) r3;
        r3 = r3.y;
        r3 = (int) r3;
        if (r14 == r3) goto L_0x0355;
    L_0x030d:
        if (r14 >= r3) goto L_0x0332;
    L_0x030f:
        r24 = r2.get(r8);
        r29 = r9;
        r9 = r24;
        r9 = (android.util.Pair) r9;
        r9 = r9.second;
        r9 = (android.graphics.PointF) r9;
        r9 = r9.y;
        r24 = r2.get(r6);
        r1 = r24;
        r1 = (android.util.Pair) r1;
        r1 = r1.second;
        r1 = (android.graphics.PointF) r1;
        r1 = r1.y;
        r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1));
        if (r1 < 0) goto L_0x0352;
    L_0x0331:
        goto L_0x0334;
    L_0x0332:
        r29 = r9;
    L_0x0334:
        if (r14 <= r3) goto L_0x0359;
    L_0x0336:
        r1 = r2.get(r8);
        r1 = (android.util.Pair) r1;
        r1 = r1.second;
        r1 = (android.graphics.PointF) r1;
        r1 = r1.y;
        r9 = r2.get(r6);
        r9 = (android.util.Pair) r9;
        r9 = r9.second;
        r9 = (android.graphics.PointF) r9;
        r9 = r9.y;
        r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1));
        if (r1 <= 0) goto L_0x0359;
    L_0x0352:
        r23 = "TRUE";
        goto L_0x0359;
    L_0x0355:
        r29 = r9;
        r23 = "";
    L_0x0359:
        r1 = r23;
        r9 = "FALSE";
        r9 = r9.equals(r10);
        if (r9 != 0) goto L_0x036d;
    L_0x0363:
        r9 = "FALSE";
        r9 = r9.equals(r1);
        if (r9 != 0) goto L_0x036d;
    L_0x036b:
        r11 = r11 + 1;
    L_0x036d:
        r9 = r2.get(r8);
        r9 = (android.util.Pair) r9;
        r9 = r9.second;
        r9 = (android.graphics.PointF) r9;
        r9 = r9.x;
        r23 = r2.get(r6);
        r30 = r11;
        r11 = r23;
        r11 = (android.util.Pair) r11;
        r11 = r11.second;
        r11 = (android.graphics.PointF) r11;
        r11 = r11.x;
        r9 = r9 - r11;
        r9 = java.lang.Math.abs(r9);
        r11 = r2.get(r8);
        r11 = (android.util.Pair) r11;
        r11 = r11.second;
        r11 = (android.graphics.PointF) r11;
        r11 = r11.y;
        r6 = r2.get(r6);
        r6 = (android.util.Pair) r6;
        r6 = r6.second;
        r6 = (android.graphics.PointF) r6;
        r6 = r6.y;
        r11 = r11 - r6;
        r6 = java.lang.Math.abs(r11);
        r11 = "FALSE";
        r23 = "FALSE";
        if (r5 == r15) goto L_0x03b5;
    L_0x03b1:
        r24 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r24 > 0) goto L_0x03bb;
    L_0x03b5:
        if (r5 != r15) goto L_0x03bf;
    L_0x03b7:
        r5 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1));
        if (r5 >= 0) goto L_0x03bf;
    L_0x03bb:
        r11 = "TRUE";
        r12 = r12 + 1;
    L_0x03bf:
        if (r14 == r3) goto L_0x03c5;
    L_0x03c1:
        r5 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r5 > 0) goto L_0x03cb;
    L_0x03c5:
        if (r14 != r3) goto L_0x03cf;
    L_0x03c7:
        r3 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r3 >= 0) goto L_0x03cf;
    L_0x03cb:
        r23 = "TRUE";
        r13 = r13 + 1;
    L_0x03cf:
        r3 = r31;
        r5 = r3.t;
        r6 = "T%d/%d; %d; %d; %f;%f; %s; %s; %s; %s;\n";
        r9 = 10;
        r14 = new java.lang.Object[r9];
        r15 = r2.get(r8);
        r15 = (android.util.Pair) r15;
        r15 = r15.first;
        r15 = (android.graphics.PointF) r15;
        r15 = r15.x;
        r15 = (int) r15;
        r15 = java.lang.Integer.valueOf(r15);
        r19 = 0;
        r14[r19] = r15;
        r15 = r2.get(r8);
        r15 = (android.util.Pair) r15;
        r15 = r15.first;
        r15 = (android.graphics.PointF) r15;
        r15 = r15.y;
        r15 = (int) r15;
        r15 = java.lang.Integer.valueOf(r15);
        r17 = 1;
        r14[r17] = r15;
        r15 = r2.get(r8);
        r15 = (android.util.Pair) r15;
        r15 = r15.first;
        r15 = (android.graphics.PointF) r15;
        r15 = r15.x;
        r15 = (int) r15;
        r15 = java.lang.Integer.valueOf(r15);
        r14[r22] = r15;
        r15 = r2.get(r8);
        r15 = (android.util.Pair) r15;
        r15 = r15.first;
        r15 = (android.graphics.PointF) r15;
        r15 = r15.y;
        r15 = (int) r15;
        r15 = java.lang.Integer.valueOf(r15);
        r14[r21] = r15;
        r15 = r2.get(r8);
        r15 = (android.util.Pair) r15;
        r15 = r15.second;
        r15 = (android.graphics.PointF) r15;
        r15 = r15.x;
        r15 = java.lang.Float.valueOf(r15);
        r14[r20] = r15;
        r15 = r2.get(r8);
        r15 = (android.util.Pair) r15;
        r15 = r15.second;
        r15 = (android.graphics.PointF) r15;
        r15 = r15.y;
        r15 = java.lang.Float.valueOf(r15);
        r14[r18] = r15;
        r14[r16] = r10;
        r10 = 7;
        r14[r10] = r1;
        r1 = 8;
        r14[r1] = r11;
        r1 = 9;
        r14[r1] = r23;
        r1 = java.lang.String.format(r6, r14);
        r5.append(r1);
        r8 = r8 + 1;
        r1 = r3;
        r14 = r26;
        r10 = r27;
        r3 = r28;
        r9 = r29;
        r11 = r30;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = 10;
        goto L_0x0260;
    L_0x0474:
        r28 = r3;
        r29 = r9;
        r27 = r10;
        r26 = r14;
        r3 = r1;
        r1 = (float) r11;
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r1 = r1 * r5;
        r5 = (float) r12;
        r1 = r1 + r5;
        r5 = (float) r13;
        r1 = r1 + r5;
        r2 = r2.size();
        r5 = 1;
        r2 = r2 - r5;
        r2 = (float) r2;
        r6 = 1082130432; // 0x40800000 float:4.0 double:5.34643471E-315;
        r2 = r2 * r6;
        r1 = r1 / r2;
        r2 = r3.t;
        r6 = "%f;%f;%f;%f;%f;%f;%f;\n";
        r8 = 7;
        r8 = new java.lang.Object[r8];
        r9 = java.lang.Float.valueOf(r9);
        r10 = 0;
        r8[r10] = r9;
        r9 = r28;
        r9 = java.lang.Float.valueOf(r9);
        r8[r5] = r9;
        r10 = r27;
        r5 = java.lang.Float.valueOf(r10);
        r8[r22] = r5;
        r5 = java.lang.Float.valueOf(r14);
        r8[r21] = r5;
        r4 = java.lang.Float.valueOf(r4);
        r8[r20] = r4;
        r4 = java.lang.Float.valueOf(r7);
        r8[r18] = r4;
        r4 = java.lang.Float.valueOf(r1);
        r8[r16] = r4;
        r4 = java.lang.String.format(r6, r8);
        r2.append(r4);
        return r1;
    L_0x04d0:
        r0 = move-exception;
        r3 = r1;
    L_0x04d2:
        r1 = r0;
        monitor-exit(r2);	 Catch:{ all -> 0x04d5 }
        throw r1;
    L_0x04d5:
        r0 = move-exception;
        goto L_0x04d2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.liveness.eyetracking.a.a.c():float");
    }

    public a(Context context) {
        super(context);
        this.q = new Object();
        this.r = new Object();
        this.handler = new LivenessHandler(this);
    }

    public void configure(StaticModel staticModel) {
        super.configure(staticModel);
        ServerSettingsModel serverSettingsModel = (ServerSettingsModel) DataAccess.load(this.mContext, ServerSettingsModel.class);
        this.a = serverSettingsModel.getEyeTrackingKey();
        this.b = serverSettingsModel.getEyeTrackingThresholdMax();
        this.d = serverSettingsModel.getEyeTrackingEarlyThresholdMin();
        this.c = serverSettingsModel.getEyeTrackingEarlyThresholdMax();
        this.e = serverSettingsModel.getEyeTrackingPositionsMin();
        this.f = serverSettingsModel.getEyeTrackingPositionsMax();
        this.g = serverSettingsModel.isEyeTrackingAnalyticsEnabled();
    }

    protected void init() {
        super.init();
        new Thread(new Runnable() {
            public void run() {
                try {
                    PreviewProperties previewProperties = a.this.getPreviewProperties();
                    if (a.this.i != null) {
                        a.this.i.a();
                    }
                    a.this.u = (WindowManager) a.this.mContext.getSystemService("window");
                    a.this.i = g.a(a.this.mContext, a.this.u.getDefaultDisplay(), previewProperties.camera.width, previewProperties.camera.height, 40.0f, 60.0f, a.this, a.this.a);
                    a.this.i.b(true);
                    a.this.i.c(true);
                    a.this.i.d(true);
                    a.this.i.a(true);
                    int i = previewProperties.sensorRotation;
                    i = i != 0 ? i != 90 ? i != 180 ? 0 : 3 : 2 : 1;
                    a.this.i.a(i);
                    a.this.a();
                } catch (Throwable e) {
                    Log.printStackTrace(e);
                    a.this.i = null;
                    a.this.a(new ExtractionUpdate(b.b, Boolean.valueOf(true)));
                }
            }
        }).start();
    }

    public void destroy() {
        if (this.i != null) {
            this.i.b();
            this.i.c();
            this.i = null;
        }
        super.destroy();
    }

    public void cancel() {
        super.cancel();
        if (this.i != null) {
            this.i.b();
        }
    }

    public void feed(byte[] bArr) {
        synchronized (this.processLock) {
            super.feed(bArr);
            if (this.i != null && this.h) {
                int rotation = this.u.getDefaultDisplay().getRotation();
                if (rotation != this.m) {
                    this.i.b();
                    a();
                }
                this.i.l(bArr, rotation);
            }
            try {
            } catch (Exception unused) {
            }
        }
    }

    private void a() {
        this.m = this.u.getDefaultDisplay().getRotation();
        if (this.i != null) {
            this.i.a(this.extractionArea.width(), this.extractionArea.height());
        }
    }

    protected void handleMessage(Message message) {
        super.handleMessage(message);
        if (message != null && message.what == 200) {
            b();
        }
    }

    protected void automaticStartAttempt() {
        if (this.i == null) {
            super.automaticStartAttempt();
            return;
        }
        this.h = true;
        this.s = new StringBuilder();
        this.t = new StringBuilder();
        this.i.e(false);
    }

    protected void resetValuesAndArrays() {
        super.resetValuesAndArrays();
        this.h = false;
        this.p = null;
        synchronized (this.r) {
            this.o = null;
        }
        synchronized (this.q) {
            this.n = null;
        }
        this.l = 0;
    }

    /* JADX WARNING: Missing block: B:62:0x00de, code:
            return;
     */
    public synchronized void a(int r4) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = 0;
        switch(r4) {
            case 1: goto L_0x00a8;
            case 2: goto L_0x0007;
            case 3: goto L_0x0007;
            default: goto L_0x0005;
        };
    L_0x0005:
        goto L_0x00dd;
    L_0x0007:
        r4 = r3.h;	 Catch:{ all -> 0x00da }
        if (r4 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r3);
        return;
    L_0x000d:
        r4 = new com.jumio.nv.liveness.extraction.LivenessDataModel;	 Catch:{ all -> 0x00da }
        r4.<init>();	 Catch:{ all -> 0x00da }
        r3.livenessDataModel = r4;	 Catch:{ all -> 0x00da }
        r4 = r3.livenessDataModel;	 Catch:{ all -> 0x00da }
        r1 = com.jumio.nv.enums.NVLivenessResult.BO;	 Catch:{ all -> 0x00da }
        r4.setLivenessResult(r1);	 Catch:{ all -> 0x00da }
        r4 = r3.q;	 Catch:{ all -> 0x00da }
        monitor-enter(r4);	 Catch:{ all -> 0x00da }
        r1 = r3.n;	 Catch:{ all -> 0x00a5 }
        r2 = 1;
        if (r1 == 0) goto L_0x002e;
    L_0x0023:
        r1 = r3.n;	 Catch:{ all -> 0x00a5 }
        r1 = r1.size();	 Catch:{ all -> 0x00a5 }
        if (r1 != 0) goto L_0x002c;
    L_0x002b:
        goto L_0x002e;
    L_0x002c:
        r1 = 0;
        goto L_0x002f;
    L_0x002e:
        r1 = 1;
    L_0x002f:
        monitor-exit(r4);	 Catch:{ all -> 0x00a5 }
        if (r1 == 0) goto L_0x007d;
    L_0x0032:
        r4 = r3.unsuccessfulAttempts;	 Catch:{ all -> 0x00da }
        r4 = r4 + r2;
        r3.unsuccessfulAttempts = r4;	 Catch:{ all -> 0x00da }
        r4 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x00da }
        r1 = com.jumio.nv.liveness.extraction.LivenessExtractionUpdateState.faceAlignmentOutOfBounds;	 Catch:{ all -> 0x00da }
        r4.<init>(r1, r0);	 Catch:{ all -> 0x00da }
        r3.a(r4);	 Catch:{ all -> 0x00da }
        r4 = r3.processLock;	 Catch:{ all -> 0x00da }
        monitor-enter(r4);	 Catch:{ all -> 0x00da }
        r1 = r3.unsuccessfulAttempts;	 Catch:{ all -> 0x007a }
        r2 = 4;
        if (r1 > r2) goto L_0x0062;
    L_0x0049:
        r3.resetValuesAndArrays();	 Catch:{ all -> 0x007a }
        r1 = r3.unsuccessfulAttempts;	 Catch:{ all -> 0x007a }
        r2 = 2;
        if (r1 != r2) goto L_0x005c;
    L_0x0051:
        r1 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x007a }
        r2 = com.jumio.nv.extraction.NVExtractionUpdateState.showHelp;	 Catch:{ all -> 0x007a }
        r1.<init>(r2, r0);	 Catch:{ all -> 0x007a }
        r3.a(r1);	 Catch:{ all -> 0x007a }
        goto L_0x005f;
    L_0x005c:
        r3.resetFaceDetection();	 Catch:{ all -> 0x007a }
    L_0x005f:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        goto L_0x00dd;
    L_0x0062:
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        r4 = r3.livenessDataModel;	 Catch:{ all -> 0x00da }
        r0 = -1082130432; // 0xffffffffbf800000 float:-1.0 double:NaN;
        r4.setLivenessValue(r0);	 Catch:{ all -> 0x00da }
        r4 = com.jumio.analytics.JumioAnalytics.getSessionId();	 Catch:{ all -> 0x00da }
        r0 = com.jumio.analytics.Screen.SCAN;	 Catch:{ all -> 0x00da }
        r1 = com.jumio.analytics.UserAction.EYE_TRACKING_FACE_NOT_DETECTED;	 Catch:{ all -> 0x00da }
        r4 = com.jumio.analytics.MobileEvents.userAction(r4, r0, r1);	 Catch:{ all -> 0x00da }
        com.jumio.analytics.JumioAnalytics.add(r4);	 Catch:{ all -> 0x00da }
        goto L_0x0093;
    L_0x007a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x007a }
        throw r0;	 Catch:{ all -> 0x00da }
    L_0x007d:
        r4 = r3.livenessDataModel;	 Catch:{ all -> 0x00da }
        r0 = -1069547520; // 0xffffffffc0400000 float:-3.0 double:NaN;
        r4.setLivenessValue(r0);	 Catch:{ all -> 0x00da }
        r4 = com.jumio.analytics.JumioAnalytics.getSessionId();	 Catch:{ all -> 0x00da }
        r0 = com.jumio.analytics.Screen.SCAN;	 Catch:{ all -> 0x00da }
        r1 = com.jumio.analytics.UserAction.EYE_TRACKING_OUT_OF_BOUNDS;	 Catch:{ all -> 0x00da }
        r4 = com.jumio.analytics.MobileEvents.userAction(r4, r0, r1);	 Catch:{ all -> 0x00da }
        com.jumio.analytics.JumioAnalytics.add(r4);	 Catch:{ all -> 0x00da }
    L_0x0093:
        r4 = r3.handler;	 Catch:{ all -> 0x00da }
        r0 = 105; // 0x69 float:1.47E-43 double:5.2E-322;
        r4.sendEmptyMessage(r0);	 Catch:{ all -> 0x00da }
        r4 = r3.handler;	 Catch:{ all -> 0x00da }
        r0 = 106; // 0x6a float:1.49E-43 double:5.24E-322;
        r4.sendEmptyMessage(r0);	 Catch:{ all -> 0x00da }
        r3.resetValuesAndArrays();	 Catch:{ all -> 0x00da }
        goto L_0x00dd;
    L_0x00a5:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00a5 }
        throw r0;	 Catch:{ all -> 0x00da }
    L_0x00a8:
        r4 = new java.util.ArrayList;	 Catch:{ all -> 0x00da }
        r4.<init>();	 Catch:{ all -> 0x00da }
        r3.p = r4;	 Catch:{ all -> 0x00da }
        r4 = r3.q;	 Catch:{ all -> 0x00da }
        monitor-enter(r4);	 Catch:{ all -> 0x00da }
        r1 = new java.util.ArrayList;	 Catch:{ all -> 0x00d7 }
        r1.<init>();	 Catch:{ all -> 0x00d7 }
        r3.n = r1;	 Catch:{ all -> 0x00d7 }
        monitor-exit(r4);	 Catch:{ all -> 0x00d7 }
        r3.b();	 Catch:{ all -> 0x00da }
        r4 = new com.jumio.sdk.extraction.ExtractionClient$ExtractionUpdate;	 Catch:{ all -> 0x00da }
        r1 = com.jumio.nv.liveness.eyetracking.a.b.onStartedCaptureLiveness;	 Catch:{ all -> 0x00da }
        r4.<init>(r1, r0);	 Catch:{ all -> 0x00da }
        r3.a(r4);	 Catch:{ all -> 0x00da }
        r4 = com.jumio.analytics.JumioAnalytics.getSessionId();	 Catch:{ all -> 0x00da }
        r0 = com.jumio.analytics.Screen.SCAN;	 Catch:{ all -> 0x00da }
        r1 = com.jumio.analytics.UserAction.EYE_TRACKING_STARTED;	 Catch:{ all -> 0x00da }
        r4 = com.jumio.analytics.MobileEvents.userAction(r4, r0, r1);	 Catch:{ all -> 0x00da }
        com.jumio.analytics.JumioAnalytics.add(r4);	 Catch:{ all -> 0x00da }
        goto L_0x00dd;
    L_0x00d7:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x00d7 }
        throw r0;	 Catch:{ all -> 0x00da }
    L_0x00da:
        r4 = move-exception;
        monitor-exit(r3);
        throw r4;
    L_0x00dd:
        monitor-exit(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.nv.liveness.eyetracking.a.a.a(int):void");
    }

    public void a(int i, f fVar, e eVar) {
        try {
            String str = "NullMovement";
            switch (eVar.j) {
                case 1:
                    str = "Fixation";
                    break;
                case 2:
                    str = "SmoothPersuit";
                    break;
                case 3:
                    str = "Saccade";
                    break;
                case 4:
                    str = "Micro";
                    break;
            }
            com.jumio.nv.liveness.extraction.a aVar = new com.jumio.nv.liveness.extraction.a();
            aVar.a = this.j;
            aVar.b = this.k;
            aVar.c = eVar.j;
            aVar.d = eVar.ejl.x;
            aVar.e = eVar.ejl.y;
            aVar.f = eVar.ejm.x;
            aVar.g = eVar.ejm.y;
            aVar.j = eVar.ejn.x;
            aVar.k = eVar.ejn.y;
            aVar.l = eVar.ejo.x;
            aVar.m = eVar.ejo.y;
            aVar.p = eVar.l;
            aVar.q = eVar.m;
            aVar.n = eVar.ejp.x;
            aVar.o = eVar.ejp.y;
            this.s.append(String.format("%d/%d;%d;%d;%s;%f;%f;%f;%f;%f;%f;%f;%f;%f;%f;%f;%f;%f;%f;\n", new Object[]{Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.j), Integer.valueOf(this.k), str, Float.valueOf(eVar.ejl.x), Float.valueOf(eVar.ejl.y), Float.valueOf(eVar.ejn.x), Float.valueOf(eVar.ejn.y), Float.valueOf(eVar.l), Float.valueOf(eVar.ejm.x), Float.valueOf(eVar.ejm.y), Float.valueOf(eVar.ejo.x), Float.valueOf(eVar.ejo.y), Float.valueOf(eVar.m), Float.valueOf(eVar.ejp.x), Float.valueOf(eVar.ejp.y), Float.valueOf(aVar.a()), Float.valueOf(aVar.b())}));
            synchronized (this.q) {
                if (this.n != null) {
                    this.n.add(aVar);
                }
            }
            synchronized (this.r) {
                if (this.o != null) {
                    this.o.add(aVar);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void b(int i) {
        if (i > 2) {
            this.l++;
        }
    }

    private void b() {
        try {
            if (this.h) {
                synchronized (this.r) {
                    if (this.o != null) {
                        this.p.add(this.o);
                    }
                    this.o = new ArrayList();
                }
                Random random = new Random();
                int nextInt = random.nextInt(2);
                int nextInt2 = random.nextInt(2);
                while (Math.abs(nextInt - this.j) + Math.abs(nextInt2 - this.k) == 0) {
                    nextInt = random.nextInt(2);
                    nextInt2 = random.nextInt(2);
                }
                this.j = nextInt;
                this.k = nextInt2;
                int i = -1;
                if (this.p.size() == 0) {
                    nextInt2 = -1;
                } else {
                    i = nextInt;
                }
                if (this.p.size() > this.e) {
                    float c = c();
                    if (c < this.d || c > this.c || this.p.size() >= this.f) {
                        this.h = false;
                    }
                    if (!this.h) {
                        int i2;
                        int i3;
                        this.livenessDataModel = new LivenessDataModel();
                        this.livenessDataModel.setLivenessValue(c);
                        this.livenessDataModel.setLivenessResult(c >= this.b ? NVLivenessResult.TRUE : NVLivenessResult.BO);
                        this.handler.sendEmptyMessage(105);
                        if (this.p.size() < this.f) {
                            this.handler.sendEmptyMessageDelayed(106, 1700);
                            i = -2;
                            nextInt2 = -2;
                        } else {
                            this.handler.sendEmptyMessage(106);
                        }
                        synchronized (this.q) {
                            int size = this.n.size();
                            Iterator it = this.n.iterator();
                            float f = 0.0f;
                            float f2 = 0.0f;
                            float f3 = 0.0f;
                            float f4 = 0.0f;
                            float f5 = 0.0f;
                            while (it.hasNext()) {
                                switch (((com.jumio.nv.liveness.extraction.a) it.next()).c) {
                                    case 0:
                                        f += 1.0f;
                                        break;
                                    case 1:
                                        f4 += 1.0f;
                                        break;
                                    case 2:
                                        f5 += 1.0f;
                                        break;
                                    case 3:
                                        f3 += 1.0f;
                                        break;
                                    case 4:
                                        f2 += 1.0f;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            float f6 = (float) size;
                            f /= f6;
                            f2 /= f6;
                            f3 /= f6;
                            f4 /= f6;
                            f5 /= f6;
                            long currentTimeMillis = System.currentTimeMillis();
                            i2 = i;
                            i3 = nextInt2;
                            float f7 = c;
                            Log.d(this.t.toString(), LogUtils.getSubFolder(a.class.getSimpleName()), String.format("scoreCalc_%d.csv", new Object[]{Long.valueOf(currentTimeMillis)}));
                            Log.d(this.s.toString(), LogUtils.getSubFolder(a.class.getSimpleName()), String.format("scoreCalc_%d.csv", new Object[]{Long.valueOf(currentTimeMillis)}));
                            Object metaInfo = new MetaInfo();
                            metaInfo.put("nullMovement", Float.valueOf(f));
                            metaInfo.put("micro", Float.valueOf(f2));
                            metaInfo.put("saccade", Float.valueOf(f3));
                            metaInfo.put("fixation", Float.valueOf(f4));
                            metaInfo.put("smooth", Float.valueOf(f5));
                            metaInfo.put("blinks", Integer.valueOf(this.l));
                            metaInfo.put("totalFrames", Integer.valueOf(size));
                            metaInfo.put("completed", Boolean.valueOf(true));
                            metaInfo.put(b.SCORE, Float.valueOf(f7));
                            metaInfo.put("targetPositions", Integer.valueOf(this.p.size()));
                            this.livenessDataModel.setEyetrackingData(new JSONObject(metaInfo).toString());
                            if (this.g) {
                                JumioAnalytics.add(MobileEvents.liveness(JumioAnalytics.getSessionId(), this.livenessDataModel.getLivenessResult().name(), metaInfo));
                            }
                        }
                        this.i.b();
                        i = i2;
                        nextInt2 = i3;
                    }
                }
                Bundle bundle = new Bundle();
                bundle.putInt("x", i);
                bundle.putInt("y", nextInt2);
                bundle.putInt("step", this.p.size());
                bundle.putInt("max_steps", this.f);
                a(new ExtractionUpdate(b.a, bundle));
                if (this.h) {
                    this.handler.sendEmptyMessageDelayed(200, 1700);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }
}
