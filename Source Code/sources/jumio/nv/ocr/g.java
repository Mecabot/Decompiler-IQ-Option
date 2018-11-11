package jumio.nv.ocr;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.nv.NVOverlay;
import com.jumio.nv.NVOverlay.NVOverlayConfig;
import com.jumio.nv.gui.PieProgressView;
import com.jumio.nv.ocr.R;
import com.jumio.nv.ocr.overlay.TemplateMatcherFrameIndicator;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TemplateMatcherOverlay */
public class g extends NVOverlay {
    private final AtomicBoolean a = new AtomicBoolean(false);
    private PieProgressView b;
    private TemplateMatcherFrameIndicator c;
    private Rect d;
    private boolean e;
    private int f;
    private int g;

    public g(Context context) {
        super(context);
        TypedValue typedValue = new TypedValue();
        Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.netverify_scanOverlayTemplateValid, typedValue, true);
        this.f = typedValue.data;
        theme.resolveAttribute(R.attr.netverify_scanOverlayTemplateInvalid, typedValue, true);
        this.g = typedValue.data;
        this.b = new PieProgressView(context);
        this.c = new TemplateMatcherFrameIndicator(context);
    }

    public void update(ExtractionUpdate extractionUpdate) {
        if (extractionUpdate.getState() == d.a) {
            a aVar = (a) extractionUpdate.getData();
            if (extractionUpdate instanceof c) {
                a(aVar, ((c) extractionUpdate).a(), false);
            }
        } else if (extractionUpdate.getState() == d.b) {
            this.b.setVisibility(4);
            this.b.setProgress(0);
            this.c.setVisibility(4);
        } else if (extractionUpdate.getState() == d.c) {
            a((a) extractionUpdate.getData(), 100.0f, true);
            if (this.c != null) {
                this.c.a(null, null, null, null, null);
            }
            if (this.b != null) {
                this.b.setVisibility(8);
            }
        }
    }

    public NVOverlayConfig getNetverifyOverlayConfiguration(Context context) {
        NVOverlayConfig nVOverlayConfig = new NVOverlayConfig();
        nVOverlayConfig.drawBrackets = false;
        nVOverlayConfig.dimBackground = false;
        return nVOverlayConfig;
    }

    public void addViews(@NonNull ViewGroup viewGroup) {
        if (this.a.compareAndSet(false, true)) {
            int dipToPx = (int) ScreenUtil.dipToPx(this.mContext, 80.0f);
            this.b.setLayoutParams(new LayoutParams(dipToPx, dipToPx));
            this.b.setBorderWidth(2);
            this.b.setVisibility(8);
            viewGroup.addView(this.b);
            this.c.setLayoutParams(new LayoutParams(-1, -1));
            viewGroup.addView(this.c);
        }
    }

    public void setVisible(int i) {
        super.setVisible(i);
        if (i != 0) {
            this.b.setVisibility(i);
            this.c.setVisibility(i);
        }
    }

    public void prepareDraw(ScanSide scanSide, boolean z, boolean z2) {
        super.prepareDraw(scanSide, z, z2);
        this.e = z;
    }

    public void calculate(@NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat, Rect rect) {
        super.calculate(documentScanMode, documentFormat, rect);
        int i = (int) ((((float) this.w) - (((float) this.w) * 0.9f)) / 2.0f);
        int i2 = (int) ((((float) this.h) - (((float) this.h) * 0.95f)) / 2.0f);
        this.d = new Rect(i, i2, this.w - i, this.h - (i2 * 3));
    }

    public Rect getOverlayBounds() {
        return this.d;
    }

    private void a(a aVar, float f, boolean z) {
        if (this.mVisibility.get() == 0 && aVar.a()) {
            if (f > 100.0f || z) {
                f = 100.0f;
            }
            PointF s = aVar.s();
            PointF t = aVar.t();
            PointF u = aVar.u();
            PointF v = aVar.v();
            PointF r = aVar.r();
            if (this.e) {
                float z2;
                if (aVar.j()) {
                    z2 = aVar.z() / 2.0f;
                    s.y = (z2 - s.y) + z2;
                    t.y = (z2 - t.y) + z2;
                    u.y = (z2 - u.y) + z2;
                    v.y = (z2 - v.y) + z2;
                    r.y = z2 + (z2 - r.y);
                } else {
                    z2 = aVar.y() / 2.0f;
                    s.x = (z2 - s.x) + z2;
                    t.x = (z2 - t.x) + z2;
                    u.x = (z2 - u.x) + z2;
                    v.x = (z2 - v.x) + z2;
                    r.x = z2 + (z2 - r.x);
                }
            }
            int i = 0;
            Object obj = (aVar.d() || !aVar.c()) ? 1 : null;
            if (this.c != null) {
                this.c.setVisibility(0);
                this.c.a(s, t, u, v, r);
                this.c.setBorderColor(obj != null ? this.g : this.f);
            }
            if (z) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("setPoly: ");
                stringBuilder.append(s);
                stringBuilder.append("/");
                stringBuilder.append(t);
                stringBuilder.append("/");
                stringBuilder.append(u);
                stringBuilder.append("/");
                stringBuilder.append(v);
                Log.i("TemplateMatcher", stringBuilder.toString());
            }
            if (this.b != null) {
                PieProgressView pieProgressView = this.b;
                if (obj != null && f == 0.0f) {
                    i = 8;
                }
                pieProgressView.setVisibility(i);
                this.b.setPieColor(obj != null ? this.g : this.f);
                this.b.setBorderColor(obj != null ? this.g : this.f);
                this.b.setProgress((int) f);
                this.b.updatePosition(r);
                this.b.invalidate();
            }
        }
    }
}
