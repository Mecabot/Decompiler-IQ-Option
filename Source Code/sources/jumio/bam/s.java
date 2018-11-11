package jumio.bam;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.util.TypedValue;
import android.view.ViewGroup;
import com.jumio.bam.R;
import com.jumio.bam.environment.BamEnvironment;
import com.jumio.commons.utils.DrawingUtil;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.data.Strings;
import com.jumio.core.data.document.DocumentFormat;
import com.jumio.core.data.document.DocumentScanMode;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.overlay.Overlay;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;

/* compiled from: OcrOverlay */
public class s implements Overlay {
    protected int a = 0;
    protected int b = 0;
    protected Paint c;
    protected Paint d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Path i;
    private Path j;
    private a k = null;
    private a l = null;
    private a m = null;
    private a n = null;
    private a o = null;
    private int p = 0;
    private Context q;

    /* compiled from: OcrOverlay */
    class a {
        private Paint b;
        private String[] c;
        private float d;
        private float e;

        public a() {
            this.b = null;
            this.c = null;
            this.d = 0.0f;
            this.e = 0.0f;
            this.b = new Paint();
            this.b.setAntiAlias(true);
        }

        public void a(int i) {
            this.b.setColor(i);
        }

        public void b(int i) {
            this.b.setAlpha(i);
        }

        public void c(int i) {
            this.b.setShadowLayer(1.0f, 1.0f, 1.0f, i);
        }

        public void a(Style style) {
            this.b.setStyle(style);
        }

        public void a(float f) {
            this.b.setTextSize(f);
        }

        public float a() {
            return this.b.getTextSize();
        }

        public void a(Typeface typeface) {
            this.b.setTypeface(typeface);
        }

        public void a(String str) {
            if (str != null) {
                this.c = str.split("\n");
            }
        }

        public float b() {
            float f = 0.0f;
            if (!(this.c == null || this.c.length == 0)) {
                for (String measureText : this.c) {
                    float measureText2 = this.b.measureText(measureText);
                    if (measureText2 > f) {
                        f = measureText2;
                    }
                }
            }
            return f;
        }

        public void a(float f, float f2) {
            this.d = f;
            this.e = f2;
        }

        public void a(Canvas canvas) {
            if (this.c != null) {
                int a = (int) a();
                int length = ((this.c.length - 1) * a) / 2;
                for (int i = 0; i < this.c.length; i++) {
                    canvas.drawText(this.c[i], this.d, (this.e - ((float) length)) + ((float) (i * a)), this.b);
                }
            }
        }
    }

    public void addViews(@NonNull ViewGroup viewGroup) {
    }

    public s(Context context) {
        this.q = context;
    }

    public void calculate(@NonNull DocumentScanMode documentScanMode, @NonNull DocumentFormat documentFormat, Rect rect) {
        int i;
        int i2;
        int round;
        int i3;
        this.a = rect.width();
        this.b = rect.height();
        if ((((float) this.a) / ((float) this.b) >= 1.3333334f ? 1 : null) != null) {
            i = (int) (((double) this.b) * 0.138d);
            i2 = ((int) (((double) this.b) * 0.138d)) + 0;
            round = Math.round((((float) this.a) - (((float) ((this.b - i) - i2)) * 1.586f)) / 2.0f);
            i3 = i;
            i = round;
        } else {
            i = (int) (((double) this.a) * 0.0675d);
            i2 = (int) (((double) this.a) * 0.0675d);
            float f = ((float) ((this.a - i) - i2)) / 1.586f;
            float f2 = (float) null;
            i3 = Math.round(((((float) this.b) - f) - f2) / 2.0f);
            int i4 = i2;
            i2 = Math.round(((((float) this.b) - f) + f2) / 2.0f);
            round = i4;
        }
        this.e = i;
        this.f = this.a - round;
        this.g = i3;
        this.h = this.b - i2;
    }

    public void prepareDraw(ScanSide scanSide, boolean z, boolean z2) {
        TypedValue typedValue = new TypedValue();
        Theme theme = this.q.getTheme();
        theme.resolveAttribute(R.attr.bam_scanOverlay, typedValue, true);
        this.c = new Paint();
        this.c.setColor(typedValue.data);
        this.c.setStyle(Style.STROKE);
        this.c.setDither(true);
        this.c.setStrokeJoin(Join.ROUND);
        this.c.setStrokeCap(Cap.ROUND);
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth((float) ScreenUtil.dpToPx(this.q, 2));
        theme.resolveAttribute(R.attr.bam_scanBackground, typedValue, true);
        int i = (typedValue.data & ViewCompat.MEASURED_SIZE_MASK) + ViewCompat.MEASURED_STATE_MASK;
        this.d = new Paint();
        this.d.setColor(typedValue.data);
        this.d.setStyle(Style.FILL);
        this.d.setDither(true);
        this.d.setStrokeJoin(Join.ROUND);
        this.d.setStrokeCap(Cap.ROUND);
        this.d.setAntiAlias(true);
        int dpToPx = ScreenUtil.dpToPx(this.q, 15);
        this.i = DrawingUtil.createRectWithRoundedCornersAsPath(getOverlayBounds(), dpToPx, dpToPx, dpToPx, dpToPx);
        this.j = new Path();
        this.j.setFillType(FillType.EVEN_ODD);
        this.j.addRect(0.0f, 0.0f, (float) this.a, (float) this.b, Direction.CW);
        this.j.addPath(this.i);
        this.k = new a();
        this.k.a(this.c.getColor());
        this.k.b(178);
        this.k.a(Style.FILL);
        this.k.a((float) ScreenUtil.dpToPx(this.q, 17));
        this.k.a(Strings.getExternalString(this.q, "scan_area_present_your_card_number"));
        dpToPx = (int) this.k.b();
        this.l = new a();
        this.l.a(this.c.getColor());
        this.l.c(i);
        this.l.b(178);
        this.l.a(Style.FILL);
        this.l.a((float) ScreenUtil.dpToPx(this.q, 14));
        this.l.a(BamEnvironment.loadOcraFontTypeface(this.q));
        this.l.a(Strings.getExternalString(this.q, "scan_area_card_holder"));
        this.n = new a();
        this.n.a(this.c.getColor());
        this.n.c(i);
        this.n.b(178);
        this.n.a(Style.FILL);
        this.n.a((float) ScreenUtil.dpToPx(this.q, 8));
        this.n.a(Strings.getExternalString(this.q, "scan_area_valid_thru"));
        int b = (int) this.n.b();
        this.o = new a();
        this.o.a(this.c.getColor());
        this.o.c(i);
        this.o.b(178);
        this.o.a(Style.FILL);
        this.o.a((float) ScreenUtil.dpToPx(this.q, 14));
        this.o.a(BamEnvironment.loadOcraFontTypeface(this.q));
        this.o.a(Strings.getExternalString(this.q, "scan_area_expiry_date"));
        this.m = new a();
        this.m.a(this.c.getColor());
        this.m.c(i);
        this.m.b(178);
        this.m.a(Style.FILL);
        this.m.a((float) ScreenUtil.dpToPx(this.q, 19));
        this.m.a(BamEnvironment.loadOcraFontTypeface(this.q));
        this.m.a(Strings.getExternalString(this.q, "scan_area_creditcard_number"));
        i = ScreenUtil.dpToPx(this.q, 35);
        int dpToPx2 = ScreenUtil.dpToPx(this.q, 74);
        int dpToPx3 = ScreenUtil.dpToPx(this.q, 20);
        int dpToPx4 = ScreenUtil.dpToPx(this.q, 122);
        int dpToPx5 = ScreenUtil.dpToPx(this.q, 8);
        int dpToPx6 = ScreenUtil.dpToPx(this.q, 53);
        int dpToPx7 = ScreenUtil.dpToPx(this.q, 51);
        int dpToPx8 = ScreenUtil.dpToPx(this.q, 20);
        int dpToPx9 = ScreenUtil.dpToPx(this.q, 26);
        this.k.a((float) (((double) (this.a - dpToPx)) * 0.5d), (float) (this.g + i));
        this.m.a((float) (this.e + dpToPx3), (float) (this.h - dpToPx2));
        dpToPx = (this.e + dpToPx3) + dpToPx4;
        this.n.a((float) dpToPx, (float) (this.h - dpToPx6));
        this.o.a((float) ((dpToPx + b) + dpToPx5), (float) (this.h - dpToPx7));
        this.l.a((float) (this.e + dpToPx8), (float) (this.h - dpToPx9));
    }

    public void doDraw(Canvas canvas) {
        if (this.p == 0) {
            if (this.i != null) {
                canvas.drawPath(this.i, this.c);
            }
            if (this.j != null) {
                canvas.drawPath(this.j, this.d);
            }
            this.k.a(canvas);
            this.l.a(canvas);
            this.o.a(canvas);
            this.n.a(canvas);
            this.m.a(canvas);
        }
    }

    public void update(ExtractionUpdate extractionUpdate) {
        if (extractionUpdate.getState() == l.c) {
            int i = ((Boolean) extractionUpdate.getData()).booleanValue() ? 178 : 0;
            this.k.b(i);
            this.l.b(i);
            this.m.b(i);
            this.n.b(i);
            this.o.b(i);
        }
    }

    public void setVisible(int i) {
        this.p = i;
    }

    public Rect getOverlayBounds() {
        return new Rect(this.e, this.g, this.f, this.h);
    }
}
