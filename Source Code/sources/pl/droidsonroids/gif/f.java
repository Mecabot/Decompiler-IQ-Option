package pl.droidsonroids.gif;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* compiled from: InvalidationHandler */
class f extends Handler {
    private final WeakReference<b> fkT;

    public f(b bVar) {
        super(Looper.getMainLooper());
        this.fkT = new WeakReference(bVar);
    }

    public void handleMessage(Message message) {
        b bVar = (b) this.fkT.get();
        if (bVar != null) {
            if (message.what == -1) {
                bVar.invalidateSelf();
            } else {
                Iterator it = bVar.fkB.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).nz(message.what);
                }
            }
        }
    }
}
