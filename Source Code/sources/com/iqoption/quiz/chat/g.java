package com.iqoption.quiz.chat;

import android.content.res.Resources;
import android.graphics.Color;
import com.iqoption.quiz.ae.a;
import com.iqoption.quiz.b.q;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, aXE = {"Lcom/iqoption/quiz/chat/ChatStylesImpl;", "Lcom/iqoption/quiz/chat/ChatStyles;", "res", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "avatarSize", "", "getAvatarSize", "()I", "largeTextSize", "", "getLargeTextSize", "()F", "smallTextSize", "getSmallTextSize", "textColor", "getTextColor", "quiz_release"})
/* compiled from: ChatStyles.kt */
public final class g implements f {
    private final int aDI;
    private final float dfH;
    private final float dfI;
    private final int textColor = Color.argb(127, 255, 255, 255);

    public g(Resources resources) {
        h.e(resources, "res");
        this.aDI = resources.getDimensionPixelSize(a.quiz_chat_avatar_size);
        this.dfH = resources.getDimension(a.sp14);
        this.dfI = resources.getDimension(a.sp20);
    }

    public void a(q qVar) {
        h.e(qVar, "binding");
        f.a.a(this, qVar);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((q) obj);
        return l.etX;
    }

    public int ayT() {
        return this.aDI;
    }

    public float ayU() {
        return this.dfH;
    }

    public float ayV() {
        return this.dfI;
    }

    public int getTextColor() {
        return this.textColor;
    }
}
