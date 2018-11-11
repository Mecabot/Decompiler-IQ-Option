package com.iqoption.quiz.model;

import com.iqoption.core.ui.widget.recyclerview.adapter.a.d;
import java.math.BigDecimal;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001aB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0013¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, aXE = {"Lcom/iqoption/quiz/model/QuizLeaderBoardItem;", "Lcom/iqoption/quiz/model/QuizLeaderBoardAdapterItem;", "Lcom/iqoption/core/ui/widget/recyclerview/adapter/diff/Identifiable;", "", "statResponse", "Lcom/iqoption/quiz/api/response/StatResponse;", "useIconForPlaces", "", "(Lcom/iqoption/quiz/api/response/StatResponse;Z)V", "displayName", "getDisplayName", "()Ljava/lang/String;", "formattedValue", "getFormattedValue", "id", "getId", "isYou", "()Z", "position", "", "getPosition", "()I", "positionIconDrawableRes", "getPositionIconDrawableRes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "Companion", "quiz_release"})
/* compiled from: QuizLeaderBoardItems.kt */
public final class l extends j implements d<String> {
    private static final BigDecimal dlW;
    public static final a dlX = new a();
    private final boolean dlS;
    private final Integer dlT;
    private final String dlU;
    private final String dlV;
    private final String id;
    private final int position;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, aXE = {"Lcom/iqoption/quiz/model/QuizLeaderBoardItem$Companion;", "", "()V", "ONE_MILLION", "Ljava/math/BigDecimal;", "getONE_MILLION", "()Ljava/math/BigDecimal;", "quiz_release"})
    /* compiled from: QuizLeaderBoardItems.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARNING: Missing block: B:22:0x00a8, code:
            if (r7 != null) goto L_0x00df;
     */
    /* JADX WARNING: Missing block: B:31:0x00d3, code:
            if (r7 != null) goto L_0x00d8;
     */
    public l(com.iqoption.quiz.api.response.j r7, boolean r8) {
        /*
        r6 = this;
        r0 = "statResponse";
        kotlin.jvm.internal.h.e(r7, r0);
        r0 = 0;
        r6.<init>(r0);
        r1 = r7.aAt();
        r1 = r1.getId();
        r1 = java.lang.String.valueOf(r1);
        r6.id = r1;
        r1 = r7.getPosition();
        r6.position = r1;
        r1 = com.iqoption.core.f.RQ();
        r1 = r1.Dr();
        r1 = r1.getUserId();
        r3 = r7.aAt();
        r3 = r3.getId();
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        r1 = 0;
        r2 = 1;
        if (r5 != 0) goto L_0x003a;
    L_0x0038:
        r3 = 1;
        goto L_0x003b;
    L_0x003a:
        r3 = 0;
    L_0x003b:
        r6.dlS = r3;
        if (r8 != 0) goto L_0x0040;
    L_0x003f:
        goto L_0x005a;
    L_0x0040:
        r8 = r6.position;
        switch(r8) {
            case 1: goto L_0x0054;
            case 2: goto L_0x004d;
            case 3: goto L_0x0046;
            default: goto L_0x0045;
        };
    L_0x0045:
        goto L_0x005a;
    L_0x0046:
        r8 = com.iqoption.quiz.ae.b.ic_leaderboard_three_22x30dp;
        r0 = java.lang.Integer.valueOf(r8);
        goto L_0x005a;
    L_0x004d:
        r8 = com.iqoption.quiz.ae.b.ic_leaderboard_two_22x30dp;
        r0 = java.lang.Integer.valueOf(r8);
        goto L_0x005a;
    L_0x0054:
        r8 = com.iqoption.quiz.ae.b.ic_leaderboard_one_22x30dp;
        r0 = java.lang.Integer.valueOf(r8);
    L_0x005a:
        r6.dlT = r0;
        r8 = r7.aAt();
        r8 = r8.aAB();
        r0 = "statResponse.user.nickName";
        kotlin.jvm.internal.h.d(r8, r0);
        r8 = (java.lang.CharSequence) r8;
        r8 = r8.length();
        if (r8 <= 0) goto L_0x0073;
    L_0x0072:
        r1 = 1;
    L_0x0073:
        if (r1 == 0) goto L_0x0084;
    L_0x0075:
        r8 = r7.aAt();
        r8 = r8.aAB();
        r0 = "statResponse.user.nickName";
        kotlin.jvm.internal.h.d(r8, r0);
        goto L_0x0092;
    L_0x0084:
        r8 = r7.aAt();
        r8 = r8.getName();
        r0 = "statResponse.user.name";
        kotlin.jvm.internal.h.d(r8, r0);
    L_0x0092:
        r6.dlU = r8;
        r8 = com.iqoption.core.f.Dr();
        r8 = r8.Dh();
        if (r8 == 0) goto L_0x00ae;
    L_0x009e:
        r7 = r7.VZ();
        if (r7 == 0) goto L_0x00ab;
    L_0x00a4:
        r7 = r7.toPlainString();
        if (r7 == 0) goto L_0x00ab;
    L_0x00aa:
        goto L_0x00df;
    L_0x00ab:
        r7 = "0";
        goto L_0x00df;
    L_0x00ae:
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r0 = 36;
        r8.append(r0);
        r7 = r7.VZ();
        if (r7 == 0) goto L_0x00d6;
    L_0x00be:
        r0 = dlW;
        r7 = r7.divide(r0);
        if (r7 == 0) goto L_0x00d6;
    L_0x00c6:
        r0 = 2;
        r1 = java.math.RoundingMode.FLOOR;
        r7 = r7.setScale(r0, r1);
        if (r7 == 0) goto L_0x00d6;
    L_0x00cf:
        r7 = r7.toPlainString();
        if (r7 == 0) goto L_0x00d6;
    L_0x00d5:
        goto L_0x00d8;
    L_0x00d6:
        r7 = "0";
    L_0x00d8:
        r8.append(r7);
        r7 = r8.toString();
    L_0x00df:
        r6.dlV = r7;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iqoption.quiz.model.l.<init>(com.iqoption.quiz.api.response.j, boolean):void");
    }

    /* renamed from: getId */
    public String Jf() {
        return this.id;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean aBw() {
        return this.dlS;
    }

    public final Integer aBx() {
        return this.dlT;
    }

    public final String getDisplayName() {
        return this.dlU;
    }

    public final String aBy() {
        return this.dlV;
    }

    static {
        BigDecimal valueOf = BigDecimal.valueOf(1000000);
        h.d(valueOf, "BigDecimal.valueOf(1000000)");
        dlW = valueOf;
    }
}
