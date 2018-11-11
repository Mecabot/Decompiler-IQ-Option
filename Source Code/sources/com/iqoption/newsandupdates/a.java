package com.iqoption.newsandupdates;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.iqoption.d.abm;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, aXE = {"Lcom/iqoption/newsandupdates/Holder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "binding", "Lcom/iqoption/databinding/NewsAndUpdatesItemBinding;", "listener", "Lcom/iqoption/newsandupdates/Listener;", "(Lcom/iqoption/databinding/NewsAndUpdatesItemBinding;Lcom/iqoption/newsandupdates/Listener;)V", "getBinding", "()Lcom/iqoption/databinding/NewsAndUpdatesItemBinding;", "bind", "", "item", "Lcom/iqoption/newsandupdates/NewsAndUpdatesItem;", "IqOption-5.5.1_optionXRelease"})
/* compiled from: NewsAndUpdatesAdapter.kt */
public final class a extends ViewHolder {
    private final abm cWT;
    private final b cWU;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, aXE = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "checked", "", "onCheckedChanged", "com/iqoption/newsandupdates/Holder$bind$1$1"})
    /* compiled from: NewsAndUpdatesAdapter.kt */
    static final class a implements OnCheckedChangeListener {
        final /* synthetic */ a cWV;
        final /* synthetic */ f cWW;

        a(a aVar, f fVar) {
            this.cWV = aVar;
            this.cWW = fVar;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            this.cWV.cWU.a(this.cWW, z);
        }
    }

    public a(abm abm, b bVar) {
        h.e(abm, "binding");
        h.e(bVar, "listener");
        super(abm.getRoot());
        this.cWT = abm;
        this.cWU = bVar;
    }

    public final void a(f fVar) {
        h.e(fVar, "item");
        abm abm = this.cWT;
        abm.bMq.setText(fVar.avo());
        abm.bMo.setText(fVar.avp());
        SwitchCompat switchCompat = abm.bMp;
        h.d(switchCompat, "newsAndUpdatesSwitch");
        switchCompat.setChecked(fVar.getChecked());
        abm.bMp.setOnCheckedChangeListener(new a(this, fVar));
    }
}
