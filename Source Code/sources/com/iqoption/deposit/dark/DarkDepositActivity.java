package com.iqoption.deposit.dark;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.iqoption.deposit.pro.b;
import java.util.ArrayList;
import kotlin.i;
import kotlin.jvm.internal.h;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0014J\b\u0010\u0005\u001a\u00020\u0004H\u0014¨\u0006\u0007"}, aXE = {"Lcom/iqoption/deposit/dark/DarkDepositActivity;", "Lcom/iqoption/deposit/pro/ProDepositActivity;", "()V", "isDarkDeposit", "", "isFullScreen", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: DarkDepositActivity.kt */
public final class DarkDepositActivity extends b {
    public static final a bXm = new a();

    @i(aXC = {1, 1, 11}, aXD = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JC\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0002\u0010\u000fJE\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, aXE = {"Lcom/iqoption/deposit/dark/DarkDepositActivity$Companion;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "defaultPreset", "Ljava/util/ArrayList;", "Lcom/iqoption/core/features/limit/CurrencyValue;", "Lkotlin/collections/ArrayList;", "returnToParent", "", "paymentMethodId", "", "(Landroid/content/Context;Ljava/util/ArrayList;ZLjava/lang/Long;)Landroid/content/Intent;", "start", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;Ljava/util/ArrayList;ZLjava/lang/Long;)V", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: DarkDepositActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* bridge */ /* synthetic */ void a(a aVar, Activity activity, ArrayList arrayList, boolean z, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            if ((i & 8) != 0) {
                l = (Long) null;
            }
            aVar.a(activity, arrayList, z, l);
        }

        public final void a(Activity activity, ArrayList<com.iqoption.core.c.c.a> arrayList, boolean z, Long l) {
            h.e(activity, "activity");
            activity.startActivity(a((Context) activity, (ArrayList) arrayList, z, l));
        }

        private final Intent a(Context context, ArrayList<com.iqoption.core.c.c.a> arrayList, boolean z, Long l) {
            Intent intent = new Intent(context, DarkDepositActivity.class);
            intent.putExtra("ARG_RETURN_TO_PARENT", z);
            if (l != null) {
                intent.putExtra("ARG_PAYMENT_METHOD_ID", l.longValue());
            }
            intent.putParcelableArrayListExtra("ARG_DEFAULT_PRESET", arrayList);
            return intent;
        }
    }

    protected boolean aci() {
        return true;
    }

    protected boolean isFullScreen() {
        return false;
    }
}
