package com.iqoption.chat.fragment;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.plus.PlusShare;
import com.iqoption.core.ui.widget.MaxSizeCardViewLayout;
import com.iqoption.d.ce;
import com.iqoption.dto.Event.Builder;
import com.iqoption.util.am;
import com.iqoption.x.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 $*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003$%&B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J&\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0016J\u001a\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, aXE = {"Lcom/iqoption/chat/fragment/MessageOptionsDialog;", "T", "Lcom/iqoption/fragment/base/IQAnimationFragment;", "()V", "animationController", "Lcom/iqoption/chat/fragment/DialogAnimationController;", "argument", "Ljava/lang/Object;", "binding", "Lcom/iqoption/databinding/ChatDialogMessageOptionsBinding;", "eventBuilder", "Lcom/iqoption/dto/Event$Builder;", "Lcom/iqoption/dto/Event;", "interactionListener", "Lcom/iqoption/chat/fragment/MessageOptionsDialog$InteractionListener;", "options", "", "Lcom/iqoption/chat/fragment/MessageOptionsDialog$Option;", "getAnimationDuration", "", "onClose", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onHideAnimation", "onShowAnimation", "onViewCreated", "view", "Companion", "InteractionListener", "Option", "IqOption-5.5.1_optionXRelease"})
/* compiled from: MessageOptionsDialog.kt */
public final class o<T> extends com.iqoption.fragment.base.b {
    private static final String TAG = "o";
    public static final a aHg = new a();
    private h aFD;
    private Builder aFE;
    private T aHc;
    private List<c> aHd;
    private b<? super T> aHe;
    private ce aHf;
    private HashMap atz;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JG\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0001\u0010\n2\u0006\u0010\u000b\u001a\u0002H\n2\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\n0\u0010¢\u0006\u0002\u0010\u0011R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, aXE = {"Lcom/iqoption/chat/fragment/MessageOptionsDialog$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "get", "Lcom/iqoption/chat/fragment/MessageOptionsDialog;", "T", "arg", "opts", "", "Lkotlin/Pair;", "interactor", "Lcom/iqoption/chat/fragment/MessageOptionsDialog$InteractionListener;", "(Ljava/lang/Object;Ljava/util/List;Lcom/iqoption/chat/fragment/MessageOptionsDialog$InteractionListener;)Lcom/iqoption/chat/fragment/MessageOptionsDialog;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessageOptionsDialog.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final String Ll() {
            return o.TAG;
        }

        public final <T> o<T> a(T t, List<Pair<String, String>> list, b<? super T> bVar) {
            h.e(list, "opts");
            h.e(bVar, "interactor");
            o oVar = new o();
            oVar.aHc = t;
            Iterable<Pair> iterable = list;
            Collection arrayList = new ArrayList(n.e(iterable, 10));
            for (Pair pair : iterable) {
                arrayList.add(new c((String) pair.getFirst(), (String) pair.aXF()));
            }
            oVar.aHd = (List) arrayList;
            oVar.aHe = bVar;
            return oVar;
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\u00020\u0002J%\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0001H&¢\u0006\u0002\u0010\t¨\u0006\n"}, aXE = {"Lcom/iqoption/chat/fragment/MessageOptionsDialog$InteractionListener;", "T", "", "onOptionClick", "", "name", "", "label", "arg", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessageOptionsDialog.kt */
    public interface b<T> {
        void a(String str, String str2, T t);
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0013"}, aXE = {"Lcom/iqoption/chat/fragment/MessageOptionsDialog$Option;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "name", "", "label", "(Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getName", "describeContents", "", "writeToParcel", "", "dest", "flags", "CREATOR", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: MessageOptionsDialog.kt */
    public static final class c implements Parcelable {
        public static final a CREATOR = new a();
        private final String label;
        private final String name;

        @i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, aXE = {"Lcom/iqoption/chat/fragment/MessageOptionsDialog$Option$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/iqoption/chat/fragment/MessageOptionsDialog$Option;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/iqoption/chat/fragment/MessageOptionsDialog$Option;", "IqOption-5.5.1_optionXRelease"})
        /* compiled from: MessageOptionsDialog.kt */
        public static final class a implements Creator<c> {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            /* renamed from: G */
            public c createFromParcel(Parcel parcel) {
                h.e(parcel, "parcel");
                return new c(parcel);
            }

            /* renamed from: dB */
            public c[] newArray(int i) {
                return new c[i];
            }
        }

        public int describeContents() {
            return 0;
        }

        public c(String str, String str2) {
            h.e(str, "name");
            h.e(str2, PlusShare.KEY_CALL_TO_ACTION_LABEL);
            this.name = str;
            this.label = str2;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getName() {
            return this.name;
        }

        public c(Parcel parcel) {
            h.e(parcel, "parcel");
            String readString = parcel.readString();
            h.d(readString, "parcel.readString()");
            String readString2 = parcel.readString();
            h.d(readString2, "parcel.readString()");
            this(readString, readString2);
        }

        public void writeToParcel(Parcel parcel, int i) {
            h.e(parcel, "dest");
            parcel.writeString(this.name);
            parcel.writeString(this.label);
        }
    }

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, aXE = {"<anonymous>", "", "T", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/iqoption/chat/fragment/MessageOptionsDialog$onCreateView$1$1"})
    /* compiled from: MessageOptionsDialog.kt */
    static final class d implements OnClickListener {
        final /* synthetic */ Object $arg$inlined;
        final /* synthetic */ LayoutInflater $inflater$inlined;
        final /* synthetic */ List $opts$inlined;
        final /* synthetic */ o this$0;

        d(o oVar, Object obj, List list, LayoutInflater layoutInflater) {
            this.this$0 = oVar;
            this.$arg$inlined = obj;
            this.$opts$inlined = list;
            this.$inflater$inlined = layoutInflater;
        }

        public final void onClick(View view) {
            this.this$0.onClose();
        }
    }

    public void KH() {
        if (this.atz != null) {
            this.atz.clear();
        }
    }

    public long getAnimationDuration() {
        return 250;
    }

    public void ND() {
        h hVar = this.aFD;
        if (hVar == null) {
            h.lS("animationController");
        }
        hVar.PF();
    }

    public void NE() {
        h hVar = this.aFD;
        if (hVar == null) {
            h.lS("animationController");
        }
        hVar.PG();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.e(layoutInflater, "inflater");
        Object obj = this.aHc;
        if (obj == null) {
            com.iqoption.core.i.w(TAG, "Argument is null");
            onClose();
            return null;
        }
        List<c> list = this.aHd;
        if (list == null) {
            com.iqoption.core.i.w(TAG, "Options list is null");
            onClose();
            return null;
        } else if (this.aHe == null) {
            com.iqoption.core.i.w(TAG, "InteractionListener is null");
            onClose();
            return null;
        } else {
            ce ceVar = (ce) com.iqoption.core.ext.a.a((Fragment) this, (int) R.layout.chat_dialog_message_options, viewGroup, false, 4, null);
            am.n(zzakw());
            this.aHf = ceVar;
            com.iqoption.fragment.base.b bVar = this;
            View root = ceVar.getRoot();
            h.d(root, "root");
            MaxSizeCardViewLayout maxSizeCardViewLayout = ceVar.bmb;
            h.d(maxSizeCardViewLayout, "frame");
            this.aFD = new h(bVar, root, maxSizeCardViewLayout);
            ceVar.awS.setOnClickListener(new d(this, obj, list, layoutInflater));
            kotlin.jvm.a.b messageOptionsDialog$onCreateView$$inlined$apply$lambda$2 = new MessageOptionsDialog$onCreateView$$inlined$apply$lambda$2(this, obj, list, layoutInflater);
            for (c cVar : list) {
                View inflate = layoutInflater.inflate(R.layout.chat_dialog_message_option_item, ceVar.bmi, false);
                if (inflate == null) {
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
                }
                TextView textView = (TextView) inflate;
                textView.setTag(cVar.getName());
                textView.setText(cVar.getLabel());
                textView.setOnClickListener(messageOptionsDialog$onCreateView$$inlined$apply$lambda$2 != null ? new p(messageOptionsDialog$onCreateView$$inlined$apply$lambda$2) : messageOptionsDialog$onCreateView$$inlined$apply$lambda$2);
                ceVar.bmi.addView(textView);
            }
            ce ceVar2 = this.aHf;
            if (ceVar2 == null) {
                h.lS("binding");
            }
            return ceVar2.getRoot();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        h.e(view, Promotion.ACTION_VIEW);
        super.onViewCreated(view, bundle);
        this.aFE = (Builder) null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        Builder builder = this.aFE;
        KH();
    }

    public boolean onClose() {
        com.iqoption.core.ext.a.p(this).popBackStack();
        return true;
    }
}
