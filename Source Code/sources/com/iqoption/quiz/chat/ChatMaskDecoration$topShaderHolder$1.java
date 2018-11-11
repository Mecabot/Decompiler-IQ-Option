package com.iqoption.quiz.chat;

import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, aXE = {"<anonymous>", "Landroid/graphics/LinearGradient;", "it", "", "invoke"})
/* compiled from: ChatMaskDecoration.kt */
final class ChatMaskDecoration$topShaderHolder$1 extends Lambda implements b<Float, LinearGradient> {
    public static final ChatMaskDecoration$topShaderHolder$1 djN = new ChatMaskDecoration$topShaderHolder$1();

    ChatMaskDecoration$topShaderHolder$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return K(((Number) obj).floatValue());
    }

    public final LinearGradient K(float f) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, f * 0.1f, e.djI, e.djJ, TileMode.CLAMP);
    }
}
