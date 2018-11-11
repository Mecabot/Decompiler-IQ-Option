package com.iqoption.kyc.activity;

import android.support.v4.app.Fragment;
import com.iqoption.dto.entity.result.ProofDocsResult;

final /* synthetic */ class q implements Runnable {
    private final Fragment cKd;
    private final ProofDocsResult cKe;

    q(Fragment fragment, ProofDocsResult proofDocsResult) {
        this.cKd = fragment;
        this.cKe = proofDocsResult;
    }

    public void run() {
        f.a(this.cKd, this.cKe);
    }
}
