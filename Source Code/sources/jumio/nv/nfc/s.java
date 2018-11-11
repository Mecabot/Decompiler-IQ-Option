package jumio.nv.nfc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedMap;
import org.jmrtd.PassportService;

/* compiled from: MockPassportReader */
public class s extends i {
    private r b;

    @Nullable
    public String i() {
        return null;
    }

    public s(r rVar, PassportService passportService, String str, Date date, Date date2, String str2) {
        super(passportService, str, date, date2, str2);
        this.b = rVar;
    }

    @NonNull
    public o a() {
        if (this.b.containsKey(p.INIT)) {
            return this.b.get(p.INIT);
        }
        return super.a();
    }

    @NonNull
    public o b() {
        return this.b.containsKey(p.BAC_CHECK) ? this.b.get(p.BAC_CHECK) : super.b();
    }

    @NonNull
    public List<o> c() {
        if (!this.b.containsKey(p.PASSIVE_AUTH_HASH_CHECK)) {
            return super.c();
        }
        List<o> arrayList = new ArrayList();
        o a = this.b.get(p.PASSIVE_AUTH_HASH_CHECK);
        if (a.g() == null) {
            return arrayList;
        }
        for (Entry entry : ((SortedMap) a.g()).entrySet()) {
            arrayList.add(new o(p.PASSIVE_AUTH_HASH_CHECK, (q) entry.getValue(), entry.getKey()));
        }
        return arrayList;
    }

    @NonNull
    public o a(d dVar, boolean z) {
        return this.b.containsKey(p.READ_LDS) ? this.b.get(p.READ_LDS) : super.a(dVar, z);
    }

    @NonNull
    public o a(boolean z) {
        return this.b.containsKey(p.READ_LDS) ? this.b.get(p.READ_LDS) : super.a(z);
    }

    @NonNull
    public o d() {
        return this.b.containsKey(p.PASSIVE_AUTH_DSC_CHECK) ? this.b.get(p.PASSIVE_AUTH_DSC_CHECK) : super.d();
    }

    @NonNull
    public o e() {
        return this.b.containsKey(p.ACTIVE_AUTH_CHECK) ? this.b.get(p.ACTIVE_AUTH_CHECK) : super.e();
    }

    @NonNull
    public o f() {
        throw new RuntimeException("not yet implemented!");
    }

    @NonNull
    public o g() {
        return this.b.containsKey(p.FACE_IMAGE) ? this.b.get(p.FACE_IMAGE) : super.g();
    }

    @NonNull
    public o h() {
        return this.b.containsKey(p.ADDITIONAL_DATA) ? this.b.get(p.ADDITIONAL_DATA) : super.h();
    }

    @NonNull
    public o a(h hVar) {
        return this.b.containsKey(p.PASSIVE_AUTH_ROOT_CERT_CHECK) ? this.b.get(p.PASSIVE_AUTH_ROOT_CERT_CHECK) : super.a(hVar);
    }
}
