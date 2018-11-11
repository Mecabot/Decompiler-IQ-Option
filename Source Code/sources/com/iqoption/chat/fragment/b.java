package com.iqoption.chat.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.iqoption.d.ea;
import com.iqoption.microservice.chat.o;
import com.iqoption.util.bg;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, aXE = {"Lcom/iqoption/chat/fragment/CantSendDelegate;", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate;", "params", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;", "message", "", "(Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;Ljava/lang/CharSequence;)V", "binding", "Lcom/iqoption/databinding/ChatRoomCantSendLayoutBinding;", "isBanned", "", "getMessage", "()Ljava/lang/CharSequence;", "tradingVolume", "", "onStateChanged", "state", "Lcom/iqoption/microservice/chat/ChatState;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomBottomBarDelegates.kt */
final class b extends u {
    private final CharSequence aFA;
    private final ea aFx = ((ea) com.iqoption.core.ext.a.a(Qd().PB(), (int) R.layout.chat_room_cant_send_layout, null, false, 6, null));
    private final Object aFy;
    private final boolean aFz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, aXE = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/CantSendDelegate$2$1"})
    /* compiled from: RoomBottomBarDelegates.kt */
    static final class a implements OnClickListener {
        final /* synthetic */ b aFB;

        a(b bVar) {
            this.aFB = bVar;
        }

        public final void onClick(View view) {
            com.iqoption.analytics.b.aiV.Bi();
            this.aFB.Qd().n(this.aFB.getMessage());
        }
    }

    public b(com.iqoption.chat.fragment.u.b bVar, CharSequence charSequence) {
        h.e(bVar, "params");
        h.e(charSequence, "message");
        super(bVar);
        this.aFA = charSequence;
        o Qi = bVar.Qi();
        boolean z = false;
        this.aFy = Qi != null ? Double.valueOf(Qi.arP()) : Integer.valueOf(0);
        o Qi2 = bVar.Qi();
        if (Qi2 != null) {
            z = Qi2.arO();
        }
        this.aFz = z;
        ViewGroup PB = Qd().PB();
        PB.removeAllViews();
        PB.addView(this.aFx.getRoot());
        ea eaVar = this.aFx;
        eaVar.bmW.setOnClickListener(new a(this));
        LinearLayout linearLayout = eaVar.bjl;
        h.d(linearLayout, "contentLayout");
        linearLayout.setLayoutTransition(bg.aGE());
    }

    public final CharSequence getMessage() {
        return this.aFA;
    }

    public u a(o oVar) {
        if (oVar == null) {
            return new i(Qg());
        }
        u acVar;
        b bVar;
        switch (Qg().Qh()) {
            case GLOBAL:
                if (!oVar.arO()) {
                    if (oVar.arP() >= oVar.arQ()) {
                        acVar = new ac(Qg());
                        break;
                    }
                    b bVar2;
                    if (h.E(this.aFy, Double.valueOf(oVar.arP()))) {
                        bVar2 = this;
                    } else {
                        bVar2 = new b(Qg(), w.a(this, oVar));
                    }
                    acVar = bVar2;
                    break;
                }
                if (this.aFz) {
                    bVar = this;
                } else {
                    bVar = new b(Qg(), getString(R.string.you_have_been_banned, new Object[0]));
                }
                acVar = bVar;
                break;
            case FEEDBACK:
                if (!oVar.arO()) {
                    acVar = new ac(Qg());
                    break;
                }
                if (this.aFz) {
                    bVar = this;
                } else {
                    bVar = new b(Qg(), getString(R.string.you_have_been_banned, new Object[0]));
                }
                acVar = bVar;
                break;
            case SUPPORT:
            case VIP:
            case MODERATION:
                acVar = new ac(Qg());
                break;
            default:
                acVar = new i(Qg());
                break;
        }
        return acVar;
    }
}
