package jumio.nv.nfc;

import java.util.HashMap;

/* compiled from: MockConfig */
public class r extends HashMap<p, o> {
    /* renamed from: a */
    public o get(Object obj) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return (o) super.get(obj);
    }
}
