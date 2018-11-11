package jumio.nv.core;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.widget.ImageView;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.nv.R;

/* compiled from: HelpViewAnimation */
public class aa {
    private AnimatedVectorDrawableCompat a = null;
    private Context b;
    private int c;
    private boolean d = false;
    private boolean e = false;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private DocumentScanMode j;
    private AnimatorSet k;
    private boolean l;
    private int m;

    public aa(Context context) {
        this.b = context;
    }

    /* JADX WARNING: Missing block: B:56:0x01c5, code:
            return;
     */
    public synchronized void a(android.view.View r7, com.jumio.nv.view.interactors.NVScanView.NVHelpConfiguration r8, boolean r9) {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.d;	 Catch:{ all -> 0x01c6 }
        if (r0 == 0) goto L_0x0008;
    L_0x0005:
        r6.b();	 Catch:{ all -> 0x01c6 }
    L_0x0008:
        r0 = r6.b;	 Catch:{ all -> 0x01c6 }
        r0 = r0.getResources();	 Catch:{ all -> 0x01c6 }
        r1 = com.jumio.nv.R.integer.help_animation_duration_default;	 Catch:{ all -> 0x01c6 }
        r0 = r0.getInteger(r1);	 Catch:{ all -> 0x01c6 }
        r6.c = r0;	 Catch:{ all -> 0x01c6 }
        r0 = com.jumio.nv.R.id.iv_help_doc;	 Catch:{ all -> 0x01c6 }
        r0 = r7.findViewById(r0);	 Catch:{ all -> 0x01c6 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ all -> 0x01c6 }
        r6.f = r0;	 Catch:{ all -> 0x01c6 }
        r0 = com.jumio.nv.R.id.iv_help_overlay_hor;	 Catch:{ all -> 0x01c6 }
        r0 = r7.findViewById(r0);	 Catch:{ all -> 0x01c6 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ all -> 0x01c6 }
        r6.g = r0;	 Catch:{ all -> 0x01c6 }
        r0 = com.jumio.nv.R.id.iv_help_overlay_vert;	 Catch:{ all -> 0x01c6 }
        r0 = r7.findViewById(r0);	 Catch:{ all -> 0x01c6 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ all -> 0x01c6 }
        r6.h = r0;	 Catch:{ all -> 0x01c6 }
        r0 = com.jumio.nv.R.id.iv_help_overlay_body;	 Catch:{ all -> 0x01c6 }
        r7 = r7.findViewById(r0);	 Catch:{ all -> 0x01c6 }
        r7 = (android.widget.ImageView) r7;	 Catch:{ all -> 0x01c6 }
        r6.i = r7;	 Catch:{ all -> 0x01c6 }
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r0 = 1;
        r1 = 0;
        if (r7 == 0) goto L_0x0052;
    L_0x0044:
        r7 = r6.g;	 Catch:{ all -> 0x01c6 }
        if (r7 == 0) goto L_0x0052;
    L_0x0048:
        r7 = r6.h;	 Catch:{ all -> 0x01c6 }
        if (r7 == 0) goto L_0x0052;
    L_0x004c:
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        if (r7 == 0) goto L_0x0052;
    L_0x0050:
        r7 = 1;
        goto L_0x0053;
    L_0x0052:
        r7 = 0;
    L_0x0053:
        r6.e = r7;	 Catch:{ all -> 0x01c6 }
        r7 = r6.e;	 Catch:{ all -> 0x01c6 }
        if (r7 != 0) goto L_0x005b;
    L_0x0059:
        monitor-exit(r6);
        return;
    L_0x005b:
        r7 = r8.scanMode;	 Catch:{ all -> 0x01c6 }
        r6.j = r7;	 Catch:{ all -> 0x01c6 }
        r7 = r8.side;	 Catch:{ all -> 0x01c6 }
        r2 = r6.j;	 Catch:{ all -> 0x01c6 }
        r3 = com.jumio.core.data.document.DocumentScanMode.MRP;	 Catch:{ all -> 0x01c6 }
        if (r2 == r3) goto L_0x0071;
    L_0x0067:
        r2 = r6.j;	 Catch:{ all -> 0x01c6 }
        r3 = com.jumio.core.data.document.DocumentScanMode.MRV;	 Catch:{ all -> 0x01c6 }
        if (r2 != r3) goto L_0x006e;
    L_0x006d:
        goto L_0x0071;
    L_0x006e:
        r6.m = r1;	 Catch:{ all -> 0x01c6 }
        goto L_0x00a1;
    L_0x0071:
        r2 = r6.b;	 Catch:{ all -> 0x01c6 }
        r2 = r2.getResources();	 Catch:{ all -> 0x01c6 }
        r3 = com.jumio.nv.R.dimen.nv_helpview_passport_document_height;	 Catch:{ all -> 0x01c6 }
        r2 = r2.getDimension(r3);	 Catch:{ all -> 0x01c6 }
        r3 = r6.b;	 Catch:{ all -> 0x01c6 }
        r3 = r3.getResources();	 Catch:{ all -> 0x01c6 }
        r3 = r3.getDisplayMetrics();	 Catch:{ all -> 0x01c6 }
        r3 = r3.density;	 Catch:{ all -> 0x01c6 }
        r2 = r2 / r3;
        r2 = (int) r2;	 Catch:{ all -> 0x01c6 }
        if (r9 == 0) goto L_0x0099;
    L_0x008d:
        r2 = (double) r2;	 Catch:{ all -> 0x01c6 }
        r4 = 4595292915783759299; // 0x3fc5c28f5c28f5c3 float:1.90232056E17 double:0.17;
        r2 = r2 * r4;
        r9 = (int) r2;	 Catch:{ all -> 0x01c6 }
        r6.m = r9;	 Catch:{ all -> 0x01c6 }
        goto L_0x00a1;
    L_0x0099:
        r2 = (double) r2;	 Catch:{ all -> 0x01c6 }
        r4 = 4593671619917905920; // 0x3fc0000000000000 float:0.0 double:0.125;
        r2 = r2 * r4;
        r9 = (int) r2;	 Catch:{ all -> 0x01c6 }
        r6.m = r9;	 Catch:{ all -> 0x01c6 }
    L_0x00a1:
        r9 = r6.f;	 Catch:{ all -> 0x01c6 }
        r2 = 0;
        r9.setAlpha(r2);	 Catch:{ all -> 0x01c6 }
        r9 = r6.i;	 Catch:{ all -> 0x01c6 }
        r9.setAlpha(r2);	 Catch:{ all -> 0x01c6 }
        r9 = r6.g;	 Catch:{ all -> 0x01c6 }
        r9.setAlpha(r2);	 Catch:{ all -> 0x01c6 }
        r9 = r6.h;	 Catch:{ all -> 0x01c6 }
        r9.setAlpha(r2);	 Catch:{ all -> 0x01c6 }
        r9 = r6.g;	 Catch:{ all -> 0x01c6 }
        r2 = 8;
        r9.setVisibility(r2);	 Catch:{ all -> 0x01c6 }
        r9 = r6.h;	 Catch:{ all -> 0x01c6 }
        r9.setVisibility(r2);	 Catch:{ all -> 0x01c6 }
        r6.l = r0;	 Catch:{ all -> 0x01c6 }
        r9 = jumio.nv.core.aa.AnonymousClass5.a;	 Catch:{ all -> 0x01c6 }
        r0 = r6.j;	 Catch:{ all -> 0x01c6 }
        r0 = r0.ordinal();	 Catch:{ all -> 0x01c6 }
        r9 = r9[r0];	 Catch:{ all -> 0x01c6 }
        switch(r9) {
            case 1: goto L_0x013a;
            case 2: goto L_0x013a;
            case 3: goto L_0x012a;
            case 4: goto L_0x0113;
            case 5: goto L_0x0113;
            case 6: goto L_0x0103;
            case 7: goto L_0x0103;
            case 8: goto L_0x00f3;
            case 9: goto L_0x00e1;
            case 10: goto L_0x00d3;
            default: goto L_0x00d1;
        };	 Catch:{ all -> 0x01c6 }
    L_0x00d1:
        goto L_0x01c4;
    L_0x00d3:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r1);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r1);	 Catch:{ all -> 0x01c6 }
        r6.l = r1;	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x00e1:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_barcode_back_doc;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_barcode_back_doc;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r6.l = r1;	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x00f3:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_lf_tm_front_doc;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_tm_front_overlay;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x0103:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_3_mrz_front_doc_big_cut;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_3_mrz_front_overlay;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x0113:
        r8 = r6.f;	 Catch:{ all -> 0x01c6 }
        r9 = com.jumio.core.data.document.ScanSide.FRONT;	 Catch:{ all -> 0x01c6 }
        if (r7 != r9) goto L_0x011c;
    L_0x0119:
        r7 = com.jumio.nv.R.drawable.id_2_mrz_front_doc;	 Catch:{ all -> 0x01c6 }
        goto L_0x011e;
    L_0x011c:
        r7 = com.jumio.nv.R.drawable.id_2_mrz_back_doc;	 Catch:{ all -> 0x01c6 }
    L_0x011e:
        r8.setImageResource(r7);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_2_mrz_front_overlay;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x012a:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_mrz_back_doc;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_mrz_back_overlay;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x013a:
        r9 = r8.isUSDLFallback;	 Catch:{ all -> 0x01c6 }
        if (r9 == 0) goto L_0x0150;
    L_0x013e:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_flip_doc_to_front;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_flip_doc_to_front;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r6.l = r1;	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x0150:
        r9 = r8.isIdBackFaceDetected;	 Catch:{ all -> 0x01c6 }
        if (r9 == 0) goto L_0x0165;
    L_0x0154:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.nv_flip_document_to_back;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.nv_flip_document_to_back;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r6.l = r1;	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x0165:
        r8 = r8.initialScanMode;	 Catch:{ all -> 0x01c6 }
        r9 = com.jumio.core.data.document.DocumentScanMode.CNIS;	 Catch:{ all -> 0x01c6 }
        if (r8 != r9) goto L_0x0192;
    L_0x016b:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_2_lf_back_doc;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_2_lf_front_overlay;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.g;	 Catch:{ all -> 0x01c6 }
        r7.setVisibility(r1);	 Catch:{ all -> 0x01c6 }
        r7 = r6.h;	 Catch:{ all -> 0x01c6 }
        r7.setVisibility(r1);	 Catch:{ all -> 0x01c6 }
        r7 = r6.h;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_2_lf_front_overlay_vertical;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.g;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_2_lf_front_overlay_horizontal;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        goto L_0x01c4;
    L_0x0192:
        r8 = com.jumio.core.data.document.ScanSide.BACK;	 Catch:{ all -> 0x01c6 }
        if (r7 != r8) goto L_0x019e;
    L_0x0196:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_lf_back_doc;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        goto L_0x01a5;
    L_0x019e:
        r7 = r6.f;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_lf_tm_front_doc;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
    L_0x01a5:
        r7 = r6.i;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_lf_front_overlay;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.g;	 Catch:{ all -> 0x01c6 }
        r7.setVisibility(r1);	 Catch:{ all -> 0x01c6 }
        r7 = r6.h;	 Catch:{ all -> 0x01c6 }
        r7.setVisibility(r1);	 Catch:{ all -> 0x01c6 }
        r7 = r6.h;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_lf_front_overlay_vertical;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
        r7 = r6.g;	 Catch:{ all -> 0x01c6 }
        r8 = com.jumio.nv.R.drawable.id_1_lf_front_overlay_horizontal;	 Catch:{ all -> 0x01c6 }
        r7.setImageResource(r8);	 Catch:{ all -> 0x01c6 }
    L_0x01c4:
        monitor-exit(r6);
        return;
    L_0x01c6:
        r7 = move-exception;
        monitor-exit(r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.core.aa.a(android.view.View, com.jumio.nv.view.interactors.NVScanView$NVHelpConfiguration, boolean):void");
    }

    /* JADX WARNING: Missing block: B:11:0x0012, code:
            return;
     */
    public synchronized void a() {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.e;	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);
        return;
    L_0x0007:
        r0 = r1.d;	 Catch:{ all -> 0x0013 }
        if (r0 != 0) goto L_0x0011;
    L_0x000b:
        r0 = 1;
        r1.d = r0;	 Catch:{ all -> 0x0013 }
        r1.c();	 Catch:{ all -> 0x0013 }
    L_0x0011:
        monitor-exit(r1);
        return;
    L_0x0013:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.core.aa.a():void");
    }

    /* JADX WARNING: Missing block: B:12:0x0014, code:
            return;
     */
    public synchronized void b() {
        /*
        r1 = this;
        monitor-enter(r1);
        r0 = r1.e;	 Catch:{ all -> 0x0015 }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r1);
        return;
    L_0x0007:
        r0 = 0;
        r1.d = r0;	 Catch:{ all -> 0x0015 }
        r0 = r1.k;	 Catch:{ all -> 0x0015 }
        if (r0 == 0) goto L_0x0013;
    L_0x000e:
        r0 = r1.k;	 Catch:{ all -> 0x0015 }
        r0.cancel();	 Catch:{ all -> 0x0015 }
    L_0x0013:
        monitor-exit(r1);
        return;
    L_0x0015:
        r0 = move-exception;
        monitor-exit(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.core.aa.b():void");
    }

    /* JADX WARNING: Missing block: B:14:?, code:
            r5.d = false;
     */
    /* JADX WARNING: Missing block: B:16:0x0064, code:
            return;
     */
    private synchronized void c() {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = 0;
        r1 = r5.d;	 Catch:{ Exception -> 0x0061 }
        if (r1 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r5);
        return;
    L_0x0008:
        r1 = r5.l;	 Catch:{ Exception -> 0x0061 }
        if (r1 == 0) goto L_0x004d;
    L_0x000c:
        r1 = new android.animation.AnimatorSet;	 Catch:{ Exception -> 0x0061 }
        r1.<init>();	 Catch:{ Exception -> 0x0061 }
        r5.k = r1;	 Catch:{ Exception -> 0x0061 }
        r1 = r5.k;	 Catch:{ Exception -> 0x0061 }
        r2 = 5;
        r2 = new android.animation.Animator[r2];	 Catch:{ Exception -> 0x0061 }
        r3 = r5.d();	 Catch:{ Exception -> 0x0061 }
        r2[r0] = r3;	 Catch:{ Exception -> 0x0061 }
        r3 = 1;
        r4 = r5.e();	 Catch:{ Exception -> 0x0061 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0061 }
        r3 = 2;
        r4 = r5.f();	 Catch:{ Exception -> 0x0061 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0061 }
        r3 = 3;
        r4 = r5.g();	 Catch:{ Exception -> 0x0061 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0061 }
        r3 = 4;
        r4 = r5.h();	 Catch:{ Exception -> 0x0061 }
        r2[r3] = r4;	 Catch:{ Exception -> 0x0061 }
        r1.playSequentially(r2);	 Catch:{ Exception -> 0x0061 }
        r1 = r5.k;	 Catch:{ Exception -> 0x0061 }
        r2 = new jumio.nv.core.aa$1;	 Catch:{ Exception -> 0x0061 }
        r2.<init>();	 Catch:{ Exception -> 0x0061 }
        r1.addListener(r2);	 Catch:{ Exception -> 0x0061 }
        r1 = r5.k;	 Catch:{ Exception -> 0x0061 }
        r1.start();	 Catch:{ Exception -> 0x0061 }
        goto L_0x0063;
    L_0x004d:
        r1 = r5.f;	 Catch:{ Exception -> 0x0061 }
        r5.a(r1);	 Catch:{ Exception -> 0x0061 }
        r1 = r5.f;	 Catch:{ Exception -> 0x0061 }
        r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r1.setAlpha(r2);	 Catch:{ Exception -> 0x0061 }
        r1 = r5.i;	 Catch:{ Exception -> 0x0061 }
        r5.a(r1);	 Catch:{ Exception -> 0x0061 }
        goto L_0x0063;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0065;
    L_0x0061:
        r5.d = r0;	 Catch:{ all -> 0x005f }
    L_0x0063:
        monitor-exit(r5);
        return;
    L_0x0065:
        monitor-exit(r5);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.nv.core.aa.c():void");
    }

    private void a(ImageView imageView) {
        imageView.setAlpha(0.0f);
        imageView.setTranslationY(0.0f);
        imageView.setTranslationX(0.0f);
        imageView.setScaleX(1.0f);
        imageView.setScaleY(1.0f);
        imageView.setRotation(0.0f);
    }

    private AnimatorSet d() {
        a(this.i);
        a(this.g);
        a(this.h);
        a(this.f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (aa.this.j == DocumentScanMode.TEMPLATEMATCHER) {
                    aa.this.i.setImageResource(R.drawable.id_1_tm_front_overlay);
                }
            }
        });
        animatorSet.setStartDelay(0);
        animatorSet.play(ObjectAnimator.ofFloat(this.f, "scaleX", new float[]{0.0f, 1.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "scaleY", new float[]{0.0f, 1.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "alpha", new float[]{0.0f, 1.0f}).setDuration((long) this.c));
        animatorSet.setTarget(this.f);
        return animatorSet;
    }

    private AnimatorSet e() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(220);
        if (this.j == DocumentScanMode.MRP || this.j == DocumentScanMode.MRV) {
            this.i.setTranslationY((float) ScreenUtil.dpToPx(this.b, this.m));
        }
        Builder with = animatorSet.play(ObjectAnimator.ofFloat(this.f, "rotation", new float[]{-6.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "translationX", new float[]{(float) (-ScreenUtil.dpToPx(this.b, 30))}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "translationY", new float[]{(float) ScreenUtil.dpToPx(this.b, 15)}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "alpha", new float[]{1.0f, 0.4f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "alpha", new float[]{0.0f, 1.0f}).setDuration((long) this.c));
        if (this.j == DocumentScanMode.TEMPLATEMATCHER) {
            Animator animatorSet2 = new AnimatorSet();
            animatorSet2.play(ObjectAnimator.ofFloat(this.i, "rotation", new float[]{-7.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "translationX", new float[]{(float) (-ScreenUtil.dpToPx(this.b, 28))}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "translationY", new float[]{(float) ScreenUtil.dpToPx(this.b, 20)}).setDuration((long) this.c));
            animatorSet2.setStartDelay(330);
            with.with(animatorSet2);
        }
        return animatorSet;
    }

    private AnimatorSet f() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(220);
        Builder play = animatorSet.play(ObjectAnimator.ofFloat(this.f, "rotation", new float[]{-3.0f}).setDuration((long) this.c));
        ImageView imageView = this.f;
        String str = "translationX";
        float[] fArr = new float[1];
        int dpToPx = (this.j == DocumentScanMode.CSSN || this.j == DocumentScanMode.LINEFINDER) ? ScreenUtil.dpToPx(this.b, 5) : ScreenUtil.dpToPx(this.b, 15);
        fArr[0] = (float) (-dpToPx);
        play = play.with(ObjectAnimator.ofFloat(imageView, str, fArr).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "translationY", new float[]{(float) ScreenUtil.dpToPx(this.b, 14)}).setDuration((long) this.c));
        if (this.j == DocumentScanMode.TEMPLATEMATCHER) {
            Animator animatorSet2 = new AnimatorSet();
            animatorSet2.play(ObjectAnimator.ofFloat(this.i, "rotation", new float[]{-3.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "translationX", new float[]{(float) (-ScreenUtil.dpToPx(this.b, 15))}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "translationY", new float[]{(float) ScreenUtil.dpToPx(this.b, 14)}).setDuration((long) this.c));
            animatorSet2.setStartDelay(330);
            play.with(animatorSet2);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                aa.this.h.setAlpha(1.0f);
            }
        });
        return animatorSet;
    }

    private AnimatorSet g() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(220);
        if (this.j == DocumentScanMode.MRP || this.j == DocumentScanMode.MRV) {
            animatorSet.play(ObjectAnimator.ofFloat(this.f, "rotation", new float[]{0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "translationY", new float[]{0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "translationX", new float[]{(float) ScreenUtil.dpToPx(this.b, 1)}).setDuration((long) this.c));
        } else {
            Builder with = animatorSet.play(ObjectAnimator.ofFloat(this.f, "rotation", new float[]{0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "translationX", new float[]{0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.f, "translationY", new float[]{0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "translationY", new float[]{0.0f}).setDuration((long) this.c));
            if (this.j == DocumentScanMode.TEMPLATEMATCHER) {
                Animator animatorSet2 = new AnimatorSet();
                animatorSet2.play(ObjectAnimator.ofFloat(this.i, "rotation", new float[]{0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "translationX", new float[]{0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "translationY", new float[]{0.0f}).setDuration((long) this.c));
                animatorSet2.setStartDelay(330);
                with.with(animatorSet2);
            }
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                aa.this.g.setAlpha(1.0f);
                if (aa.this.j == DocumentScanMode.TEMPLATEMATCHER) {
                    aa.this.a = AnimatedVectorDrawableCompat.create(aa.this.b, R.drawable.nv_animated_vector_tm_build_up);
                    aa.this.i.setImageDrawable(aa.this.a);
                    aa.this.a.start();
                }
            }
        });
        return animatorSet;
    }

    private AnimatorSet h() {
        AnimatorSet animatorSet = new AnimatorSet();
        if (this.j == DocumentScanMode.TEMPLATEMATCHER) {
            animatorSet.setStartDelay((long) this.b.getResources().getInteger(R.integer.help_template_matcher_keyframe_full_duration));
        } else {
            animatorSet.setStartDelay((long) this.c);
        }
        animatorSet.play(ObjectAnimator.ofFloat(this.f, "alpha", new float[]{0.4f, 0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.i, "alpha", new float[]{1.0f, 0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.h, "alpha", new float[]{1.0f, 0.0f}).setDuration((long) this.c)).with(ObjectAnimator.ofFloat(this.g, "alpha", new float[]{1.0f, 0.0f}).setDuration((long) this.c));
        return animatorSet;
    }
}
