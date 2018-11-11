package com.iqoption.chat.fragment;

import android.arch.lifecycle.Observer;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.chat.viewmodel.RoomViewModel.c;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.d.ee;
import com.iqoption.microservice.chat.n;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/chat/fragment/PublicRoomTopBarDelegate;", "Lcom/iqoption/chat/fragment/RoomTopBarDelegate;", "delegateContext", "Lcom/iqoption/chat/fragment/DelegateContext;", "(Lcom/iqoption/chat/fragment/DelegateContext;)V", "binding", "Lcom/iqoption/databinding/ChatRoomPublicToolbarBinding;", "onRoomLoaded", "", "room", "Lcom/iqoption/microservice/chat/ChatRoom;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomTopBarDelegates.kt */
public final class s extends y {
    private final ee aHJ = ((ee) aa.e(this.aHK, R.layout.chat_room_public_toolbar));
    private final g aHK;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/viewmodel/RoomViewModel$TypingInfo;", "onChanged", "com/iqoption/chat/fragment/PublicRoomTopBarDelegate$onRoomLoaded$1$3"})
    /* compiled from: RoomTopBarDelegates.kt */
    static final class a<T> implements Observer<c> {
        final /* synthetic */ PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2 aHL;
        final /* synthetic */ PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1 aHM;

        a(PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2 publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2, PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1 publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1) {
            this.aHL = publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2;
            this.aHM = publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1;
        }

        /* renamed from: a */
        public final void onChanged(c cVar) {
            if (cVar != null) {
                int count = cVar.getCount();
                if (count != 0) {
                    this.aHL.B(cVar.getName(), count);
                } else {
                    this.aHM.invoke();
                }
            }
        }
    }

    public s(g gVar) {
        h.e(gVar, "delegateContext");
        super(gVar);
        this.aHK = gVar;
    }

    public void g(n nVar) {
        if (nVar != null) {
            ee eeVar = this.aHJ;
            TextView textView = eeVar.agA;
            h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            textView.setText(LocalizationUtil.translate(nVar.getName()));
            PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1 publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1 = new PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1(eeVar, this, nVar);
            PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2 publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2 = new PublicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2(eeVar, this, nVar);
            publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1.invoke();
            this.aHK.PC().Rg().observe(this.aHK, new a(publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$2, publicRoomTopBarDelegate$onRoomLoaded$$inlined$apply$lambda$1));
        }
    }
}
