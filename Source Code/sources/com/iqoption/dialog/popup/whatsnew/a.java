package com.iqoption.dialog.popup.whatsnew;

import android.arch.lifecycle.Observer;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.ext.g;
import com.iqoption.core.util.a.e;
import com.iqoption.d.jz;
import com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.d;
import com.iqoption.dto.ChartTimeInterval;
import com.iqoption.fragment.dialog.popup.PopupViewModel;
import com.iqoption.traderoom.TradeRoomViewModel;
import com.iqoption.x.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import java.util.HashMap;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewDialog;", "Lcom/iqoption/core/ui/fragment/IQFragment;", "()V", "popup", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "getPopup", "()Lcom/iqoption/core/microservices/popupserver/response/Popup;", "close", "", "event", "", "onCreateTransitionProvider", "Lcom/iqoption/core/ui/animation/transitions/TransitionProvider;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WhatsNewDialog.kt */
public final class a extends com.iqoption.core.ui.fragment.b {
    public static final String TAG = "com.iqoption.dialog.popup.whatsnew.a";
    public static final a cjC = new a();
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, aXE = {"Lcom/iqoption/dialog/popup/whatsnew/WhatsNewDialog$Companion;", "", "()V", "ARG_POPUP", "", "TAG", "kotlin.jvm.PlatformType", "newInstance", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewDialog;", "popup", "Lcom/iqoption/core/microservices/popupserver/response/Popup;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WhatsNewDialog.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final a b(com.iqoption.core.microservices.popupserver.response.a aVar) {
            h.e(aVar, "popup");
            a aVar2 = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("arg.popup", aVar);
            aVar2.setArguments(bundle);
            return aVar2;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, aXE = {"com/iqoption/dialog/popup/whatsnew/WhatsNewDialog$onCreateView$1$clickListener$1", "Lcom/iqoption/core/ext/OnDelayClickListener;", "onDelayClick", "", "v", "Landroid/view/View;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WhatsNewDialog.kt */
    public static final class b extends g {
        final /* synthetic */ jz cjD;
        final /* synthetic */ a cjE;
        final /* synthetic */ WhatsNewViewModel cjF;
        final /* synthetic */ a cjG;

        b(jz jzVar, a aVar, WhatsNewViewModel whatsNewViewModel, a aVar2) {
            this.cjD = jzVar;
            this.cjE = aVar;
            this.cjF = whatsNewViewModel;
            this.cjG = aVar2;
            super(0, 1, null);
        }

        public void q(View view) {
            h.e(view, "v");
            switch (view.getId()) {
                case R.id.btnClose:
                case R.id.veil:
                    this.cjE.close();
                    return;
                case R.id.btnNegative:
                    this.cjF.aeT();
                    return;
                case R.id.btnPlayVideo:
                    String aeX = this.cjF.aeR().aeX();
                    if (aeX != null) {
                        TradeRoomViewModel B = TradeRoomViewModel.dsq.B(com.iqoption.core.ext.a.n(this.cjE));
                        ImageView imageView = this.cjD.aEt;
                        h.d(imageView, "image");
                        B.a(aeX, com.iqoption.core.ext.a.J(imageView));
                        return;
                    }
                    return;
                case R.id.btnPositive:
                    this.cjF.aeU();
                    return;
                default:
                    return;
            }
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, aXE = {"<anonymous>", "", "action", "Lcom/iqoption/dialog/popup/whatsnew/WhatsNewViewModel$Action;", "onChanged", "com/iqoption/dialog/popup/whatsnew/WhatsNewDialog$onCreateView$1$2"})
    /* compiled from: WhatsNewDialog.kt */
    static final class c<T> implements Observer<com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a> {
        final /* synthetic */ a cjE;
        final /* synthetic */ WhatsNewViewModel cjF;
        final /* synthetic */ a cjG;

        c(a aVar, WhatsNewViewModel whatsNewViewModel, a aVar2) {
            this.cjE = aVar;
            this.cjF = whatsNewViewModel;
            this.cjG = aVar2;
        }

        /* renamed from: a */
        public final void onChanged(com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a aVar) {
            FragmentActivity activity;
            if (aVar instanceof com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.a) {
                this.cjE.close();
            } else if (aVar instanceof com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.c) {
                activity = this.cjE.zzakw();
                if (activity != null) {
                    this.cjE.close(aVar.getId());
                    com.iqoption.traderoom.TradeRoomViewModel.b bVar = TradeRoomViewModel.dsq;
                    h.d(activity, "activity");
                    com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.c cVar = (com.iqoption.dialog.popup.whatsnew.WhatsNewViewModel.a.c) aVar;
                    bVar.B(activity).c(cVar.getInstrumentType(), cVar.getActiveId());
                }
            } else if (aVar instanceof d) {
                activity = this.cjE.zzakw();
                if (activity != null) {
                    this.cjE.close(aVar.getId());
                    com.iqoption.traderoom.TradeRoomViewModel.b bVar2 = TradeRoomViewModel.dsq;
                    h.d(activity, "activity");
                    bVar2.B(activity).eY(true);
                }
            }
        }
    }

    public static final a b(com.iqoption.core.microservices.popupserver.response.a aVar) {
        return cjC.b(aVar);
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public View dj(int i) {
        if (this.atz == null) {
            this.atz = new HashMap();
        }
        View view = (View) this.atz.get(Integer.valueOf(i));
        if (view == null) {
            view = getView();
            if (view == null) {
                return null;
            }
            view = view.findViewById(i);
            this.atz.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        KH();
    }

    private final com.iqoption.core.microservices.popupserver.response.a aeQ() {
        Parcelable parcelable = com.iqoption.core.ext.a.o(this).getParcelable("arg.popup");
        h.d(parcelable, "args.getParcelable(ARG_POPUP)");
        return (com.iqoption.core.microservices.popupserver.response.a) parcelable;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        WhatsNewViewModel a = WhatsNewViewModel.cjM.a(this, aeQ());
        if (a.isInvalid()) {
            close();
            return null;
        }
        jz jzVar = (jz) com.iqoption.core.ext.a.a(this, (int) R.layout.dialog_whats_new, viewGroup, false, 4, null);
        a aVar = (a) this;
        OnClickListener bVar = new b(jzVar, this, a, aVar);
        jzVar.buJ.setOnClickListener(bVar);
        jzVar.blt.setOnClickListener(bVar);
        jzVar.buG.setOnClickListener(bVar);
        jzVar.buE.setOnClickListener(bVar);
        jzVar.buF.setOnClickListener(bVar);
        TextView textView = jzVar.buH;
        h.d(textView, "headerTitle");
        textView.setText(a.aeR().aeW());
        Picasso.with(com.iqoption.core.ext.a.m(this)).load(a.aeR().getImage()).resizeDimen(R.dimen.dp280, R.dimen.dp132).transform((Transformation) new com.iqoption.core.ui.picasso.c(com.iqoption.core.ext.a.c((ViewDataBinding) jzVar, (int) R.dimen.dp8))).centerCrop().placeholder((int) R.drawable.rect_grey_blur_05_rounded_8).into(jzVar.aEt);
        textView = jzVar.agA;
        h.d(textView, PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE);
        textView.setText(a.aeR().getTitle());
        com.iqoption.core.util.a.a aeY = a.aeR().aeY();
        String message = a.aeR().getMessage();
        if (aeY != null) {
            TextView textView2 = jzVar.buI;
            h.d(textView2, "message");
            com.iqoption.core.util.a.a[] aVarArr = new com.iqoption.core.util.a.a[]{aeY};
            com.iqoption.core.util.a.d.a(new e(aVarArr, textView2, message, 0, 0, false, null, ChartTimeInterval.CANDLE_2m, null));
        } else {
            textView = jzVar.buI;
            h.d(textView, "message");
            textView.setText(message);
        }
        if (a.aeR().aeX() != null) {
            View view = jzVar.buK;
            h.d(view, "videoVeil");
            com.iqoption.core.ext.a.L(view);
            ImageView imageView = jzVar.buF;
            h.d(imageView, "btnPlayVideo");
            com.iqoption.core.ext.a.L(imageView);
        }
        textView = jzVar.buE;
        h.d(textView, "btnNegative");
        textView.setText(a.aeR().aeZ().getTitle());
        textView = jzVar.buG;
        h.d(textView, "btnPositive");
        textView.setText(a.aeR().afa().getTitle());
        a.aeS().observe(aVar, new c(this, a, aVar));
        com.iqoption.core.ui.navigation.a YH = YH();
        if (YH != null) {
            getLifecycle().a(new WhatsNewDialog$onCreateView$$inlined$let$lambda$1(YH, YH, this));
        }
        return jzVar.getRoot();
    }

    private final void close() {
        close("close");
    }

    private final void close(String str) {
        FragmentActivity activity = zzakw();
        if (activity != null) {
            com.iqoption.fragment.dialog.popup.PopupViewModel.a aVar = PopupViewModel.cBp;
            h.d(activity, "activity");
            aVar.j(activity).a(aeQ(), str);
            if (isAdded()) {
                com.iqoption.core.ext.a.p(this).popBackStack();
            }
        }
    }

    protected com.iqoption.core.ui.b.b.e JO() {
        return new com.iqoption.core.ui.b.b.a(this, null, 2, null);
    }
}
