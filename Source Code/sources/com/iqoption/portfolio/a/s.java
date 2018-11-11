package com.iqoption.portfolio.a;

import android.widget.TextView;
import com.iqoption.portfolio.component.o;
import com.iqoption.portfolio.f;
import com.iqoption.x.R;

/* compiled from: PortfolioAppBarHelper */
final class s implements an {
    private final u dcH;
    private final TextView dcI;
    private final TextView dcJ;
    private final TextView dcK;

    /* compiled from: PortfolioAppBarHelper */
    static final class a {
        private final u dcH;
        private TextView dcI;
        private TextView dcJ;
        private TextView dcK;

        a(u uVar) {
            this.dcH = uVar;
        }

        a l(TextView textView) {
            this.dcI = textView;
            return this;
        }

        a m(TextView textView) {
            this.dcJ = textView;
            return this;
        }

        a n(TextView textView) {
            this.dcK = textView;
            return this;
        }

        s axY() {
            return new s(this);
        }
    }

    void ei(boolean z) {
    }

    private s(a aVar) {
        this.dcH = aVar.dcH;
        this.dcI = aVar.dcI;
        this.dcJ = aVar.dcJ;
        this.dcK = aVar.dcK;
    }

    public o axx() {
        return this.dcH.axx();
    }

    void b(f fVar) {
        switch (fVar.avX()) {
            case 0:
                this.dcI.setText(R.string.all_assets);
                return;
            case 1:
                this.dcI.setText(R.string.expiration);
                return;
            case 2:
                this.dcI.setText(R.string.no_expiration);
                return;
            case 3:
                this.dcI.setText(R.string.binary);
                return;
            case 4:
                this.dcI.setText(R.string.cfd);
                return;
            case 5:
                this.dcI.setText(R.string.forex);
                return;
            case 6:
                this.dcI.setText(R.string.crypto);
                return;
            case 7:
                this.dcI.setText(R.string.digital);
                return;
            case 8:
                this.dcI.setText(R.string.fx);
                return;
            default:
                this.dcI.setText(null);
                return;
        }
    }

    void c(f fVar) {
        this.dcH.axB().a(this.dcJ, this.dcK, fVar.awc());
    }
}
