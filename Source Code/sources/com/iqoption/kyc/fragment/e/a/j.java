package com.iqoption.kyc.fragment.e.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.iqoption.microservice.a.a.a.a;

final /* synthetic */ class j implements OnClickListener {
    private final h cNo;
    private final a cNp;

    j(h hVar, a aVar) {
        this.cNo = hVar;
        this.cNp = aVar;
    }

    public void onClick(View view) {
        this.cNo.b(this.cNp, view);
    }
}
