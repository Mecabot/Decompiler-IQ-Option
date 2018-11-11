package com.iqoption.view.text;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, aXE = {"Lcom/iqoption/view/text/OpenBrowserClickListener;", "Lcom/iqoption/view/text/LinkClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "onLinkClicked", "", "link", "Lcom/iqoption/view/text/Link;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: LinkUtils.kt */
public final class s implements m {
    private final Context context;

    public s(Context context) {
        h.e(context, "context");
        this.context = context;
    }

    public void b(l lVar) {
        h.e(lVar, "link");
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(lVar.getUrl()));
        intent.addFlags(268435456);
        this.context.startActivity(intent);
    }
}
