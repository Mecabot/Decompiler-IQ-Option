package com.iqoption.chat.fragment;

import android.arch.lifecycle.Observer;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.chat.viewmodel.RoomViewModel.c;
import com.iqoption.core.util.LocalizationUtil;
import com.iqoption.d.ej;
import com.iqoption.microservice.chat.n;
import com.iqoption.view.text.FormattedTextView;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/chat/fragment/SupportRoomTopBarDelegate;", "Lcom/iqoption/chat/fragment/RoomTopBarDelegate;", "delegateContext", "Lcom/iqoption/chat/fragment/DelegateContext;", "showOnline", "", "(Lcom/iqoption/chat/fragment/DelegateContext;Z)V", "binding", "Lcom/iqoption/databinding/ChatRoomSupportToolbarBinding;", "onRoomLoaded", "", "room", "Lcom/iqoption/microservice/chat/ChatRoom;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomTopBarDelegates.kt */
public final class ae extends y {
    private final g aHK;
    private final ej aJc = ((ej) aa.e(this.aHK, R.layout.chat_room_support_toolbar));
    private final boolean aJd;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "it", "Lcom/iqoption/chat/viewmodel/RoomViewModel$TypingInfo;", "onChanged", "com/iqoption/chat/fragment/SupportRoomTopBarDelegate$onRoomLoaded$1$1"})
    /* compiled from: RoomTopBarDelegates.kt */
    static final class a<T> implements Observer<c> {
        final /* synthetic */ n $room$inlined;
        final /* synthetic */ ej aJe;
        final /* synthetic */ ae aJf;

        a(ej ejVar, ae aeVar, n nVar) {
            this.aJe = ejVar;
            this.aJf = aeVar;
            this.$room$inlined = nVar;
        }

        /* renamed from: a */
        public final void onChanged(c cVar) {
            if (cVar != null) {
                int count = cVar.getCount();
                if (count != 0) {
                    TextView textView = this.aJe.bnb;
                    h.d(textView, "typing");
                    textView.setText(this.aJf.a(R.plurals.typing, count, cVar.getName()));
                    return;
                }
                TextView textView2 = this.aJe.bnb;
                h.d(textView2, "typing");
                textView2.setText((CharSequence) null);
            }
        }
    }

    public ae(g gVar, boolean z) {
        h.e(gVar, "delegateContext");
        super(gVar);
        this.aHK = gVar;
        this.aJd = z;
    }

    public void g(n nVar) {
        if (nVar != null) {
            ej ejVar = this.aJc;
            TextView textView = ejVar.agA;
            h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
            textView.setText(LocalizationUtil.translate(nVar.getName()));
            FormattedTextView formattedTextView;
            ImageView imageView;
            if (this.aJd) {
                formattedTextView = ejVar.bna;
                h.d(formattedTextView, "subtitle");
                formattedTextView.setVisibility(0);
                imageView = ejVar.bmZ;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            } else {
                formattedTextView = ejVar.bna;
                h.d(formattedTextView, "subtitle");
                formattedTextView.setVisibility(8);
                imageView = ejVar.bmZ;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }
            this.aHK.PC().Rg().observe(this.aHK, new a(ejVar, this, nVar));
        }
    }
}
