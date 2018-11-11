package jumio.nv.ocr;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import com.jumio.clientlib.impl.imagequality.ImageQualityAcquisition;
import com.jumio.clientlib.impl.imagequality.PixelFormatType;
import com.jumio.clientlib.impl.templatematcher.FrameProcessingSettingsTemplateMatcher;
import com.jumio.clientlib.impl.templatematcher.FrameProcessorTemplateMatcher;
import com.jumio.clientlib.impl.templatematcher.HierarchicalClusteringSettings;
import com.jumio.clientlib.impl.templatematcher.LibImage;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.FileUtil;
import com.jumio.core.ImageQuality;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.nv.benchmark.Benchmark;
import com.jumio.nv.benchmark.BenchmarkAlgorithm.DeviceCategory;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.enums.NVErrorCase;
import com.jumio.nv.models.DocumentDataModel;
import com.jumio.nv.models.SelectionModel;
import com.jumio.nv.models.TemplateModel;
import com.jumio.nv.ocr.environment.NVOcrEnvironment;
import com.jumio.persistence.DataAccess;
import com.jumio.sdk.exception.JumioException;
import com.jumio.sdk.extraction.ExtractionClient;
import com.jumio.sdk.extraction.ExtractionClient.ExtractionUpdate;
import com.jumio.sdk.extraction.ExtractionUpdateState;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TemplateMatcherClient */
public class b extends ExtractionClient<ExtractionUpdate, DocumentDataModel> {
    private final Handler a;
    private final Object b = new Object();
    private final Object c = new Object();
    private final AtomicBoolean d = new AtomicBoolean(false);
    private final Object e = new Object();
    private final int f;
    private int g = 10;
    private c h;
    private ExecutorService i;
    private boolean j = true;
    private FrameProcessorTemplateMatcher k = null;
    private e l = null;
    private int m;
    private int n;
    private boolean o = false;
    private byte[] p = null;
    private byte[] q = null;

    /* compiled from: TemplateMatcherClient */
    class a implements Runnable {
        private a() {
        }

        public void run() {
            synchronized (b.this.b) {
                HierarchicalClusteringSettings hierarchicalClusteringSettings = new HierarchicalClusteringSettings();
                DeviceCategory deviceCategory = new Benchmark(b.this.mContext).getDeviceCategory();
                if (deviceCategory == DeviceCategory.FAST) {
                    b.this.g = 15;
                } else if (deviceCategory == DeviceCategory.MEDIUM) {
                    b.this.g = 10;
                } else {
                    b.this.g = 7;
                }
                b.this.g = 15;
                FrameProcessingSettingsTemplateMatcher frameProcessingSettingsTemplateMatcher = new FrameProcessingSettingsTemplateMatcher(500, true, hierarchicalClusteringSettings, b.this.g, b.this.g);
                b.this.l = new e(b.this.a);
                b.this.k = new FrameProcessorTemplateMatcher(frameProcessingSettingsTemplateMatcher, b.this.l);
                b bVar;
                try {
                    SelectionModel selectionModel = (SelectionModel) DataAccess.load(b.this.mContext, SelectionModel.class);
                    if (selectionModel == null) {
                        b.this.b(new JumioException(NVErrorCase.OCR_LOADING_FAILED));
                        b.this.destroy();
                        b.this.o = true;
                        b.this.d.set(false);
                        System.gc();
                        synchronized (b.this) {
                            b.this.j = false;
                        }
                        b.this.setDataExtractionActive(true);
                        return;
                    }
                    Country selectedCountry = selectionModel.getSelectedCountry();
                    for (String str : new TemplateModel(b.this.mContext).getTemplate(selectedCountry, selectionModel.getSelectedDoctype().getId(), selectionModel.getSelectedDoctype().getDocumentScanSide())) {
                        if (b.this.k.addTemplatesFromBinaryFile(str)) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("pushed template ");
                            stringBuilder.append(selectedCountry);
                            stringBuilder.append(" to template matcher");
                            Log.d("TemplateMatcherClient", stringBuilder.toString());
                        } else {
                            b.this.b(new JumioException(NVErrorCase.OCR_LOADING_FAILED));
                            FileUtil.deleteFile(str);
                            b.this.i.shutdownNow();
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Could not push file ");
                            stringBuilder2.append(str);
                            stringBuilder2.append(" to template matcher");
                            Log.w("TemplateMatcher", stringBuilder2.toString());
                        }
                    }
                    b.this.o = true;
                    b.this.d.set(false);
                    System.gc();
                    synchronized (b.this) {
                        b.this.j = false;
                    }
                    bVar = b.this;
                    bVar.setDataExtractionActive(true);
                } catch (Exception e) {
                    try {
                        Log.w("TemplateMatcherClient", e.getMessage());
                        b.this.o = true;
                        b.this.d.set(false);
                        System.gc();
                        synchronized (b.this) {
                            b.this.j = false;
                            bVar = b.this;
                        }
                    } catch (Throwable th) {
                        b.this.o = true;
                        b.this.d.set(false);
                        System.gc();
                        synchronized (b.this) {
                            b.this.j = false;
                            b.this.setDataExtractionActive(true);
                        }
                    }
                }
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    /* compiled from: TemplateMatcherClient */
    class b extends Handler {
        private b() {
        }

        public void handleMessage(Message message) {
            a aVar = (a) message.getData().getParcelable("templateInfo");
            byte[] byteArray = message.getData().getByteArray("finalResultFrame");
            if (aVar != null) {
                aVar.a(b.this.getPreviewProperties(), b.this.mIsTablet, b.this.mIsPortrait, b.this.mIsInverted);
                aVar.a(b.this.g);
                aVar.a(true);
            }
            switch (message.what) {
                case 101:
                    a();
                    synchronized (b.this) {
                        b.this.j = false;
                    }
                    return;
                case 102:
                    a(byteArray, aVar);
                    synchronized (b.this) {
                        b.this.j = false;
                    }
                    return;
                case 103:
                    b(byteArray, aVar);
                    return;
                default:
                    return;
            }
        }

        private void a(byte[] bArr, a aVar) {
            synchronized (b.this.b) {
                Object obj = (aVar.d() || !aVar.c()) ? 1 : null;
                if (obj != null) {
                    a(aVar.k());
                } else {
                    b.this.n = b.this.n + 1;
                }
                b.this.f(new c(d.a, aVar, (float) Math.round((((float) b.this.n) / ((float) (b.this.g - 1))) * 100.0f)));
                if (bArr != null && obj == null) {
                    try {
                        System.gc();
                        Size size = new Size(-1, -1);
                        bArr = a(bArr, aVar, false, size);
                        float f = 0.0f;
                        if (bArr != null) {
                            f = ImageQuality.calculateFocus(bArr, size.width, size.height, true);
                        }
                        if (f < 0.12f) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("request refocus - focus too low (");
                            stringBuilder.append(f);
                            stringBuilder.append(")");
                            Log.d("TemplateMatcherClient", stringBuilder.toString());
                            b.this.f(new ExtractionUpdate(ExtractionUpdateState.notifyFocus, new Point((int) aVar.r().x, (int) aVar.r().y)));
                        }
                        System.gc();
                    } catch (Throwable e) {
                        Log.w("TemplateMatcher", "Intermediate result: focus check skipped - OOM!", e);
                        System.gc();
                    } catch (Throwable e2) {
                        Log.w("TemplateMatcher handle IntermediateResult exception ", e2);
                    }
                }
            }
        }

        private void a() {
            synchronized (b.this.b) {
                b.this.n = 0;
            }
            b.this.f(new c(d.b));
        }

        private void b(byte[] bArr, a aVar) {
            b.this.f(new c(d.c, aVar, 100.0f));
            synchronized (b.this.b) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Handler: final result, fIx = ");
                stringBuilder.append(aVar.k());
                Log.i("TemplateMatcherClient", stringBuilder.toString());
                b.this.n = 0;
            }
            synchronized (b.this) {
                b.this.h.interrupt();
            }
            if (!aVar.c() || aVar.d()) {
                Log.w("TemplateMatcherClient", "discard final result - out of bounds or object too small");
                synchronized (b.this) {
                    b.this.j = false;
                }
            } else {
                float w = ((float) aVar.w()) / ((float) aVar.x());
                int width = aVar.p().width();
                int i = (int) (((float) width) / w);
                byte[] a = f.a(bArr, b.this.isPortrait(), aVar);
                float a2 = a(a, width, i, true);
                if (a2 >= 0.12f) {
                    b.this.f(new ExtractionUpdate(ExtractionUpdateState.shotTaken, Float.valueOf(a2)));
                    Size size = new Size(-1, -1);
                    b.this.a(f.a(bArr, 1.1f, size, b.this.isPortrait(), aVar), size.width, size.height, a, width, i);
                    synchronized (b.this) {
                        b.this.j = true;
                    }
                } else {
                    Log.w("TemplateMatcherClient", "discard final result because focus < 0.12");
                    synchronized (b.this) {
                        b.this.j = false;
                    }
                }
            }
            b.this.k.reset();
            b.this.l.a();
        }

        public float a(byte[] bArr, int i, int i2, boolean z) {
            try {
                return ImageQualityAcquisition.Evaluate(bArr, ((long) i) * ((long) (z ? 3 : 1)), i, i2, z ? PixelFormatType.PIXEL_FORMAT_RGB_8 : PixelFormatType.PIXEL_FORMAT_YUV420_NV21);
            } catch (Throwable e) {
                Log.printStackTrace(e);
                return -1.0f;
            }
        }

        private void a(int i) {
            try {
                if (b.this.k != null) {
                    b.this.k.discardFrameByID(i);
                }
            } catch (Throwable e) {
                Log.printStackTrace(e);
            }
        }

        private byte[] a(byte[] bArr, a aVar, boolean z, Size size) {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            Size size2 = size;
            Rect q = aVar.q();
            int i7 = q.left;
            int i8 = q.top;
            int height = q.height();
            int width = q.width();
            if (z) {
                int i9;
                if (b.this.isPortrait()) {
                    i7 = (int) aVar.n();
                    height = (int) (((float) q.width()) * 1.1f);
                    width = q.left - ((int) (((float) q.width()) * 0.05f));
                    if (width < 0) {
                        width = height;
                        i = 0;
                    } else if (((float) (height + width)) > aVar.o()) {
                        i9 = width;
                        width = (int) (aVar.o() - ((float) width));
                        i = i9;
                    } else {
                        i = width;
                        width = height;
                    }
                    i2 = i;
                    i3 = i7;
                    i4 = i3;
                    i = width;
                    i5 = i;
                } else {
                    i7 = (int) aVar.o();
                    height = (int) (((float) q.width()) * 1.1f);
                    width = q.left - ((int) (((float) q.width()) * 0.05f));
                    if (width < 0) {
                        width = height;
                        i = 0;
                    } else if (((float) (height + width)) > aVar.n()) {
                        i9 = width;
                        width = (int) (aVar.n() - ((float) width));
                        i = i9;
                    } else {
                        i = width;
                        width = height;
                    }
                    i2 = i;
                    i = i7;
                    i3 = i;
                    i5 = width;
                    i4 = i5;
                }
                i6 = 0;
            } else {
                int height2;
                if (b.this.isPortrait()) {
                    height2 = q.height();
                    i = q.width();
                } else {
                    height2 = q.width();
                    i = q.height();
                }
                i2 = i7;
                i6 = i8;
                i3 = height;
                i5 = width;
                i4 = height2;
            }
            if (size2 != null) {
                size2.width = i4;
                size2.height = i;
            }
            return CameraUtils.yuv2rgb(bArr, b.this.mIsPortrait, b.this.getPreviewProperties(), i5, i3, i2, i6, i4, i);
        }
    }

    /* compiled from: TemplateMatcherClient */
    class c extends Thread {
        public c(byte[] bArr) {
            setName("TM Task");
            try {
                b.this.p = new byte[bArr.length];
                if (b.this.p == null || b.this.p.length != bArr.length) {
                    throw new IllegalStateException("dataBuffer may not be null and must match data in size!");
                }
                System.arraycopy(bArr, 0, b.this.p, 0, bArr.length);
            } catch (Throwable e) {
                b.this.cancel();
                Log.e("TemplateMatcherClient", "TemplateMatcherTask#ctor()", e);
            }
        }

        public void run() {
            synchronized (b.this) {
                PreviewProperties previewProperties = b.this.getPreviewProperties();
                int i = previewProperties.camera.width;
                int i2 = previewProperties.camera.height;
                b.this.f(new ExtractionUpdate(ExtractionUpdateState.notifyFlash, Boolean.valueOf(ImageQuality.isFlashNeeded(b.this.p, i, i2, false))));
                try {
                    b.this.k.pushFrame(new LibImage(b.this.p, com.jumio.clientlib.impl.templatematcher.PixelFormatType.PIXEL_FORMAT_YUV420_NV21, i, i2, (long) i, 1, 1, b.this.m = b.this.m + 1, 0));
                } catch (Throwable e) {
                    Log.e("TemplateMatcherClient", "Error pushing Frame to TemplateMatcherEngine: ", e);
                }
            }
        }
    }

    public void configure(StaticModel staticModel) {
    }

    public b(Context context) {
        super(context);
        NVOcrEnvironment.loadTemplateMatcherLib();
        this.f = (int) System.currentTimeMillis();
        this.i = Executors.newSingleThreadExecutor();
        this.a = new b();
    }

    protected void init() {
        if (this.d.compareAndSet(false, true)) {
            Log.v("TemplateMatcherClient", "init: cancel()");
            cancel();
            Log.v("TemplateMatcherClient", "init: entering lifecyclelock()");
            synchronized (this.c) {
                Log.d("Lifecycle", "init: delete old vars");
                if (this.k != null) {
                    this.k.delete();
                }
                if (this.i == null) {
                    this.i = Executors.newFixedThreadPool(1);
                }
                synchronized (this) {
                    this.o = false;
                    Log.d("TemplateMatcherClient", "init: start loading task");
                    this.i.submit(new a());
                }
            }
            return;
        }
        Log.v("TemplateMatcherClient", "initialization not started due to a running initialization");
    }

    public void destroy() {
        cancel();
        this.d.set(false);
        this.o = false;
    }

    /* renamed from: a */
    public void feed(byte[] bArr) {
        synchronized (this) {
            if (a() && !this.j) {
                this.j = true;
                this.h = new c(bArr);
                this.h.start();
            }
        }
    }

    private boolean a() {
        boolean z;
        synchronized (this.e) {
            z = this.o && !this.d.get();
        }
        return z;
    }

    public void a(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        if (bArr2 != null) {
            Bitmap rgb2bitmap = CameraUtils.rgb2bitmap(bArr2, i3, i4);
            f(new ExtractionUpdate(ExtractionUpdateState.saveImage, CameraUtils.rgb2bitmap(bArr, i, i2)));
            f(new ExtractionUpdate(ExtractionUpdateState.saveExactImage, rgb2bitmap));
        }
        System.gc();
        f(null);
    }
}
