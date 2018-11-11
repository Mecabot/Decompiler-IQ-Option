package com.iqoption.chat.fragment;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.iqoption.chat.component.aw;
import com.iqoption.chat.viewmodel.RoomViewModel;
import com.iqoption.d.eh;
import com.iqoption.microservice.chat.ChatRoomType;
import com.iqoption.microservice.chat.n;
import com.iqoption.microservice.chat.o;
import com.iqoption.util.bg;
import com.iqoption.view.text.x;
import com.iqoption.x.R;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\rH\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, aXE = {"Lcom/iqoption/chat/fragment/SendDelegate;", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate;", "Landroid/arch/lifecycle/LifecycleOwner;", "params", "Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;", "(Lcom/iqoption/chat/fragment/RoomBottomBarDelegate$Params;)V", "binding", "Lcom/iqoption/databinding/ChatRoomSendLayoutBinding;", "lastHandledTime", "", "viewModel", "Lcom/iqoption/chat/viewmodel/RoomViewModel;", "getLifecycle", "Landroid/arch/lifecycle/Lifecycle;", "isMessageInteractionsAvailable", "", "onReplyMessage", "", "message", "Lcom/iqoption/microservice/chat/ChatMessage;", "withText", "onStateChanged", "state", "Lcom/iqoption/microservice/chat/ChatState;", "save", "Landroid/os/Bundle;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: RoomBottomBarDelegates.kt */
final class ac extends u implements LifecycleOwner {
    public static final g aIZ = new g();
    private final /* synthetic */ g aHX;
    private final eh aIX = ((eh) com.iqoption.core.ext.a.a(Qd().PB(), (int) R.layout.chat_room_send_layout, null, false, 6, null));
    private long aIY;
    private final RoomViewModel aIf = Qd().PC();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange", "com/iqoption/chat/fragment/SendDelegate$2$4"})
    /* compiled from: RoomBottomBarDelegates.kt */
    static final class a implements OnFocusChangeListener {
        final /* synthetic */ ac $lifecycleOwner$inlined;
        final /* synthetic */ com.iqoption.chat.fragment.u.b $params$inlined;
        final /* synthetic */ ac this$0;

        a(ac acVar, ac acVar2, com.iqoption.chat.fragment.u.b bVar) {
            this.this$0 = acVar;
            this.$lifecycleOwner$inlined = acVar2;
            this.$params$inlined = bVar;
        }

        public final void onFocusChange(View view, boolean z) {
            if (!z) {
                this.this$0.Qd().PD();
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/chat/fragment/SendDelegate$Companion;", "", "()V", "KEY_LAST_HANDLED_TIME", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomBottomBarDelegates.kt */
    public static final class g {
        private g() {
        }

        public /* synthetic */ g(f fVar) {
            this();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/SendDelegate$2$6", "Lcom/iqoption/view/text/TextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomBottomBarDelegates.kt */
    public static final class b extends x {
        final /* synthetic */ ac $lifecycleOwner$inlined;
        final /* synthetic */ com.iqoption.chat.fragment.u.b $params$inlined;
        final /* synthetic */ ac this$0;

        b(ac acVar, ac acVar2, com.iqoption.chat.fragment.u.b bVar) {
            this.this$0 = acVar;
            this.$lifecycleOwner$inlined = acVar2;
            this.$params$inlined = bVar;
        }

        public void afterTextChanged(Editable editable) {
            h.e(editable, "s");
            super.afterTextChanged(editable);
            this.this$0.aIf.fW(editable.toString());
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/chat/fragment/SendDelegate$2$7", "Lcom/iqoption/view/text/TextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomBottomBarDelegates.kt */
    public static final class c extends x {
        final /* synthetic */ ac $lifecycleOwner$inlined;
        final /* synthetic */ com.iqoption.chat.fragment.u.b $params$inlined;
        final /* synthetic */ ac this$0;

        c(ac acVar, ac acVar2, com.iqoption.chat.fragment.u.b bVar) {
            this.this$0 = acVar;
            this.$lifecycleOwner$inlined = acVar2;
            this.$params$inlined = bVar;
        }

        public void afterTextChanged(Editable editable) {
            h.e(editable, "s");
            super.afterTextChanged(editable);
            this.this$0.aIf.Rm();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/SendDelegate$$special$$inlined$setOnDelayedClickListener$1"})
    /* compiled from: AndroidExtensions.kt */
    public static final class d extends com.iqoption.core.ext.g {
        final /* synthetic */ ac $lifecycleOwner$inlined;
        final /* synthetic */ com.iqoption.chat.fragment.u.b $params$inlined;
        final /* synthetic */ ac this$0;

        public d(ac acVar, ac acVar2, com.iqoption.chat.fragment.u.b bVar) {
            this.this$0 = acVar;
            this.$lifecycleOwner$inlined = acVar2;
            this.$params$inlined = bVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            this.this$0.Qd().PE();
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, aXE = {"com/iqoption/core/ext/AndroidExtensionsKt$setOnDelayedClickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "core_release", "com/iqoption/chat/fragment/SendDelegate$$special$$inlined$setOnDelayedClickListener$2"})
    /* compiled from: AndroidExtensions.kt */
    public static final class e extends com.iqoption.core.ext.g {
        final /* synthetic */ ac $lifecycleOwner$inlined;
        final /* synthetic */ com.iqoption.chat.fragment.u.b $params$inlined;
        final /* synthetic */ eh aJa;
        final /* synthetic */ ac this$0;

        public e(eh ehVar, ac acVar, ac acVar2, com.iqoption.chat.fragment.u.b bVar) {
            this.this$0 = acVar;
            this.$lifecycleOwner$inlined = acVar2;
            this.$params$inlined = bVar;
            this.aJa = ehVar;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            n nVar = (n) this.this$0.aIf.Ra().getValue();
            if (nVar != null) {
                com.iqoption.analytics.b bVar = com.iqoption.analytics.b.aiV;
                h.d(nVar, "it");
                bVar.b(nVar);
            }
            RoomViewModel b = this.this$0.aIf;
            EditText editText = this.aJa.bmY;
            h.d(editText, "messageInput");
            String obj = editText.getText().toString();
            if (obj == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            b.fV(v.trim(obj).toString());
            ImageView imageView = this.aJa.bmG;
            h.d(imageView, "btnSend");
            imageView.setEnabled(false);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, aXE = {"com/iqoption/chat/fragment/SendDelegate$2$5", "Lcom/iqoption/view/text/TextWatcherAdapter;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: RoomBottomBarDelegates.kt */
    public static final class f extends x {
        final /* synthetic */ kotlin.jvm.a.b aJb;

        f(kotlin.jvm.a.b bVar) {
            this.aJb = bVar;
        }

        public void afterTextChanged(Editable editable) {
            h.e(editable, "s");
            super.afterTextChanged(editable);
            this.aJb.invoke(editable);
        }
    }

    public boolean Qf() {
        return true;
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.aHX.getLifecycle();
    }

    public ac(com.iqoption.chat.fragment.u.b bVar) {
        ImageView imageView;
        h.e(bVar, "params");
        super(bVar);
        this.aHX = bVar.Qd();
        ViewGroup PB = Qd().PB();
        PB.removeAllViews();
        PB.addView(this.aIX.getRoot());
        Bundle Qj = bVar.Qj();
        if (Qj != null) {
            this.aIY = Qj.getLong("key.lastHandledTime");
        }
        ac acVar = this;
        eh ehVar = this.aIX;
        this.aIf.Rc().observe(acVar, new aw(new SendDelegate$$special$$inlined$apply$lambda$1(this, acVar, bVar), new SendDelegate$$special$$inlined$apply$lambda$2(ehVar, this, acVar, bVar)));
        LinearLayout linearLayout = ehVar.bjl;
        h.d(linearLayout, "contentLayout");
        LayoutTransition aGE = bg.aGE();
        aGE.setDuration(200);
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(ehVar.bmG, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_X, new float[]{0.05f, 1.0f}), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[]{0.05f, 1.0f})});
        aGE.setAnimator(2, ofPropertyValuesHolder);
        aGE.setDuration(2, 200);
        aGE.setStartDelay(2, 150);
        aGE.setInterpolator(2, com.iqoption.view.a.a.d.dEM);
        ofPropertyValuesHolder = ofPropertyValuesHolder.clone();
        h.d(ofPropertyValuesHolder, "disappearing");
        ofPropertyValuesHolder.setTarget(ehVar.bmG);
        aGE.setAnimator(3, ofPropertyValuesHolder);
        aGE.setStartDelay(3, 0);
        aGE.setInterpolator(3, new com.iqoption.view.a.a.e());
        aGE.setStartDelay(1, 150);
        linearLayout.setLayoutTransition(aGE);
        if (com.iqoption.core.ext.c.b(bVar.Qh(), ChatRoomType.SUPPORT, ChatRoomType.VIP)) {
            imageView = ehVar.bmX;
            h.d(imageView, "btnAttach");
            imageView.setVisibility(0);
        } else {
            imageView = ehVar.bmX;
            h.d(imageView, "btnAttach");
            imageView.setVisibility(8);
        }
        kotlin.jvm.a.b sendDelegate$2$updateSendButton$1 = new SendDelegate$2$updateSendButton$1(ehVar);
        sendDelegate$2$updateSendButton$1.invoke("");
        ehVar.bmY.setOnFocusChangeListener(new a(this, acVar, bVar));
        ehVar.bmY.addTextChangedListener(new f(sendDelegate$2$updateSendButton$1));
        if (bVar.Qh() == ChatRoomType.SUPPORT || bVar.Qh() == ChatRoomType.VIP) {
            ehVar.bmY.addTextChangedListener(new b(this, acVar, bVar));
        } else if (bVar.Qh() == ChatRoomType.GLOBAL) {
            ehVar.bmY.addTextChangedListener(new c(this, acVar, bVar));
        }
        imageView = ehVar.bmX;
        h.d(imageView, "btnAttach");
        imageView.setOnClickListener(new d(this, acVar, bVar));
        imageView = ehVar.bmG;
        h.d(imageView, "btnSend");
        imageView.setOnClickListener(new e(ehVar, this, acVar, bVar));
    }

    public u a(o oVar) {
        if (oVar == null) {
            Qd().PD();
            return new i(Qg());
        }
        u uVar;
        switch (Qg().Qh()) {
            case GLOBAL:
                if (!oVar.arO()) {
                    if (oVar.arP() >= oVar.arQ()) {
                        uVar = this;
                        break;
                    }
                    Qd().PD();
                    uVar = new b(Qg(), w.a(this, oVar));
                    break;
                }
                Qd().PD();
                uVar = new b(Qg(), getString(R.string.you_have_been_banned, new Object[0]));
                break;
            case FEEDBACK:
                if (!oVar.arO()) {
                    uVar = this;
                    break;
                }
                Qd().PD();
                uVar = new b(Qg(), getString(R.string.you_have_been_banned, new Object[0]));
                break;
            case SUPPORT:
            case VIP:
            case MODERATION:
                uVar = this;
                break;
            default:
                uVar = new i(Qg());
                break;
        }
        return uVar;
    }

    public Bundle Qe() {
        Bundle bundle = new Bundle();
        bundle.putLong("key.lastHandledTime", this.aIY);
        return bundle;
    }

    public void a(com.iqoption.microservice.chat.g gVar, boolean z) {
        String stringBuilder;
        h.e(gVar, "message");
        StringBuilder stringBuilder2;
        if (z) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(getString(R.string.sender_wrote_message, gVar.arn(), gVar.getText()));
            stringBuilder2.append(10);
            stringBuilder = stringBuilder2.toString();
        } else {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(gVar.arn());
            stringBuilder2.append(", ");
            stringBuilder = stringBuilder2.toString();
        }
        this.aIX.bmY.setText(stringBuilder);
        this.aIX.bmY.setSelection(stringBuilder.length());
        this.aIX.bmY.requestFocus();
        g Qd = Qd();
        EditText editText = this.aIX.bmY;
        h.d(editText, "binding.messageInput");
        Qd.G(editText);
    }
}
