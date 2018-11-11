package io.fabric.sdk.android;

import io.fabric.sdk.android.services.common.r;
import io.fabric.sdk.android.services.concurrency.Priority;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.concurrency.c;

/* compiled from: InitializationTask */
class g<Result> extends c<Void, Void, Result> {
    final h<Result> rR;

    public g(h<Result> hVar) {
        this.rR = hVar;
    }

    protected void onPreExecute() {
        super.onPreExecute();
        r lv = lv("onPreExecute");
        try {
            boolean go = this.rR.go();
            lv.aUS();
            if (go) {
                return;
            }
        } catch (UnmetDependencyException e) {
            throw e;
        } catch (Throwable e2) {
            c.aUg().e("Fabric", "Failure onPreExecute()", e2);
            lv.aUS();
        } catch (Throwable th) {
            lv.aUS();
            cancel(true);
        }
        cancel(true);
    }

    protected Result doInBackground(Void... voidArr) {
        r lv = lv("doInBackground");
        Result doInBackground = !isCancelled() ? this.rR.doInBackground() : null;
        lv.aUS();
        return doInBackground;
    }

    protected void onPostExecute(Result result) {
        this.rR.onPostExecute(result);
        this.rR.emf.bR(result);
    }

    protected void onCancelled(Result result) {
        this.rR.onCancelled(result);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.rR.getIdentifier());
        stringBuilder.append(" Initialization was cancelled");
        this.rR.emf.e(new InitializationException(stringBuilder.toString()));
    }

    public Priority hA() {
        return Priority.HIGH;
    }

    private r lv(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.rR.getIdentifier());
        stringBuilder.append(".");
        stringBuilder.append(str);
        r rVar = new r(stringBuilder.toString(), "KitInitialization");
        rVar.aUR();
        return rVar;
    }
}
