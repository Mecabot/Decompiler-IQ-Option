package com.iqoption.withdrawal.common.fields;

import java.util.List;
import kotlin.i;

@i(aXC = {1, 1, 11}, aXD = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0007"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/ValidationUIMode;", "", "(Ljava/lang/String;I)V", "UPDATE_UI", "SKIP_UI_UPDATES", "HIDE_ERROR_IF_VALID", "Companion", "IqOption-5.5.1_optionXRelease"})
/* compiled from: WithdrawFieldsFragment.kt */
enum ValidationUIMode {
    UPDATE_UI,
    SKIP_UI_UPDATES,
    HIDE_ERROR_IF_VALID;
    
    public static final a Companion = null;
    private static final List<ValidationUIMode> HIDE_ERROR_MODES = null;

    @i(aXC = {1, 1, 11}, aXD = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, aXE = {"Lcom/iqoption/withdrawal/common/fields/ValidationUIMode$Companion;", "", "()V", "HIDE_ERROR_MODES", "", "Lcom/iqoption/withdrawal/common/fields/ValidationUIMode;", "getHIDE_ERROR_MODES", "()Ljava/util/List;", "IqOption-5.5.1_optionXRelease"})
    /* compiled from: WithdrawFieldsFragment.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final List<ValidationUIMode> aMZ() {
            return ValidationUIMode.HIDE_ERROR_MODES;
        }
    }

    static {
        Companion = new a();
        HIDE_ERROR_MODES = m.listOf(UPDATE_UI, HIDE_ERROR_IF_VALID);
    }
}
