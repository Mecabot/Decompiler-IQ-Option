package com.airbnb.lottie.c;

import android.os.AsyncTask;
import android.util.JsonReader;
import com.airbnb.lottie.a;
import com.airbnb.lottie.g;
import com.airbnb.lottie.r;

/* compiled from: AsyncCompositionLoader */
public final class e extends AsyncTask<JsonReader, Void, g> implements a {
    private final r iR;

    public e(r rVar) {
        this.iR = rVar;
    }

    /* renamed from: a */
    protected g doInBackground(JsonReader... jsonReaderArr) {
        try {
            return g.a.a(jsonReaderArr[0]);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: f */
    protected void onPostExecute(g gVar) {
        this.iR.a(gVar);
    }

    public void cancel() {
        cancel(true);
    }
}
