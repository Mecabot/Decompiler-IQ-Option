package com.iqoption.dialog.popup.whatsnew;

import com.iqoption.core.ui.navigation.LifecycleBackListener;
import com.iqoption.core.ui.navigation.a;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, aXE = {"com/iqoption/dialog/popup/whatsnew/WhatsNewDialog$onCreateView$2$1", "Lcom/iqoption/core/ui/navigation/LifecycleBackListener;", "onBackPressed", "", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WhatsNewDialog.kt */
public final class WhatsNewDialog$onCreateView$$inlined$let$lambda$1 extends LifecycleBackListener {
    final /* synthetic */ a azx;
    final /* synthetic */ a cjE;

    WhatsNewDialog$onCreateView$$inlined$let$lambda$1(a aVar, a aVar2, a aVar3) {
        this.azx = aVar;
        this.cjE = aVar3;
        super(aVar2);
    }

    public boolean onBackPressed() {
        this.cjE.close();
        return true;
    }
}
