package com.iqoption.widget.helper;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.CountDownTimer;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.iqoption.analytics.f;
import com.iqoption.app.af;
import com.iqoption.core.i;
import com.iqoption.dto.Event.ApiCallEventBusEvent;
import com.iqoption.service.e.d;
import com.iqoption.system.a.e;
import com.iqoption.util.Network;
import com.iqoption.util.ab;
import com.iqoption.util.ag;
import com.iqoption.util.k;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class SplashLogHelper {
    private static final String TAG = "com.iqoption.widget.helper.SplashLogHelper";
    private static c dPk;
    private final TextView bTy;
    private boolean cDy;
    private final TextView dPl;
    private final TextView dPm;
    private final TextView dPn;
    private final b dPo;
    private final ArrayList<a> dPp = new ArrayList();
    private boolean dPq;
    private CountDownTimer dPr;
    private long dPs;
    private int dPt;
    private boolean dPu;
    private final Runnable dPv = new Runnable() {
        public void run() {
            SplashLogHelper.this.aML();
        }
    };
    private Runnable dPw = new Runnable() {
        public void run() {
            SplashLogHelper.this.dPm.setVisibility(0);
            SplashLogHelper.this.bTy.setVisibility(0);
            SplashLogHelper.this.dPn.setVisibility(0);
            SplashLogHelper.this.aMO();
        }
    };
    private long dPx;
    private long dPy;
    private String dpE;

    public static class LongLaunchException extends Exception {
        LongLaunchException(String str) {
            super(str);
        }
    }

    public static class LongLaunchNoResponseException extends Exception {
        LongLaunchNoResponseException(String str) {
            super(str);
        }
    }

    public static class a {
        private final String abQ;
        private final String apiName;

        public a(String str, String str2) {
            this.apiName = str;
            this.abQ = str2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return this.apiName.equals(((a) obj).apiName);
            }
            return super.equals(obj);
        }

        public int hashCode() {
            return this.apiName.hashCode();
        }

        public String toString() {
            return this.abQ;
        }
    }

    private static class c implements Parcelable {
        public static final Creator<c> CREATOR = new Creator<c>() {
            /* renamed from: ac */
            public c createFromParcel(Parcel parcel) {
                return new c(parcel);
            }

            /* renamed from: hy */
            public c[] newArray(int i) {
                return new c[i];
            }
        };
        String cre;
        String dPF;
        long dPG;
        String dpE;

        public int describeContents() {
            return 0;
        }

        private void clear() {
            this.cre = null;
            this.dPF = null;
            this.dPG = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.cre);
            parcel.writeString(this.dPF);
            parcel.writeString(this.dpE);
            parcel.writeLong(this.dPG);
        }

        protected c(Parcel parcel) {
            this.cre = parcel.readString();
            this.dPF = parcel.readString();
            this.dpE = parcel.readString();
            this.dPG = parcel.readLong();
        }
    }

    public class b extends e<Context> {
        public b(Context context) {
            super(context);
        }

        @com.google.common.b.e
        public void onApiCallEvent(final ApiCallEventBusEvent apiCallEventBusEvent) {
            if (!apiCallEventBusEvent.apiName.contains("api/appsflyer/link") && !apiCallEventBusEvent.apiName.contains("appsflyer-initialization")) {
                if (apiCallEventBusEvent.t == null || (apiCallEventBusEvent.t instanceof SocketTimeoutException)) {
                    com.iqoption.core.d.a.aSe.execute(new Runnable() {
                        public void run() {
                            if (((Context) b.this.drU.get()) != null) {
                                long j = -1;
                                SplashLogHelper splashLogHelper;
                                String str;
                                String apiCallEventBusEvent;
                                if (VERSION.SDK_INT < 19 || !SplashLogHelper.this.dPl.isAttachedToWindow()) {
                                    splashLogHelper = SplashLogHelper.this;
                                    str = apiCallEventBusEvent.apiName;
                                    apiCallEventBusEvent = apiCallEventBusEvent.toString();
                                    if (apiCallEventBusEvent.apiCallEvent.duration != null) {
                                        j = apiCallEventBusEvent.apiCallEvent.duration.longValue();
                                    }
                                    splashLogHelper.c(str, apiCallEventBusEvent, j);
                                    return;
                                }
                                splashLogHelper = SplashLogHelper.this;
                                str = apiCallEventBusEvent.apiName;
                                apiCallEventBusEvent = apiCallEventBusEvent.toString();
                                if (apiCallEventBusEvent.apiCallEvent.duration != null) {
                                    j = apiCallEventBusEvent.apiCallEvent.duration.longValue();
                                }
                                splashLogHelper.c(str, apiCallEventBusEvent, j);
                            }
                        }
                    });
                }
            }
        }

        @com.google.common.b.e
        public void onWebSocketFrontEvent(final d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    if (((Context) b.this.drU.get()) != null) {
                        SplashLogHelper.this.dpE = dVar.dpE;
                        if (VERSION.SDK_INT < 19 || !SplashLogHelper.this.dPl.isAttachedToWindow()) {
                            SplashLogHelper.this.ko(dVar.toString());
                        } else {
                            SplashLogHelper.this.ko(dVar.toString());
                        }
                    }
                }
            });
        }

        @com.google.common.b.e
        public void onRetryFutureEvent(final ag.d dVar) {
            com.iqoption.core.d.a.aSe.execute(new Runnable() {
                public void run() {
                    if (((Context) b.this.drU.get()) == null) {
                        return;
                    }
                    if (VERSION.SDK_INT < 19 || !SplashLogHelper.this.dPl.isAttachedToWindow()) {
                        SplashLogHelper.this.log(dVar.toString());
                    } else {
                        SplashLogHelper.this.log(dVar.toString());
                    }
                }
            });
        }
    }

    public static boolean aMJ() {
        if (com.iqoption.app.managers.feature.b.HT().ff("splash-log") && af.h("is_log_api_call", false)) {
            return true;
        }
        return false;
    }

    public static String cf(Context context) {
        Throwable th;
        File file = new File(context.getApplicationContext().getFilesDir(), "api_call.log");
        Closeable closeable = null;
        try {
            byte[] bArr = new byte[((int) file.length())];
            Closeable bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                bufferedInputStream.read(bArr, 0, bArr.length);
                bufferedInputStream.close();
                String str = new String(bArr);
                ab.c(bufferedInputStream);
                return str;
            } catch (Exception unused) {
                closeable = bufferedInputStream;
            } catch (Throwable th2) {
                th = th2;
                closeable = bufferedInputStream;
                ab.c(closeable);
                throw th;
            }
        } catch (Exception unused2) {
            ab.c(closeable);
            return "";
        } catch (Throwable th3) {
            th = th3;
            ab.c(closeable);
            throw th;
        }
    }

    public static void cg(Context context) {
        if (dPk != null) {
            dPk.clear();
        }
        ch(context);
    }

    private static void ch(Context context) {
        File file = new File(context.getApplicationContext().getFilesDir(), "api_call.log");
        if (file.exists()) {
            file.delete();
        }
    }

    public SplashLogHelper(Context context, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        this.dPl = textView2;
        this.bTy = textView3;
        this.dPm = textView;
        this.dPn = textView4;
        this.dPo = new b(context);
        textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView3.setMovementMethod(ScrollingMovementMethod.getInstance());
        cB(view);
        this.dPo.register();
    }

    private void a(c cVar) {
        if (cVar != null) {
            this.dPl.setText(cVar.cre);
            this.bTy.setText(cVar.dPF);
            this.dPm.setText(cVar.dpE);
            this.dPy = cVar.dPG;
        }
    }

    private c aMK() {
        c cVar = new c();
        cVar.cre = this.dPl.getText().toString();
        cVar.dpE = this.dPm.getText().toString();
        cVar.dPF = this.bTy.getText().toString();
        cVar.dPG = this.dPx;
        return cVar;
    }

    public void cB(View view) {
        view.setOnClickListener(new OnClickListener() {
            private int count;
            private long dPA;

            public void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.dPA == 0 || currentTimeMillis - this.dPA > 3000) {
                    this.dPA = currentTimeMillis;
                    this.count = 1;
                } else {
                    this.count++;
                }
                if (this.count == 5) {
                    this.count = 0;
                    af.i("is_log_api_call", af.h("is_log_api_call", false) ^ true);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Technical log ");
                    stringBuilder.append(SplashLogHelper.aMJ() ? "enabled" : "disabled");
                    com.iqoption.app.a.b.eP(stringBuilder.toString());
                    if (SplashLogHelper.aMJ() && SplashLogHelper.this.dPq) {
                        SplashLogHelper.this.show();
                    } else if (SplashLogHelper.this.dPq) {
                        SplashLogHelper.this.hide();
                    }
                }
            }
        });
    }

    public void show() {
        this.dPq = true;
        com.iqoption.core.d.a.aSe.removeCallbacks(this.dPw);
        this.dPo.register();
        if (!aMJ()) {
            com.iqoption.core.d.a.aSe.postDelayed(this.dPw, 15000);
        }
        if (!this.cDy && aMJ()) {
            a(dPk);
            this.dPl.setVisibility(0);
            this.dPm.setVisibility(0);
            this.dPn.setVisibility(0);
            this.bTy.setVisibility(0);
            this.dPr = new CountDownTimer(2147483647L, 200) {
                long startTime = System.currentTimeMillis();

                public void onFinish() {
                }

                public void onTick(long j) {
                    SplashLogHelper.this.dPx = SplashLogHelper.this.dPy + (System.currentTimeMillis() - this.startTime);
                    long h = SplashLogHelper.this.dPx - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(SplashLogHelper.this.dPx));
                    SplashLogHelper.this.dPn.setText(String.format(Locale.US, "%d,%03dsec", new Object[]{Long.valueOf(j), Long.valueOf(h)}));
                }
            };
            this.dPr.start();
            this.cDy = true;
        }
    }

    @Nullable
    public void hide() {
        this.dPq = false;
        com.iqoption.core.d.a.aSe.removeCallbacks(this.dPw);
        this.dPo.unregister();
        this.dPl.setVisibility(8);
        this.dPm.setVisibility(8);
        this.dPn.setVisibility(8);
        this.bTy.setVisibility(8);
        if (this.cDy) {
            aMN();
            if (aMJ()) {
                if (this.dPr != null) {
                    this.dPr.cancel();
                }
                com.iqoption.core.d.a.aSe.removeCallbacks(this.dPv);
                aMM();
                this.cDy = false;
            }
        }
    }

    public void saveState() {
        dPk = aMK();
    }

    private void c(String str, String str2, long j) {
        String str3 = TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("logApiCall: ");
        stringBuilder.append(str2);
        i.v(str3, stringBuilder.toString());
        if (j == -1) {
            this.dPp.add(new a(str, str2));
            com.iqoption.core.d.a.aSe.postDelayed(this.dPv, 3000);
            return;
        }
        if (this.dPp.remove(new a(str, str2))) {
            aML();
        }
        if (this.dPl.getText().length() > 0) {
            this.dPl.append("\n");
        }
        this.dPl.append(str2);
    }

    private void aML() {
        com.iqoption.core.d.a.aSe.removeCallbacks(this.dPv);
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = this.dPp.iterator();
        while (it.hasNext()) {
            stringBuilder.append(((a) it.next()).toString());
            stringBuilder.append("\n");
        }
        this.bTy.setText(stringBuilder.toString());
    }

    public void log(String str) {
        if (this.cDy) {
            if (this.dPl.getText().length() > 0) {
                this.dPl.append("\n");
            }
            this.dPl.append(str);
        }
    }

    private void ko(String str) {
        this.dPm.setText(str);
    }

    private void aMM() {
        Throwable e;
        Closeable closeable = null;
        try {
            Closeable bufferedWriter = new BufferedWriter(new FileWriter(aMP(), false));
            try {
                bufferedWriter.append(this.dPm.getText());
                bufferedWriter.append("\t\t\t\t\t\t\t\t\t\t\t\t");
                bufferedWriter.append(this.dPn.getText());
                bufferedWriter.append("\n");
                bufferedWriter.append(this.dPl.getText());
                bufferedWriter.append("\n");
                Iterator it = this.dPp.iterator();
                while (it.hasNext()) {
                    bufferedWriter.append(((a) it.next()).toString());
                    bufferedWriter.append("\n");
                }
                bufferedWriter.close();
                this.dPl.setText("");
                this.dPp.clear();
                ab.c(bufferedWriter);
            } catch (IOException e2) {
                e = e2;
                closeable = bufferedWriter;
                try {
                    i.e(TAG, "error due write to log file", e);
                    ab.c(closeable);
                } catch (Throwable th) {
                    e = th;
                    bufferedWriter = closeable;
                    ab.c(bufferedWriter);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                ab.c(bufferedWriter);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
            i.e(TAG, "error due write to log file", e);
            ab.c(closeable);
        }
    }

    private void aMN() {
        String charSequence = this.dPl.getText().toString();
        if (!this.dPu && !TextUtils.isEmpty(charSequence)) {
            f.Br().a(this.dpE, charSequence, this.dPs, this.dPt);
            this.dPu = true;
        }
    }

    private void aMO() {
        if (Network.dwp.aGr()) {
            Object charSequence = this.bTy.getText().toString();
            if (TextUtils.isEmpty(charSequence)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("More than 15000 ms on splash screen\n");
                stringBuilder.append(this.dPl.getText().toString());
                k.c(new LongLaunchException(stringBuilder.toString()));
                return;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("More than 15000 ms on splash screen\n");
            stringBuilder2.append(this.dPl.getText().toString());
            stringBuilder2.append(10);
            stringBuilder2.append(charSequence);
            k.c(new LongLaunchNoResponseException(stringBuilder2.toString()));
        }
    }

    @NonNull
    private File aMP() {
        File file = new File(this.dPl.getContext().getApplicationContext().getFilesDir(), "api_call.log");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e) {
                i.e(TAG, "error due create log file", e);
            }
        }
        return file;
    }
}
