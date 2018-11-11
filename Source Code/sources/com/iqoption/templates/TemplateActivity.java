package com.iqoption.templates;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.iqoption.charttools.f;
import com.iqoption.charttools.model.chart.ChartColor;
import com.iqoption.charttools.model.chart.ChartType;
import com.iqoption.charttools.tools.d;
import com.iqoption.chat.viewmodel.WebSocketViewModel;
import com.iqoption.core.ui.navigation.b;
import com.iqoption.core.ui.navigation.g;
import com.iqoption.util.EventSenderLifecycleObserver;
import com.iqoption.x.R;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0014J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/templates/TemplateActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/iqoption/core/ui/navigation/BackController;", "()V", "backController", "Lcom/iqoption/core/ui/navigation/FirstWinBackController;", "addListener", "", "listener", "Lcom/iqoption/core/ui/navigation/BackListener;", "getArgs", "Landroid/os/Bundle;", "intent", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "removeListener", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: TemplateActivity.kt */
public final class TemplateActivity extends AppCompatActivity implements com.iqoption.core.ui.navigation.a {
    public static final a dsm = new a();
    private final g aew = new g();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, aXE = {"Lcom/iqoption/templates/TemplateActivity$Companion;", "", "()V", "EXTRA_TEMPLATE_ID", "", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: TemplateActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public void a(b bVar) {
        h.e(bVar, "listener");
        this.aew.a(bVar);
    }

    public void b(b bVar) {
        h.e(bVar, "listener");
        this.aew.b(bVar);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.content);
        setContentView(frameLayout, new LayoutParams(-1, -1));
        if (bundle == null) {
            Intent intent = getIntent();
            h.d(intent, "intent");
            bundle = x(intent);
            if (bundle == null) {
                finish();
                return;
            }
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            h.d(supportFragmentManager, "supportFragmentManager");
            FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
            h.d(beginTransaction, "ft");
            com.iqoption.charttools.templates.i iVar = new com.iqoption.charttools.templates.i();
            iVar.setArguments(bundle);
            beginTransaction.add(R.id.content, iVar, com.iqoption.charttools.templates.i.TAG);
            beginTransaction.commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
        WebSocketViewModel.aMd.h(this);
        getLifecycle().a(new EventSenderLifecycleObserver(d.aAz.Nt(), null, 2, null));
    }

    private final Bundle x(Intent intent) {
        com.iqoption.app.managers.tab.a Il = com.iqoption.app.managers.tab.a.Il();
        h.d(Il, "TabHelper.instance()");
        com.iqoption.app.managers.tab.a.g IC = Il.IC();
        Bundle bundle = null;
        if (IC == null) {
            return null;
        }
        long longExtra = intent.getLongExtra("extra.templateId", -1);
        com.iqoption.charttools.templates.i.a aVar;
        String IM;
        if (longExtra != -1) {
            aVar = com.iqoption.charttools.templates.i.azq;
            IM = IC.IM();
            h.d(IM, "tab.idString");
            return aVar.f(IM, longExtra);
        }
        com.iqoption.app.managers.tab.a.h IX = IC.IX();
        int i = IX.chartType;
        ChartType[] values = ChartType.values();
        for (Enum enumR : values) {
            if ((enumR.ordinal() == i ? 1 : null) != null) {
                break;
            }
        }
        Enum enumR2 = null;
        ChartType chartType = enumR2 != null ? enumR2 : values[0];
        i = (IX.apA ^ 1) != 0 ? 1 : 0;
        ChartColor[] values2 = ChartColor.values();
        for (Enum enumR3 : values2) {
            if ((enumR3.ordinal() == i ? 1 : null) != null) {
                bundle = enumR3;
                break;
            }
        }
        if (bundle == null) {
            bundle = values2[0];
        }
        com.iqoption.charttools.model.chart.a aVar2 = new com.iqoption.charttools.model.chart.a(chartType, bundle, Integer.valueOf(IX.candleSize), Boolean.valueOf(IX.apC), Boolean.valueOf(IX.apB), Boolean.valueOf(com.iqoption.core.data.d.d.aOE.SH()), Boolean.valueOf(com.iqoption.core.data.d.d.aOE.SI()), Boolean.valueOf(f.arM.Ka()));
        aVar = com.iqoption.charttools.templates.i.azq;
        IM = IC.IM();
        h.d(IM, "tab.idString");
        return aVar.a(IM, aVar2);
    }

    public void onBackPressed() {
        if (!this.aew.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
