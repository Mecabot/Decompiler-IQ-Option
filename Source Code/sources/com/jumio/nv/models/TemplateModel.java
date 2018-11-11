package com.jumio.nv.models;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.jumio.commons.log.Log;
import com.jumio.commons.obfuscate.StringObfuscater;
import com.jumio.core.data.document.ScanSide;
import com.jumio.core.mvp.model.Publisher;
import com.jumio.core.mvp.model.PublisherWithUpdate;
import com.jumio.core.mvp.model.StaticModel;
import com.jumio.core.network.DownloadTask;
import com.jumio.core.network.DownloadTask.ProgressListener;
import com.jumio.nv.data.country.Country;
import com.jumio.nv.data.document.NVDocumentType;
import com.jumio.nv.environment.NVEnvironment;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jumio.nv.core.n;
import jumio.nv.core.o;

public class TemplateModel extends Publisher<Void> implements StaticModel {
    private static final NVDocumentType[] a = new NVDocumentType[]{NVDocumentType.DRIVER_LICENSE, NVDocumentType.IDENTITY_CARD};
    private o b;
    private Context c;

    static class b extends Handler {
        private ArrayList<NVDocumentType> a;
        private final WeakReference<TemplateModel> b;

        public b(TemplateModel templateModel) {
            super(Looper.getMainLooper());
            this.b = new WeakReference(templateModel);
        }

        public void handleMessage(Message message) {
            TemplateModel templateModel = (TemplateModel) this.b.get();
            if (templateModel != null) {
                templateModel.a(message, this.a);
            }
        }

        public void a(NVDocumentType[] nVDocumentTypeArr) {
            if (this.a == null) {
                this.a = new ArrayList();
            } else {
                this.a.clear();
            }
            Collections.addAll(this.a, nVDocumentTypeArr);
        }
    }

    class a extends PublisherWithUpdate<Float, NVDocumentType> implements ProgressListener {
        private Country b;
        private NVDocumentType c;
        private ScanSide d;
        private Handler e;

        public void onProgressException(Exception exception) {
        }

        public a(Handler handler, Country country, NVDocumentType nVDocumentType, ScanSide scanSide) {
            this.b = country;
            this.c = nVDocumentType;
            this.d = scanSide;
            this.e = handler;
        }

        public void onProgressUpdate(float f) {
            a(Float.valueOf(f));
        }

        public void onProgressDone(byte[] bArr) {
            try {
                Log.d("TemplateModel", "download finished");
                if (bArr != null) {
                    TemplateModel.this.b.a(TemplateModel.this.a(this.b.getIsoCode(), this.c, this.d), bArr);
                }
                Message message = new Message();
                message.obj = this.c;
                message.arg1 = 0;
                this.e.sendMessage(message);
                b(this.c);
            } catch (Throwable e) {
                Log.w("TemplateModel", e);
                Message message2 = new Message();
                message2.obj = this.c;
                message2.arg1 = 1;
                this.e.sendMessage(message2);
                e(e);
            }
        }
    }

    public TemplateModel(Context context) {
        this.b = new n(context);
        this.c = context;
    }

    public List<String> getTemplate(Country country, NVDocumentType nVDocumentType, ScanSide scanSide) {
        if (this.b.a(a(country.getIsoCode(), nVDocumentType, scanSide))) {
            Log.d("TemplateModel", "getTemplate() cache hit");
            return this.b.b(country, nVDocumentType, scanSide);
        }
        Log.d("TemplateModel", "getTemplate(): cache miss");
        return null;
    }

    public void getOrLoad(Country country, NVDocumentType[] nVDocumentTypeArr, ServerSettingsModel serverSettingsModel) {
        if (nVDocumentTypeArr == null || nVDocumentTypeArr.length == 0) {
            nVDocumentTypeArr = a;
        }
        Handler bVar = new b(this);
        bVar.a(nVDocumentTypeArr);
        try {
            for (NVDocumentType nVDocumentType : nVDocumentTypeArr) {
                if (this.b.a(country, nVDocumentType, ScanSide.FRONT)) {
                    Log.d("TemplateModel", "getOrLoad(): cache hit - publishing");
                    Message message = new Message();
                    message.obj = nVDocumentType;
                    message.arg1 = 0;
                    bVar.sendMessage(message);
                } else {
                    Log.d("TemplateModel", "getOrLoad(): cache miss - trying download");
                    if (serverSettingsModel != null && serverSettingsModel.isCdnUsable()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(NVEnvironment.CDN_URL);
                        stringBuilder.append(StringObfuscater.format(new byte[]{(byte) -65, (byte) -105, (byte) 36, (byte) 57, (byte) -25, (byte) -92, (byte) 82, (byte) -17, (byte) 28, (byte) 97, (byte) 75, (byte) -58, (byte) -127, (byte) 25, (byte) -96, (byte) -56}, 7016678690876285673L));
                        stringBuilder.append(NVEnvironment.CLIENTLIB_VERSION);
                        stringBuilder.append("/");
                        stringBuilder.append(a(country.getIsoCode(), nVDocumentType, ScanSide.FRONT));
                        DownloadTask downloadTask = new DownloadTask(stringBuilder.toString(), serverSettingsModel.getCdnPublicKey());
                        downloadTask.setListener(new a(bVar, country, nVDocumentType, ScanSide.FRONT));
                        downloadTask.start();
                    }
                }
            }
        } catch (Throwable e) {
            publishError(e);
        }
    }

    private String a(String str, NVDocumentType nVDocumentType, ScanSide scanSide) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.toUpperCase());
        stringBuilder.append("_");
        stringBuilder.append(a(nVDocumentType).toLowerCase());
        stringBuilder.append("_");
        stringBuilder.append(scanSide.toString().toLowerCase());
        stringBuilder.append(".bin");
        return stringBuilder.toString();
    }

    private String a(NVDocumentType nVDocumentType) {
        if (nVDocumentType == NVDocumentType.DRIVER_LICENSE) {
            return "DL";
        }
        if (nVDocumentType == NVDocumentType.IDENTITY_CARD) {
            return "ID";
        }
        if (nVDocumentType == NVDocumentType.PASSPORT) {
            return "PP";
        }
        return nVDocumentType.toString();
    }

    private void a(Message message, ArrayList<NVDocumentType> arrayList) {
        if (message.obj instanceof NVDocumentType) {
            if (arrayList.contains(message.obj)) {
                arrayList.remove(message.obj);
            }
            if (arrayList.isEmpty()) {
                publishResult(null);
            }
        }
    }
}
