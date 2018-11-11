package com.iqoption.quiz.chat;

import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import com.iqoption.quiz.b.q;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\bf\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0011\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0002R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0012"}, aXE = {"Lcom/iqoption/quiz/chat/ChatStyles;", "Lkotlin/Function1;", "Lcom/iqoption/quiz/databinding/QuizChatItemBinding;", "", "avatarSize", "", "getAvatarSize", "()I", "largeTextSize", "", "getLargeTextSize", "()F", "smallTextSize", "getSmallTextSize", "textColor", "getTextColor", "invoke", "binding", "quiz_release"})
/* compiled from: ChatStyles.kt */
public interface f extends b<q, l> {

    @i(aXC = {1, 1, 11})
    /* compiled from: ChatStyles.kt */
    public static final class a {
        public static void a(f fVar, q qVar) {
            h.e(qVar, "binding");
            ImageView imageView = qVar.bmj;
            h.d(imageView, "binding.avatar");
            imageView.setLayoutParams(new LayoutParams(fVar.ayT(), fVar.ayT()));
        }
    }

    void a(q qVar);

    int ayT();

    float ayU();

    float ayV();

    int getTextColor();
}
