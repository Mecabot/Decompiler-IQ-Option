package com.appsflyer;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import com.appsflyer.z.AnonymousClass1;
import com.iqoption.dto.ToastEntity;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import org.json.JSONObject;

final class ab extends AsyncTask<String, Void, String> {
    String pJ;
    private String po = "";
    private boolean qQ = false;
    private boolean qb;
    private boolean qc;
    Map<String, String> qg;
    private boolean qn = false;
    private WeakReference<Context> rb;
    private URL rc;
    private HttpURLConnection rd;

    protected final void onCancelled() {
    }

    ab(Context context, boolean z) {
        this.rb = new WeakReference(context);
        this.qc = true;
        this.qb = true;
        this.qQ = z;
    }

    protected final void onPreExecute() {
        if (this.pJ == null) {
            this.pJ = new JSONObject(this.qg).toString();
        }
    }

    /* renamed from: a */
    protected final String doInBackground(String... strArr) {
        if (this.qQ) {
            return null;
        }
        StringBuilder stringBuilder;
        try {
            int length;
            this.rc = new URL(strArr[0]);
            if (this.qc) {
                ah.ge().j(this.rc.toString(), this.pJ);
                length = this.pJ.getBytes("UTF-8").length;
                stringBuilder = new StringBuilder("call = ");
                stringBuilder.append(this.rc);
                stringBuilder.append("; size = ");
                stringBuilder.append(length);
                stringBuilder.append(" byte");
                stringBuilder.append(length > 1 ? "s" : "");
                stringBuilder.append("; body = ");
                stringBuilder.append(this.pJ);
                AnonymousClass1.ah(stringBuilder.toString());
            }
            this.rd = (HttpURLConnection) this.rc.openConnection();
            this.rd.setReadTimeout(ToastEntity.ACTION_TOAST_DURATION);
            this.rd.setConnectTimeout(ToastEntity.ACTION_TOAST_DURATION);
            this.rd.setRequestMethod("POST");
            this.rd.setDoInput(true);
            this.rd.setDoOutput(true);
            this.rd.setRequestProperty("Content-Type", "application/json");
            OutputStream outputStream = this.rd.getOutputStream();
            Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(this.pJ);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();
            this.rd.connect();
            length = this.rd.getResponseCode();
            if (this.qb) {
                h.fA();
                this.po = h.a(this.rd);
            }
            if (this.qc) {
                ah.ge().a(this.rc.toString(), length, this.po);
            }
            if (length == 200) {
                AFLogger.an("Status 200 ok");
                Context context = (Context) this.rb.get();
                if (this.rc.toString().startsWith(q.aA(h.pr)) && context != null) {
                    Editor edit = context.getSharedPreferences("appsflyer-data", 0).edit();
                    edit.putBoolean("sentRegisterRequestToAF", true);
                    edit.apply();
                    AFLogger.am("Successfully registered for Uninstall Tracking");
                }
            } else {
                this.qn = true;
            }
        } catch (Throwable th) {
            stringBuilder = new StringBuilder("Error while calling ");
            stringBuilder.append(this.rc.toString());
            AFLogger.a(stringBuilder.toString(), th);
            this.qn = true;
        }
        return this.po;
    }

    /* renamed from: al */
    protected final void onPostExecute(String str) {
        if (this.qn) {
            AFLogger.an("Connection error: ".concat(String.valueOf(str)));
        } else {
            AFLogger.an("Connection call succeeded: ".concat(String.valueOf(str)));
        }
    }

    final void fz() {
        this.qc = false;
    }
}
