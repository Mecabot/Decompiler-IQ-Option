package jumio.nv.nfc;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import java.util.Date;
import net.sf.scuba.smartcards.CardService;
import org.jmrtd.PassportService;

/* compiled from: PassportFactory */
public class g {
    private static r a;
    private Tag b;
    private PassportService c;
    private IsoDep d;

    public g(Tag tag) {
        this.b = tag;
    }

    protected PassportService a(Tag tag) {
        if (this.c == null) {
            this.d = IsoDep.get(tag);
            this.c = new PassportService(CardService.getInstance(this.d));
        }
        return this.c;
    }

    public k a(String str, Date date, Date date2, String str2) {
        if (this.b != null) {
            this.c = a(this.b);
        }
        if (a != null) {
            return new s(a, this.c, str, date, date2, str2);
        }
        if (this.b == null) {
            throw new IllegalStateException("the factory must be constructed with a Tag object!");
        }
        k iVar = new i(this.c, str, date, date2, str2);
        iVar.a(this.d);
        return iVar;
    }
}
