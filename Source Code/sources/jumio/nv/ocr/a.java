package jumio.nv.ocr;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.jumio.clientlib.impl.templatematcher.TemplateInfo;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.math.MathUtils;
import com.jumio.commons.math.TrigonometryUtils;
import com.jumio.commons.math.Vector2D;
import java.util.ArrayList;
import java.util.List;

/* compiled from: TemplateInfoWrapper */
public class a implements Parcelable {
    public static final Creator<a> CREATOR = new Creator<a>() {
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        /* renamed from: a */
        public a[] newArray(int i) {
            return new a[i];
        }
    };
    public static double a = 0.6d;
    public static double b = 0.75d;
    private float A;
    private float B;
    private int C;
    private int D;
    private PreviewProperties E;
    private boolean F;
    private int G;
    private float H;
    private float I;
    private float J;
    private float K;
    private ScreenAngle L;
    private boolean M;
    private boolean N;
    private final float c;
    private final float d;
    private final float e;
    private final float f;
    private final float g;
    private final float h;
    private final float i;
    private final float j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final int o;
    private final int p;
    private final double q;
    private long r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    public int describeContents() {
        return 0;
    }

    /* synthetic */ a(Parcel parcel, AnonymousClass1 anonymousClass1) {
        this(parcel);
    }

    public a(TemplateInfo templateInfo) {
        PointF pointF = new PointF(templateInfo.getPolygon().getTLx(), templateInfo.getPolygon().getTLy());
        PointF pointF2 = new PointF(templateInfo.getPolygon().getTRx(), templateInfo.getPolygon().getTRy());
        PointF pointF3 = new PointF(templateInfo.getPolygon().getBRx(), templateInfo.getPolygon().getBRy());
        PointF pointF4 = new PointF(templateInfo.getPolygon().getBLx(), templateInfo.getPolygon().getBLy());
        PointF[] inflatePolygon = MathUtils.inflatePolygon(pointF, pointF2, pointF3, pointF4, (int) Math.ceil((double) (Math.max(Math.max((float) new Vector2D(pointF2.x, pointF2.y, pointF.x, pointF.y).length(), (float) new Vector2D(pointF3.x, pointF3.y, pointF4.x, pointF4.y).length()), Math.max((float) new Vector2D(pointF2.x, pointF2.y, pointF3.x, pointF3.y).length(), (float) new Vector2D(pointF.x, pointF.y, pointF4.x, pointF4.y).length())) * 0.0f)));
        this.e = inflatePolygon[0].x;
        this.f = inflatePolygon[0].y;
        this.c = inflatePolygon[1].x;
        this.d = inflatePolygon[1].y;
        this.g = inflatePolygon[2].x;
        this.h = inflatePolygon[2].y;
        this.i = inflatePolygon[3].x;
        this.j = inflatePolygon[3].y;
        this.k = templateInfo.getCountry();
        this.l = templateInfo.getState();
        this.m = templateInfo.getDocumentType();
        this.n = templateInfo.getRegion();
        this.o = templateInfo.getFrameIndex();
        this.p = templateInfo.getMatchesCount();
        this.q = templateInfo.getTransformError();
        this.C = templateInfo.getTemplateWidth();
        this.D = templateInfo.getTemplateHeight();
    }

    private a(Parcel parcel) {
        this.k = parcel.readString();
        this.m = parcel.readString();
        this.n = parcel.readString();
        this.l = parcel.readString();
        this.o = parcel.readInt();
        this.p = parcel.readInt();
        float[] fArr = new float[8];
        parcel.readFloatArray(fArr);
        boolean z = false;
        this.e = fArr[0];
        this.f = fArr[1];
        this.c = fArr[2];
        this.d = fArr[3];
        this.i = fArr[4];
        this.j = fArr[5];
        this.g = fArr[6];
        this.h = fArr[7];
        this.q = (double) parcel.readFloat();
        this.A = parcel.readFloat();
        this.B = parcel.readFloat();
        this.J = parcel.readFloat();
        this.K = parcel.readFloat();
        this.H = parcel.readFloat();
        this.I = parcel.readFloat();
        this.L = ScreenAngle.values()[parcel.readInt()];
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = (PreviewProperties) parcel.readSerializable();
        this.M = parcel.readByte() == (byte) 1;
        this.N = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        }
        this.F = z;
        this.G = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(g());
        parcel.writeString(f());
        parcel.writeString(i());
        parcel.writeString(h());
        parcel.writeInt(k());
        parcel.writeInt(l());
        parcel.writeFloatArray(e());
        parcel.writeDouble(m());
        parcel.writeFloat(n());
        parcel.writeFloat(o());
        parcel.writeFloat(this.J);
        parcel.writeFloat(this.K);
        parcel.writeFloat(this.H);
        parcel.writeFloat(this.I);
        parcel.writeInt(this.L.getValue());
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeSerializable(this.E);
        parcel.writeByte((byte) this.M);
        parcel.writeByte((byte) this.N);
        parcel.writeByte((byte) this.F);
        parcel.writeInt(this.G);
    }

    public boolean a() {
        List b = b();
        int size = b.size();
        int i = 0;
        boolean z = false;
        while (true) {
            boolean z2 = true;
            if (i >= size) {
                return true;
            }
            int i2 = (i + 2) % size;
            int i3 = i + 1;
            int i4 = i3 % size;
            double d = (((double) (((PointF) b.get(i2)).x - ((PointF) b.get(i4)).x)) * ((double) (((PointF) b.get(i)).y - ((PointF) b.get(i4)).y))) - (((double) (((PointF) b.get(i2)).y - ((PointF) b.get(i4)).y)) * ((double) (((PointF) b.get(i)).x - ((PointF) b.get(i4)).x)));
            if (i == 0) {
                if (d <= 0.0d) {
                    z2 = false;
                }
                z = z2;
            } else {
                if (d <= 0.0d) {
                    z2 = false;
                }
                if (z != z2) {
                    return false;
                }
            }
            i = i3;
        }
    }

    public List<PointF> b() {
        List<PointF> arrayList = new ArrayList();
        arrayList.add(s());
        arrayList.add(t());
        arrayList.add(v());
        arrayList.add(u());
        return arrayList;
    }

    public boolean c() {
        int i = (this.E.getScaleFactor() > 1.0f ? 1 : (this.E.getScaleFactor() == 1.0f ? 0 : -1));
        float f = (float) this.E.surface.width;
        float f2 = (float) this.E.surface.height;
        n();
        return this.u >= 0.0f && this.u <= f && this.y >= 0.0f && this.y <= f && this.s >= 0.0f && this.s <= f && this.w >= 0.0f && this.w <= f && this.v >= 0.0f && this.v <= f2 && this.z >= 0.0f && this.z <= f2 && this.t >= 0.0f && this.t <= f2 && this.x >= 0.0f && this.x <= f2;
    }

    public boolean d() {
        float n = n() / o();
        float w = ((float) w()) / ((float) x());
        boolean z = false;
        Object obj = ((n <= 1.0f || w <= 1.0f) && (n >= 1.0f || w >= 1.0f)) ? null : 1;
        w = (float) this.E.surface.width;
        float f = (float) this.E.surface.height;
        if (obj == null || this.M) {
            if (((double) Math.max((int) Math.round(TrigonometryUtils.getDistanceBetweenTwoPoints(new Point(Math.round(this.s), Math.round(this.t)), new Point(Math.round(this.u), Math.round(this.v)))), (int) Math.round(TrigonometryUtils.getDistanceBetweenTwoPoints(new Point(Math.round(this.y), Math.round(this.z)), new Point(Math.round(this.w), Math.round(this.x)))))) < ((double) w) * b) {
                z = true;
            }
            return z;
        }
        if (((double) p().height()) < ((double) f) * a) {
            z = true;
        }
        return z;
    }

    public float[] e() {
        return new float[]{this.e, this.f, this.c, this.d, this.g, this.h, this.i, this.j};
    }

    public void a(long j) {
        this.r = j;
    }

    public String f() {
        return this.m;
    }

    public String g() {
        return this.k;
    }

    public String h() {
        return this.l;
    }

    public String i() {
        return this.n;
    }

    public boolean j() {
        return this.N;
    }

    public int k() {
        return this.o;
    }

    public int l() {
        return this.p;
    }

    public double m() {
        return this.q;
    }

    public float n() {
        return this.A;
    }

    public void a(float f) {
        this.A = f;
    }

    public float o() {
        return this.B;
    }

    public void b(float f) {
        this.B = f;
    }

    public Rect p() {
        Rect rect = new Rect();
        rect.top = (int) MathUtils.min(this.v, this.t, this.z, this.x);
        rect.left = (int) MathUtils.min(this.u, this.s, this.y, this.w);
        rect.bottom = (int) MathUtils.max(this.v, this.t, this.z, this.x);
        rect.right = (int) MathUtils.max(this.u, this.s, this.w, this.y);
        return rect;
    }

    public Rect q() {
        Rect rect = new Rect();
        rect.top = (int) MathUtils.min(this.f, this.d, this.j, this.h);
        rect.left = (int) MathUtils.min(this.e, this.c, this.i, this.g);
        rect.bottom = (int) MathUtils.max(this.f, this.d, this.j, this.h);
        rect.right = (int) MathUtils.max(this.e, this.c, this.g, this.i);
        return rect;
    }

    public PointF r() {
        PointF pointF = new PointF();
        Vector2D vector2D = new Vector2D((double) this.u, (double) this.v);
        vector2D = vector2D.add(new Vector2D((double) this.w, (double) this.x).subtract(vector2D).scale(0.5d));
        pointF.x = (float) vector2D.getX();
        pointF.y = (float) vector2D.getY();
        return pointF;
    }

    private PointF a(PointF pointF, PreviewProperties previewProperties) {
        float f;
        float f2;
        int i = previewProperties.orientation;
        Object obj = 1;
        Object obj2 = (i == 180 || i == 270) ? 1 : null;
        if (!(i == 90 || i == 270)) {
            obj = null;
        }
        float f3 = this.H;
        float f4 = this.I;
        float f5 = this.J;
        float f6 = this.K;
        if (obj != null) {
            if (obj2 != null) {
                f = (pointF.y * f3) - f5;
                f2 = ((float) previewProperties.surface.height) - ((pointF.x * f4) - f6);
            } else {
                f = ((float) previewProperties.surface.width) - ((pointF.y * f3) - f5);
                f2 = (pointF.x * f4) - f6;
            }
        } else if (obj2 != null) {
            f = ((float) previewProperties.surface.width) - ((pointF.x * f3) - f5);
            f2 = ((float) previewProperties.surface.height) - ((pointF.y * f4) - f6);
        } else {
            f = (pointF.x * f3) - f5;
            f2 = (pointF.y * f4) - f6;
        }
        pointF.x = f;
        pointF.y = f2;
        return pointF;
    }

    public void a(PreviewProperties previewProperties, boolean z, boolean z2, boolean z3) {
        this.E = previewProperties;
        this.M = z;
        this.N = z2;
        b((float) previewProperties.preview.height);
        a((float) previewProperties.preview.width);
        this.H = ((float) previewProperties.scaledPreview.width) / ((float) previewProperties.preview.width);
        this.I = ((float) previewProperties.scaledPreview.height) / ((float) previewProperties.preview.height);
        this.J = ((float) (previewProperties.scaledPreview.width - previewProperties.surface.width)) / 2.0f;
        this.K = ((float) (previewProperties.scaledPreview.height - previewProperties.surface.height)) / 2.0f;
        PointF a = a(new PointF(this.c, this.d), previewProperties);
        this.s = a.x;
        this.t = a.y;
        a = a(new PointF(this.e, this.f), previewProperties);
        this.u = a.x;
        this.v = a.y;
        a = a(new PointF(this.g, this.h), previewProperties);
        this.w = a.x;
        this.x = a.y;
        PointF a2 = a(new PointF(this.i, this.j), previewProperties);
        this.y = a2.x;
        this.z = a2.y;
    }

    public PointF s() {
        return new PointF(this.u, this.v);
    }

    public PointF t() {
        return new PointF(this.s, this.t);
    }

    public PointF u() {
        return new PointF(this.y, this.z);
    }

    public PointF v() {
        return new PointF(this.w, this.x);
    }

    public int w() {
        return this.C;
    }

    public int x() {
        return this.D;
    }

    public float y() {
        return (float) this.E.surface.width;
    }

    public float z() {
        return (float) this.E.surface.height;
    }

    public void a(boolean z) {
        this.F = z;
    }

    public void a(int i) {
        this.G = i;
    }
}
