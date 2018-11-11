package com.iqoption.core.ui.a;

import android.support.v7.app.AppCompatActivity;
import com.iqoption.core.ui.navigation.b;
import com.iqoption.core.ui.navigation.g;
import com.iqoption.core.util.j;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, aXE = {"Lcom/iqoption/core/ui/activity/IQActivity;", "Landroid/support/v7/app/AppCompatActivity;", "Lcom/iqoption/core/ui/navigation/BackController;", "()V", "backController", "Lcom/iqoption/core/ui/navigation/FirstWinBackController;", "keyboardUtil", "Lcom/iqoption/core/util/KeyboardUtil;", "addListener", "", "listener", "Lcom/iqoption/core/ui/navigation/BackListener;", "isKeyboardVisible", "", "onBackPressed", "onCloseByBack", "onPause", "onResume", "removeListener", "core_release"})
/* compiled from: IQActivity.kt */
public abstract class a extends AppCompatActivity implements com.iqoption.core.ui.navigation.a {
    private final g aew = new g();
    private j baZ;

    protected void Yv() {
    }

    public void onResume() {
        super.onResume();
        this.baZ = new j(this);
    }

    public void onPause() {
        super.onPause();
        this.baZ = (j) null;
    }

    public final boolean Yu() {
        j jVar = this.baZ;
        return jVar != null && jVar.zN();
    }

    public void a(b bVar) {
        h.e(bVar, "listener");
        this.aew.a(bVar);
    }

    public void b(b bVar) {
        h.e(bVar, "listener");
        this.aew.b(bVar);
    }

    public void onBackPressed() {
        if (!this.aew.onBackPressed()) {
            Yv();
            super.onBackPressed();
        }
    }
}
