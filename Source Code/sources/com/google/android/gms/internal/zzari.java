package com.google.android.gms.internal;

import com.google.android.gms.common.internal.Hide;

@Hide
public abstract class zzari extends zzarh {
    private boolean zzdyq;

    protected zzari(zzark zzark) {
        super(zzark);
    }

    @Hide
    public final void initialize() {
        zzwk();
        this.zzdyq = true;
    }

    @Hide
    public final boolean isInitialized() {
        return this.zzdyq;
    }

    @Hide
    protected abstract void zzwk();

    @Hide
    protected final void zzyk() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
