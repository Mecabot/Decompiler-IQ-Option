package com.iqoption.chat.fragment;

import android.widget.EditText;
import android.widget.ImageView;
import com.iqoption.chat.component.ag;
import com.iqoption.d.eh;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.a.b;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/component/ResultEvent;", "invoke", "com/iqoption/chat/fragment/SendDelegate$2$2"})
/* compiled from: RoomBottomBarDelegates.kt */
final class SendDelegate$$special$$inlined$apply$lambda$2 extends Lambda implements b<ag, l> {
    final /* synthetic */ ac $lifecycleOwner$inlined;
    final /* synthetic */ u.b $params$inlined;
    final /* synthetic */ eh receiver$0;
    final /* synthetic */ ac this$0;

    SendDelegate$$special$$inlined$apply$lambda$2(eh ehVar, ac acVar, ac acVar2, u.b bVar) {
        this.receiver$0 = ehVar;
        this.this$0 = acVar;
        this.$lifecycleOwner$inlined = acVar2;
        this.$params$inlined = bVar;
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        b((ag) obj);
        return l.etX;
    }

    public final void b(ag agVar) {
        h.e(agVar, "it");
        if (agVar.Pg()) {
            EditText editText = this.receiver$0.bmY;
            h.d(editText, "messageInput");
            editText.setText((CharSequence) null);
        } else if (h.E("access denied", agVar.getError())) {
            com.iqoption.app.a.b.eP(this.this$0.getString(R.string.you_have_been_temporarily_blocked_by_a_moderator, new Object[0]));
        } else {
            com.iqoption.app.a.b.eP(this.this$0.getString(R.string.something_went_wrong_please_try_again_later, new Object[0]));
        }
        this.this$0.aIY = agVar.getTime();
        ImageView imageView = this.receiver$0.bmG;
        h.d(imageView, "btnSend");
        imageView.setEnabled(true);
    }
}
