package jumio.nv.nfc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.jumio.commons.PersistWith;
import com.jumio.nv.enums.EMRTDStatus;
import com.jumio.nv.models.MrtdDataModel;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;
import org.jmrtd.lds.icao.MRZInfo;

@PersistWith("MrtdDataModel")
/* compiled from: EmrtdDataModel */
public class t implements MrtdDataModel {
    @NonNull
    private List<o> a;
    @Nullable
    private n b;
    @Nullable
    private String c;

    public t(@NonNull List<o> list, @Nullable n nVar, @Nullable String str) {
        this.a = list;
        this.b = nVar;
        this.c = str;
    }

    @Nullable
    public String getMrzString() {
        return this.c;
    }

    @Nullable
    private MRZInfo c() {
        return this.b != null ? this.b.c() : null;
    }

    public String getMrzFirstName() {
        if (c() == null) {
            return null;
        }
        return c().bBA().replace("<", " ").trim();
    }

    public String getMrzLastName() {
        if (c() == null) {
            return null;
        }
        return c().bBz();
    }

    public String getMrzPersonalNumber() {
        if (c() == null) {
            return null;
        }
        return c().getPersonalNumber();
    }

    public String getMrzIdNumber() {
        if (c() == null) {
            return null;
        }
        return c().bAv();
    }

    public String getMrzIssuingCountry() {
        if (c() == null) {
            return null;
        }
        return c().bBy();
    }

    public String getMrzOriginatingCountry() {
        if (c() == null) {
            return null;
        }
        return c().bBB();
    }

    public int getBacCheckResult() {
        return a(p.BAC_CHECK);
    }

    public int getDscCheckResult() {
        return a(p.PASSIVE_AUTH_DSC_CHECK);
    }

    public int getActiveAuthResult() {
        return a(p.ACTIVE_AUTH_CHECK);
    }

    public Map<String, Integer> getHtCheckResults() {
        o b = b(p.PASSIVE_AUTH_HASH_CHECK);
        if (b == null) {
            return null;
        }
        Map<String, Integer> treeMap = new TreeMap();
        for (Entry entry : ((SortedMap) b.g()).entrySet()) {
            treeMap.put(String.valueOf(entry.getKey()), Integer.valueOf(((q) entry.getValue()).ordinal()));
        }
        return treeMap;
    }

    public int[] getEncodedDataItems() {
        if (b() == null) {
            return null;
        }
        return b().d();
    }

    public int getRootCertCheck() {
        return a(p.PASSIVE_AUTH_ROOT_CERT_CHECK);
    }

    public EMRTDStatus getVerificationStatus() {
        EMRTDStatus eMRTDStatus = EMRTDStatus.NOT_AVAILABLE;
        if (!(this.a == null || this.a.isEmpty())) {
            for (o oVar : this.a) {
                switch (oVar.a()) {
                    case PASSIVE_AUTH_DSC_CHECK:
                    case PASSIVE_AUTH_HASH_CHECK:
                    case PASSIVE_AUTH_ROOT_CERT_CHECK:
                    case ACTIVE_AUTH_CHECK:
                        if (!(eMRTDStatus == EMRTDStatus.DENIED || oVar.b() == q.NOT_AVAILABLE)) {
                            if (!oVar.e()) {
                                eMRTDStatus = EMRTDStatus.VERIFIED;
                                break;
                            }
                            eMRTDStatus = EMRTDStatus.DENIED;
                            break;
                        }
                    default:
                        break;
                }
            }
        }
        return eMRTDStatus;
    }

    @Nullable
    public String getPlaceOfBirth() {
        if (b() == null || b().b() == null || b().b().h == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : b().b().h) {
            stringBuilder.append(append);
        }
        return stringBuilder.toString();
    }

    @Nullable
    public Date getIssuingDate() {
        return (b() == null || b().a() == null || b().a().h == null) ? null : b().a().h;
    }

    private int a(p pVar) {
        o b = b(pVar);
        return b != null ? b.b().ordinal() : 2;
    }

    private o b(p pVar) {
        for (o oVar : this.a) {
            if (oVar.a() == pVar) {
                return oVar;
            }
        }
        return null;
    }

    public List<o> a() {
        return this.a;
    }

    @Nullable
    public n b() {
        return this.b;
    }
}
