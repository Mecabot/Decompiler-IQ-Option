package com.iqoption.portfolio;

import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.common.base.i;
import com.google.common.collect.Sets;
import com.iqoption.util.aw;
import com.iqoption.util.g;
import java.util.Collections;
import java.util.Set;

/* compiled from: PortfolioSelection */
public class l {
    private final a cYI;
    private Set<String> cYJ = Sets.uI();
    private String cYK;

    /* compiled from: PortfolioSelection */
    public interface a {
        boolean au(String str, String str2);
    }

    public l(@NonNull a aVar) {
        i.checkNotNull(aVar);
        this.cYI = aVar;
    }

    public boolean iO(String str) {
        return this.cYJ.contains(str);
    }

    public boolean iP(String str) {
        return this.cYK != null && aw.equals(this.cYK, str);
    }

    public String awt() {
        return this.cYK;
    }

    public boolean iQ(String str) {
        boolean z = this.cYJ.add(str) || !this.cYJ.remove(str);
        if (!(this.cYK == null || z || !this.cYI.au(this.cYK, str))) {
            this.cYK = null;
        }
        return z;
    }

    public boolean iR(String str) {
        if (this.cYK == null) {
            this.cYK = str;
            return true;
        } else if (aw.equals(this.cYK, str)) {
            this.cYK = null;
            return false;
        } else {
            this.cYK = str;
            return true;
        }
    }

    public Bundle awu() {
        return new g().b("key.groups", (String[]) this.cYJ.toArray(new String[this.cYJ.size()])).aA("key.item", this.cYK).toBundle();
    }

    public void af(Bundle bundle) {
        if (bundle != null) {
            String[] stringArray = bundle.getStringArray("key.groups");
            if (stringArray != null) {
                Collections.addAll(this.cYJ, stringArray);
            }
            this.cYK = bundle.getString("key.item");
        }
    }

    public boolean a(l lVar) {
        if (lVar != null && this.cYJ.equals(lVar.cYJ)) {
            return aw.equals(this.cYK, lVar.cYK);
        }
        return false;
    }
}
